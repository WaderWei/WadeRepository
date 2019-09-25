function Person(name, age) {
    this.name = name;
    this.age = age;
    this.show = function () {
        return name + "--->" + age;
    }
}

export {Person}