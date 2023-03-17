// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 03/16/2023

// Define an abstract class Entity
public abstract class Entity {

    /* Instance variables */
    private String name; 		// The name of the entity
    private Date born; 			// The date of birth of the entity
    private double difficulty; 	// The difficulty level of the entity

    /* Constructors */
    
    // Default constructor
    public Entity() {
        this("", new Date(), 0.0);
    }

    // Constructor with arguments for name, birth date, and difficulty level
    public Entity(String name, Date born, double difficulty) {
        this.name = name;
        this.born = new Date(born); 	// Make a defensive copy of the Date object to avoid privacy leak
        this.difficulty = difficulty;
	}


    // Copy constructor
    public Entity(Entity entity) {
        this(entity.name, entity.born, entity.difficulty);
    }

    /* Accessors and mutators */
	// Setter for the name variable
    public void setName(String name) {
        this.name = name;
    }
    
    // Setter for the born variable
    public void setBorn(Date born) {
        this.born = new Date(born); 	// Make a defensive copy of the Date object to avoid privacy leak
    }

    // Setter for the difficulty variable
    public void setDifficulty(double difficulty) {
        // Check that the difficulty level is between 0 and 1 (Inclusive)
        if (difficulty < 0 || difficulty > 1) {
            throw new IllegalArgumentException("Difficulty must be between 0 and 1");
        }
        this.difficulty = difficulty;
    }

    // Getter for the name variable
    public String getName() {
        return name;
    }
    
    // Getter for the born variable
    public Date getBorn() {
        return new Date(born); 			// Make a defensive copy of the Date object to avoid privacy leak
    }

    // Getter for the difficulty variable
    public double getDifficulty() {
        return difficulty;
    }

    /* Abstract methods */
    public abstract String entityType();	// Method to return the type of entity
    public abstract Entity clone();			// Method to create a copy of the entity


    /* Method to calculate and return the number of awarded ticket */
    public int getAwardedTicketNumber() {
        return (int) (difficulty * 100);
    }

    /* Method to return a string representation of the entity */
    public String toString() {
        return "Name: " + name + "\nBorn on: " + born;
    }

    /* Method to return a welcome message for the entity */
    public String welcomeMessage() {
        return "Welcome! Let’s start the game! This entity is a " + entityType();
    }
    
    /* Method to return a closing message for the entity */
    public String closingMessage() {
        return "Congratulations! The detailed information of the entity you guess is: " + toString();
    }

    /* Method to check if two entities are equal */
    public boolean equals(Entity entity) {
        if (this == entity) {
            return true;
        }
        if (entity == null) {
            return false;
        }
        return name.equals(entity.name) && born.equals(entity.born) && difficulty == entity.difficulty;
    }
}
