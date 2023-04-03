/**
 * Monkey class is a subclass of RescueAnimal that represents a monkey with
 * specific attributes such as species, tail length, height, and body length.
 */
public class Monkey extends RescueAnimal {

    // Instance variables
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    // Constructor
    public Monkey(String name, String species, String gender, String age,
            String weight, String acquisitionDate, String acquisitionCountry,
            String trainingStatus, boolean reserved, String inServiceCountry,
            String tailLength, String height, String bodyLength) {
        // Set the inherited attributes using setter methods
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

        // Set the Monkey-specific attributes using setter methods
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
    }

    // Accessor Methods

    // Getter method for species
    public String getSpecies() {
        return species;
    }

    // Getter method for tail length
    public String getTailLength() {
        return tailLength;
    }

    // Getter method for height
    public String getHeight() {
        return height;
    }

    // Getter method for body length
    public String getBodyLength() {
        return bodyLength;
    }

    // Mutator Methods

    // Setter method for species
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }

    // Setter method for tail length
    public void setTailLength(String monkeyTailLength) {
        tailLength = monkeyTailLength;
    }

    // Setter method for height
    public void setHeight(String monkeyHeight) {
        height = monkeyHeight;
    }

    // Setter method for body length
    public void setBodyLength(String monkeyBodyLength) {
        bodyLength = monkeyBodyLength;
    }
}
