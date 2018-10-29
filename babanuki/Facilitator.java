package babanuki;

import java.util.Scanner;

public class Facilitator {
    Scanner userImput = new Scanner(System.in);
    private int mPlayerNum = Constant.INITIAL_NUM;

    public void startOldMaid() {
        Card trump = new Card();
        createPlayer();
        trump.distributionCards(mPlayerNum);
    }

    public void createPlayer() {
        askPlayerNum();

        String[] userName = new String[mPlayerNum];
        Player[] player = new Player[mPlayerNum];

        for (int i = Constant.INITIAL_NUM; i < mPlayerNum; i++) {
            System.out.println(i + Constant.ADJUST_ELEMENT_NUM + Constant.ASK_PLAYER_NAME);
            String playerName = userImput.next();

            userName[i] = playerName;
            player[i] = new Player(userName[i]);
        }
    }

    public void distribution() {
        for (int i = Constant.INITIAL_NUM; i < Constant.MAX_TRUMP_NUM; i++) {

        }
    }

    public void askPlayerNum() {
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        mPlayerNum = userImput.nextInt();
    }

}
