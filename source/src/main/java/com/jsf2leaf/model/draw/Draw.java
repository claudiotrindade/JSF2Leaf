package com.jsf2leaf.model.draw;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jsf2leaf.model.Circle;
import com.jsf2leaf.model.Feature;
import com.jsf2leaf.model.LatLong;
import com.jsf2leaf.model.Layer;
import com.jsf2leaf.model.Marker;
import com.jsf2leaf.model.Polyline;
import com.jsf2leaf.model.Style;
import com.jsf2leaf.options.Position;

public class Draw {
	
	private Layer layer;
	private Position position = Position.TOP_RIGHT;
	private Style style = new Style();
	private boolean polylineEnabled = true;
	private boolean polygonEnabled = true;
	private boolean rectangleEnabled = true;
	private boolean circleEnabled = true;
	private boolean markerEnabled = true;
	private boolean editEnabled = true;
	private boolean removeEnabled = true;
	private String geoJsonObject;
	
	public Layer getLayer() {
		return layer;
	}
	
	public void setLayer(Layer layer) {
		this.layer = layer;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public boolean isPolylineEnabled() {
		return polylineEnabled;
	}

	public void setPolylineEnabled(boolean polylineEnabled) {
		this.polylineEnabled = polylineEnabled;
	}

	public boolean isPolygonEnabled() {
		return polygonEnabled;
	}

	public void setPolygonEnabled(boolean polygonEnabled) {
		this.polygonEnabled = polygonEnabled;
	}

	public boolean isRectangleEnabled() {
		return rectangleEnabled;
	}

	public void setRectangleEnabled(boolean rectangleEnabled) {
		this.rectangleEnabled = rectangleEnabled;
	}

	public boolean isCircleEnabled() {
		return circleEnabled;
	}

	public void setCircleEnabled(boolean circleEnabled) {
		this.circleEnabled = circleEnabled;
	}

	public boolean isMarkerEnabled() {
		return markerEnabled;
	}

	public void setMarkerEnabled(boolean markerEnabled) {
		this.markerEnabled = markerEnabled;
	}

	public boolean isEditEnabled() {
		return editEnabled;
	}

	public void setEditEnabled(boolean editEnabled) {
		this.editEnabled = editEnabled;
	}

	public boolean isRemoveEnabled() {
		return removeEnabled;
	}

	public void setRemoveEnabled(boolean removeEnabled) {
		this.removeEnabled = removeEnabled;
	}

	public String getGeoJsonObject() {
		return geoJsonObject;
	}

	public void setGeoJsonObject(String geoJsonObject) {
		this.geoJsonObject = geoJsonObject;
	}
	
	public void create(AjaxBehaviorEvent event) {
		JSONObject jsonObj = new JSONObject(geoJsonObject);
		if (jsonObj.getJSONObject("properties").get("layerType").equals("marker")) {
			String latitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(1).toString(); 
			String longitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(0).toString();
			Marker marker = new Marker(new LatLong(latitude, longitude));
			layer.addMarker(marker);
			jsonObj.getJSONObject("properties").put("indexOfArray", layer.getMarkers().indexOf(marker));
			geoJsonObject = jsonObj.toString();
		} else if (jsonObj.getJSONObject("properties").get("layerType").equals("circle")) {
			String latitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(1).toString(); 
			String longitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(0).toString();
			Circle circle = new Circle();
			circle.setPosition(new LatLong(latitude, longitude));
			circle.setRadius(jsonObj.getJSONObject("geometry").getDouble("radius"));
			layer.addCircle(circle);
			jsonObj.getJSONObject("properties").put("indexOfArray", layer.getCircles().indexOf(circle));
			geoJsonObject = jsonObj.toString();
		} else if (jsonObj.getJSONObject("properties").get("layerType").equals("polyline")) {
			Polyline polyline = new Polyline();
			for (Object array : jsonObj.getJSONObject("geometry").getJSONArray("coordinates")) {
				if ( array instanceof JSONArray ) {
					String latitude = ((JSONArray) array).get(1).toString(); 
					String longitude = ((JSONArray) array).get(0).toString();
					polyline.addPoint(new LatLong(latitude, longitude));
			    }
			}
			layer.addPolyline(polyline);
			jsonObj.getJSONObject("properties").put("indexOfArray", layer.getPolylines().indexOf(polyline));
			geoJsonObject = jsonObj.toString();
		} else if (jsonObj.getJSONObject("properties").get("layerType").equals("polygon") || jsonObj.getJSONObject("properties").get("layerType").equals("rectangle")) {
			Feature feature = new Feature();
			feature.setGeometry(jsonObj.getJSONObject("geometry").toString());
			layer.addFeature(feature);
			jsonObj.getJSONObject("properties").put("indexOfArray", layer.getFeatures().indexOf(feature));
			geoJsonObject = jsonObj.toString();
		}
	}
	
	public void edit(AjaxBehaviorEvent event) {
		JSONObject jsonObj = new JSONObject(geoJsonObject);
		if (jsonObj.getJSONObject("properties").getInt("indexOfArray") >= 0) {
			if (jsonObj.getJSONObject("properties").get("layerType").equals("marker") && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getMarkers().size()) {
				String latitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(1).toString(); 
				String longitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(0).toString();
				layer.getMarkers().get(jsonObj.getJSONObject("properties").getInt("indexOfArray")).setPosition(new LatLong(latitude, longitude));
			} else if (jsonObj.getJSONObject("properties").get("layerType").equals("circle") && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getCircles().size()) {
				String latitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(1).toString(); 
				String longitude = jsonObj.getJSONObject("geometry").getJSONArray("coordinates").get(0).toString();
				layer.getCircles().get(jsonObj.getJSONObject("properties").getInt("indexOfArray")).setPosition(new LatLong(latitude, longitude));
				layer.getCircles().get(jsonObj.getJSONObject("properties").getInt("indexOfArray")).setRadius(jsonObj.getJSONObject("geometry").getDouble("radius"));
			} else if (jsonObj.getJSONObject("properties").get("layerType").equals("polyline") && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getPolylines().size()) {
				List<LatLong> points = new ArrayList<LatLong>();
				for (Object array : jsonObj.getJSONObject("geometry").getJSONArray("coordinates")) {
					if ( array instanceof JSONArray ) {
						String latitude = ((JSONArray) array).get(1).toString(); 
						String longitude = ((JSONArray) array).get(0).toString();
						points.add(new LatLong(latitude, longitude));
				    }
				}
				layer.getPolylines().get(jsonObj.getJSONObject("properties").getInt("indexOfArray")).setPoints(points);
			} else if ((jsonObj.getJSONObject("properties").get("layerType").equals("feature") || jsonObj.getJSONObject("properties").get("layerType").equals("polygon") || jsonObj.getJSONObject("properties").get("layerType").equals("rectangle")) && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getFeatures().size()) {
				layer.getFeatures().get(jsonObj.getJSONObject("properties").getInt("indexOfArray")).setGeometry(jsonObj.getJSONObject("geometry").toString());
			}
		}
	}

	public void delete(AjaxBehaviorEvent event) {
		JSONObject jsonObj = new JSONObject(geoJsonObject);
		if (jsonObj.getJSONObject("properties").getInt("indexOfArray") >= 0) {
			if (jsonObj.getJSONObject("properties").get("layerType").equals("marker") && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getMarkers().size()) {
				layer.getMarkers().remove(jsonObj.getJSONObject("properties").getInt("indexOfArray"));
			} else if (jsonObj.getJSONObject("properties").get("layerType").equals("circle") && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getCircles().size()) {
				layer.getCircles().remove(jsonObj.getJSONObject("properties").getInt("indexOfArray"));
			} else if (jsonObj.getJSONObject("properties").get("layerType").equals("polyline") && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getPolylines().size()) {
				layer.getPolylines().remove(jsonObj.getJSONObject("properties").getInt("indexOfArray"));
			} else if ((jsonObj.getJSONObject("properties").get("layerType").equals("feature") || jsonObj.getJSONObject("properties").get("layerType").equals("polygon") || jsonObj.getJSONObject("properties").get("layerType").equals("rectangle")) && jsonObj.getJSONObject("properties").getInt("indexOfArray") < layer.getFeatures().size()) {
				layer.getFeatures().remove(jsonObj.getJSONObject("properties").getInt("indexOfArray"));
			}
		}
	}

}
