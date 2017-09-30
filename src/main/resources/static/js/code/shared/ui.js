/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

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

function inputProgramKeyListenerLogic(line) {
    if ($("#inp").text().length > 0) {
        cachedProgram = inputHandler(line, $("#inp"), cachedProgram);
    } else {
        error("No input");
    }
}

function populateDataFromResult(data) {
    makeAnswer(data);
    populateCellsValues(data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.duration);
}

function makeAnswer(data) {
    result = new Answer(data.vm.output, data.vm.memoryPoint, data.vm.currentMemBlock, data.vm.mem);
}
