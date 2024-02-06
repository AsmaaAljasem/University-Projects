/*
 in this class we will print the results of our effort 
we made 5 classes and here we will use them to see the out put
 */
public class DisplayResults {
    
    // main method , everything we want to see on the screen should be here
    public static void main(String[] args) {
        
        // we will make four cars
        
        Car TheFirstCar = new Car(24,"Bentley",100,"USA",true,2013);
        Car TheSecondCar = new Car(27,"Chevrolet",500,"UK",true,2019);
        Car TheThirdCar = new Car(20,"BWW",250,"China",true,2015);
        Car TheForthCar = new Car(22,"Bentley",150,"USA",true,2018);
        Car TheFifthCar = new Car(25,"Chevrolet",350,"China",true,2020);
        
        // now we make 3 customers
       
        Customer clientOne = new Customer(1111,"Osama","Male",23456789,false);
        Customer clientTwo = new Customer(2222,"Siba","Female",98765423,false);
        Customer clientThree = new Customer(1111,"Osama","Male",13579246,false);
        
        BuildToRent.enterCar(TheFirstCar);
        BuildToRent.enterCar(TheSecondCar);
        BuildToRent.enterCar(TheThirdCar);
        BuildToRent.enterCar(TheForthCar);
        BuildToRent.enterCar(TheSecondCar);
        
        BuildToRent.justOneCar(TheThirdCar, clientThree, new TheCertainDate(3,4,2021));
        BuildToRent.justOneCar(TheSecondCar, clientTwo, new TheCertainDate(7,2,2021));
        BuildToRent.justOneCar(TheFirstCar, clientTwo, new TheCertainDate(3,4,2021));
        BuildToRent.justOneCar(TheFirstCar, clientTwo, new TheCertainDate(3,4,2021));
        BuildToRent.justOneCar(TheSecondCar, clientTwo, new TheCertainDate(5,4,2021));
        BuildToRent.justOneCar(TheFifthCar, clientTwo, new TheCertainDate(3,4,2021));
        
        BuildToRent.moreWantedCar();
        BuildToRent.writeInFile("src/theRentalProcess.txt");
       
        
    }// end of main method
} // end of class
