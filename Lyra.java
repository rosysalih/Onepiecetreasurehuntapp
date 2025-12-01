/**
 * Lyra class representing a skilled navigator and treasure hunter.
 * Expert in navigation, pathfinding, and treasure detection.
 */
public class Lyra extends Character {

    /**
     * Constructor for Lyra with predefined stats.
     */
    public Lyra() {
        super("Lyra", 120, 25);
    }

    /**
     * Lyra's special ability: Navigation & Treasure Detection
     * Uses her navigation skills to detect treasure locations and avoid danger.
     */
    @Override
    public void specialAbility() {
        System.out.println("\n🗺️  " + name + " uses PATHFINDER SENSE! 🗺️");
        System.out.println("Lyra reads the terrain and detects hidden treasure nearby!");
        System.out.println("✨ Reveals treasure location and increases crew's chance of success! ✨\n");
    }

    /**
     * Lyra's main action in the game.
     */
    @Override
    public void performAction() {
        System.out.println(name + " navigates using her pathfinding skills!");
    }

    /**
     * Override attack method to add Lyra's unique combat style.
     */
    @Override
    public int attack() {
        System.out.println(name + " strikes with her staff!");
        return super.attack();
    }

    /**
     * Special method for Lyra to detect treasure.
     * 
     * @return true with higher probability due to her navigation skills
     */
    public boolean detectTreasure() {
        System.out.println(name + " uses her navigation expertise to search for treasure...");
        // Lyra has a better chance of finding treasure (70% vs normal 50%)
        return Math.random() < 0.7;
    }
}
