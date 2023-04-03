/*
 * This program manages a rescue animal system, allowing users to intake new dogs and monkeys, 
 * reserve animals, and display lists of all dogs, monkeys, and available animals.
 * The main class (Driver) contains methods for displaying a menu, handling user input,
 * and managing animal lists.
 */

import java.util.ArrayList;
import java.util.Scanner;

// The Driver class is the main class of the rescue animal system.
public class Driver {
    // ArrayLists for storing dog and monkey objects.
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Added Monkey ArrayList

    public static void main(String[] args) {
        // Initialize lists with sample data.
        initializeDogList();
        initializeMonkeyList();

        // Create a scanner object for user input.
        Scanner scanner = new Scanner(System.in);
        String userInput;

        // Main program loop.
        do {
            // Display the menu to the user.
            displayMenu();

            // Read the user's input.
            userInput = scanner.nextLine();

            // Process the user's input using a switch statement.
            switch (userInput) {
                case "1":
                    // Intake a new dog.
                    intakeNewDog(scanner);
                    break;
                case "2":
                    // Intake a new monkey.
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    // Reserve an animal.
                    reserveAnimal(scanner);
                    break;
                case "4":
                    // Print a list of all dogs.
                    printAnimals("dog");
                    break;
                case "5":
                    // Print a list of all monkeys.
                    printAnimals("monkey");
                    break;
                case "6":
                    // Print a list of all available animals.
                    printAnimals("available");
                    break;
                case "q":
                    // Quit the application.
                    System.out.println("Quitting application...");
                    break;
                default:
                    // Handle invalid input.
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (!userInput.equalsIgnoreCase("q"));

        // Close the scanner.
        scanner.close();
    }

    // This method displays the menu options for the user to interact with
    // the Rescue Animal System.
    public static void displayMenu() {
        // Print empty lines for better readability.
        System.out.println("\n\n");

        // Print the menu header.
        System.out.println("\t\t\t\tRescue Animal System Menu");

        // Print each menu option with a brief description.
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");

        // Print an empty line for better readability.
        System.out.println();

        // Prompt the user to enter their menu selection.
        System.out.println("Enter a menu selection");
    }

    // This method initializes the dogList with sample data for testing purposes.
    public static void initializeDogList() {
        // Create sample dogs with their attributes.
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
                "Canada");
        Dog dog4 = new Dog("Max", "Labrador Retriever", "male", "2", "28.5", "01-15-2020", "United States",
                "in service",
                false, "United States");

        // Add the sample dogs to the dogList ArrayList.
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }

    // This method initializes the monkeyList with sample data for testing purposes.
    public static void initializeMonkeyList() {
        // Create sample monkeys with their attributes.
        Monkey monkey1 = new Monkey("George", "Capuchin", "male", "2", "9.4", "01-15-2018", "Brazil", "Phase III",
                false, "United States", "12.5", "22.5", "18.0");
        Monkey monkey2 = new Monkey("Coco", "Marmoset", "female", "5", "8.1", "07-23-2019", "Colombia", "in service",
                false, "United States", "10.0", "20.0", "16.0");
        Monkey monkey3 = new Monkey("Bubbles", "Squirrel Monkey", "male", "3", "10.3", "03-30-2020", "Peru", "Phase II",
                true, "United States", "14.0", "24.0", "20.0");
        Monkey monkey4 = new Monkey("Momo", "Tamarin", "female", "4", "8.5", "06-18-2018", "United States", "Phase II",
                false, "United States", "11.0", "21.0", "17.0");

        // Add the sample monkeys to the monkeyList ArrayList.
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
    }

    // This method collects user input to create a new Dog object and
    // add it to the dogList ArrayList.
    public static void intakeNewDog(Scanner scanner) {
        // Prompt user for the dog's name.
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();

        // Check if the dog is already in the dogList and return to the menu if it is.
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu
            }
        }

        // Collect other dog attributes from the user input.
        System.out.println("Enter the breed:");
        String breed = scanner.nextLine();
        System.out.println("Enter the gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the age:");
        String age = scanner.nextLine();
        System.out.println("Enter the weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog reserved? (yes/no):");
        boolean reserved = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.println("Enter the in-service country:");
        String inServiceCountry = scanner.nextLine();

