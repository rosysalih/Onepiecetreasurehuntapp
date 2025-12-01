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
     * If Lyra is in the crew and alive, she has a better chance.
     * 
     * @return true if treasure is found, false otherwise
     */
    public boolean findTreasure() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🗺️  SEARCHING FOR TREASURE... 🗺️");
        System.out.println("=".repeat(50));

        // Check if Lyra is alive to use her special detection ability
        boolean lyraIsAlive = false;
        Lyra lyra = null;
        for (Character c : characters) {
            if (c instanceof Lyra && c.isAlive()) {
                lyraIsAlive = true;
                lyra = (Lyra) c;
                break;
            }
        }

        boolean treasureFound;
        if (lyraIsAlive) {
            System.out.println("Lyra uses her navigation skills to search!");
            treasureFound = lyra.detectTreasure();
        } else {
            System.out.println("The crew searches the island...");
            treasureFound = random.nextDouble() < 0.5; // 50% chance without Lyra
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
     * Run the game loop by calling performAction() and triggering random events for each character.
     * Runs for multiple rounds, removing characters when they die.
     */
    public void runGameLoop() {
        int rounds = random.nextInt(3) + 3; // 3-5 rounds
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("GAME LOOP - " + rounds + " ROUNDS");
        System.out.println("=".repeat(60) + "\n");
        
        for (int round = 1; round <= rounds; round++) {
            System.out.println("\n" + "#".repeat(60));
            System.out.println("### ROUND " + round + " ###");
            System.out.println("#".repeat(60) + "\n");
            
            // Create a copy to safely remove characters during iteration
            ArrayList<Character> aliveCharacters = new ArrayList<>();
            for (Character c : characters) {
                if (c.isAlive()) {
                    aliveCharacters.add(c);
                }
            }
            
            // Check if any characters are still alive
            if (aliveCharacters.isEmpty()) {
                System.out.println("All characters have been defeated!");
                System.out.println("GAME OVER!");
                break;
            }
            
            // Process each alive character
            for (Character character : aliveCharacters) {
                System.out.println("\n" + "-".repeat(60));
                System.out.println(">>> " + character.getName() + "'s Turn <<<");
                System.out.println("-".repeat(60));
                
                // Step 1: Perform character action
                character.performAction();
                System.out.println();
                
                // Step 2: Trigger random event
                triggerRandomEvent(character);
                
                // Step 3: Check if character died and remove from list
                if (!character.isAlive()) {
                    System.out.println("*** " + character.getName() + " HAS BEEN DEFEATED! ***");
                    System.out.println("*** " + character.getName() + " is removed from the adventure. ***");
                    characters.remove(character);
                }
                
                System.out.println("-".repeat(60));
            }
            
            // Display round summary
            System.out.println("\n" + "=".repeat(60));
            System.out.println("END OF ROUND " + round);
            System.out.println("Remaining Characters:");
            for (Character c : characters) {
                if (c.isAlive()) {
                    System.out.println("  - " + c.getName() + " (Health: " + c.getHealth() + ")");
                }
            }
            System.out.println("=".repeat(60));
        }
        
        // Final summary
        System.out.println("\n" + "=".repeat(60));
        System.out.println("GAME LOOP COMPLETE");
        System.out.println("=".repeat(60));
        
        if (!characters.isEmpty()) {
            System.out.println("\nSurvivors:");
            for (Character c : characters) {
                if (c.isAlive()) {
                    System.out.println("  - " + c.getName() + " (Health: " + c.getHealth() + ")");
                }
            }
        } else {
            System.out.println("\nNo survivors. The adventure has ended.");
        }
        
        System.out.println("=".repeat(60) + "\n");
    }

    /**
     * Battle between a character and an enemy.
     * Single round combat where character attacks first, then enemy counterattacks if alive.
     * 
     * @param character The character fighting
     * @param enemy The enemy to fight
     */
    public void battle(Character character, Enemy enemy) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BATTLE: " + character.getName() + " vs " + enemy.getName());
        System.out.println("=".repeat(50));
        
        // Display initial stats
        System.out.println(character.getName() + " Health: " + character.getHealth());
        System.out.println(enemy.toString());
        System.out.println();
        
        // Character attacks first
        character.attack(enemy);
        
        // Check if enemy is still alive to counterattack
        if (enemy.isAlive()) {
            System.out.println();
            enemy.attack(character);
        } else {
            System.out.println(enemy.getName() + " has been defeated!");
        }
        
        // Display final health
        System.out.println();
        System.out.println("--- Battle Results ---");
        System.out.println(character.getName() + " Health: " + character.getHealth());
        System.out.println(enemy.getName() + " Health: " + enemy.getHealth());
        
        if (!character.isAlive()) {
            System.out.println(character.getName() + " has been defeated!");
        }
        
        System.out.println("=".repeat(50) + "\n");
    }

    /**
     * Trigger a random event for a character.
     * Events include: enemy encounter, treasure find, environmental hazard, or peaceful moment.
     * 
     * @param character The character experiencing the event
     * @return String description of the event that occurred
     */
    public String triggerRandomEvent(Character character) {
        int eventType = random.nextInt(4); // 0-3 for four event types
        String eventDescription;
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RANDOM EVENT!");
        System.out.println("=".repeat(50));
        
        switch (eventType) {
            case 0:
                // Enemy encounter
                String[] enemyNames = {"Bandit", "Wild Beast", "Rival Pirate", "Island Guardian"};
                String enemyName = enemyNames[random.nextInt(enemyNames.length)];
                int enemyHealth = random.nextInt(30) + 20; // 20-49 health
                int enemyAttack = random.nextInt(15) + 10; // 10-24 attack
                
                Enemy enemy = new Enemy(enemyName, enemyHealth, enemyAttack);
                eventDescription = character.getName() + " encountered a " + enemyName + "!";
                System.out.println(eventDescription);
                battle(character, enemy);
                break;
                
            case 1:
                // Find treasure - increase health or attack power
                if (random.nextBoolean()) {
                    int healthBoost = random.nextInt(20) + 10; // 10-29 health
                    character.setHealth(character.getHealth() + healthBoost);
                    eventDescription = character.getName() + " found a health potion! Gained " + healthBoost + " health.";
                } else {
                    int attackBoost = random.nextInt(5) + 3; // 3-7 attack
                    character.setHealth(character.getHealth()); // Keep current health
                    eventDescription = character.getName() + " found a power-up! Attack increased by " + attackBoost + "! (Simulated)";
                }
                System.out.println(eventDescription);
                System.out.println(character.getName() + " current health: " + character.getHealth());
                System.out.println("=".repeat(50) + "\n");
                break;
                
            case 2:
                // Environmental hazard
                int damage = random.nextInt(15) + 5; // 5-19 damage
                String[] hazards = {"spike trap", "falling rocks", "poisonous gas", "collapsing floor"};
                String hazard = hazards[random.nextInt(hazards.length)];
                
                eventDescription = character.getName() + " triggered a " + hazard + "!";
                System.out.println(eventDescription);
                character.takeDamage(damage);
                System.out.println("=".repeat(50) + "\n");
                break;
                
            case 3:
                // Peaceful moment
                String[] peacefulEvents = {
                    "found a safe resting spot",
                    "enjoyed the scenic view",
                    "discovered an ancient inscription",
                    "spotted a friendly island creature"
                };
                String peaceful = peacefulEvents[random.nextInt(peacefulEvents.length)];
                eventDescription = character.getName() + " " + peaceful + ". Nothing happened.";
                System.out.println(eventDescription);
                System.out.println("=".repeat(50) + "\n");
                break;
                
            default:
                eventDescription = "An unknown event occurred.";
                System.out.println("=".repeat(50) + "\n");
        }
        
        return eventDescription;
    }
}
