/**
 * Blaze class representing a powerful warrior with superhuman strength.
 * Known for his incredible physical power and devastating attacks.
 */
public class Blaze extends Character {

    /**
     * Constructor for Blaze with predefined stats.
     */
    public Blaze() {
        super("Blaze", 150, 30);
    }

    /**
     * Blaze's special ability: Flame Strike
     * A powerful attack that deals extra damage.
     */
    @Override
    public void specialAbility() {
        System.out.println("\n🔥 " + name + " uses FLAME STRIKE! 🔥");
        System.out.println("Blaze channels his inner power and launches a devastating attack!");
        int specialDamage = attackPower * 2;
        System.out.println("💥 Deals " + specialDamage + " damage! 💥\n");
    }

    /**
     * Blaze's main action in the game.
     */
    @Override
    public void performAction() {
        System.out.println(name + " uses Flame Strike!");
    }

    /**
     * Override attack method to add Blaze's unique combat style.
     */
    @Override
    public int attack() {
        System.out.println(name + " throws a powerful punch!");
        return super.attack();
    }
}
