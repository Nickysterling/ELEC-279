import java.util.Scanner;

public class GuessMaster {
    private int numberOfCandidateEntities;
    private Entity[] entities;

    public GuessMaster() {
        numberOfCandidateEntities = 0;
        entities = new Entity[10];
    }

    public void addEntity(Entity entity) {
        entities[numberOfCandidateEntities++] = entity;
    }

    public void playGame(Entity entity) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess " + entity.getName() + "'s birthdate (MM/DD/YYYY)");
        String userGuess = sc.nextLine();
        
    	String strBirthday = "";
    	String day, month, year;
    	
    	day = addZero(entity.getBorn().getDay());
    	month = addZero(entity.getBorn().getMonth());
    	year = addZero(entity.getBorn().getYear());

    	strBirthday = month + "/" + day + "/" + year;
    	
        while (!userGuess.equals("quit")) {
        	
        	/* Stores each element as a string by splitting at the '/' */
        	String[] elements = userGuess.split("/");
        	userGuess = "";
        	
        	for(int i = 0; i < 3; i++) {
        		if(i == 2)
        			userGuess += addZero(elements[i]);
        		else
        			userGuess += addZero(elements[i]) + "/";
        	}
        	
            if (strBirthday.equals(userGuess)) {
                System.out.println("BINGO. You got it!!");
                break;
            } else if (entity.getBorn().precedes(new Date(userGuess))) {
                System.out.println("Incorrect. The entity is older than your guess.");
                userGuess = sc.nextLine();
            } else {
                System.out.println("Incorrect. The entity is younger than your guess.");
                userGuess = sc.nextLine();
            }
        }
        
        sc.close();
        
    }

    public void playGame(int entityInd) {
        playGame(entities[entityInd]);
    }

    public void playGame() {
        int randomEntityInd = genRandomEntityInd();
        playGame(randomEntityInd);
    }

    private int genRandomEntityInd() {
        return (int) (Math.random() * numberOfCandidateEntities);
    }
    
    public String addZero(int number) {
        String result = Integer.toString(number);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
    
    public String addZero(String input) {
    	if (input.length() == 1) {
            return "0" + input;
        }
        return input;
    }


    public static void main(String[] args) {
        Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
        Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
        Entity usa = new Entity("United States", new Date("July", 4, 1776));
        GuessMaster gm = new GuessMaster();
        gm.addEntity(trudeau);
        gm.addEntity(dion);
        gm.addEntity(usa);
        gm.playGame();
    }
}
