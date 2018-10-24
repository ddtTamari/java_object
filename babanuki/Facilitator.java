package babanuki;

import java.util.Scanner;

public class Facilitator {
    Scanner userImput = new Scanner(System.in);
    private int mPlayerNum = Constant.INITIAL_NUM;

    public void startOldMaid() {
        createPlayer();

    }

    public void createPlayer() {
        String[] userName = new String[mPlayerNum];
        Player[] player = new Player[mPlayerNum];

        askPlayerNum();
        for (int i = Constant.INITIAL_NUM; i < mPlayerNum; i++) {
            System.out.println(i + Constant.ASK_PLAYER_NAME);
            String playerName = userImput.nextLine();

            userName[i] = playerName;
            player[i] = new Player(userName[i]);
        }
    }

    public void askPlayerNum() {
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        mPlayerNum = userImput.nextInt();
    }

}
