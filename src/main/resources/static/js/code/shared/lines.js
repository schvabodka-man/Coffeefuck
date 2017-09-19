function readInput(line) {
    return line.text();
}

function makeOutputLine(currentLine, stdout) {
    newOutputLine(currentLine, stdout);
}

function resetInputLine(input) {
    input.text(',');
}

function newLine(currentLine, input) {
    newOutputLine(currentLine, input.html());
    resetInputLine(input);
}

function newInputArgsLine(currentLine, input, program) {
    infoIO("Input arg $" + program.inputArgs.length);
    newProgramLine(currentLine, input.html());
    resetInputLine(input);
}

function newOutputLine(currentLine, text) {
    if (text.length != 0) {
        currentLine.before("<div class=\"output\">" + text + "</div>");
    }
}

function newProgramLine(currentLine, html) {
    currentLine.before("<div class=\"output codeLine\">" + html + "</div>");
}
