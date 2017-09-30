/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * Inits keyListener
 */
function keyListener() {
    shiftEnterListener(function () {
        inputProgramKeyListenerLogic($("#inputholder"));
    });
}
