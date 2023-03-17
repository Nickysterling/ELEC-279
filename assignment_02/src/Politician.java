// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 03/16/2023

// Define the Politician class, which extends the Person class
public class Politician extends Person {

    // Define a private instance variable called party to store the politician's political party
    private String party;

    // Define a default constructor for the Politician class
    public Politician() {
        // Call the default constructor of the Person class
        super();
        // Set the party instance variable to an empty string
        party = "";
    }

    // Define a parameterized constructor for the Politician class
    public Politician(String name, Date born, String gender, String party, double difficulty) {
        // Call the parameterized constructor of the Person class with the specified name, birthdate, gender, and difficulty
        super(name, born, gender, difficulty);
        // Set the party instance variable to the specified political party
        this.party = party;
    }

    // Define a copy constructor for the Politician class
    public Politician(Politician politician) {
        // Call the copy constructor of the Person class with the specified politician
        super(politician);
        // Set the party instance variable to the political party of the specified politician
        party = politician.party;
    }

    // Define a getter method for the party instance variable
    public String getParty() {
        return party;
    }

    // Define a setter method for the party instance variable
    public void setParty(String party) {
        this.party = party;
    }

    // Override the entityType method of the Person class to return a string indicating that this entity is a politician
    @Override
    public String entityType() {
        return "This entity is a politician!";
    }

    // Override the clone method of the Person class to create a new Politician object by calling the copy constructor
    @Override
    public Politician clone() {
        return new Politician(this);
    }

    // Override the toString method of the Person class to return a string representation of the Politician object
    @Override
    public String toString() {
        // Call the toString method of the Person class to get the string representation of the Person object
        // and concatenate the political party to it
        return super.toString() + "\nPolitical Party: " + party;
    }
}