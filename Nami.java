public class Nami extends Character {
    public Nami() {
        super("Nami", 120, 25);
    }

    @Override
    public void specialAbility() {
        System.out.println("🗺️ " + name + " uses NAVIGATION SENSE! Treasure detection improved! ✨");
    }

    @Override
    public String getActionName() {
        return "navigates using weather knowledge";
    }

    public boolean detectTreasure() {
        System.out.println(name + " uses navigation expertise to search...");
        return Math.random() < 0.7;
    }
}
