/**
 * Simple Enemy class for the treasure hunt game.
 */
public class Enemy {
    private String name;
    private int health;
    private int damage;

    /**
     * Constructor to create an enemy.
     * @param name Enemy name
     * @param health Enemy health points
     * @param damage Enemy damage value
     */
    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    /**
     * Reduce the enemy's health by the given amount.
     * 
     * @param amount Damage to take
     */
    public void takeDamage(int amount) {
        this.health -= amount;
    }

    /**
     * Check if the enemy is defeated.
     * 
     * @return true if health <= 0
     */
    public boolean isDefeated() {
        return this.health <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
