/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * Handles user input in command line.
 */
function inputHandler(currentLine, input, program) {
    if (program.code.length == 0) { //if program is nothing sets program from input
        program.setProgram(readInput(input));
    }
    //if there is not enough args simply switches to input args mode
    if (program.argsCount > 0 && program.inputArgsFlag == false) {
        program.argsCount = program.countInputArgs(readInput(input));
        inputArgsMode(currentLine, input, program);
    } else if (program.inputArgsFlag == true) { //if we're in args mode
        if (readInput(input).length == 1) { //simple check(brainfuck can input only 1 char in cell)
            if (program.argsCount == program.inputArgs.length) { //if all args are in just run app
                disableInputArgsMode(program);
                sendInput(program);
                newLine(currentLine, input);
            } else { //if not ask for more args
                program.addArg(readInput(input));
                newInputArgsLine(currentLine, input, program);
                if (program.argsCount == program.inputArgs.length) { //if it's become ok run it
                    sendInput(program);
                }
            }
        } else {
            error("Input can only be 1 char");
        }
    } else { //if everything ok start execution on sever
        warningIO("No input args specified");
        sendInput(program);
        newProgramLine(currentLine, input.html());
    }
    return program;
}

/*
 * Switches input mode to input arguments
 */
function inputArgsMode(currentLine, input, program) {
    program.inputArgsFlag = true;
    if (program.argsCount != 1) {
        infoIO('Input all the ' + program.argsCount + " args");
    }
    newInputArgsLine(currentLine, input, program);
}

/*
 * Switches inout mode to input program
 */
function disableInputArgsMode(program) {
    program.inputArgsFlag = false;
}

/*
 * Clears program object
 */
function clearCache() {
    cachedProgram = new Program();
}
