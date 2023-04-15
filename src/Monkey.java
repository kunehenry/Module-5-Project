/**
 * Monkey class is a subclass of RescueAnimal that represents a monkey with
 * specific attributes such as species, tail length, height, and body length.
 * 
 * @author Dat Nguyen
 * @version 2.0
 */
public class Monkey extends RescueAnimal {

    // Instance variables
    private String species;
    private double tailLength;
    private double height;
    private double bodyLength;


    
    /**
     * Constructor for the Monkey class.
     *
     * @param name               The name of the monkey.
     * @param species            The species of the monkey.
     * @param gender             The gender of the monkey.
     * @param age                The age of the monkey.
     * @param weight             The weight of the monkey.
     * @param acquisitionDate    The acquisition date of the monkey.
     * @param acquisitionCountry The acquisition country of the monkey.
     * @param trainingStatus     The training status of the monkey.
     * @param reserved           Whether the monkey is reserved.
     * @param inServiceCountry   The in-service country of the monkey.
     * @param tailLength         The tail length of the monkey.
     * @param height             The height of the monkey.
     * @param bodyLength         The body length of the monkey.
     */
    public Monkey(String name, String species, String gender, int age,
            double weight, String acquisitionDate, String acquisitionCountry,
            String trainingStatus, boolean reserved, String inServiceCountry,
            double tailLength, double height, double bodyLength) {
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

    /**
     * Gets the species of the monkey.
     *
     * @return The species of the monkey.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the tail length of the monkey.
     *
     * @return The tail length of the monkey.
     */
    public double getTailLength() {
        return tailLength;
    }

    /**
     * Gets the height of the monkey.
     *
     * @return The height of the monkey.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the body length of the monkey.
     *
     * @return The body length of the monkey.
     */
    public double getBodyLength() {
        return bodyLength;
    }

    

    // Mutator Methods

    /**
     * Sets the species of the monkey.
     *
     * @param monkeySpecies The species of the monkey.
     */
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }

    /**
     * Sets the tail length of the monkey.
     *
     * @param monkeyTailLength The tail length of the monkey.
     */
    public void setTailLength(double monkeyTailLength) {
        tailLength = monkeyTailLength;
    }

    /**
     * Sets the height of the monkey.
     *
     * @param monkeyHeight The height of the monkey.
     */
    public void setHeight(double monkeyHeight) {
        height = monkeyHeight;
    }

    /**
     * Sets the body length of the monkey.
     *
     * @param monkeyBodyLength The body length of the monkey.
     */
    public void setBodyLength(double monkeyBodyLength) {
        bodyLength = monkeyBodyLength;
    }
}