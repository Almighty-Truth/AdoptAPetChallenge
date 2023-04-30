/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalprojectp1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.UUID;

///**
// *
// * @author Khalil Tobias 
// * Date: 4/4/2023
// * Instructor: Cristy Charters
// * Class: Intermediate Java
// */
public class FinalProjectP1 {

    //Instance variables of the class
    Scanner keyboard = new Scanner(System.in); //Keyboard to get input from user
    Queue<Pet> dogQueue = new LinkedList<>(); //Queue for dogs
    Queue<Pet> catQueue = new LinkedList<>(); //Queue for cats 
    PriorityQueue<Pet> animalShelter = new PriorityQueue<>();//Queue to enter oldest pet
    Stack<Long> microchip = new Stack<>();

    private String name; //Name of pet
    private int dob; //Date of birth of pet
    private String species; //Species of pet
    Pet aPet; //Pet object

    public static void main(String[] args) {
        // TODO code application logic here

        //Create a default adopt a pet object to call methods on
        FinalProjectP1 test = new FinalProjectP1();
        test.displayMenu();
    }

    /**
     * This is the class pushes microchips if the user needs it
     */
    public void pushMicroChip() {
        if (microchip.isEmpty()) {
            System.out.println("The microchip stack is empty");
        } else {
            System.out.println("We have stacks of microchips.");
        }

        do {
            System.out.println("Do you want to push more microchips? (Y/N)");
            String answer = keyboard.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                long startTime = System.nanoTime();
                for (int i = 1; i < 100; i++) {
                    microchip.push((long) i);
                }
                long endTime = System.nanoTime();

                long ElapsedTime = endTime - startTime;

                System.out.println("The time taken to push 100 chips: " + ElapsedTime);
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Exiting....");
                break;
            } else {
                System.out.println("Please enter (Y/N)");
            }
        } while (true);

