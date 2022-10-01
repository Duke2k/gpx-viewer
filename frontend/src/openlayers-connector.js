import GPX from 'ol/format/GPX';
import Map from 'ol/Map';
import View from 'ol/View';
import {OSM, Vector as VectorSource} from 'ol/source';
import XYZ from 'ol/source/XYZ';
import {Circle as CircleStyle, Fill, Stroke, Style} from 'ol/style';
import {Tile as TileLayer, Vector as VectorLayer} from 'ol/layer';

window.Vaadin.Flow.openLayersConnector = {
    initLazy: function (c) {
        if (c.$connector) {
            return;
        }
        c.$connector = {
        };
        c.$connector.map = new Map({
            target: c,
            layers: [
                new TileLayer({
                    source: new OSM()
                })
            ],
            view: new View({
                center: [0, 0],
                zoom: 0
            })
        });
    },
    centerAndScale: function (c, lat, lon, scale) {
        if (c.$connector) {
            return;
        }
        c.$connector = {
        };
        c.$connector.map = new Map({
            target: c,
            layers: [
                new TileLayer({
                    source: new OSM()
                })
            ],
            view: new View({
                center: [lat, lon],
                zoom: scale
            })
        });
    }
}