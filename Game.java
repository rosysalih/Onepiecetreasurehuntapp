import java.util.ArrayList;
import java.util.Random;

/**
 * Game class that manages the One Piece: The Treasure Hunt game.
 * Handles character management, battles, and treasure discovery.
 */
public class Game {
    // List of characters in the player's crew
    private ArrayList<Character> characters;
    private Random random;

    /**
     * Constructor initializes the game with an empty character list.
     */
    public Game() {
        this.characters = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Add a character to the crew.
     * 
     * @param character The character to add
     */
    public void addCharacter(Character character) {
        characters.add(character);
        System.out.println(character.getName() + " has joined the crew!");
    }

    /**
     * Start the game and display the story introduction.
     */
    public void startGame() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏴‍☠️  ONE PIECE: THE TREASURE HUNT 🏴‍☠️");
        System.out.println("=".repeat(60));
        System.out.println("\nThe Straw Hat Pirates have discovered an ancient map");
        System.out.println("leading to a legendary treasure hidden on Mystery Island!");
        System.out.println("\nBut beware! The island is crawling with enemy pirates,");
        System.out.println("deadly traps, and treacherous terrain.");
        System.out.println("\nYour crew:");
        for (Character character : characters) {
            System.out.println("  - " + character.getName());
        }
        System.out.println("\n⚠️  Find the treasure before your crew is defeated! ⚠️\n");
        System.out.println("=".repeat(60) + "\n");
    }

    /**
     * Simulate a battle encounter.
     * A random crew member fights an enemy with random strength.
     */
    public void battle() {
        if (characters.isEmpty()) {
            System.out.println("No crew members available to battle!");
            return;
        }

        // Check if any characters are still alive
        ArrayList<Character> aliveCharacters = new ArrayList<>();
        for (Character c : characters) {
            if (c.isAlive()) {
                aliveCharacters.add(c);
            }
        }

        if (aliveCharacters.isEmpty()) {
            System.out.println("All crew members have been defeated!");
            return;
        }

        // Select a random alive character to fight
        Character fighter = aliveCharacters.get(random.nextInt(aliveCharacters.size()));
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("⚔️  BATTLE ENCOUNTER! ⚔️");
        System.out.println("=".repeat(50));
        System.out.println(fighter.getName() + " encounters an enemy pirate!");
        System.out.println();

        // Show fighter's special ability
        fighter.specialAbility();

        // Simulate battle with random outcome
        int enemyStrength = random.nextInt(30) + 20; // Enemy deals 20-49 damage
        System.out.println("Enemy pirate attacks with " + enemyStrength + " power!");
        
        // 60% chance to win the battle
        if (random.nextDouble() < 0.6) {
            System.out.println("\n✅ " + fighter.getName() + " defeats the enemy pirate!");
            int damageReceived = enemyStrength / 3; // Take reduced damage on victory
            fighter.takeDamage(damageReceived);
        } else {
            System.out.println("\n❌ The enemy pirate lands a heavy blow!");
            fighter.takeDamage(enemyStrength);
        }

        System.out.println("=".repeat(50) + "\n");
    }

    /**
     * Attempt to find the treasure.
     * Uses random chance to determine if the treasure is found.
     * If Nami is in the crew and alive, she has a better chance.
     * 
     * @return true if treasure is found, false otherwise
     */
    public boolean findTreasure() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🗺️  SEARCHING FOR TREASURE... 🗺️");
        System.out.println("=".repeat(50));

        // Check if Nami is alive to use her special detection ability
        boolean namiIsAlive = false;
        Nami nami = null;
        for (Character c : characters) {
            if (c instanceof Nami && c.isAlive()) {
                namiIsAlive = true;
                nami = (Nami) c;
                break;
            }
        }

        boolean treasureFound;
        if (namiIsAlive) {
            System.out.println("Nami uses her navigation skills to search!");
            treasureFound = nami.detectTreasure();
        } else {
            System.out.println("The crew searches the island...");
            treasureFound = random.nextDouble() < 0.5; // 50% chance without Nami
        }

        if (treasureFound) {
            System.out.println("\n🎉🎉🎉 TREASURE FOUND! 🎉🎉🎉");
            System.out.println("The crew has discovered the legendary treasure!");
            System.out.println("💰 Victory is yours! 💰");
        } else {
            System.out.println("\n❌ No treasure here... The search continues.");
        }

        System.out.println("=".repeat(50) + "\n");
        return treasureFound;
    }

    /**
     * Display the status of all crew members.
     */
    public void displayCrewStatus() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("👥 CREW STATUS 👥");
        System.out.println("=".repeat(50));
        for (Character character : characters) {
            character.displayStats();
            if (!character.isAlive()) {
                System.out.println("💀 " + character.getName() + " has been defeated!");
            }
            System.out.println();
        }
        System.out.println("=".repeat(50) + "\n");
    }

    /**
     * Check if the crew has been completely defeated.
     * 
     * @return true if all characters are defeated, false otherwise
     */
    public boolean isGameOver() {
        for (Character c : characters) {
            if (c.isAlive()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the list of characters.
     * 
     * @return ArrayList of Character objects
     */
    public ArrayList<Character> getCharacters() {
        return characters;
    }

    /**
     * Run the game loop by calling performAction() on each character.
     */
        Add performAction() method to character system
    
    - Added abstract performAction() method in Character.java
    - Implemented unique actions in Luffy, Zoro, and Nami subclasses
    - Added runGameLoop() in Game.java to execute all character actions
    - Updated Main.java to call runGameLoop() on startup
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎮 GAME ACTIONS 🎮");
        System.out.println("=".repeat(50));
        
        for (Character character : characters) {
            if (character.isAlive()) {
                character.performAction();
                System.out.println("-".repeat(50));
            }
        }
        
        System.out.println("=".repeat(50) + "\n");
    }
}
