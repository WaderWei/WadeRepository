let i = 0;
let c = 0;

function timedCount() {
    i = i + 1;
    if (c === 0) {
        postMessage(i);
        setTimeout("timedCount()", 500);
    }

}

this.addEventListener('message', function (e) {
    if (e.data === 'close') {
        c = 1;
    }
}, false);
timedCount();