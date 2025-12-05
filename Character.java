/**
 * Abstract base class representing a character in the One Piece treasure hunt game.
 */
public abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int score;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.score = 0;
    }

    public abstract void specialAbility();
    public abstract String getActionName();

    public void performAction() {
        System.out.println("[" + name + "] " + getActionName());
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + damage + " damage! HP: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getAttackPower() { return attackPower; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
