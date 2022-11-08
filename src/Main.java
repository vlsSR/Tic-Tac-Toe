import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    final static String EMPTY = "  ";
    final static String CROSS = "❌";
    final static String CIRCLE = "🔵";

    static boolean victory = false;
    static String[] boxes = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
    static String player_input;
    static int player = 1; //1 = X, 2 = 0
    
    public static void changeBoxes(int i) {
        if (player == 1 && boxes[i].equals(EMPTY)) {
            boxes[i] = CROSS;
        }
        else if (player == 2 && boxes[i].equals(EMPTY)){
            boxes[i] = CIRCLE;
        }
        else{
            System.out.println("Box already used");
        }
    }

    public static boolean checkVictory() {
        //Horizontal Checks
        for(int i = 0; i < 9; i+=3){
            Set <String> winner = new HashSet<>();
            winner.add(boxes[i]);
            winner.add(boxes[i+1]);
            winner.add(boxes[i+2]);
            if(winner.size() == 1 && winner.contains(player == 1 ? CROSS : CIRCLE)) {
                victory = true;
                System.out.println("You won player: "+player);
                return true;
            }
        }
        //Vertical Checks
        for(int i = 0; i < 3; i++){
            Set <String> winner = new HashSet<>();
            winner.add(boxes[i]);
            winner.add(boxes[i+3]);
            winner.add(boxes[i+6]);
            if(winner.size() == 1 && winner.contains(player == 1 ? CROSS : CIRCLE)) {
                victory = true;
                System.out.println("You won player: "+player);
                return true;
            }
        }
        //Diagonal Checks
        if(boxes[0].equals(boxes[4]) && boxes[4].equals(boxes[8]) && (boxes[0].equals(CROSS) || boxes[0].equals(CIRCLE))) {
            victory = true;
            System.out.println("You won player: "+player);
            return true;
        }
        else if (boxes[2].equals(boxes[4]) && boxes[4].equals(boxes[6]) && (boxes[2].equals(CROSS) || boxes[2].equals(CIRCLE))) {
            victory = true;
            System.out.println("You won player: "+player);
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //String a1 = EMPTY, a2 = EMPTY, a3 = EMPTY, b1 = EMPTY, b2 = EMPTY, b3 = EMPTY, c1 = EMPTY, c2 = EMPTY, c3 = EMPTY;


        while(!victory) {
            System.out.println("|" + boxes[0] + "|" + boxes[1] + "|" + boxes[2] + "|\n" +
                    "|" + boxes[3] + "|" + boxes[4] + "|" + boxes[5] + "|\n" +
                    "|" + boxes[6] + "|" + boxes[7] + "|" + boxes[8] + "|\n");

            System.out.println("Select where you want to play player: "+player+" (a1-a3, b1-b3, c1-c3)  ");
            System.out.println("Playing with: "+ (player == 1 ? CROSS : CIRCLE));
            player_input = sc.nextLine();

            switch (player_input) {
                case "a1":
                    changeBoxes(0);
                    break;
                case "a2":
                    changeBoxes(1);
                    break;
                case "a3":
                    changeBoxes(2);
                    break;
                case "b1":
                    changeBoxes(3);
                    break;
                case "b2":
                    changeBoxes(4);
                    break;
                case "b3":
                    changeBoxes(5);
                    break;
                case "c1":
                    changeBoxes(6);
                    break;
                case "c2":
                    changeBoxes(7);
                    break;
                case "c3":
                    changeBoxes(8);
                    break;
                default:
                    System.out.println("Incorrect option, try again");
            }
            if(checkVictory()){
                System.out.println("\n|" + boxes[0] + "|" + boxes[1] + "|" + boxes[2] + "|\n" +
                        "|" + boxes[3] + "|" + boxes[4] + "|" + boxes[5] + "|\n" +
                        "|" + boxes[6] + "|" + boxes[7] + "|" + boxes[8] + "|\n");
            }
            if (player == 1) {
                player = 2;
            }
            else {
                player = 1;
            }
        }
    }
}