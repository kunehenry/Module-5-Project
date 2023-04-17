
/**
 * This program manages a rescue animal system, allowing users to intake new dogs and monkeys, 
 * reserve animals, and display lists of all dogs, monkeys, and available animals.
 * The main class (Driver) contains methods for displaying a menu, handling user input,
 * and managing animal lists.
 *
 * @author Dat Nguyen
 * @version 2.0
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The Driver class is the main class of the rescue animal system.
 */
public class Driver {
    // ArrayLists for storing dog and monkey objects.
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Added Monkey ArrayList

    // SimpleDateFormat for parsing and formatting dates in the "MM-dd-yyyy"
    // pattern.
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    /**
     * The main method of the application, where the program execution starts.
     * It initializes the dog and monkey lists with sample data, creates a scanner
     * object for user input, and provides a menu to the user for performing
     * various actions, such as intake a new dog or monkey, reserve an animal,
     * and print a list of animals.
     *
     * @param args Command line arguments.
     */
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

    /**
     * This method displays the menu options for the user to interact with
     * the Rescue Animal System. It prints each menu option with a brief
     * description, and prompts the user to enter their menu selection.
     */
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
        System.out.println("[6] Print a list of all In-Service animals that are not reserved");
        System.out.println("[q] Quit application");

        // Print an empty line for better readability.
        System.out.println();

