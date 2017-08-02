function readInput(line) {
    return line.text();
}

function sendInput() {

}

function initInputListener() {
    $("#inp").on('input', function(e) {
        $(this).html(Prism.highlight($(this).text(), Prism.languages.brainfuck));
    });
}

function countInputArgs(program) {
    return program.split(",").length - 1;
}

function newLine(currentLine) {
    currentLine.before("<div>" + currentLine.html() + "</div>");
	currentLine.text("");
    if (countInputArgs(readInput(currentLine)) > 0) {
        for (i = 0; i < countInputArgs(currentLine.text()); i++) {
		    currentLine.before("<div>Stdin arg #" + (i+1) + ":</div>");	
        }
    }
}

function keyListener() {
    $(document).on("keypress", function(e) {
        if (e.keyCode == 13 && e.shiftKey) {
            if ($("#inp").text().length > 0) {
                newLine($("#inp"));
            } else {
				errorNoInput($("#inp"));
			}
        }
    });
}


function errorNoInput(currentLine) {
	 currentLine.before("<div>No input</div>");
}

function main() {
    initInputListener();
    keyListener();
}
