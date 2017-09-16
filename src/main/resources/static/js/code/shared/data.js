function Program() {
    this.code = "";
    this.inputArgs = Array();
    this.argsCount = 0;
    this.outputSymbols = 0;
    this.inputArgsFlag = false;

    this.setProgram = function (code) {
        this.code = code;
        this.argsCount = this.countInputArgs();
        this.outputSymbols = this.countOutput();
    };

    this.addArg = function (arg) {
        this.inputArgs.push(arg);
    };

    this.countInputArgs = function () {
        return this.countChars(",");
    };

    this.countOutput = function () {
        return this.countChars(".");
    };

    this.countChars = function (char) {
        return this.code.split(char).length - 1;
    };
}

function Answer(output, memoryPoint, currentMemBlock, memDump) {
    this.output = output;
    this.memoryPoint = memoryPoint;
    this.currentMemBlock = currentMemBlock;
    this.memDump = memDump;
}

var result = new Answer();
var cachedProgram = new Program();
