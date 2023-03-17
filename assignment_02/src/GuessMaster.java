// name: Nicholas Seegobin
// student_number: 20246787
// date_of_submission: 03/16/2023

/* Import statements */
import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	/* Instance variables */

	/* Counter to track number of Entity objects added to entities array */
	private int numberOfCandidateEntities;
	private int currentTickets;
	private int numTicketsTotal;
	
	/* An array that holds objects of type Entity */
	private Entity[] entities;
	private Scanner sc;

	/* Default Constructor */
	public GuessMaster() {
		numberOfCandidateEntities = 0;
		entities = new Entity[10];
		sc = new Scanner(System.in);
	}

	/* Adds an Entity to the Entities array */
	public void addEntity(Entity entity) {
		entities[numberOfCandidateEntities++] = entity.clone();
	}

	/*
	 * Generates a random integer between 0 (inclusive) and
	 * numberOfCandidateEntities (exclusive)
	 */
	
	private int genRandomEntity() {
		Random rand = new Random();
		return rand.nextInt(numberOfCandidateEntities);
	}

	/*
	 * Generates a random array index using genRandomEntity() Continues generating
	 * new Entities to guess until user quits
	 */
	public void playGame() {

		/* String used as a looping condition for the do while loop */
		String continuePlaying;

		do {
			welcomeMessage();
			/* Generate a random Entity in the array using genRandomEntity() */
			int randomEntityInd = genRandomEntity();
			
			/* Pass the randomly generated entity to playGame(int) */
			playGame(randomEntityInd);
			
			/* Prompt to ask the user if they would like to continue playing */
			System.out.println("Guess another entity's birthdate? (y/n)");
			continuePlaying = sc.nextLine();
			
		} while (continuePlaying.equalsIgnoreCase("y"));

		System.out.println("Thanks for playing!");
		sc.close();
	}

	/* Select the chosen Entity in the generated index */
	public void playGame(int entityInd) {
		playGame(entities[entityInd]);
	}

	/*
	 * Takes an Entity object as input, prompts the user to guess the entity's DOB
	 */
	public void playGame(Entity entity) {

		System.out.println(entity.entityType() + "\n");

		/* Variables used to manipulate the format of the DOB string */
		String entityBirthday = "";
		String day, month, year;

		/* Get DOB information about Entities */
		day = addZero(entity.getBorn().getDay());
		month = addZero(entity.getBorn().getMonth());
		year = addZero(entity.getBorn().getYear());

		/* Concatenate DOB information and store it in entityBirthday */
		entityBirthday = month + "/" + day + "/" + year;

		/* Prompt the user to guess the DOB of the Entity */
		System.out.println("Guess " + entity.getName() + "'s birthdate (MM/DD/YYYY)");
		String userGuess = sc.nextLine();

		/* Continually looping until the user quits out of the game */
		while (!userGuess.equalsIgnoreCase("quit")) {

			/* Try catch used to eliminate the ArrayIndexOutOfBounds error */
			try {

				/* Stores each element of the userGuess as a string by splitting at the '/' */
				String[] elements = userGuess.split("/");
				userGuess = "";

				/* Formatting the userGuess String to match the entityBirthday String */
				for (int i = 0; i < 3; i++) {
					if (i == 2)
						userGuess += addZero(elements[i]);
					else
						userGuess += addZero(elements[i]) + "/";
				}

				/* Check if the userGuess is before, equal, or after the entityBirthday */
				if (entityBirthday.equals(userGuess)) {
					
					/* Add tickets to current and total ticket counts */
					currentTickets = entity.getAwardedTicketNumber();
					numTicketsTotal += entity.getAwardedTicketNumber();
					
					/* Print the current and total ticket amounts */
					System.out.println("*************BINGO!*************");
					System.out.println("You won " + currentTickets + " tickets this round");
					System.out.println("The total number of your tickets is " + numTicketsTotal);
					System.out.println("**********************************");
					
					/* Print closing message and entity information */
					closingMessage();
					System.out.println(entity.toString());
					System.out.println("**********************************");
					
					break;

				} else if (entity.getBorn().precedes(new Date(userGuess))) {

					System.out.println("Incorrect. The entity is older than your guess.");
					userGuess = sc.nextLine();

				} else {

					System.out.println("Incorrect. The entity is younger than your guess.");
					userGuess = sc.nextLine();
				}

			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("Invalid input. Please enter a date in the format MM/DD/YYYY or 'quit'.");
				userGuess = sc.nextLine();

			} catch (NumberFormatException e) {

				System.out.println("Invalid input. Please enter a date in the format MM/DD/YYYY or 'quit'.");
				userGuess = sc.nextLine();
			}
		}
	}

	/* Used to format the entityBirthday String */
	private String addZero(int number) {
		return String.format("%02d", number);
	}

	/* Used to format the userGuess String */
	private String addZero(String input) {
		if (input.length() == 1) {
			return "0" + input;
		}
		return input;
	}

	public void welcomeMessage() {
		System.out.print("***************************\nWelcome! Let’s start the game! ");
	}

	public void closingMessage() {
		System.out.println("Congratulations! The detailed information of the entity you guessed is:");
	}

	/* Main method */
	public static void main(String[] args) {
		/* Opening Message */
		System.out.println("=========================\r\n\n"
						 + "    GuessMaster 2.0\r\n\n"
						 + "=========================\n");
		
		/* Creating new Entities */
		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25,1971), "Male", "Liberal", 0.25);
		Singer dion = new Singer("Celine Dion", new Date("March", 30, 1968), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1);
		Country usa = new Country("United States", new Date("July", 4, 1776), "Washinton D.C.", 0.1);
		
		/* Adding Entities into the Entity array */
		GuessMaster gm = new GuessMaster();
		gm.addEntity(trudeau);
		gm.addEntity(dion);
		gm.addEntity(myCreator);
		gm.addEntity(usa);
		
		/* Running the game */
		gm.playGame();
	}
}
