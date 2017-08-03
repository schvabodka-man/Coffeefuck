function readInput(line) {
    return line.text();
}

function sendInput() {
    if (countOutput() == 0) {
        warningIO("No output specified");
    }
}

function addArgument(input) {
    inputArgs.push(input);
}

function nullArgParams() {
    inputArgs = Array();
    argsCount = 0;
}

function initInputListener() {
    $("#inp").on('input', function (e) {
        $(this).html(Prism.highlight($(this).text(), Prism.languages.brainfuck));
    });
}

function countInputArgs() {
    return countChars(",");
}

function countOutput() {
    return countChars(".");

}

function countChars(char) {
    return program.split(char).length - 1;

}

function newLine(currentLine, input) {
    currentLine.before("<div>" + input.html() + "</div>");
    input.text(",");
}

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

function inputHandler(currentLine, input) {
    program = readInput(input);
    if (countInputArgs() > 0 && inputArgsFlag == false) {
        argsCount = countInputArgs(readInput(input));
        inputArgsMode(currentLine, input);
    } else if (inputArgsFlag == true && argsCount != inputArgs.length) {
        if (readInput(input).length == 1) {
            addArgument(readInput(input));
            if (argsCount == inputArgs.length) {
                disableInputArgsMode();
                sendInput();
                nullArgParams();
                newLine(currentLine, input);
            } else {
                newInputArgsLine(currentLine, input);
            }
        } else {
            errorWayTooManyInput();
        }
    } else {
        warningIO("No input args specified");
        sendInput(input.text());
        newLine(currentLine, input);
    }
}

function inputArgsMode(currentLine, input) {
    inputArgsFlag = true;
    infoInputAllTheArgs(argsCount);
    newInputArgsLine(currentLine, input);
}

function disableInputArgsMode() {
    inputArgsFlag = false;
}

function newInputArgsLine(currentline, input) {
    infoIO("Input arg $" + inputArgs.length);
    currentline.before("<div>" + input.html() + "</div>");
    input.text("+");
}

function errorNoInput() {
    error("No input");
}

function errorWayTooManyInput() {
    error("Input can only be 1 char");
}

function error(text) {
    toastr.error(text, 'Error');
}

function infoInputAllTheArgs(argsNumber) {
    infoIO('Input all the ' + argsNumber + " args");
}

function infoIO(text) {
    toastr.info(text, "I/O");
}

function warningIO(text) {
    toastr.warning(text, "I/O");

}

function main() {
    initInputListener();
    keyListener();
}
