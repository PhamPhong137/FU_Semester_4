/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
flag = true;
canMove = true;

function myfun(x, y, n) {
    var obj = document.getElementById("btn" + (x * n + y));
    if (obj.innerHTML === "" && canMove) {
        obj.innerHTML = flag ? "X" : "O";
       obj.classList.add(flag ? "red" : "blue");
        canMove = !checkWin(x, y, n, flag);
        flag = !flag;
    }
}

function check(x, n) {
    return x >= 0 && x < n;
}
function checkWin(x, y, n, flag) {
    c = flag ? "X" : "O";
    count = 0;

    var dirs = [[1, 0], [0, 1], [1, 1], [-1, 1]];

    for (var [ox, oy] of dirs) {
        for (var i = -4; i < 5; i++) {
            var xr = x + i * ox;
            var yr = y + i * oy;
            if (check(xr, n) && check(yr, n)) {
                if (document.getElementById("btn" + (xr * n + yr)).innerHTML === c) {
                    count++;
                } else {
                    count = 0;
                }
                if (count === 5) {
                    setTimeout(alertWin,1) ;
                    return true;
                }
            }
        }
    }
}
function alertWin(){
    alert(c+ " is win");
}

function reset(n) {
    flag = true;
    canMove = true;
    for (let x = 0; x < n; x++) {
        for (let y = 0; y < n; y++) {
            var obj = document.getElementById("btn" + (x * n + y));
            obj.innerHTML = "";
            obj.classList.remove("red","blue");
        }
    }
}


//Cach 1
//    for (var i = -4; i < 5; i++) {
//        if (check(x + i, n) && check(y + i, n)) {
//            if (document.getElementById("btn" + ((x + i) * n + y + i)).innerHTML === c) {
//                count++;
//            } else {
//                count = 0;
//            }
//            if (count === 5)
//                return true;
//        }
//        count = 0;
//        if (check(x - i, n) && check(y + i, n)) {
//            if (document.getElementById("btn" + ((x - i) * n + y + i)).innerHTML === c) {
//                count++;
//            } else {
//                count = 0;
//            }
//            if (count === 5)
//                return true;
//        }
//        count = 0;
//        if (check(x + i, n)) {
//            if (document.getElementById("btn" + ((x + i) * n + y)).innerHTML === c) {
//                count++;
//            } else {
//                count = 0;
//            }
//            if (count === 5)
//                return true;
//        }
//        count = 0;
//        if (check(y + i, n)) {
//            if (document.getElementById("btn" + (x * n + y + i)).innerHTML === c) {
//                count++;
//            } else {
//                count = 0;
//            }
//            if (count === 5)
//                return true;
//        }
//    }