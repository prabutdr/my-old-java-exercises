/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Prabu
 */

var customer = Customer {
    firstName: "Prabhakaran"
    lastName: "Rajendran"
    phoneNum: "(412) 519 2802"
    address: Address {
        street: "1020, Hillgate Place"
        city: "Pittsburgh"
        state: "PA"
        zip: "15220"
    }
}

customer.printName();
customer.printPhoneNum();
customer.printAddress();

def weekdays = ["Mon", "Tue", "Wed", "Thu", "Fri"];
println("weekdays: {weekdays} {weekdays[2]}");
def nums = [1..100];
println("Nums: {nums}");
println("sizeof nums: {sizeof nums}");