        // Prompt the user to enter their menu selection.
        System.out.println("Enter a menu selection");
    }

    /**
     * This method initializes the dogList with sample data for testing purposes.
     * It creates sample dogs with their attributes and adds them to the dogList
     * ArrayList.
     */
    public static void initializeDogList() {
        // Create sample dogs with their attributes.
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", 1, 25.6, "05-12-2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", 3, 35.2, "02-03-2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", 4, 25.6, "12-12-2019", "Canada", "in-service", true,
                "Canada");
        Dog dog4 = new Dog("Max", "Labrador Retriever", "male", 2, 28.5, "01-15-2020", "United States",
                "in-service", false, "United States");

        // Add the sample dogs to the dogList ArrayList.
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }

    /**
     * This method initializes the monkeyList with sample data for testing purposes.
     * It creates sample monkeys with their attributes and adds them to the
     * monkeyList ArrayList.
     */
    public static void initializeMonkeyList() {
        // Create sample monkeys with their attributes.
        Monkey monkey1 = new Monkey("George", "Capuchin", "male", 2, 9.4, "01-15-2018", "Brazil", "Phase III",
                false, "United States", 12.5, 22.5, 18.0);
        Monkey monkey2 = new Monkey("Coco", "Marmoset", "female", 5, 8.1, "07-23-2019", "Colombia", "in-service",
                false, "Colombia", 10.0, 20.0, 16.0);
        Monkey monkey3 = new Monkey("Bubbles", "Squirrel Monkey", "male", 3, 10.3, "03-30-2020", "Peru", "Phase II",
                true, "United States", 14.0, 24.0, 20.0);
        Monkey monkey4 = new Monkey("Momo", "Tamarin", "female", 4, 8.5, "06-18-2018", "United States", "Phase II",
                false, "United States", 11.0, 21.0, 17.0);

        // Add the sample monkeys to the monkeyList ArrayList.
        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
    }

    /**
     * Intakes a new dog's information from the user and adds it to the dog list.
     *
     * @param scanner A Scanner object for reading user input.
     */
    public static void intakeNewDog(Scanner scanner) {
        try {
            // Prompt for the dog's name and return if the input is null.
            String name = promptForName(scanner, dogList);
            if (name == null)
                return;

            // Prompt for the dog's breed and return if the input is null.
            String breed = promptForAttribute(scanner, "Enter the breed:");
            if (breed == null)
                return;

            // Prompt for the dog's gender and return if the input is null.
            String gender = promptForGender(scanner);
            if (gender == null)
                return;

            // Prompt for the dog's age and return if the input is -1.
            int age = promptForInt(scanner, "Enter the age:");
            if (age == -1)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Prompt for the dog's weight and return if the input is -1.0.
            double weight = promptForDouble(scanner, "Enter the weight:");
            if (weight == -1.0)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Prompt for the dog's acquisition date and return if the input is null.
            String acquisitionDate = promptForDate(scanner, "Enter the acquisition date (MM-DD-YYYY):");
            if (acquisitionDate == null)
                return;

            // Prompt for the dog's acquisition country and return if the input is null.
            String acquisitionCountry = promptForAttribute(scanner, "Enter the acquisition country:");
            if (acquisitionCountry == null)
                return;

            // Prompt for the dog's training status and return if the input is null.
            String trainingStatus = promptForTrainingStatus(scanner);
            if (trainingStatus == null)
                return;

            // Prompt for whether the dog is reserved.
            boolean reserved = promptForBoolean(scanner, "Is the dog reserved? (yes/no):");

            // Prompt for the dog's in-service country and return if the input is null.
            String inServiceCountry = promptForAttribute(scanner, "Enter the in-service country:");
            if (inServiceCountry == null)
                return;

            // Create a new Dog object and add it to the dogList.
            Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                    reserved, inServiceCountry);

            // Add the new dog to the dogList.
            dogList.add(newDog);

            // Print a success message.
            System.out.println("\n\nDog added successfully!\n\n");

            // Handle number format exceptions.
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid input. Please enter a valid number.\n\n");

            // Handle date parsing exceptions.
        } catch (ParseException e) {
            System.out.println("\n\nInvalid date format. Please enter the date in the format MM-DD-YYYY.\n\n");
        }
    }

    /**
     * Intakes a new monkey's information from the user and adds it to the monkey
     * list.
     *
     * @param scanner A Scanner object for reading user input.
     */
    public static void intakeNewMonkey(Scanner scanner) {
        try {
            // Prompt for the monkey's name and return if the input is null.
            String name = promptForName(scanner, monkeyList);
            if (name == null)
                return;

            // Prompt for the monkey's species and return if the input is null.
            String species = promptForSpecies(scanner);
            if (species == null)
                return;

            // Prompt for the monkey's gender and return if the input is null.
            String gender = promptForGender(scanner);
            if (gender == null)
                return;

            // Prompt for the monkey's age and return if the input is -1.
            int age = promptForInt(scanner, "Enter the monkey's age:");
            if (age == -1)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Prompt for the monkey's weight and return if the input is -1.0.
            double weight = promptForDouble(scanner, "Enter the monkey's weight:");
            if (weight == -1.0)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Prompt for the monkey's acquisition date and return if the input is null.
            String acquisitionDate = promptForDate(scanner, "Enter the acquisition date (MM-DD-YYYY):");
            if (acquisitionDate == null)
                return;

            // Prompt for the monkey's acquisition country and return if the input is null.
            String acquisitionCountry = promptForAttribute(scanner, "Enter the monkey's acquisition country:");
            if (acquisitionCountry == null)
                return;

            // Prompt for the monkey's training status and return if the input is null.
            String trainingStatus = promptForTrainingStatus(scanner);
            if (trainingStatus == null)
                return;

            // Prompt for whether the monkey is reserved.
            boolean reserved = promptForBoolean(scanner, "Is the monkey reserved? (yes/no):");

            // Prompt for the monkey's in-service country and return if the input is null.
            String inServiceCountry = promptForAttribute(scanner, "Enter the monkey's in-service country:");
            if (inServiceCountry == null)
                return;

            // Prompt for the monkey's tail length and return if the input is -1.0.
            double tailLength = promptForDouble(scanner, "Enter the monkey's tail length:");
            if (tailLength == -1.0)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Prompt for the monkey's height and return if the input is -1.0.
            double height = promptForDouble(scanner, "Enter the monkey's height:");
            if (height == -1.0)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Prompt for the monkey's body length and return if the input is -1.0.
            double bodyLength = promptForDouble(scanner, "Enter the monkey's body length:");
            if (bodyLength == -1.0)
                return;

            // Clear any newline character from the input buffer.
            scanner.nextLine();

            // Create a new Monkey object and add it to the monkeyList.
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry,
                    trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);

            // Add the new monkey to the monkeyList.
            monkeyList.add(newMonkey);

            // Print a success message.
            System.out.println("\n\nNew monkey added successfully!\n\n");

            // Handle number format exceptions.
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid input. Please enter a valid number.\n\n");

            // Handle date parsing exceptions.
        } catch (ParseException e) {
            System.out.println("\n\nInvalid date format. Please enter the date in the format MM-DD-YYYY.\n\n");
        }
    }

    /**
     * This method allows the user to reserve an available animal (dog or monkey)
     * based on their in-service country and ensures the animal is in-service and
     * not already reserved.
     * 
     * @param scanner Scanner object to read user input.
     */
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
                        && dog.getTrainingStatus().equalsIgnoreCase("in-service") && !dog.getReserved()) {
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
                        && monkey.getTrainingStatus().equalsIgnoreCase("in-service") && !monkey.getReserved()) {
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

    /**
     * This method prints a list of animals based on the specified listType (dog,
     * monkey, or available).
     *
     * @param listType The type of list to print (dog, monkey, or available).
     */
    public static void printAnimals(String listType) {
        // If the listType is "dog", print a list of all dogs
        if (listType.equalsIgnoreCase("dog")) {
            System.out
                    .println("\n\n                                                               LIST OF ALL DOGS:\n");
            for (Dog dog : dogList) {
                System.out.println(
                        "    Name: " + dog.getName() + " | Breed: " + dog.getBreed() + " | Age: " + dog.getAge()
                                + " | Gender: " + dog.getGender() + " | Weight: " + dog.getWeight());
                System.out.println("        Status: " + dog.getTrainingStatus() + " | Reserved: " + dog.getReserved()
                        + " | In-Service Country: " + dog.getInServiceLocation() + " | Acquisition Country: "
                        + dog.getAcquisitionLocation() + " | Acquisition Date: " + dog.getAcquisitionDate() + "\n");
            }
        }
        // If the listType is "monkey", print a list of all monkeys
        else if (listType.equalsIgnoreCase("monkey")) {
            System.out.println(
                    "\n\n                                                               LIST OF ALL MONKEYS:\n");
            for (Monkey monkey : monkeyList) {
                System.out.println("    Name: " + monkey.getName() + " | Species: " + monkey.getSpecies() + " | Age: "
                        + monkey.getAge() + " | Gender: " + monkey.getGender() + " | Weight: " + monkey.getWeight()
                        + " | Tail Length: " + monkey.getTailLength() + " | Height: " + monkey.getHeight()
                        + " | Body Length: " + monkey.getBodyLength());
                System.out.println("        Status: " + monkey.getTrainingStatus() + " | Reserved: "
                        + monkey.getReserved()
                        + " | In-Service Country: " + monkey.getInServiceLocation() + " | Acquisition Country: "
                        + monkey.getAcquisitionLocation() + " | Acquisition Date: " + monkey.getAcquisitionDate()
                        + "\n");
            }

        }
        // If the listType is "available", print a list of all animals that are not
        // reserved and are in-service
        else if (listType.equalsIgnoreCase("available")) {
            System.out.println(
                    "\n\n                                                  LIST OF ALL IN-SERVICE ANIMALS THAT ARE AVAILABLE:\n");
            boolean availableAnimalFound = false;
            for (Dog dog : dogList) {
                // Print only in-service dogs that are not reserved
                if (!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in-service")) {
                    System.out.println(
                            "    Name: " + dog.getName() + " | Breed: " + dog.getBreed() + " | Age: " + dog.getAge()
                                    + " | Gender: " + dog.getGender() + " | Weight: " + dog.getWeight());
                    System.out.println("        Status: " + dog.getTrainingStatus() + " | Reserved: "
                            + dog.getReserved()
                            + " | In-Service Country: " + dog.getInServiceLocation() + " | Acquisition Country: "
                            + dog.getAcquisitionLocation() + " | Acquisition Date: " + dog.getAcquisitionDate() + "\n");
                    availableAnimalFound = true;
                }
            }
            for (Monkey monkey : monkeyList) {
                // Print only in-service monkeys that are not reserved
                if (!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in-service")) {
                    System.out.println("    Name: " + monkey.getName() + " | Species: " + monkey.getSpecies()
                            + " | Age: "
                            + monkey.getAge() + ", Gender: " + monkey.getGender() + ", Weight: " + monkey.getWeight()
                            + " | Tail Length: " + monkey.getTailLength() + " | Height: " + monkey.getHeight()
                            + " | Body Length: " + monkey.getBodyLength());
                    System.out.println("        Status: " + monkey.getTrainingStatus() + " | Reserved: "
                            + monkey.getReserved()
                            + " | In-Service Country: " + monkey.getInServiceLocation() + " | Acquisition Country: "
                            + monkey.getAcquisitionLocation() + " | Acquisition Date: " + monkey.getAcquisitionDate()
                            + "\n");
                    availableAnimalFound = true;
                }
            }

            // If no available animals are found, print a message
            if (!availableAnimalFound) {
                System.out.println("There is no available animal at this time.");
            }
        }
        // If an invalid list type is entered, print an error message and return to the
        // menu
        else {
            System.out.println("\n\nInvalid list type.\n\n");
        }
    }

    /**
     * This method prints the reservation result, indicating the reserved animal's
     * name or notifying the user if no available animal was found in the specified
     * in-service country.
     *
     * @param animalType         The type of animal to reserve (dog or monkey).
     * @param inServiceCountry   The in-service country where the animal is serving.
     * @param reserved           A boolean flag indicating if an animal was reserved
     *                           or not.
     * @param reservedAnimalName The name of the reserved animal.
     */
    public static void printReservationResult(String animalType, String inServiceCountry, boolean reserved,
            String reservedAnimalName) {
        if (reserved) {
            System.out.println("\n\n" + reservedAnimalName + " is now reserved.\n\n");
        } else {
            System.out.println("\n\nNo available " + animalType + " found in " + inServiceCountry + ".\n\n");
        }
    }

    /**
     * Additional helper methods to collect and validate user input:
     */

    /**
     * This method prompts the user for the animal's name and checks if it already
     * exists in the
     * system.
     *
     * @param scanner    The Scanner object used for reading user input.
     * @param animalList The list of RescueAnimal objects to search for a name
     *                   match.
     * @return The animal's name if it doesn't exist in the system, or null if it
     *         does.
     */
    private static String promptForName(Scanner scanner, ArrayList<? extends RescueAnimal> animalList) {
        System.out.println("What is the animal's name?");
        String name = scanner.nextLine();

        // Check if the animal's name already exists in the system
        for (RescueAnimal animal : animalList) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis animal is already in our system\n\n");
                return null;
            }
        }

        return name;
    }

    /**
     * This method prompts the user for an attribute and validates that the input is
     * not empty.
     *
     * @param scanner The Scanner object used for reading user input.
     * @param prompt  The message to display to the user when asking for input.
     * @return The user's input if it is not empty, or null if it is.
     */
    private static String promptForAttribute(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();

        // Check if the input is empty
        if (input == "") {
            System.out.println("\n\nInvalid input. Input is empty.\n\n");
            return null;
        }
        return input;
    }

    /**
     * This method prompts the user for the animal's gender and validates the input.
     *
     * @param scanner The Scanner object used for reading user input.
     * @return The animal's gender if it is valid, or null if it is not.
     */
    private static String promptForGender(Scanner scanner) {
        System.out.println("Enter the gender (male/female):");
        String gender = scanner.nextLine();

        // Validate the input for gender
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
            System.out.println("\n\nInvalid input. Please enter a valid gender.\n\n");
            return null;
        }

        return gender;
    }

    /**
     * This method prompts the user for an integer value and validates that the
     * input is
     * positive.
     *
     * @param scanner The Scanner object used for reading user input.
     * @param prompt  The message to display to the user when asking for input.
     * @return The user's input if it is positive, or -1 if it is not.
     */
    private static int promptForInt(Scanner scanner, String prompt) {
        System.out.println(prompt);
        int input = scanner.nextInt();

        // Check if the input is positive
        if (input < 0) {
            System.out.println("\n\nInvalid input. Please enter a positive number.\n\n");
            return -1;
        }
        return input;
    }

    /**
     * This method prompts the user for a double value and validates that the input
     * is positive.
     *
     * @param scanner The Scanner object used for reading user input.
     * @param prompt  The message to display to the user when asking for input.
     * @return The user's input if it is positive, or -1.0 if it is not.
     */
    private static double promptForDouble(Scanner scanner, String prompt) {
        System.out.println(prompt);
        double input = scanner.nextDouble();

        // Check if the input is positive
        if (input < 0.0) {
            System.out.println("\n\nInvalid input. Please enter a positive number.\n\n");
            return -1.0;
        }
        return input;
    }

    /**
     * This method prompts the user for a date and validates that the input is in
     * the correct
     * format.
     *
     * @param scanner The Scanner object used for reading user input.
     * @param prompt  The message to display to the user when asking for input.
     * @return The date as a string if it is valid, or null if it is not.
     * @throws ParseException If the input date is not in the correct format.
     */
    private static String promptForDate(Scanner scanner, String prompt) throws ParseException {
        System.out.println(prompt);
        String dateString = scanner.nextLine();

        dateFormat.setLenient(false);
        dateFormat.parse(dateString);

        return dateString;
    }

    /**
     * This method prompts the user for the training status of the animal and
     * validates the
     * input.
     *
     * @param scanner The Scanner object used for reading user input.
     * @return The training status if it is valid, or null if it is not.
     */
    private static String promptForTrainingStatus(Scanner scanner) {
        String[] validStatuses = { "Phase I", "Phase II", "Phase III", "Phase IV", "Phase V", "In-service", "Intake",
                "Farm" };

        System.out.println(
                "Enter the training status (Intake | Phase I | Phase II | Phase III | Phase IV | Phase V | In-service | Farm):");
        String trainingStatus = scanner.nextLine();

        // Check if the input matches any of the valid training statuses
        for (String status : validStatuses) {
            if (status.equalsIgnoreCase(trainingStatus)) {
                return trainingStatus;
            }
        }

        System.out.println("\n\nInvalid input. Please enter a valid training status.\n\n");
        return null;
    }

    /**
     * This method prompts the user for a boolean value with a custom prompt
     * message.
     *
     * @param scanner The Scanner object used for reading user input.
     * @param prompt  The message to display to the user when asking for input.
     * @return True if the user enters "yes", false otherwise.
     */
    private static boolean promptForBoolean(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().equalsIgnoreCase("yes");
    }

    /**
     * Prompts the user for the species of a monkey and validates the input.
     *
     * @param scanner The Scanner object used for reading user input.
     * @return The species if it is valid, or null if it is not.
     */
    private static String promptForSpecies(Scanner scanner) {
        String[] validSpecies = { "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin" };
        // Display the prompt for the user to enter the monkey's species
        System.out.println(
                "Enter the monkey's species (Capuchin | Guenon | Macaque | Marmoset | Squirrel monkey | Tamarin):");
        String inputSpecies = scanner.nextLine();

        // Check if the input matches any of the valid monkey species
        for (String species : validSpecies) {
            if (species.equalsIgnoreCase(inputSpecies)) {
                return inputSpecies;
            }
        }

        System.out.println("\n\nInvalid species. Please enter a valid species.\n\n");
        return null;
    }
}