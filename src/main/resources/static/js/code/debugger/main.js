/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

function main() {
    initInputListener();
    makeConnection();
    connectToServer();
    clickListener();
    keyListener();
    prevFrameListener();
    $("#liveOutput").hide();
}
