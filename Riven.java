/**
 * Riven class representing a master swordsman warrior.
 * Master of dual-blade combat techniques.
 */
public class Riven extends Character {

    /**
     * Constructor for Riven with predefined stats.
     */
    public Riven() {
        super("Riven", 140, 35);
    }

    /**
     * Riven's special ability: Blade Storm
     * A devastating sword technique with incredible precision.
     */
    @Override
    public void specialAbility() {
        System.out.println("\n⚔️  " + name + " uses BLADE STORM! ⚔️");
        System.out.println("Riven unleashes a flurry of sword strikes with incredible precision!");
        int specialDamage = attackPower * 2;
        System.out.println("💥 Deals " + specialDamage + " cutting damage! 💥\n");
    }

    /**
     * Riven's main action in the game.
     */
    @Override
    public void performAction() {
        System.out.println(name + " performs Blade Storm!");
    }

    /**
     * Override attack method to add Riven's unique combat style.
     */
    @Override
    public int attack() {
        System.out.println(name + " slashes with dual blades!");
        return super.attack();
    }
}
