/*
 * Copyright (c) 2017. scvh-man
 * Licence: http://www.gnu.org/licenses/gpl-3.0.en.html
 */

/*
 * App class. App is user input
 */
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

/*
 * Simply answer from server
 */
function Answer(output, memoryPoint, currentMemBlock, memDump) {
    this.output = output;
    this.memoryPoint = memoryPoint;
    this.currentMemBlock = currentMemBlock;
    this.memDump = memDump;
}

//yes, global vars
var result = new Answer();
var cachedProgram = new Program();
