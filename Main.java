public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        
        game.addCharacter(new Luffy());
        game.addCharacter(new Zoro());
        game.addCharacter(new Nami());
        
        game.startGame();
        game.runGameLoop();
        
        if (game.findTreasure()) {
            System.out.println("\n🏆 VICTORY! The treasure is found! 🏆");
        } else if (game.isGameOver()) {
            System.out.println("\n💀 DEFEAT! All crew members fallen! 💀");
        } else {
            System.out.println("\n⚔️ The adventure continues... ⚔️");
        }
        
        game.displayCrewStatus();
        System.out.println("\nThanks for playing! 🏴‍☠️");
    }
}
