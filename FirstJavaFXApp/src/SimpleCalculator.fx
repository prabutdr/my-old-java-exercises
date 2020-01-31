/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Prabu
 */

def numOne = 100;
def numTwo = 2;
var result;

/*add();
subtract();
multiply();
divide();
add(100, 10);
subtract(50, 5);
multiply(25, 4);
divide(500, 3);*/

function run(args: String[]) {
    //Convert Strings to Integers
    def numOne = Integer.parseInt(args[0]);
    def numTwo = Integer.parseInt(args[1]);

    //Invoke functions
    add(numOne, numTwo);
    subtract(numOne, numTwo);
    multiply(numOne, numTwo);
    divide(numOne, numTwo);

    println("isReadOnly(numOne): {isReadOnly(result)}");
}

function add() {
    result = numOne + numTwo;
    println("{numOne} + {numTwo} = {result}");
}

function subtract() {
    result = numOne - numTwo;
    println("{numOne} - {numTwo} = {result}");
}

function multiply() {
    result = numOne * numTwo;
    println("{numOne} * {numTwo} = {result}");
}

function divide() {
    result = numOne / numTwo;
    println("{numOne} / {numTwo} = {result}");
}

function add(argOne: Integer, argTwo: Integer) {
    result = argOne + argTwo;
    println("{argOne} + {argTwo} = {result}");
}

function subtract(argOne: Integer, argTwo: Integer) {
    result = argOne - argTwo;
    println("{argOne} - {argTwo} = {result}");
}

function multiply(argOne: Integer, argTwo: Integer) {
    result = argOne * argTwo;
    println("{argOne} * {argTwo} = {result}");
}

function divide(argOne: Integer, argTwo: Integer) {
    result = argOne / argTwo;
    println("{argOne} / {argTwo} = {result}");
}






