
/*
 
- this class is about the customers.
- We rent cars, but knowing the specifications of the rental car is not enough. It is also necessary to know information about the buyers
so that we can communicate with him in the event of any problem. That is why we decided to use the classes to accomplish this task.
- each customer is different from another, so We will create variables in which we store information about the person and then we will create
ways to represent this information when needed.
- classes are indispensable because they are the best way to represent information of the same type of data about several people.
*/

// we made the class by writting the keyword class then we named it Customer.
// this class is public which means we can use it everywhere inside the package or in another packages.
public class Customer {
    
    // the variables that will be used to store data about the customer.
    private int theSpecialCivilID; // we will store the civil ID of the user because each person has a differente number from the others.
    private String personsName; // name is important , i mean how are we gonna talk to the person if we don't know what to call them?
    
    // three variables from me as asked in the question.
    private String gender; // the customer either male or female.
    private long customerCardNumber; 
    /* the above variable is to store the number of the card that the customer would use to pay, and it's from 
    type long because the card number consist of 12 digits*/
    private boolean hasCriminalRecord; // will check if the user made crimes before or not.

    // till here we only declared the variables, but they don't have values yet so we need to assign initial values to them
    
    // here we made a zero argument constructer to assign the default values to the variables by using this() .
    public Customer(){
    
        this(0,null,null,0L,false);
    }
    
    // multi argument constructor was made to get the wanted values from the user and assign them to the variables
    // and by this way, we can send all the features in just one line.
    public Customer(int CivID, String perNam, String gen, long custCardNum, boolean criminal) {
        theSpecialCivilID = CivID; // the civil id will be send to the parametar then it will be assigned to the instans variable
        personsName = perNam; // the name will be send to the parametar then it will be assigned to the instans variable
        gender = gen; // the gender of the user will be send to the parametar then it will be assigned to the instans variable
        customerCardNumber = custCardNum; // the card number will be send to the parametar then it will be assigned to the instans variable
        hasCriminalRecord = criminal; // whether the user is criminal or not the value will be assigned to the instans variable 
    }

    // the variables are from type private so we will make getter mathods to make it easy to us to get the valuse out of the class.
    // we have five priavet variables so we will make five getter methods.
    
    // return value from type int
    public int bring_outTheSpecialCivilID() {
        return theSpecialCivilID;
    } // end of first geeter method

    // returns value from type String
    public String bring_outPersonsName() {
        return personsName;
    } // end of seconed getter method

    // returns value from type String
    public String bring_outGender() {
        return gender;
    } // end of third getter method

    // returns value from type long
    public long bring_outCustomerCardNumber() {
        return customerCardNumber;
    } // end of 4th getter method

    // returns value from type boolean
    public boolean bring_outCriminalRecord() {
        return hasCriminalRecord;
    } // end of 5th getter method
    
    
    // we made setter methods so we can change the value of an instans variable
    // setter methods are void because they don't return a value, they recive the value in the argument then assign it to the variable
    
    // to get a new civil id
    public void newTheSpecialCivilID(int vilID) {
        theSpecialCivilID = vilID;
    } // end of first setter method

    // to get a new name.
    public void newPersonsName(String nsNam) {
        personsName = nsNam;
    } // end of second setter method

    // to change the gender
    public void newGender(String der) {
        gender = der;
    } // end of third setter method

    // to get a new card number
    public void newCustomerCardNumber(long merCar) {
        customerCardNumber = merCar;
    } // end of 4th setter method

    // to reset the existence of the criminal record
    public void newHasCriminalRecord(boolean haord) {
        hasCriminalRecord = haord;
    } // end of 5th setter method

    /*
     now we will write one of the most timprtant methods in this class which is the toString method.
    the toString method is method was build in the father class for the classes in java Object class.
    Object class is the root class in java and it has many methods, and since it's the father clas this means out class is 
    a subclass of Object, which means exactly that we can use all the methods there because we inhearted them.
    and toString methods is one of these methods that we are going to use here in this class
    
    we will override the method to make display our class in just one print statment instaid of many.
    */
    
    /* the toString methods returns the values as String and it's a public method which means we can call the method and get
      our class repreasntion where we want */
    public String toString() {
        return "Customer's Civil ID= " + theSpecialCivilID +
                ", Name: " + personsName + ", gender: " + gender + 
                ", Card Number= " + customerCardNumber + ", has Criminal Record? " + hasCriminalRecord ;
    }
    
    /*
    the equals method is also a method difined in Object class, we will override it to check if the user who send the number
    is the same as the user who rent the car by checking the civil id since there's no way that two people might have the same id
    and in this case, if the two IDs are the same the method will return true to inform us that it's the person who rent the car
    otherwise it will return false if the person didn't rent this car
    
    */
    
    // the equals mwthod is from type boolean because it will return either true or faalse
    public boolean equals(Object para){
    
        Customer checkVar = (Customer) para;
        return theSpecialCivilID == checkVar.theSpecialCivilID;
    } // end of equals method
    
} // end of class
