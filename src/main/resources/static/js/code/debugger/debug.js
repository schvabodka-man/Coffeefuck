/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

var connection = null;
var client = null;

var programInputMode = true;

/*
 * Makes websocket connection object
 */
function makeConnection() {
    connection = new SockJS('/debuginp');
    client = Stomp.over(connection);
}

/*
 * Start websocket connection
 */
function connectToServer() {
    client.connect({}, function (frame) {
        client.subscribe('/debugout', function (response) {
            if (!checkError(response)) {
                populateUIWithResult(response);
                checkIfProgramEnded(response);
            }
        });
    });
}

function nextStep() {
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "next"
    }));
    infoExec("Step into");
}

function prevStep() {
    client.send("/coffeedebugger/debuginp", {}, JSON.stringify({
        'command': "prev"
    }));
    infoExec("Step back");
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
    $("#liveOutput").show();
    $("#inputholder").hide();
    programInputMode = false;
    debuggerInit(program);
}

/*
 * Checks if you can run any further
 * @param data retrieved from server frame
 */
function checkIfProgramEnded(data) {
    if (!JSON.parse(data.body).anyFurther) {
        finalExec("Done!");
        programInputMode = true;
        cleanOutput($("#liveOutput"));
        cachedProgram = new Program();
        $("#liveOutput").hide();
        $("#inputholder").show();
    }
}

/*
 * Dumb error handling
 * @param response server response
 */
function checkError(response) {
    if (JSON.parse(response.body).vm != null) {
        return false;
    } else {
        var message = JSON.parse(response.body);
        if (message.code == 400) {
            if (message.explanation == "Can't decrement") {
                errorExec("Cannot go back any further");
                return true;
            } else if (message.explanation == "Stop playing with protocol") {
                error("Server connection error");
                return true;
            } else if (message.explanation == "Not enough args") {
                errorExec("Not enough args for input");
                return true;
            } else {
                error("Unknown error");
                return true;
            }
        } else {
            return false;
        }
    }
}
