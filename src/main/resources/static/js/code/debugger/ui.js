function populateUIWithResult(response) {
    finalExec("Done");
    populateDataFromResult(JSON.parse(response.body));
}
