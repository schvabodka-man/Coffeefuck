/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * Toastr wrapper
 */

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
