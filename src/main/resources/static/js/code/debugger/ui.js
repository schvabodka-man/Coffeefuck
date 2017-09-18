function populateUIWithResult(response) {
    populateDataFromResult(JSON.parse(response.body));
    updateOutput(JSON.parse(response.body).vm.output);
}

function updateOutput(newOutput) {
    $("#liveOutput").text(newOutput);
}

function cleanOutput(line) {
    newOutputLine(line, line.text());
    line.text("");
}
