let person = {
    name: {
        firstName: 'wade',
        lastName: 'wei'
    },
    age: 18,
    gender: 'male',
    show: function () {
        return "hello I'm " + this.name.firstName + this.name.lastName;
    }
};

function Human(name) {
    this.name = name;
    this.show = function () {
        alert("hello,I'm " + this.name);
    }
}