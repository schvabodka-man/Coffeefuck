function initInputListener() {
    $("#inp").on('input', function (e) {
        $(this).html(Prism.highlight($(this).text(), Prism.languages.brainfuck));
    });
}

function clickListener() {
    $("#memory").click(function (e) {
        popupWindowWithMemory(result.memDump);
    });
}

function shiftEnterListener(func) {
    $(document).on("keypress", function (e) {
        if (e.keyCode == 13) {
            func();
        }
    });
}
