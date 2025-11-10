/**
 * Zoro class representing Roronoa Zoro, the swordsman of the Straw Hat Pirates.
 * Master of the Three-Sword Style technique.
 */
public class Zoro extends Character {

    /**
     * Constructor for Zoro with predefined stats.
     */
    public Zoro() {
        super("Roronoa Zoro", 140, 35);
    }

    /**
     * Zoro's special ability: Three-Sword Style (Santoryu)
     * A devastating sword technique using three swords simultaneously.
     */
    @Override
    public void specialAbility() {
        System.out.println("\n⚔️  " + name + " uses THREE-SWORD STYLE: ONI GIRI! ⚔️");
        System.out.println("Zoro crosses his three swords and slashes with incredible precision!");
        int specialDamage = attackPower * 2;
        System.out.println("💥 Deals " + specialDamage + " cutting damage! 💥\n");
    }

    /**
     * Override attack method to add Zoro's unique combat style.
     */
    @Override
    public int attack() {
        System.out.println(name + " slashes with his swords!");
        return super.attack();
    }
}
