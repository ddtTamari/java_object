package babanuki;

import java.util.Scanner;

public class Facilitator {
    Scanner userImput = new Scanner(System.in);
    private int mPlayerNum = Constant.INITIAL_NUM;

    //ゲーム開始処理
    public void startOldMaid() {
        Card trump = new Card();
        askPlayerNum();

        String[] userName = new String[mPlayerNum];
        Player[] player = new Player[mPlayerNum];

        createPlayer(userName, player);
        trump.shuffleCards();
        distribution(trump, player);

        for (int i = Constant.INITIAL_NUM; i < mPlayerNum; i++) {
            String user = userName[i];
            player[i].showHands(user);
        }
    }

    //プレイヤー作成処理
    public void createPlayer(String[] userName, Player[] player) {
        for (int i = Constant.INITIAL_NUM; i < mPlayerNum; i++) {
            System.out.println(i + Constant.ADJUST_ELEMENT_NUM + Constant.ASK_PLAYER_NAME);
            String playerName = userImput.next();
            userName[i] = playerName;
            player[i] = new Player(userName[i]);
        }
    }

    //配る処理？
    public void distribution(Card trump, Player[] player) {
        int playerID = Constant.INITIAL_NUM;
        for (int i = Constant.INITIAL_NUM; i < Constant.MAX_TRUMP_NUM; i++) {
            int inputCard = getCard(trump, i);
            distributionPlayer(player, inputCard, i, playerID);
            playerID = playerID + 1;
            if (playerID == mPlayerNum - Constant.ADJUST_ELEMENT_NUM) {
                playerID = Constant.INITIAL_NUM;
            }

        }
    }

    public void distributionPlayer(Player[] player, int card, int element, int playerID) {
        player[playerID].setPlayerHand(card);
    }

    public int getCard(Card trump, int element) {
        int card = Constant.INITIAL_NUM;
        card = trump.returnCard(element);
        return card;
    }

    //プレイヤー人数の取得
    public void askPlayerNum() {
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        mPlayerNum = userImput.nextInt();
    }

}
