/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

function populateUIWithResult(response) {
    populateDataFromResult(JSON.parse(response.body));
    updateOutput(JSON.parse(response.body).vm.output);
    highlightProgramSymbol(response);
}

function updateOutput(newOutput) {
    $("#liveOutput").text(newOutput);
}

function cleanOutput(line) {
    newOutputLine(line, line.text());
    line.text("");
    $(".codeLine").removeClass("codeLine");
}

function highlightProgramSymbol(response) {
    $("#currentpoint").removeAttr("id");
    var point = JSON.parse(response.body).programPoint;
    $(".codeLine").children().eq(point - 1).attr("id", "currentpoint");
}
