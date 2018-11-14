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
        //手札を見せる
        showHand(userName, player);
        //同じ数字の手札がないか確認させる
        makeAllPlayerHandsCheck(player);
        showHand(userName, player);
    }

    //プレイヤー人数の取得
    public void askPlayerNum() {
        //プレイヤーの人数を聞く
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        //プレイヤー人数用の変数に格納
        mPlayerNum = userImput.nextInt();
    }

    //プレイヤー作成処理
    public void createPlayer(String[] userName, Player[] player) {
        //スキャナで読み取った名前を格納しておく変数
        String playerName = "";
        //プレイヤーの名前とプレイヤークラスを作成するため人数分繰り返す
        for (int playerID = Constant.INITIAL_NUM; playerID < mPlayerNum; playerID++) {
            //プレイヤーの名前を聞く文言を表示
            System.out.println(playerID + Constant.ADJUST_ELEMENT_NUM + Constant.ASK_PLAYER_NAME);
            //プレイヤーネームをユーザ入力から取得
            playerName = userImput.next();
            //名前を入れておくための配列に格納
            userName[playerID] = playerName;
            //プレイヤー名を持ったプレイヤークラスを作成する
            player[playerID] = new Player(userName[playerID]);
        }
    }

    //配る処理
    public void distribution(Card trump, Player[] player) {
        //どのプレイヤーに配るかIDを用意しておく
        int playerID = Constant.INITIAL_NUM;
        //プレイヤーに渡すカード
        int inputCard = Constant.INITIAL_NUM;
        //53枚配り終わるまで繰り返す
        for (int trumpID = Constant.INITIAL_NUM; trumpID < Constant.MAX_TRUMP_NUM; trumpID++) {
            //プレイヤーに渡すカードを取得する
            inputCard = getCard(trump, trumpID);
            //プレイヤーに配る処理を行う
            distributionPlayer(player, inputCard, trumpID, playerID);
            //次のプレイヤーに配る人を変える
            playerID = playerID + 1;
            //プレイヤーがmax行くまで繰り返す
            if (playerID == mPlayerNum) {
                //初期化する
                playerID = Constant.INITIAL_NUM;
            }
        }
    }

    //全員の手札を確認させる処理
    public void makeAllPlayerHandsCheck(Player[] player) {
        for (int playerID = Constant.INITIAL_NUM; playerID < mPlayerNum; playerID++) {
            player[playerID].checkSameNumHand();
        }
    }

    //個人の手札を確認させる処理
    public void makePlayerHandsCheck(int playerId) {

    }

    //手札を見せる処理(デバッグ用)
    public void showHand(String[] userName, Player[] player) {
        for (int i = Constant.INITIAL_NUM; i < mPlayerNum; i++) {
            String user = userName[i];
            player[i].showHands(user);
        }
    }

    //プレイヤークラスに手札としてカードを配る
    public void distributionPlayer(Player[] player, int card, int element, int playerID) {
        //引数に渡されたカードをプレイヤーに渡す
        player[playerID].setPlayerHand(card);
    }

    //カードクラスから指定された番号のカードを返す
    public int getCard(Card trump, int element) {
        //カードクラスから受け取ったトランプを格納する変数
        int card = Constant.INITIAL_NUM;
        //指定された番号の位置のカードをカードクラスから受け取ってくる
        card = trump.returnCard(element);
        //加える手札として返す
        return card;
    }

}
