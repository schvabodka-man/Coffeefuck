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
