// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 03/16/2023

// Define the Singer class, which extends the Person class
public class Singer extends Person {
    // Define private instance variables to store the singer's debut album and release date
    private String debutAlbum;
    private Date debutAlbumReleaseDate;

    // Define a default constructor for the Singer class
    public Singer() {
        // Call the default constructor of the Person class
        super();
        // Set the debut album instance variable to an empty string
        debutAlbum = "";
        // Set the debut album release date instance variable to the current date and time
        debutAlbumReleaseDate = new Date();
    }

    // Define a parameterized constructor for the Singer class
    public Singer(String name, Date born, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
        // Call the parameterized constructor of the Person class with the specified name, birthdate, gender, and difficulty
        super(name, born, gender, difficulty);
        // Set the debut album instance variable to the specified debut album
        this.debutAlbum = debutAlbum;
        // Set the debut album release date instance variable to the specified debut album release date
        this.debutAlbumReleaseDate = debutAlbumReleaseDate;
    }

    // Define a copy constructor for the Singer class
    public Singer(Singer singer) {
        // Call the copy constructor of the Person class with the specified singer
        super(singer);
        // Set the debut album instance variable to the debut album of the specified singer
        debutAlbum = singer.debutAlbum;
        // Set the debut album release date instance variable to the debut album release date of the specified singer
        debutAlbumReleaseDate = singer.debutAlbumReleaseDate;
    }

    // Define a getter method for the debut album instance variable
    public String getDebutAlbum() {
        return debutAlbum;
    }

    // Define a setter method for the debut album instance variable
    public void setDebutAlbum(String debutAlbum) {
        this.debutAlbum = debutAlbum;
    }

    // Define a getter method for the debut album release date instance variable
    public Date getDebutAlbumReleaseDate() {
        return debutAlbumReleaseDate;
    }

    // Define a setter method for the debut album release date instance variable
    public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
        this.debutAlbumReleaseDate = debutAlbumReleaseDate;
    }

    // Override the entityType method of the Person class to return a string indicating that this entity is a singer
    @Override
    public String entityType() {
        return "This entity is a singer!";
    }

    // Override the clone method of the Person class to create a new Singer object by calling the copy constructor
    @Override
    public Singer clone() {
        return new Singer(this);
    }

    // Override the toString method of the Person class to return a string representation of the Singer object
    @Override
    public String toString() {
        // Call the toString method of the Person class to get the string representation of the Person object
        // and concatenate the debut album and debut album release date to it
        return super.toString() + "\nDebut album: " + debutAlbum + "\nDebut album release date: " + debutAlbumReleaseDate;
    }
}
