// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 03/16/2023

public class Person extends Entity {
    
	/* Instance Variables */
	private String gender;

	/* Constructors */
    public Person() {
		
    	/* Calls the default constructor of the parent class */
    	super();
		
    	/* Initialize gender string */
        gender = "";
    }
    
    public Person(String name, Date born, String gender, double difficulty) {
    	
		/* Call the constructor of the parent class with the given parameters */
    	super(name, born, difficulty);
    	
		/* Initialize the gender instance variable with the given value */
    	this.gender = gender;
	}
    
    public Person(Person person) {
        
		/* Call the copy constructor of the parent class with the given person object */
    	super(person);
    	
		/*
		 * Initialize gender instance variable with the gender value of the given person
		 * object
		 */
        gender = person.gender;
    }

	/* Accessor method to get the gender of the person */
	public String getGender() {
        return gender;
    }

	/* Mutator method to set the gender of the person */
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
	/* Method to return the entity type of a person */
    public String entityType() {
        return "This entity is a person!";
    }

    @Override
	/* Method to clone a person object */
    public Person clone() {
        return new Person(this);
    }

    @Override
	/* Method to return a string representation of a person object */
    public String toString() {
        return super.toString() + "\nGender: " + gender;
    }
}
