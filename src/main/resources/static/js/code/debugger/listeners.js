function keyListener() {
    shiftEnterListener(function () {
        if (programInputMode) {
            inputProgramKeyListenerLogic($("#liveOutput"));
        } else {
            nextStep();
        }
    });
}
