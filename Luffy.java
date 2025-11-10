/**
 * Luffy class representing Monkey D. Luffy, the captain of the Straw Hat Pirates.
 * Known for his superhuman strength and Gum-Gum Devil Fruit powers.
 */
public class Luffy extends Character {

    /**
     * Constructor for Luffy with predefined stats.
     */
    public Luffy() {
        super("Monkey D. Luffy", 150, 30);
    }

    /**
     * Luffy's special ability: Gum-Gum Pistol
     * A powerful stretching punch that deals extra damage.
     */
    @Override
    public void specialAbility() {
        System.out.println("\n🔥 " + name + " uses GUM-GUM PISTOL! 🔥");
        System.out.println("Luffy stretches his arm back and launches a devastating punch!");
        int specialDamage = attackPower * 2;
        System.out.println("💥 Deals " + specialDamage + " damage! 💥\n");
    }

    /**
     * Override attack method to add Luffy's unique combat style.
     */
    @Override
    public int attack() {
        System.out.println(name + " throws a powerful punch!");
        return super.attack();
    }
}
