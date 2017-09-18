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
            checkIfProgramEnded(response);
        });
    });
}

function nextStep() {
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "next"
    }));
    infoExec("Step");
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
    programInputMode = false;
    debuggerInit(program);
}

function checkIfProgramEnded(data) {
    if (!JSON.parse(data.body).anyFurther) {
        finalExec("Done!");
        programInputMode = true;
        cleanOutput($("#liveOutput"));
        cachedProgram = new Program();
    }
}
