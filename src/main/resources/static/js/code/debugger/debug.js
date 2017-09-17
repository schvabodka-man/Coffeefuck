var connection = null;
var client = null;

var programInputMode = true;

function makeConnection() {
    connection = new SockJS('/debuginp');
    client = Stomp.over(connection);
}

function connectToServer() {
    client.connect({}, function (frame) {
        client.subscribe('/debugout', function (response) {
            populateUIWithResult(response);
        });
    });
}

function nextStep() {
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "next"
    }));
}

function debuggerInit(programm) {
    infoExec("Starting debugger");
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "init",
        'app': programm.code,
        'args': programm.inputArgs
    }));
}

function sendInput(program) {
    if (program.outputSymbols == 0) {
        warningIO("No output specified");
    }
    if (programInputMode) {
        programInputMode = false;
        debuggerInit(program);
    } else {
        nextStep();
    }
}
