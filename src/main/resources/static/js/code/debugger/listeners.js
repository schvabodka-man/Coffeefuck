/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

function keyListener() {
    shiftEnterListener(function () {
        if (programInputMode) {
            inputProgramKeyListenerLogic($("#liveOutput"));
        } else {
            nextStep();
        }
    });
}

function prevFrameListener() {
    $(document).on("keypress", function (e) {
        if (e.keycode == 8) {
            prevStep();
        }
    });
}
