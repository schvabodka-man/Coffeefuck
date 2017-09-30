/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * Read text from specified line
 */
function readInput(line) {
    return line.text();
}

function makeOutputLine(currentLine, stdout) {
    newOutputLine(currentLine, stdout);
}

/*
 * Clears input line
 */
function resetInputLine(input) {
    input.text(',');
}

/*
 * Make new line under specified
 */
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
