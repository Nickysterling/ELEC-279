// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 03/16/2023

public class Country extends Entity {
    private String capital;

    /* Default constructor */
    public Country() {
        super(); 			// Call Entity's default constructor
        capital = ""; 		// Set default value for capital
    }
    
    /* Constructor with arguments */
    public Country(String name, Date born, String capital, double difficulty) {
        super(name, born, difficulty); 		// Call Entity's constructor with arguments
        this.capital = capital; 			// Set value for capital
    }
    
    /* Copy constructor */
    public Country(Country country) {
        super(country); 				// Call Entity's copy constructor
        capital = country.capital; 		// Copy value for capital
    }

    /* Accessors and mutators */
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    /* Override methods from Entity */
    @Override
    public String entityType() {
        return "This entity is a country!"; 	// Return a string indicating the entity type
    }

    @Override
    public Country clone() {
        return new Country(this); 	// Use the copy constructor to create a new instance of Country
    }

    @Override
    public String toString() {
        return super.toString() + "\nCapital: " + capital; 	// Call Entity's toString and add capital
    }
}
