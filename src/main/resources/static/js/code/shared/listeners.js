/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * Code syntax highlight
 */
function initInputListener() {
    $("#inp").on('input', function (e) {
        $(this).html(Prism.highlight($(this).text(), Prism.languages.brainfuck));
    });
}

/*
 * Listener for the vm image popup
 */
function clickListener() {
    $("#memory").click(function (e) {
        popupWindowWithMemory(result.memDump);
    });
}

/*
 * Generic "template" for keybind
 */
function shiftEnterListener(func) {
    $(document).on("keypress", function (e) {
        if (e.keyCode == 13) {
            func();
        }
    });
}
