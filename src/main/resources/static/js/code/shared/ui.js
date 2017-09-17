function populateCellsValues(memBlock, cellValue, time) {
    $('#memcell').text(memBlock);
    $('#cellval').text(cellValue);
    $('#exectime').text(time);
}

function popupWindowWithMemory(mem) {
    var modal = new tingle.modal({
        footer: true,
        stickyFooter: false,
        closeMethods: ['overlay', 'escape'],
        closeLabel: "Close"
    });
    overrideDefaultCss();
    modal.setContent(generateModalmemoryContent(mem));
    modal.addFooterBtn('Backup', 'btnbackupi', function () {
        downloadVMBackup('default.json');
    });
    modal.open();
}

function generateModalmemoryContent(mem) {
    var stringbuf = '<div id="memholder">' + mem + '</div>';
    return stringbuf;
}

function overrideDefaultCss() {
    $(".tingle-modal-box").css({
        "background-color": "#212121",
        "color": "#FFFFFF"
    });
    $(".tingle-modal-box__footer").css({
        "background-color": "#212121",
        "color": "#FFFFFF"
    });
}

function focusOnInputLine() {
    $("#inputholder").focus();
}

function inputProgramKeyListenerLogic() {
    if ($("#inp").text().length > 0) {
        cachedProgram = inputHandler($("#inputholder"), $("#inp"), cachedProgram);
    } else {
        error("No input");
    }
}

function populateDataFromResult(data) {
    makeAnswer(data);
    if (data.vm.output.length != 0) {
        makeOutputLine($("#inputholder"), data.vm.output);
    }
    populateCellsValues(data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.duration);
}

function makeAnswer(data) {
    result = new Answer(data.vm.output, data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.mem);
}