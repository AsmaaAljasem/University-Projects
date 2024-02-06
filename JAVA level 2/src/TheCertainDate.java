
/*
we were asked in the tma to get the date when the customer rent the car, sure we have a class in java was made by
java developers but sinse they told us in the question not to use a build class in java so we are going to make our own class
that will give us the date correctly.

and as before we will use the following steps to bulid a good and complete class
1- make instanse variables
2- zero argument constructor & multi argument constructor
3- setter methods
4- getter methods
5- toString method to fully represant the class

*/

// here we wrote the keyword class then we chose a name to our class, we didn't call it Date because java already has class with this name
// the class' modifire is public which means we can use it everywhere.
public class TheCertainDate {
    
    // the date consist of three important things , the day, the month, and the year and that's why we declared 3 instance variables here.
    private int paymentDay; // in the first variable we will store the day
    private int paymentMonth; // in the second variable we will store the number of the month
    private int paymentYear; // and lastly we will store the year.

    // we made a zero argument constructor that gives tha instans variables their defualt values
    // since all the variables are from type int, so the defualt values are 0,0,0
   
    public TheCertainDate (){
    
        this(0,0,0);
    } // end of constructor, it's a zero argument
    
    // we made a multi argument constructor to assign the date that the user sends to our instans variables
    public TheCertainDate(int payDay, int mentnth, int payar) {
        paymentDay = payDay; // assigning the day's value from the parametar to the instans variable
        paymentMonth = mentnth; // assigning the month's value from the parametar to the instans variable
        paymentYear = payar; // assigning the year's value from the parametar to the instans variable
    } // end of multi-Argument Constructor
    
    /* we made a three getter methods because we have three variable and all of them are private so we used the
    geeters to help us to use the values of these variables without facing a problem 
    
    
    the getters modifires are public and return data from type int */ 

    // after we wrote public and difined the data type we write the method name, we can use any name.
    // this method will give us the value of the day
    public int bring_outPaymentDay() {
        return paymentDay;
    } // end of 1st getter method

    // this method will give us the value of the month
    public int bring_outPaymentMonth() {
        return paymentMonth;
    } // end of 2nd getter method

    // this method will give us the value of the year
    public int bring_outPaymentYear() {
        return paymentYear;
    } // end of 3rd getter method

    /*
    now the setter methods , we surly need these methods because if we wanted to change the value of a private variable we can only
    do that with the setter methods, and thats why we declared three methods. because we have three variables and all of them
    with a private modifire
    
    so here we made the methods' modifire public in case we wanted to use it in many classes or packages.
    the setters only recive, the don't send values so we wrote the keyword void then we named each method.
    */ 
    
    // this setter method will recive a new value of the day then it will assign it to the day's instans variable
    public void newPaymentDay(int paDay) {
        paymentDay = paDay;
    } // end of setter method

    // this setter method will recive a new value of the month then it will assign it to the month's instans variable
    public void newPaymentMonth(int payMon) {
        paymentMonth = payMon;
    } // end of setter method

    // this setter method will recive a new value of the year then it will assign it to the year's instans variable
    public void newPaymentYear(int mentYe) {
        paymentYear = mentYe;
    } // end of setter method

    // an overriden toString method
    // used to display the date in an organaized way
    // public and returns the date as String
    public String toString() {
        return "The rental process Date: " +  paymentDay + "/" + paymentMonth + "/" + paymentYear;
    } // end of toString method
    
    
    // overriden equals methods
    // checks if the two dates are matched or not
    // in case there's a match it will return true, otherwise it will return false
    // boolean becuase the return vlaue either true or flase
    // checks the three variables beacuse we need the day and month and year to know if the date is the same or no.
    public boolean equals(Object arg){
    TheCertainDate when = (TheCertainDate) arg;
    return paymentDay==when.paymentDay && paymentMonth == when.paymentMonth && paymentYear == when.paymentYear;
    } // end of equals method 
} // end of class
