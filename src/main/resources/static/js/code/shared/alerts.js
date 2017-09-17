function error(text) {
    toastr.error(text, 'Error');
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
