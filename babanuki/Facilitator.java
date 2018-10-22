package babanuki;

import java.util.Scanner;

public class Facilitator {
    Scanner userImput = new Scanner(System.in);

    private int mPlayerNum = Constant.INITIAL_NUM;

    public void startOldMaid() {
        createPlayer();

    }



    public void createPlayer() {
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        mPlayerNum = userImput.nextInt();
        String[] userName = new String[mPlayerNum];
        Player[] player = new Player[mPlayerNum];

        for (int i = 0; i < mPlayerNum; i++) {
            System.out.println(i + Constant.ASK_PLAYER_NAME);
            String playerName = userImput.nextLine();

            userName[i] = playerName;
            player[i] = new Player(userName[i]);
        }
    }







}
