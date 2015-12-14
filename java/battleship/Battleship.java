

public class Battleship {
    
    Set<String> validPositions = new HashSet<String>(Arrays.asList(
        "A1", "A2", "A3", "A4", "A5", 
        "B1", "B2", "B3", "B4", "B5",
        "C1", "C2", "C3", "C4", "C5",
        "D1", "D2", "D3", "D4", "D5",
        "E1", "E2", "E3", "E4", "E5"
    ));

    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        System.out.println("Welcome to 2-player Command Line Battleship!" + 
                           "\nPlayer 1 enter 5 positions of your ships: ");
        setPlayerPositions(p1);
        System.out.println("Player 2 enter 5 positions of your ships: ");

    }

    public void setPlayerPositions(Player player) {
        Scanner scanner = new Scanner(System.in);
        int positions = 0;

        while (positions != 5) {
            if (!player.addPosition(scanner.next())) {
                System.out.println("You have already entered this coordinate! Try again.");
            }
            
        }
    }
}