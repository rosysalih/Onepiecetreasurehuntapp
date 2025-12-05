public class Luffy extends Character {
    public Luffy() {
        super("Monkey D. Luffy", 150, 30);
    }

    @Override
    public void specialAbility() {
        System.out.println("🔥 " + name + " uses GUM-GUM PISTOL! Deals " + (attackPower * 2) + " damage! 💥");
    }

    @Override
    public String getActionName() {
        return "uses Gum-Gum Pistol";
    }
}
