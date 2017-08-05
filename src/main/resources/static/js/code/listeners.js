function keyListener() {
    $(document).on("keypress", function (e) {
        if (e.keyCode == 13 && e.shiftKey) {
            if ($("#inp").text().length > 0) {
                inputHandler($("#inputholder"), $("#inp"));
            } else {
                errorNoInput();
            }
        }
    });
}

function initInputListener() {
    $("#inp").on('input', function (e) {
        $(this).html(Prism.highlight($(this).text(), Prism.languages.brainfuck));
    });
}

function clickListener() {
    $("#memory").click(function (e) {
        popupWindowWithMemory(result.memDump);
    });
    $("#clear").click(function (e) {

    });
}
