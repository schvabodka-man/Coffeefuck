function sendInput(program) {
    if (program.outputSymbols == 0) {
        warningIO("No output specified");
    }
    infoExec("Running code now");
    $.ajax({
        url: "api/vm?" + $.param({
            app: program.code,
            input: program.inputArgs
        }, true),
        type: "GET",
        success: function (data) {
            populateDataFromResult(data);
            finalExec("Finished");
            focusOnInputLine();
            clearCache();
        },
        error: function (xhr, status) {
            errorExec("Error");
        }
    });
}

function populateDataFromResult(data) {
    makeAnswer(data);
    if (data.vm.output.length != 0) {
        makeOutputLine($("#inputholder"), data.vm.output);
    }
    populateCellsValues(data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.duration);
}

function makeAnswer(data) {
    result = new Answer(data.vm.output, data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.mem);
}

function inputHandler(currentLine, input, program) {
    if (program.code.length == 0) {
        program.setProgram(readInput(input));
    }
    if (program.argsCount > 0 && program.inputArgsFlag == false) {
        program.argsCount = program.countInputArgs(readInput(input));
        inputArgsMode(currentLine, input, program);
    } else if (program.inputArgsFlag == true) {
        if (readInput(input).length == 1) {
            if (program.argsCount == program.inputArgs.length) {
                disableInputArgsMode(program);
                sendInput(program);
                newLine(currentLine, input);
            } else {
                program.addArg(readInput(input));
                newInputArgsLine(currentLine, input, program);
                if (program.argsCount == program.inputArgs.length) {
                    sendInput(program);
                }
            }
        } else {
            error("Input can only be 1 char");
        }
    } else {
        warningIO("No input args specified");
        sendInput(program);
        newLine(currentLine, input);
    }
    return program;
}

function inputArgsMode(currentLine, input, program) {
    program.inputArgsFlag = true;
    if (program.argsCount != 1) {
        infoInputAllTheArgs(program.argsCount);
    }
    newInputArgsLine(currentLine, input, program);
}

function disableInputArgsMode(program) {
    program.inputArgsFlag = false;
}

function clearCache() {
    cachedProgram = new Program();
}
