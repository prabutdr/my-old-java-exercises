/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Prabu
 */

public class Customer {
    public var firstName: String;
    public var lastName: String;
    public var phoneNum: String;
    public var address: Address;

    public function printName() {
        println("Name: {firstName} {lastName}");
    }

    public function printPhoneNum() {
        println("Phone Number: {phoneNum}");
    }

    public function printAddress() {
        println("Street: {address.street}");
        println("City: {address.city}");
        println("State: {address.state}");
        println("Zip: {address.zip}");
    }

}
