function sendInput() {
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
            nullArgParams();
            populateDataFromResult(data);
            finalExec("Finished");
            focusOnInputLine();
        },
        error: function (xhr, status) {
            errorExec("Error");
        }
    });
}

function populateDataFromResult(data) {
    makeAnswer(data);
    if (result.output.length != 0) {
        makeOutputLine($("#inputholder"), result.output);
    }
    populateCellsValues(result.memoryPoint, result.currentMemBlock, result.duration);
}

function makeAnswer(data) {
    result = new Answer(data.vm.output, data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.mem);
}

function inputHandler(currentLine, input) {
    if (program.code == "") {
        program.setProgram(readInput(input));
    }
    if (program.argsCount > 0 && program.inputArgsFlag == false) {
        program.argsCount = program.countInputArgs(readInput(input));
        inputArgsMode(currentLine, input);
    } else if (program.inputArgsFlag == true) {
        if (readInput(input).length == 1) {
            if (program.argsCount == program.inputArgs.length) {
                disableInputArgsMode();
                sendInput();
                nullArgParams();
                newLine(currentLine, input);
            } else {
                program.addArg(readInput(input));
                newInputArgsLine(currentLine, input);
                if (program.argsCount == program.inputArgs.length) {
                    sendInput();
                }
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
    program.inputArgsFlag = true;
    if (program.argsCount != 1) {
        infoInputAllTheArgs(program.argsCount);
    }
    newInputArgsLine(currentLine, input);
}

function disableInputArgsMode() {
    program.inputArgsFlag = false;
}
