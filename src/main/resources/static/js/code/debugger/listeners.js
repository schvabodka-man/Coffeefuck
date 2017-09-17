function keyListener() {
    shiftEnterListener(function () {
        if (programInputMode) {
            inputProgramKeyListenerLogic();
        } else {
            nextStep();
        }
    });
}
