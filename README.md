Grazioso Salvare - Animal Reservation System
This Animal Reservation System is a Java console application that helps manage and reserve animals for users. It supports two types of animals: dogs and monkeys. The application allows users to input new animals, reserve available animals, and view animal lists.
Features
* Add new dogs and monkeys to the system
* Reserve animals based on their in-service country
* View lists of all dogs, all monkeys, or all available animals
How to Use
1. Compile and run the Java application.
2. Follow the prompts in the console to interact with the application.
    * Choose an option from the main menu:
    * Add a new dog
    * Add a new monkey
    * Reserve an animal
    * Print a list of animals (all dogs, all monkeys, or all available animals)
    * Quit the application
3. Depending on the chosen option, provide the requested information.
4. The application will display the results of your action and return to the main menu.
Notes
* When adding a new dog, the system will ask for the dog's name, breed, gender, age, weight, acquisition date, acquisition country, training status, reservation status, in-service country, and other relevant attributes.
* When adding a new monkey, the system will ask for the monkey's name, species, gender, age, weight, acquisition date, acquisition country, training status, reservation status, in-service country, and other relevant attributes.
* The application only supports the following monkey species: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, and Tamarin.
* Animals can be reserved based on their in-service country. The system will find the first available animal (dog or monkey) that matches the specified in-service country, is in service, and is not already reserved.
