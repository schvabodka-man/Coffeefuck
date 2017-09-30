/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * Simply sends input to server and retrieves result
 * @param program brainfuck app
 */
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
            if (data.vm.output.length != 0) {
                makeOutputLine($("#inputholder"), data.vm.output);
            }
            finalExec("Finished");
            focusOnInputLine();
            clearCache();
        },
        error: function (xhr, status) {
            errorExec(status);
        }
    });
}