

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
 
 */
public class BuildToRent {
    private static ArrayList<Car> multiCars = new ArrayList<Car>();
    private static ArrayList<RentTransaction> multiTrans = new ArrayList<RentTransaction>();

public BuildToRent(){} // i added it incase there was a mark on it.

public static void enterCar(Car carPlus){

    /* before we add any car to the list we need to check if the car is already there
    or not so we don't add it twice!
    by using for-each statement we will check each element in the list and compare it to the
    car that we want to add
    
    if the car is already there, then the new car won't be added, if it's not there
    then we will add the car to the list
    */ 
  
    // to use for each statement we declared a variable from type Car that will go to each elemant in the list
// we declared a boolean variable to store the result true or false (the excistance of the car in the list)
     boolean result = true ; // we but true as an initial value 
     for (Car k : multiCars)
     {
        if (carPlus.equals(k)) 
         { // we will compair if the car in the parametar carPlus is the same as an elemant in the list multiCars
 
         result = false; // if the car is already in the list, result value will be false (it tells us don't add it)
         break; // then we leave the if statement and for loop will stop
        } // end of if statment
     }// end for each statement
     
     if (result == true) // if the car is not in the list
     {
     multiCars.add(carPlus); //since we didn't find it in the list, now we add it.
     System.out.println("The car that has a number plate = "+ carPlus.bring_outSpeicalNumberPlate() + " is now in the list!");
     
     }// end of if statement 
     else 
         System.out.println("The car that has a number plate = "+ carPlus.bring_outSpeicalNumberPlate() + 
                 " is already in the list so we can't add it again!");
     
} // end of method


// we want to rent one car to one curtomer without renting this car twice in a day
// we put three parametars from our three classes that will represent the car and the person and the date
public static void  justOneCar (Car tc, Customer per, TheCertainDate today){

   /*before we rent the car we need to  check if our store has this car or not , and if we have it we need to check
    if the car was rented before or not ((if the car is avilable to be rent or not))*/ 
   
   // 1st we will check now if our company has bought the car that the user want.
    boolean foundCar = true;
    boolean holder = true;
    // to check we made for each statement to search the car
    for (Car player : multiCars)
    {
       if (player.equals(tc)){
           foundCar = true; // the company has the car
           break;
       }// end if
       
       else 
           foundCar = false; // car is not bought
    }// end for
   
   // 2nd we need a for each statement to check if the car is rented or not
   
   for(RentTransaction checker: multiTrans) // checker will go to each elemant and checks
   {
       /* we will check the car and the date to know it it's already rented or not*/ 
       if (checker.bring_outStoredCar().equals(tc) && checker.bring_outTime().equals(today))
       {
         holder = false; // if it's rented then holder will be false and this mean the user cant rent the car today and we won't add it to the list
         break; 
       } // end if
   } // end for each
    
    if (holder == true && foundCar == true) {
    
    /* we have a class called rentTransactions has a multiargument constructer
    that takes  a car and a customer and a date , so we will make an aoblect from that
    class by sending the data to the constructer and then we will store that object in the list multiTrans*/

    RentTransaction rentra = new RentTransaction (tc,per,today); // an object with information
    multiTrans.add(rentra); // the object will be stored in the list

      System.out.println("We allows you to rent the car " +tc.bring_outSpeicalNumberPlate()+" of the customer: "+
            per.bring_outTheSpecialCivilID()+" in "+today.toString()+" successfully,thanks for your help" );
    } // end if
    else if (holder == true ) {
        System.out.println("the task can not be done because the company don't have this car " + tc.bring_outSpeicalNumberPlate() );
    }
        
    else 
      System.out.println("repeated elemant, can't be added" );
    } // endo of method


/* we have many cars and we want to know how many times each car was rented
since every car the user rent is stored in the multiTrans arrayList , we will check
the arrayList and make a counter for each car was rented and then we will check all the 
elemants in the array to count the times this car repeated 

to do this task we need a for loop to know how many cars was rented and to make a counter for each car
and then we will need an innar for loop to search for the number of times the car was repeated in the list

after we count all the times that each car was reapeted in the list, we will find the car with the
highest times of repeatition to print
*/

public static void moreWantedCar (){
 int max = 0; // here we will store the highst number of the counter
 int numberOfWantedCar = 0 ; // here we will store the number plate of the most rented car
 
 // outer for loop will get each elemant 
 for (Car wanted: multiCars){
 
     int counter = 0;
     // inner loop will check how many times the elemant is repeated
     for(RentTransaction record : multiTrans) {
     
         if (wanted.equals(record.bring_outStoredCar()))
             counter++; // if the eleamnt exist we will increase counter by 1
     
     }// end of inner for each
 
     // after we finish the elemant we will check the counter value comaired to max value
     // if counter is greater than max then max will take the value of counter and we will get the number of that car 
     if (counter> max){
         max= counter; // max will take the value of counter if the condition is true
         numberOfWantedCar = wanted.bring_outSpeicalNumberPlate(); // here we will store the car number
         // if the condition is false, max won't take the value
     } // end of 2nd if
       
 }// end of for each

 System.out.println("The car "+numberOfWantedCar+" was rented more times than the other cars in total "+max+" times!");
}// end of method

/* as asked in the tma , we want to save the information we have in the multTrans list
in a text file, so we will make a method to this task perfectly */

public static void writeInFile(String textFile){

    // before we save it into file we will sort the list by using Collections
    Collections.sort(multiTrans);
    try{
String ce ="";
File thisFile = new File(textFile); // an object from the class File that is developed already in java
PrintWriter fileOfList = new PrintWriter(thisFile); 
    
for (RentTransaction rent: multiTrans){ 
// every elemant in the arrayList multiTrans will be repreasented in all details in by the toString
ce+= rent.toString();
}// end of for loop

    fileOfList.println(ce); // the toString will be writen in a file
    fileOfList.close();
    System.out.println("Task is completed!");
    } // end of try
    // in case we didn't find the file , we will print a message to the user
    catch(FileNotFoundException anError){
    System.out.println("The file doesn't exist");

    }// end of catch
    
}// end of method





} // end of class