        System.out.println("\nThe microchip stack contains: " + microchip.size() + " chips");
    }

    /**
     * this displays the menu for the option below
     */
    public void displayMenu() {
        //boolean variable to keep going until the user no longer wishes to use the menu
        boolean KeepGoing = true;
        while (KeepGoing) {
            try {
                System.out.println("Select an option.");
                int menuOption;
                do {
                    System.out.println("1. Donate a Cat");
                    System.out.println("2. Donate a Dog");
                    System.out.println("3. Adopt a Cat");
                    System.out.println("4. Adopt a Dog");
                    System.out.println("5. Adopt oldest pet");
                    System.out.println("6. Add new microchip");
                    System.out.println("7. Exit");
                    menuOption = keyboard.nextInt(); //Set menu option to the next int
                    keyboard.nextLine(); //Clear the bufer in the keyboard

                    switch (menuOption) {

                        case 1 ->
                            specialCats(); //Menu option equal 1
                        case 2 ->
                            specialDogs(); //Menu option equal 2
                        case 3 ->
                            importantCats(); //Menu option equal 3
                        case 4 ->
                            importantDogs(); //Menu option equal 4
                        case 5 ->
                            greatshelter(); //Menu option equal 5
                        case 6 ->
                            pushMicroChip(); //Menu option equal 6
                        case 7 -> {
                            KeepGoing = false;   //Menu option equal 7 then exit
                            System.out.println("Thanks for adopting an animal");
                        }
                    }
                } while (menuOption != 7); //When menu option becomes 7 stop the loop
            } //Catch input mismatch exception
            catch (InputMismatchException e) {
                System.out.println("Sorry you can only enter numbers 1-6. Try again");
                keyboard.nextLine();
            } //Catch any other exception
            catch (Exception e) {
                System.out.println("Sorry you can only enter numbers 1-6. Try again");
                keyboard.nextLine();
            }
        }
    }

    /**
     * Ask user for appropriate information to create a pet object and add it to
     * the cat queue and the shelter queue
     */
    public void specialCats() 
    {    
        String microchipID;
        
        do
        {
            try
            {
                System.out.println("What is the name of the cat you are donating?");
                name = keyboard.nextLine();
                System.out.println("When was your cat born? format(yyyymmdd)");
                dob = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("What type of cat is it?");
                species = keyboard.next();
                
                String dobString = Integer.toString(dob);
                int year = Integer.parseInt(dobString.substring(0, 4));
                int month = Integer.parseInt(dobString.substring(4, 6));
                int day = Integer.parseInt(dobString.substring(6));
                
                if (year <= 2000 && year >= 2023)
                {
                    throw new Exception("Invalid year");
                }
                if(month <= 1 && month >=12)
                {
                    throw new Exception("Invalid month");
                }
                if(day <= 1 && day >=31)
                {
                    throw new Exception("Invalid day");
                }
                 microchipID = UUID.randomUUID().toString(); // generate a unique microchip ID for each cat as it is donated.
                aPet = new Pet(name, dob, species);
                // aPet.setMicrochipId(microchipID);
                catQueue.add(aPet);
                animalShelter.add(aPet);
                
                System.out.println(aPet + " has been added with a microchipID: " + microchipID + "\n");
                
                break; // exit the loop if all inputs are valid
            } catch(Exception e)
            {
                System.out.println("Invalid date format. Please try again.");
            }
        } while(true);
    }

    /**
     * Ask user for appropriate information to create a pet object and add it to
     * the dog queue and the shelter queue
     */
    public void specialDogs() 
    {
         String microchipID;
         Scanner keyboard = new Scanner(System.in);
         String name, species;
         int dob;
         Pet aPet;
         Queue<Pet> dogQueue = new LinkedList<>();
         List<Pet> animalShelter = new ArrayList<>();
         
        do
        {
            try
            {
                System.out.println("What is the name of the dog you are donating?");
                name = keyboard.nextLine();
                System.out.println("When was your dog born? format(yyyymmdd)");
                dob = keyboard.nextInt();
                keyboard.nextLine();
                System.out.println("What type of dog is it?");
                species = keyboard.next();
                
                String dobString = Integer.toString(dob);
                int year = Integer.parseInt(dobString.substring(0, 4));
                int month = Integer.parseInt(dobString.substring(4, 6));
                int day = Integer.parseInt(dobString.substring(6));
                
                if (year <= 2000 || year >= 2023)
                {
                    throw new Exception("Invalid year");
                }
                if(month <= 1 || month >=12)
                {
                    throw new Exception("Invalid month");
                }
                if(day <= 1 || day >=31)
                {
                    throw new Exception("Invalid day");
                }
                 microchipID = UUID.randomUUID().toString(); // generate a unique microchip ID for each cat as it is donated.
                aPet = new Pet(name, dob, species);
                // aPet.setMicrochipId(microchipID);
                dogQueue.add(aPet);
                animalShelter.add(aPet);
                
                System.out.println(aPet + " has been added with a microchipID: " + microchipID + "\n");
                
                break; // exit the loop if all inputs are valid
            } catch(Exception e)
            {
                System.out.println("Invalid date format. Please try again.");
            }
        } while(true);
    }

    /**
     * Remove the oldest cat from the queue and the shelter and print it out
     */
    public void importantCats() {
        Pet temp;
        temp = catQueue.remove();
        animalShelter.remove(temp);
        System.out.println("You have adopted" + temp + "\n");
    }

    /**
     * Remove the oldest dog from the queue and the shelter and print it out
     */
    public void importantDogs() {
        Pet temp;
        temp = dogQueue.remove();
        animalShelter.remove(temp);
        System.out.println("You have adopted" + temp + "\n");
    }

    /**
     * Remove the oldest cat or dog from the queue and depending on which was
     * removed also remove it from the appropriate queue
     */
    public void greatshelter() {
        Pet temp;
        temp = animalShelter.remove();
        if (catQueue.contains(temp)) {
            System.out.println("You have adopted" + catQueue.remove() + "\n");
        } else if (dogQueue.contains(temp)) {
            System.out.println("You have adopted" + dogQueue.remove() + "\n");
        }
    }
}
