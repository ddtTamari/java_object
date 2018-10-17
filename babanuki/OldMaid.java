package babanuki;

import java.util.Scanner;

public class OldMaid {

    //変数一覧//
    private Scanner userImput = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner userImput = new Scanner(System.in);
        System.out.print(Constract.ASK_NUM_OF_PLAYER);
        int playerNum = userImput.nextInt();

        String userName[] = new String[playerNum];

        for (int i = 0; i < playerNum; i++) {
            System.out.println(i + Constract.ASK_PLAYER_NAME);
            String playerName = userImput.nextLine();
            userName[i] = playerName;
            Player[] player = new Player[playerNum];
        }

    }

}
