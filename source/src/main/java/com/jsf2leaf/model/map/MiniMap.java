package com.jsf2leaf.model.map;

import com.jsf2leaf.options.Position;

/**
 * Java model for leaflet mini map object.
 * Default values of properties:
 * <ul>
 *     <li>width - 100</li>
 *     <li>height - 100</li>
 *     <li>position - {@link Position#BOTTOM_RIGHT}</li>
 *     <li>toggleDisplay - true</li>
 *     <li>zoomAnimation - true</li>
 * </ul>
 * Created by Bartosz Wesolowski on 25.11.2016.
 */
public class MiniMap {

    private int width = 100;

    private int height = 100;

    private Position position = Position.BOTTOM_RIGHT;

    private boolean toggleDisplay = true;

    private boolean  zoomAnimation = true;

    public MiniMap() {
        super();
    }

    /**
     * Builder for min map.
     * <ul>
     *     <li>width - 100</li>
     *     <li>height - 100</li>
     *     <li>position - {@link Position#BOTTOM_RIGHT}</li>
     *     <li>toggleDisplay - true</li>
     *     <li>zoomAnimation - true</li>
     * </ul>
     */
    public static class Builder {

        private int width = 100;

        private int height = 100;

        private Position position = Position.BOTTOM_RIGHT;

        private boolean toggleDisplay = true;

        private boolean  zoomAnimation = true;

        public static Builder builder() {
            return new Builder();
        }

        public MiniMap build() {
            final MiniMap miniMap = new MiniMap();
            miniMap.width = this.width;
            miniMap.height = this.height;
            miniMap.position = this.position;
            miniMap.toggleDisplay = this.toggleDisplay;
            miniMap.zoomAnimation = this.zoomAnimation;
            return  miniMap;
        }
        /**
         * Sets width of mini map. Default value is 100.
         * @param width - width in pixels
         * @return Builder
         */
        public Builder withWidth(final int width) {
            this.width = width;
            return this;
        }

        /**
         * Sets width of mini map. Default value is 100.
         * @param height - height in pixels
         * @return Builder
         */
        public Builder withHeight(final int height) {
            this.height = height;
            return this;
        }

        /**
         * Sets the toggle display property. Default true.
         * @return Builder
         */
        public Builder withToggleDisplay(final boolean toggleDisplay) {
            this.toggleDisplay = toggleDisplay;
            return this;
        }
        /**
         * Sets zoomAnimation property. Default true.
         * @return Builder
         */
        public Builder withPosition(final boolean zoomAnimation) {
            this.zoomAnimation = zoomAnimation;
            return this;
        }
    }
}
