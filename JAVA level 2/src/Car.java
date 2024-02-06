/*

cars are not the same! Each car has its own characteristics that distinguish it from other cars.
but how are we going to put those characteristics into an application?
ofcourse it is not correct to make many variables just to store similar types of data,the best way to do it 
is to create a class that allow us to make many objects (cars) that has the similar data types that descripe its characteristics.
so here we make a class called Car and by this way we are making it possibale to create many cars that has differant featchers
without defining many variables and methods in the main method just to do the same job!
classes are easier and more efficient not to mention that it's a good programming style.
and also by using this class we can make unlimited number of object for cars! it's so usefull


and to do this job we followed specified steps:

*/
public class Car {
    
    /*
    the first step is we make wariables, we need to store the car's characteristics in a suitable variable
    data type so declared variable for each characteristic we want to use to describe the car
    
    the variables should be private to stay safe and protected from any changes from other classes
    */
    private int speicalNumberPlate; // the car must have a number plate so to store this number we made a variable from type int.
    private String carsBrand; // the name of the company is important and to store a name we should use String type.
    private int theRateOfTheRental; // this variable is to store the money that the user will pay so it's better be an int type.
    
//three variabless from me ((asked in the Q))
    private String whereTheCarWasMade; // which country made the car? and since the answer should be sequense of letters so the data type is String
    private boolean isClean; // is this car clean?
    private int produtionYear; // this variable will help us to know if the car is too old or no

    /*the variables above have no value yet,there is nothing stored in them.so we made multi argument constructor to
    make it easy to creat many cars with the wanted characteristics by sending each characteristic to the parametar and then
    each variable will take it's own value from the assigined parametar
    
    and this is the seconed step ((and most important step)) in building our class
    - i hope you understand ^.^ - */ 
    public Car()
    // zero argument constructer
    {
    this(0,null,0,null,false,0); // giving the variables initial values
    }
    public Car(int spNUpl, String company, int ren_rate, String country, boolean times, int prodYear) {
        speicalNumberPlate = spNUpl;
        carsBrand = company;
        theRateOfTheRental = ren_rate;
        whereTheCarWasMade = country;
        isClean = times;
        produtionYear = prodYear;
    }

    /*
    third step is : getter methods
    we have a private variables which means we can't call them in other classes or use them anywhere out of
    this class which is a problem because sometimes we need to print the value of a variable but if we can't reach it
    then we can't print it so what are we going to do?
    
    we solved this problem by making getter methods, by calling the geeter method we can use the vale of the variable successfully
    without getting any errors
    
    in the getter methods the user doesn't send any value so we didn't write an argument inside the ().
    */
    
    // the method here will get us the value of the variable speicalNumberPlate and its return type is int because the value is from type int
    public int bring_outSpeicalNumberPlate() {
        return speicalNumberPlate;
    }

    // the method here will get us the value of the variable carsBrand and its return type is String because the value is from type String
    public String bring_outCarsBrand() {
        return carsBrand;
    }

    // the method here will get us the value of the variable theRateOfTheRental and its return type is int because the value is from type int
    public int bring_outTheRateOfTheRental() {
        return theRateOfTheRental;
    }

    // the method here will get us the value of the variable whereTheCarWasMade and its return type is String because the value is from type String
    public String bring_outWhereTheCarWasMade() {
        return whereTheCarWasMade;
    }

    // the method here will get us the value of the variable isClean and its return type is boolean because the value is from type boolean
    public boolean bring_outIsClean() {
        return isClean;
    }

    // the method here will get us the value of the variable produtionYear and its return type is int because the value is from type int
    public int bring_outProdutionYear() {
        return produtionYear;
    }
    
    /*
    4th step is making setter methods
    in case we needed to change the value of a specific feature of the car without changing all the other features, we can use the setter methods
    
    the setter method get the value from the user so we write a single argument from the same data type of the orginal value that we want to change
    and then we will assign the new value that was send to the parametar to the orginal variable.
     also, since setter methods don't return any value we used the key word void.
    */
    
    // a method that helps to give the speicalNumberPlate variable a new value
    public void newSpeicalNumberPlate(int spelate) {
        speicalNumberPlate = spelate;
    }

    // a method that helps to give the carsBrand variable a new value
    public void newCarsBrand(String cand) {
        carsBrand = cand;
    }

    // a method that helps to give the theRateOfTheRental variable a new value
    public void newTheRateOfTheRental(int teOftal) {
        theRateOfTheRental = teOftal;
    }

    // a method that helps to give the whereTheCarWasMade variable a new value
    public void newWhereTheCarWasMade(String wherMade) {
        whereTheCarWasMade = wherMade;
    }

    // a method that helps to give the isClean variable a new value
    public void newRentPrice(boolean hontIt) {
        isClean = hontIt;
    }

    // a method that helps to give the produtionYear variable a new value
    public void newProdutionYear(int prYear) {
        produtionYear = prYear;
    }

    /*
    
    the 5th step to make a good class is to write a toString method
    the toString method is a method made in the root class Object, we are overriding this method to represent
    the class' components in one statement instaid of writing many print statements 
    
    the toString method returns a data from type String 
    */
    public String toString() {
        return "Car has a speical Number Plate= " + speicalNumberPlate + ", from the brand: " + carsBrand +
                ", with a rental rate= " + theRateOfTheRental + ", The Car Was Made in: " + whereTheCarWasMade +
                " in " + produtionYear+", the car is clean? " + isClean  ;
             
    }
    
    /*
    
     the equals method is a ggod addition to the class, it will help us to check if the car is the same by comparing the number plate
    of our car with a number we sent to the argument, and we chose to compair by the number plate because every car 
    has a special number that cannot be the same with another car 
    
    the method will return true if the two numbers are the same, otherwise it will return false so we put the return type boolean.
    */
    
    public boolean equals(Object thing){
    
        /*before we check if the numbers are the same, we need to do casting to resived value because the program won't work if the two
        are not from the same data type, and since the argument from type Object we convert it to the class type Car */
        Car checkTheCar = (Car) thing;
        
        // now it's ready to be checked and the answer will be ethier true or false 
        return speicalNumberPlate == checkTheCar.speicalNumberPlate;
    } // end of equals method
    
    // we will compare two number palet of diffrente cars.
    // the method compareTo is overriden
    public int comareTo (Car thisCar) {
    
    return new Integer(speicalNumberPlate).compareTo(thisCar.speicalNumberPlate);
    } // end of the compareTo method
    
} // end of class
