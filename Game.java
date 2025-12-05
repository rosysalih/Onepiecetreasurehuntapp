import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Character> characters;
    private ArrayList<String> eventLog;
    private Random random;

    public Game() {
        this.characters = new ArrayList<>();
        this.eventLog = new ArrayList<>();
        this.random = new Random();
    }

    public void addCharacter(Character character) {
        characters.add(character);
        System.out.println(character.getName() + " joined the crew!");
    }

    public void startGame() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏴‍☠️  ONE PIECE: THE TREASURE HUNT 🏴‍☠️");
        System.out.println("=".repeat(50));
        System.out.println("\nThe Straw Hats search Mystery Island for legendary treasure!");
        System.out.println("\nYour crew:");
        for (Character c : characters) {
            System.out.println("  - " + c.getName());
        }
        System.out.println("\n⚠️  Find the treasure before the crew is defeated! ⚠️\n");
        System.out.println("=".repeat(50) + "\n");
    }

    public boolean findTreasure() {
        System.out.println("\n🗺️  SEARCHING FOR TREASURE...");
        
        // Check if Nami is alive for bonus chance
        for (Character c : characters) {
            if (c instanceof Nami && c.isAlive()) {
                return ((Nami) c).detectTreasure();
            }
        }
        
        System.out.println("The crew searches...");
        return random.nextDouble() < 0.5;
    }

    public void displayCrewStatus() {
        System.out.println("\n👥 CREW STATUS");
        for (Character c : characters) {
            String status = c.isAlive() ? "HP: " + c.getHealth() : "💀 Defeated";
            System.out.println("  " + c.getName() + " - " + status);
        }
    }

    public boolean isGameOver() {
        return characters.stream().noneMatch(Character::isAlive);
    }

    private void battle(Character player, Enemy enemy) {
        System.out.println("[" + player.getName() + "] battles " + enemy.getName());
        eventLog.add("Battle: " + player.getName() + " vs " + enemy.getName());
        
        int playerDamage = player.getAttackPower() + random.nextInt(4);
        enemy.takeDamage(playerDamage);
        System.out.println("  " + enemy.getName() + " takes " + playerDamage + " damage");
        
        if (enemy.isDefeated()) {
            System.out.println("  " + enemy.getName() + " defeated!");
            player.setScore(player.getScore() + 10);
        } else {
            int enemyDamage = enemy.getDamage() + random.nextInt(3);
            player.takeDamage(enemyDamage);
        }
    }

    public void runGameLoop() {
        int rounds = random.nextInt(3) + 3;
        System.out.println("\n===== GAME START (" + rounds + " rounds) =====\n");
        
        for (int round = 1; round <= rounds; round++) {
            System.out.println("=== Round " + round + " ===");
            
            ArrayList<Character> alive = new ArrayList<>();
            for (Character c : characters) {
                if (c.isAlive()) alive.add(c);
            }
            
            if (alive.isEmpty()) {
                System.out.println("All defeated! GAME OVER!");
                break;
            }
            
            for (Character c : alive) {
                c.performAction();
                triggerRandomEvent(c);
                if (!c.isAlive()) {
                    System.out.println("[" + c.getName() + "] has been defeated");
                    characters.remove(c);
                }
            }
            
            System.out.println("\nRound " + round + " complete:");
            for (Character c : characters) {
                if (c.isAlive()) {
                    System.out.println("  [" + c.getName() + "] HP: " + c.getHealth());
                }
            }
            System.out.println();
        }
        
        printFinalSummary();
    }

    private void printFinalSummary() {
        System.out.println("\n===== GAME COMPLETE =====");
        System.out.println("\nBattle Events:");
        eventLog.stream()
            .filter(log -> log.contains("Battle"))
            .forEach(log -> System.out.println("  " + log));
        
        System.out.println("\nFinal Scores:");
        for (Character c : characters) {
            System.out.println("  " + c.getName() + ": " + c.getScore() + " points");
        }
        
        System.out.println("\nSurvivors:");
        long survivors = characters.stream().filter(Character::isAlive).count();
        if (survivors > 0) {
            characters.stream().filter(Character::isAlive)
                .forEach(c -> System.out.println("  " + c.getName() + " - HP: " + c.getHealth()));
        } else {
            System.out.println("  None");
        }
        System.out.println("=========================\n");
    }

    private void triggerRandomEvent(Character c) {
        switch (random.nextInt(4)) {
            case 0:
                String[] names = {"Bandit", "Wild Beast", "Pirate", "Guardian"};
                Enemy enemy = new Enemy(names[random.nextInt(4)], 
                                       random.nextInt(30) + 20, 
                                       random.nextInt(15) + 10);
                battle(c, enemy);
                break;
            case 1:
                int boost = random.nextInt(20) + 10;
                c.setHealth(c.getHealth() + boost);
                System.out.println("[" + c.getName() + "] finds treasure (+" + boost + " HP)");
                break;
            case 2:
                int dmg = random.nextInt(15) + 5;
                String[] hazards = {"trap", "rocks", "gas", "floor"};
                System.out.println("[" + c.getName() + "] triggers " + hazards[random.nextInt(4)] + " (-" + dmg + " HP)");
                c.setHealth(c.getHealth() - dmg);
                break;
            case 3:
                String[] peaceful = {"rests", "enjoys view", "finds clue", "spots creature"};
                System.out.println("[" + c.getName() + "] " + peaceful[random.nextInt(4)]);
                break;
        }
    }
}
