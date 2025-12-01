/**
 * Enemy class representing an adversary in the treasure hunt game.
 * Enemies can attack characters and have health and attack power.
 */
public class Enemy {
    // Enemy attributes
    private String name;
    private int health;
    private int attackPower;

    /**
     * Constructor to initialize an enemy with name, health, and attack power.
     * 
     * @param name The enemy's name
     * @param health The enemy's health points
     * @param attackPower The enemy's attack damage
     */
    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * Attack a character, reducing their health by this enemy's attack power.
     * 
     * @param target The character to attack
     */
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + " for " + attackPower + " damage!");
        target.takeDamage(attackPower);
    }

    /**
     * Check if the enemy is still alive.
     * 
     * @return true if health > 0, false otherwise
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Get the enemy's name.
     * 
     * @return The enemy's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the enemy's current health.
     * 
     * @return The enemy's health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the enemy's health.
     * 
     * @param health The new health value
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Reduce the enemy's health by the specified damage amount.
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
     * Returns a string representation of the enemy with its stats.
     * 
     * @return String containing enemy name, health, and attack power
     */
    @Override
    public String toString() {
        return "Enemy: " + name + " | Health: " + health + " | Attack Power: " + attackPower;
    }
}
