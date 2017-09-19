function keyListener() {
    shiftEnterListener(function () {
        if (programInputMode) {
            inputProgramKeyListenerLogic($("#liveOutput"));
        } else {
            nextStep();
        }
    });
}

function prevFrameListener(func) {
    $(document).on("keypress", function (e) {
        if (e.shiftKey && e.keyCode == 13) {
            prevStep();
        }
    });
}
