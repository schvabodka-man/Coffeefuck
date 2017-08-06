function populateCellsValues(memBlock, cellValue) {
    $('#memcell').text("Current memory cell: " + memBlock);
    $('#cellval').text("Current cell value: " + cellValue);
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

