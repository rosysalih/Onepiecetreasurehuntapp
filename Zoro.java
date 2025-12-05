public class Zoro extends Character {
    public Zoro() {
        super("Roronoa Zoro", 140, 35);
    }

    @Override
    public void specialAbility() {
        System.out.println("⚔️ " + name + " uses THREE-SWORD STYLE! Deals " + (attackPower * 2) + " damage! 💥");
    }

    @Override
    public String getActionName() {
        return "uses Three-Sword Style";
    }
}
