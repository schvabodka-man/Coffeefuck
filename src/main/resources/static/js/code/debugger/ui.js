function populateUIWithResult(response) {
    populateDataFromResult(JSON.parse(response.body));
    updateOutput(JSON.parse(response.body).vm.output);
}

function updateOutput(newOutput) {
    $("#liveOutput").html(newOutput);
}

function cleanOutput(inputLine) {

}
