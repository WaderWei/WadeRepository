import {Person} from "./module";

var person1 = new Person("wade",18);
console.log(person1.show())
{
    var b = 3;/*全局都共享*/
    let a = 2;/*被限定在代码块中*/
}
console.log(b);/*3*/
//console.log(a);/*报错*/

{
    for (var i = 0; i < 10; i++) {
        setTimeout(function () {
            console.log(i)
        })
    }
}
{
    for (let j = 0; j < 10; j++) {
        setTimeout(function () {
            console.log(j)
        })
    }
}


const COLOR_RED = "red";
const COLOR_YELLOW = "yellow";
const COLOR_BLUE = "blue";
const MY_BLUE = "blue";

function ColorException(message) {
    this.message = message;
    this.name = "ColorException";
}

console.log(COLOR_BLUE === MY_BLUE)

function getConstantName(color) {
    switch (color) {
        case COLOR_RED :
            return "COLOR_RED";
        case COLOR_YELLOW :
            return "COLOR_YELLOW ";
        case COLOR_BLUE:
            return "COLOR_BLUE";
        case MY_BLUE:
            return "MY_BLUE";
        default:
            throw new ColorException("Can't find this color");
    }
}

try {
    var color = "green"; // green 引发异常
    var colorName = getConstantName(color);
} catch (e) {
    var colorName = "unknown";
    console.log(e.message, e.name); // 传递异常对象到错误处理
}


{
    let map = new Map();
    map.set(NaN, 'not a number');
    map.set("str", "字符串");
    map.set("fun", function () {
        alert("map 中是函数");
    })

    for (let [key, val] of map) {
        console.log(key + "=" + val);
    }

    for (let [key, value] of map.entries()) {
        console.log(key + " = " + value);
    }
    for (let key of map.keys()) {
        console.log(key);
    }
    for (let value of map.values()) {
        console.log(value);
    }

    map.forEach((val, key) => {
        console.log(key + "=" + val)
    }, map)


    class Cal {
        constructor(a, b) {
            this.a = a;
            this.b = b;
        }

        sum() {
            return this.a + this.b;
        }
    }

    let person = new Cal(1, 2);
    console.log(person.sum())

}