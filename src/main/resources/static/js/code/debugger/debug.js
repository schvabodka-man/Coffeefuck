var connection = null;
var client = null;

function makeConnection() {
    connection = new SockJS('/debuginp');
    client = Stomp.over(connection);
}

function connectToServer() {
    client.connect({}, function (frame) {
        client.subscribe('/debugout', function (response) {
            alert(response);
        });
    });
}

function nextStep() {
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "next"
    }));
}

function debuggerInit(programm, input) {
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "init",
        'app': programm,
        'args': input
    }));
}
