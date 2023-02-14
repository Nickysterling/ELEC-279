
// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 02/15/2023

public class Entity {
   
	/* Instance variables */
	private String name;
    private Date born;

    /* Default constructor */
    public Entity() {
        this("", new Date());
    }
    
	/* Constructor takes two parameters, a string "name" and a date object "born" */
    public Entity(String name, Date born) {
        this.name = name;
        this.born = new Date(born);
    }
    
    /* Constructor creates an Entity instance with the same instance variables 
     * as the parameter passed in */
    public Entity(Entity entity) {
        this(entity.name, entity.born);
    }

    /* Mutator function used to assign entity name */
    public void setName(String name) {
        this.name = name;
    }
    
    /* Mutator function used to assign entity DOB by calling Date constructor */
    public void setBorn(Date born) {
        this.born = new Date(born);
    }

    /* Accessor function used to retrieve entity name */
    public String getName() {
        return name;
    }
    
    /* Accessor function used to retrieve entity DOB */
    public Date getBorn() {
        return new Date(born);
    }

    /* Returns the name of the entity and their DOB in a string form */
    public String toString() {
        return name + ", born on " + born;
    }

	/*
	 * Checks if entity parameter instance variables are equal to instance variables
	 * of current object
	 */
    public boolean equals(Entity entity) {
        if (this == entity) {
            return true;
        }
        if (entity == null) {
            return false;
        }
        return name.equals(entity.name) && born.equals(entity.born);
    }
}
