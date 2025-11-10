import java.util.Scanner;

/**
 * Main class - Entry point for the One Piece: The Treasure Hunt game.
 * Handles game flow and user interaction.
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a new game instance
        Game game = new Game();
        
        // Add all crew members
        game.addCharacter(new Luffy());
        game.addCharacter(new Zoro());
        game.addCharacter(new Nami());
        
        System.out.println();
        
        // Start the game and display the story
        game.startGame();
        
        // Game loop
        boolean treasureFound = false;
        int turnCount = 0;
        
        while (!treasureFound && !game.isGameOver()) {
            turnCount++;
            System.out.println("📍 TURN " + turnCount);
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Explore and search for treasure");
            System.out.println("2. View crew status");
            System.out.println("3. Quit game");
            System.out.print("\nEnter your choice (1-3): ");
            
            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine(); // Clear invalid input
                System.out.println("\n⚠️  Invalid input! Please enter a number.\n");
                continue;
            }
            
            System.out.println();
            
            switch (choice) {
                case 1:
                    // Explore - triggers random events
                    System.out.println("The crew ventures deeper into the island...\n");
                    
                    // Random chance of battle encounter (70% chance)
                    if (Math.random() < 0.7) {
                        game.battle();
                        
                        // Check if crew is defeated
                        if (game.isGameOver()) {
                            break;
                        }
                    } else {
                        System.out.println("The path is clear... No enemies in sight.\n");
                    }
                    
                    // Attempt to find treasure
                    treasureFound = game.findTreasure();
                    break;
                    
                case 2:
                    // View crew status
                    game.displayCrewStatus();
                    break;
                    
                case 3:
                    // Quit game
                    System.out.println("Thanks for playing! Setting sail another day...\n");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("⚠️  Invalid choice! Please select 1, 2, or 3.\n");
            }
            
            // Pause between turns
            if (!treasureFound && !game.isGameOver()) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine(); // Consume newline
                scanner.nextLine(); // Wait for Enter
                System.out.println("\n" + "~".repeat(60) + "\n");
            }
        }
        
        // Game ending
        System.out.println("\n" + "=".repeat(60));
        if (treasureFound) {
            System.out.println("🏆 CONGRATULATIONS! 🏆");
            System.out.println("The Straw Hat Pirates have claimed the legendary treasure!");
            System.out.println("The adventure continues on the Grand Line...");
        } else if (game.isGameOver()) {
            System.out.println("💀 GAME OVER 💀");
            System.out.println("All crew members have been defeated...");
            System.out.println("The treasure remains hidden on Mystery Island.");
        }
        System.out.println("=".repeat(60));
        
        // Display final stats
        game.displayCrewStatus();
        
        System.out.println("Game completed in " + turnCount + " turns.");
        System.out.println("\nThanks for playing One Piece: The Treasure Hunt! 🏴‍☠️");
        
        scanner.close();
    }
}
