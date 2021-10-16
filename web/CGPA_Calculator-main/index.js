var result = () => {
    var nos = document.getElementById("num0").value;
    var n1 = document.getElementById("num1").value;
    var n2 = document.getElementById("num2").value;
    var n3 = document.getElementById("num3").value;
    var n4 = document.getElementById("num4").value;
    var n5 = document.getElementById("num5").value;
    var n6 = document.getElementById("num6").value;
    var n7 = document.getElementById("num7").value;
    var n8 = document.getElementById("num8").value;
    var total;
    var finale;
    var cg;
    total = parseInt(n1) + parseInt(n2) + parseInt(n3) + parseInt(n4) + parseInt(n5) + parseInt(n6) + parseInt(n7) + parseInt(n8);
    finale = total / parseInt(nos);
    cg = finale / 10;
    if (cg > 10) {
        alert("Invalid Inputs!");
    }
    if (finale >= 90 && finale <= 100) {
        return cg;
    }
    else if (finale >= 80 && finale <= 89) {
        return cg;
    }
    else if (finale >= 70 && finale <= 79) {
        return cg;
    }
    else if (finale >= 60 && finale <= 69) {
        return cg;
    }
    else if (finale >= 50 && finale <= 59) {
        return cg;
    }
    else if (finale >= 40 && finale <= 49) {
        return cg;
    }
    else {
        return "Fail";
    }
}
var finres = () => {
    document.write(result())
}
