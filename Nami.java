/**
 * Nami class representing Nami, the navigator of the Straw Hat Pirates.
 * Expert in navigation, weather prediction, and treasure detection.
 */
public class Nami extends Character {

    /**
     * Constructor for Nami with predefined stats.
     */
    public Nami() {
        super("Nami", 120, 25);
    }

    /**
     * Nami's special ability: Navigation & Treasure Detection
     * Uses her navigation skills to detect treasure locations and avoid danger.
     */
    @Override
    public void specialAbility() {
        System.out.println("\n🗺️  " + name + " uses NAVIGATION SENSE! 🗺️");
        System.out.println("Nami reads the weather patterns and detects hidden treasure nearby!");
        System.out.println("✨ Reveals treasure location and increases crew's chance of success! ✨\n");
    }

    /**
     * Override attack method to add Nami's unique combat style.
     */
    @Override
    public int attack() {
        System.out.println(name + " strikes with her Clima-Tact!");
        return super.attack();
    }

    /**
     * Special method for Nami to detect treasure.
     * 
     * @return true with higher probability due to her navigation skills
     */
    public boolean detectTreasure() {
        System.out.println(name + " uses her navigation expertise to search for treasure...");
        // Nami has a better chance of finding treasure (70% vs normal 50%)
        return Math.random() < 0.7;
    }
}
