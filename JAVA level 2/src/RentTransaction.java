

/* this class is summery to the Customer, Car , TheCertianDate classes
here we are writing information about all the rental transaction in just one class
*/

// the class as usual is public and we named it after using the keyword class
public class RentTransaction implements Comparable<RentTransaction> {
 
    // it has three instans variables 
    private Car storedCar; // variable from type Car will represeant the car
    private Customer person; // variable from type Customer, we get it from the class Customer will represeant the person who rent
    private TheCertainDate time; // variable from type TheCertianDate will represeant the date

    // zero argument constructor that gives the instans variables their defualt values.
    // we made it by writing public as a modifire and the name of the class ((since the constructor must hold the class' name))
    public RentTransaction(){
    this(null,null,null); // null is the defualt value
    }
    
    // a multi argument constructor to give the variables values from the user.
    public RentTransaction(Car stoar, Customer pen, TheCertainDate tim) {
        storedCar = stoar; // the variable storedCar will take its value from the parametar stoar
        person = pen; // the variable person will take its value from the parametar pen
        time = tim; // the variable time will take its value from the parametar tim
    } // end of multi argument constructor

    // getter methods will be used to get the values of the private variables
    
    // the return type is Car 
    public Car bring_outStoredCar() {
        return storedCar;
    } // end of getter method

    // the return type is Customer
    public Customer bring_outPerson() {
        return person;
    } // end of getter method

    // the return type is TheCertianDate
    public TheCertainDate bring_outTime() {
        return time;
    } // end of getter method

    // setter methods are used to change the value of a private variable
    // it's void because it doesn't return any data type.
    
    // change the value of the storedCar to a new given vlaue
    public void newStoredCar(Car str) {
        storedCar = str;
    } // end of setter method

    // change the value of the person to a new given vlaue
    public void newPerson(Customer pon) {
        person = pon;
    } // end of setter method

    // change the value of the time to a new given vlaue
    public void newTime(TheCertainDate im) {
        time = im;
    } // end of setter method

    // an overriden toString method from the root class Object to display the components of the class.
    public String toString() {
        return "RentTransaction: \n" + "Car's information=" + storedCar + "\n Customer =" + person + "\n " + time +"\n" + "\n";
    } // end of the overriden method (toString)
    
    // another overriden method but this one checks if a two given values from the same type are the same or not
     public boolean equals(Object here){
     
     RentTransaction trans = (RentTransaction) here;
     return storedCar.equals(trans.storedCar) &&
             person.equals(trans.person) &&
             time.equals(trans.time);
     } // end of method

    
     /*
     we wanted to sort the cars in the list so the best way to do it is by using the number plate of the car
     each car has it's own number plate so we will check each number and then the least number will become the first elemant
     we can do this easly by the overriden method compareTo .
     we will send a number to the method then it will copmare it with the number of each car
     */
    public int compareTo(RentTransaction t) {
       return this.storedCar.comareTo(t.storedCar); // we are comaring
    } // end of method
} // end of class
