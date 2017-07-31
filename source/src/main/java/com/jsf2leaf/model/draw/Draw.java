package com.jsf2leaf.model.draw;

import com.jsf2leaf.model.Layer;
import com.jsf2leaf.options.Position;

public class Draw {
	
	private Layer layer;
	private Position position = Position.TOP_RIGHT;
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

}
