/**
 * Abstract base class representing a character in the One Piece treasure hunt game.
 * All playable characters inherit from this class and must implement specialAbility().
 */
public abstract class Character {
    // Character attributes
    protected String name;
    protected int health;
    protected int attackPower;

    /**
     * Constructor to initialize a character with name, health, and attack power.
     * 
     * @param name The character's name
     * @param health The character's starting health points
     * @param attackPower The character's base attack damage
     */
    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * Perform a basic attack.
     * Returns the damage dealt based on attackPower.
     * 
     * @return The amount of damage dealt
     */
    public int attack() {
        System.out.println(name + " attacks with " + attackPower + " damage!");
        return attackPower;
    }

    /**
     * Defend against an incoming attack.
     * Reduces damage taken by 50%.
     * 
     * @param incomingDamage The amount of damage before defense
     * @return The actual damage taken after defense
     */
    public int defend(int incomingDamage) {
        int reducedDamage = incomingDamage / 2;
        System.out.println(name + " defends! Damage reduced from " + incomingDamage + " to " + reducedDamage);
        return reducedDamage;
    }

    /**
     * Display the character's current stats.
     */
    public void displayStats() {
        System.out.println("=== " + name + "'s Stats ===");
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("======================");
    }

    /**
     * Abstract method for each character's unique special ability.
     * Must be implemented by all subclasses.
     */
    public abstract void specialAbility();

    /**
     * Abstract method for a character's main action in the game.
     * Must be implemented by all subclasses.
     */
    public abstract void performAction();

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Take damage and reduce health.
     * 
     * @param damage The amount of damage to take
     */
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + this.health);
    }

    /**
     * Check if the character is still alive.
     * 
     * @return true if health > 0, false otherwise
     */
    public boolean isAlive() {
        return this.health > 0;
    }
}
