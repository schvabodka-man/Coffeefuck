function readInput(line) {
    return line.text();
}

function sendInput() {
    if (program.outputSymbols == 0) {
        warningIO("No output specified");
    }
    infoExec("Running code now");
    var req = $.ajax({
        url: "api/vm",
        type: "GET",
        dataType: "json",
        data: {
            app: program.code,
            input: program.inputArgs
        }
    });
    req.done(function (data) {
        nullArgParams();
        populateDataFromResult(data);
        finalExec("Finished");
    });
    req.fail(function (xhr, status) {
        errorExec("Error");
    });
}

function populateDataFromResult(data) {
    makeAnswer(data);
    if (result.output.length != 0) {
        makeOutputLine($("#inputholder"), result.output);
    }
    populateCellsValues(result.memoryPoint, result.currentMemBlock);
}

function makeAnswer(data) {
    result = new Answer(data.vm.output, data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.mem);
}

function makeOutputLine(currentLine, stdout) {
    newOutputLine(currentLine, stdout);
}

function populateCellsValues(memBlock, cellValue) {
    $('#memcell').text("Current memory cell: " + memBlock);
    $('#cellval').text("Current cell value: " + cellValue);
}

function nullArgParams() {
    program = new Program();
}

function resetInputLine(input) {
    input.text('+>');
}

function initInputListener() {
    $("#inp").on('input', function (e) {
        $(this).html(Prism.highlight($(this).text(), Prism.languages.brainfuck));
    });
}

function newLine(currentLine, input) {
    newOutputLine(currentLine, input.html());
    resetInputLine(input);
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
    program.setProgram(readInput(input));
    if (program.argsCount > 0 && program.inputArgsFlag == false) {
        program.argsCount = program.countInputArgs(readInput(input));
        inputArgsMode(currentLine, input);
    } else if (program.inputArgsFlag == true && program.argsCount != program.inputArgs.length) {
        if (readInput(input).length == 1) {
            program.addArg(readInput(input));
            if (program.argsCount == program.inputArgs.length) {
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
    program.inputArgsFlag = true;
    if (program.argsCount != 1) {
        infoInputAllTheArgs(program.argsCount);
    }
    newInputArgsLine(currentLine, input);
}

function disableInputArgsMode() {
    program.inputArgsFlag = false;
}

function newInputArgsLine(currentline, input) {
    infoIO("Input arg $" + program.inputArgs.length);
    newOutputLine(currentLine, text.html());
    resetInputLine(input);
}

function newOutputLine(currentLine, text) {
    currentLine.before("<div class=\"output\">" + text + "</div>");
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

function infoExec(text) {
    toastr.info(text, "Exec");
}

function finalExec(text) {
    toastr.success(text, "Exec");
}

function errorExec(text) {
    toastr.error(text, "Exec");
}

function main() {
    initInputListener();
    keyListener();
}
