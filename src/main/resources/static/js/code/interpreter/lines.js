function readInput(line) {
    return line.text();
}

function makeOutputLine(currentLine, stdout) {
    newOutputLine(currentLine, stdout);
}

function resetInputLine(input) {
    input.text('+>');
}

function newLine(currentLine, input) {
    newOutputLine(currentLine, input.html());
    resetInputLine(input);
}

function newInputArgsLine(currentline, input, program) {
    infoIO("Input arg $" + program.inputArgs.length);
    newOutputLine(currentline, input.html());
    resetInputLine(input);
}

function newOutputLine(currentLine, text) {
    currentLine.before("<div class=\"output\">" + text + "</div>");
}