        // Create a new Dog object with the collected attributes and add it to the
        // dogList ArrayList.
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("\n\nDog added successfully!\n\n");
    }

    // This method collects user input to create a new Monkey object
    // and add it to the monkeyList ArrayList.
    public static void intakeNewMonkey(Scanner scanner) {
        // Prompt user for the monkey's name.
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        // Check if the monkey is already in the monkeyList and return to the menu if it
        // is.
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to menu
            }
        }

        // Collect monkey attributes from the user input.
        System.out.println(
                "Enter the monkey's species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, or Tamarin):");
        String species = scanner.nextLine();
        if (!species.equalsIgnoreCase("Capuchin") && !species.equalsIgnoreCase("Guenon") &&
                !species.equalsIgnoreCase("Macaque") && !species.equalsIgnoreCase("Marmoset") &&
                !species.equalsIgnoreCase("Squirrel monkey") && !species.equalsIgnoreCase("Tamarin")) {
            System.out.println(
                    "\n\nInvalid species. Only Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, and Tamarin monkeys are allowed.\n\n");
            return;
        }

        System.out.println("Enter the monkey's gender:");
        String gender = scanner.nextLine();
        System.out.println("Enter the monkey's age:");
        String age = scanner.nextLine();
        System.out.println("Enter the monkey's weight:");
        String weight = scanner.nextLine();
        System.out.println("Enter the monkey's acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        System.out.println("Enter the monkey's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        System.out.println("Enter the monkey's training status:");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the monkey reserved? (yes/no):");
        boolean reserved = scanner.nextLine().equalsIgnoreCase("yes");
        System.out.println("Enter the monkey's in service country:");
        String inServiceCountry = scanner.nextLine();
        System.out.println("Enter the monkey's tail length:");
        String tailLength = scanner.nextLine();
        System.out.println("Enter the monkey's height:");
        String height = scanner.nextLine();
        System.out.println("Enter the monkey's body length:");
        String bodyLength = scanner.nextLine();

        // Create a new Monkey object with the collected attributes and add it to the
        // monkeyList ArrayList.
        Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
        monkeyList.add(newMonkey);
        System.out.println("\n\nNew monkey added successfully!\n\n");
    }

    // This method allows the user to reserve an available animal (dog or monkey)
    // based on their in-service country and ensures the animal is in service and
    // not already reserved.
    public static void reserveAnimal(Scanner scanner) {
        // Prompt the user for the animal type and in-service country
        System.out.println("Enter the type of animal you want to reserve (dog/monkey):");
        String animalType = scanner.nextLine();
        System.out.println("Enter the animal's in-service country:");
        String inServiceCountry = scanner.nextLine();
        boolean reserved = false;
        String reservedAnimalName = "";

        // If the animal type is a dog, search through the dogList for a matching,
        // in-service, unreserved dog
        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)
                        && dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    dog.setReserved(true);
                    reserved = true;
                    reservedAnimalName = dog.getName();
                    break;
                }
            }
        }
        // If the animal type is a monkey, search through the monkeyList for a matching,
        // in-service, unreserved monkey
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)
                        && monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    reserved = true;
                    reservedAnimalName = monkey.getName();
                    break;
                }
            }
        }
        // If an invalid animal type is entered, print an error message and return to
        // the menu
        else {
            System.out.println("\n\nInvalid animal type.\n\n");
            return;
        }

        // Print the reservation result based on whether an animal was successfully
        // reserved or not
        printReservationResult(animalType, inServiceCountry, reserved, reservedAnimalName);
    }

    // This method prints the reservation result, indicating the reserved animal's
    // name or notifying the user if no available animal was found in the specified
    // in-service country
    public static void printReservationResult(String animalType, String inServiceCountry, boolean reserved,
            String reservedAnimalName) {
        if (reserved) {
            System.out.println("\n\n" + reservedAnimalName + " is now reserved.\n\n");
        } else {
            System.out.println("\n\nNo available " + animalType + " found in " + inServiceCountry + ".\n\n");
        }
    }

    // This method prints a list of animals based on the specified listType (dog,
    // monkey, or available)
    public static void printAnimals(String listType) {
        // If the listType is "dog", print a list of all dogs
        if (listType.equalsIgnoreCase("dog")) {
            System.out.println("\nList of all dogs:");
            for (Dog dog : dogList) {
                System.out.println(
                        "Name: " + dog.getName() + ", Status: " + dog.getTrainingStatus() + ", Acquisition Country: "
                                + dog.getAcquisitionLocation() + ", In-Service Country: " + dog.getInServiceLocation()
                                + ", Reserved: " + dog.getReserved());
            }
        }
        // If the listType is "monkey", print a list of all monkeys
        else if (listType.equalsIgnoreCase("monkey")) {
            System.out.println("\nList of all monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName() + ", Status: " + monkey.getTrainingStatus()
                        + ", Acquisition Country: " + monkey.getAcquisitionLocation() + ", In-Service Country: "
                        + monkey.getInServiceLocation() + ", Reserved: " + monkey.getReserved());
            }
        }
        // If the listType is "available", print a list of all animals that are not
        // reserved and are in service
        else if (listType.equalsIgnoreCase("available")) {
            System.out.println("\nList of all animals that are not reserved:");
            boolean availableAnimalFound = false;
            for (Dog dog : dogList) {
                // Print only in-service dogs that are not reserved
                if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out
                            .println("Dog: " + dog.getName() + ", Acquisition Country: " + dog.getAcquisitionLocation()
                                    + ", In-Service Country: " + dog.getInServiceLocation());
                    availableAnimalFound = true;
                }
            }
            for (Monkey monkey : monkeyList) {
                // Print only in-service monkeys that are not reserved
                if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
                    System.out.println("Monkey: " + monkey.getName() + ", Acquisition Country: "
                            + monkey.getAcquisitionLocation() + ", In-Service Country: "
                            + monkey.getInServiceLocation());
                    availableAnimalFound = true;
                }
            }

            // If no available animals are found, print a message
            if (!availableAnimalFound) {
                System.out.println("There are no available animals at this time.");
            }
        }
        // If an invalid list type is entered, print an error message and return to the
        // menu
        else {
            System.out.println("\n\nInvalid list type.\n\n");
        }
    }
}