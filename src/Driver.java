import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>(); // Added Monkey ArrayList

    public static void main(String[] args) {
        initializeDogList();
        initializeMonkeyList();

        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            displayMenu();
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Quitting application...");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (!userInput.equalsIgnoreCase("q"));

        scanner.close();
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
                false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true,
                "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds monkeys to a list for testing
    // Optional for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("George", "Capuchin", "male", "2", "9.4", "01-15-2018", "Brazil", "Phase III",
                false, "United States", "12.5", "22.5", "18.0");
        Monkey monkey2 = new Monkey("Coco", "Marmoset", "female", "5", "8.1", "07-23-2019", "Colombia", "in service",
                false, "United States", "10.0", "20.0", "16.0");
        Monkey monkey3 = new Monkey("Bubbles", "Squirrel Monkey", "male", "3", "10.3", "03-30-2020", "Peru", "Phase II",
                true, "United States", "14.0", "24.0", "20.0");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // Complete the intakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; // returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
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

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus,
                reserved, inServiceCountry);
        dogList.add(newDog);
        System.out.println("\n\nDog added successfully!\n\n");
    }

    public static void intakeNewMonkey(Scanner scanner) {
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; // returns to menu
            }
        }

        System.out.println("Enter the monkey's species (Capuchin or Squirrel):");
        String species = scanner.nextLine();
        if (!species.equalsIgnoreCase("Capuchin") && !species.equalsIgnoreCase("Squirrel")) {
            System.out.println("\n\nInvalid species. Only Capuchin and Squirrel monkeys are allowed.\n\n");
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

        Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength);
        monkeyList.add(newMonkey);
        System.out.println("\n\nNew monkey added successfully!\n\n");
    }

    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter the type of animal you want to reserve (dog/monkey):");
        String animalType = scanner.nextLine();
        System.out.println("Enter the animal's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        boolean reserved = false;

        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {
                if (dog.getAcquisitionLocation().equalsIgnoreCase(acquisitionCountry)
                        && dog.getTrainingStatus().equalsIgnoreCase("Phase III") && !dog.getReserved()) {
                    dog.setReserved(true);
                    reserved = true;
                    System.out.println("\n\n" + dog.getName() + " is now reserved.\n\n");
                    break;
                }
            }
        } else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getAcquisitionLocation().equalsIgnoreCase(acquisitionCountry)
                        && monkey.getTrainingStatus().equalsIgnoreCase("Phase III") && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    reserved = true;
                    System.out.println("\n\n" + monkey.getName() + " is now reserved.\n\n");
                    break;
                }
            }
        } else {
            System.out.println("\n\nInvalid animal type.\n\n");
            return;
        }

        if (!reserved) {
            System.out.println("\n\nNo available " + animalType + " found in " + acquisitionCountry + ".\n\n");
        }
    }

    public static void printAnimals(String listType) {
        if (listType.equalsIgnoreCase("dog")) {
            System.out.println("\nList of all dogs:");
            for (Dog dog : dogList) {
                System.out.println(
                        "Name: " + dog.getName() + ", Status: " + dog.getTrainingStatus() + ", Acquisition Country: "
                                + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
            }
        } else if (listType.equalsIgnoreCase("monkey")) {
            System.out.println("\nList of all monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName() + ", Status: " + monkey.getTrainingStatus()
                        + ", Acquisition Country: " + monkey.getAcquisitionLocation() + ", Reserved: "
                        + monkey.getReserved());
            }
        } else if (listType.equalsIgnoreCase("available")) {
            System.out.println("\nList of all animals that are not reserved:");
            for (Dog dog : dogList) {
                if (!dog.getReserved()) { // Updated condition
                    System.out.println(
                            "Dog: " + dog.getName() + ", Acquisition Country: " + dog.getAcquisitionLocation());
                }
            }
            for (Monkey monkey : monkeyList) {
                if (!monkey.getReserved()) { // Updated condition
                    System.out.println("Monkey: " + monkey.getName() + ", Acquisition Country: "
                            + monkey.getAcquisitionLocation());
                }
            }
        } else {
            System.out.println("\n\nInvalid list type.\n\n");
        }
    }
}