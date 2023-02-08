public class Entity {
    private String name;
    private Date born;

    // Constructors
    public Entity() {
        this("", new Date());
    }
    
    public Entity(String name, Date born) {
        this.name = name;
        this.born = new Date(born);
    }
    
    public Entity(Entity entity) {
        this(entity.name, entity.born);
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBorn(Date born) {
        this.born = new Date(born);
    }

    // Accessors
    public String getName() {
        return name;
    }
    
    public Date getBorn() {
        return new Date(born);
    }

    // toString method
    public String toString() {
        return name + ", born on " + born;
    }

    // equals method
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
