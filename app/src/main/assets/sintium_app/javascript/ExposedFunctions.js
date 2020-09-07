function getColors() {
    const stringifiedColors = JSON.stringify(toolsLayerColors);
    Android.setToolColors(stringifiedColors);
}

function getLayers() {
    const layerNames = map.getLayerHandler().getLayerNames().slice().reverse();
    const stringifiedLayerNames = JSON.stringify(layerNames);
    Android.setLayers(stringifiedLayerNames);
}

function toggleLayers(layers) {
    const layerHandler = map.getLayerHandler();
    const layerNames = layerHandler.getLayerNames();
    for (const layerIndex in layerNames) {
        const layer = layerNames[layerIndex];
        const visibility = layers.indexOf(layer) >= 0;
        layerHandler.setLayerVisibleById(layer, visibility);
    }
}

function fail() {
    alert("Noe gikk galt, venligst sjekk om du har internett- eller Ggps (gps, glonass osv) forbindelse");
}

function populateUserPosition(callback) {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(callback, fail, {timeout: 60000});
        return true;
    } else {
        return false;
    }
}

function zoomToUserPosition() {
    sensor = populateUserPosition(function (position) {
        const userPosition = ol.proj.transform([position.coords.longitude, position.coords.latitude], 'EPSG:4326', 'EPSG:3857');
        map.zoomToCoordinates([position.coords.longitude, position.coords.latitude], 10)
    });
}

function closeBottomSheet() {
    infoDrawer.close();
    vesselInfoDrawer.close();
    map.getSelectionHandler().clearSelection();
}