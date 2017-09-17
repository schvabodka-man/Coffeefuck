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