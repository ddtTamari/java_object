package babanuki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facilitator {
    // キーボードからの入力を取得する
    Scanner userImput = new Scanner(System.in);
    private List<Player> rankingList = new ArrayList<>(); // 勝利したプレイヤーの名前を格納するリスト

    private int playerNum = Constant.INITIAL_NUM; //  プレイヤーの人数を格納する変数
    //  トランプ53枚を用意する
    private Card trump = new Card();

    // ゲーム開始処理
    public void doOldMaid() {

        // プレイヤーの人数を確認する
        askPlayerNum();

        String[] userName = new String[playerNum]; // ユーザの名前を格納しておく配列
        Player[] player = new Player[playerNum]; // 人数分のプレイヤーを格納する配列
        List<Player> playerList = new ArrayList<Player>(); // 現在プレイしているプレイヤーリスト

        boolean finish = false; // ゲームが終了しているか判断する変数
        int turnUserID = Constant.INITIAL_NUM; // カードを引くプレイヤーのID

        // 初回しか行わない動作を呼び出す
        initialOperation(userName, player);
        makePlayerList(playerList, player);
        showHand(userName, player);

        // ゲーム終了していないとき繰り返す処理
        while (!finish) {
            if (!playerList.get(turnUserID).isFinish()) {
                drawCard(player, turnUserID, playerList);
                checkHandAfterDraw(player, turnUserID, playerList);
            }

            turnUserID++;
            if (turnUserID >= playerList.size()) {
                turnUserID = 0;
            }

            showHand(userName, player);
            finish = checkRemainPlayer(playerList);
        }
        if (finish) {
            callRank(rankingList);
            System.out.println("ゲームが終了しました");
        }
    }

    // プレイヤー人数の取得
    public void askPlayerNum() {
        // プレイヤーの人数を聞く
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        // トランプの最大枚数以上でも1人以下ではない人数にする
        while (playerNum <= 1 || playerNum > 53) {
            // プレイヤー人数用の変数に格納
            playerNum = userImput.nextInt();
        }
    }

    // 初回一回目のみ行う動作
    public void initialOperation(String[] userName, Player[] player) {
        // プレイヤークラスの作成
        createPlayer(userName, player);
        // カードをシャッフル
        trump.shuffleCards();
        // カードを配る
        distribution(trump, player);
        // 手札を見せる(完璧デバッグ用)
        showHand(userName, player);
        // 同じ数字の手札がないか確認させる
        makeAllPlayerHandsCheck(player);
    }

    // プレイヤー作成処理
    public void createPlayer(String[] userName, Player[] player) {
        // スキャナで読み取った名前を格納しておく変数
        String playerName = "";
        // プレイヤーの名前とプレイヤークラスを作成するため人数分繰り返す
        for (int playerID = Constant.INITIAL_NUM; playerID < playerNum; playerID++) {
            // プレイヤーの名前を聞く文言を表示
            System.out.println(playerID + Constant.ADJUST_ELEMENT_NUM + Constant.ASK_PLAYER_NAME);
            // プレイヤーネームをユーザ入力から取得
            playerName = userImput.next();
            // 名前を入れておくための配列に格納
            userName[playerID] = playerName;
            // プレイヤー名を持ったプレイヤークラスを作成する
            player[playerID] = new Player(userName[playerID]);
        }
    }

    // playerlistを作成するメソッド
    public void makePlayerList(List<Player> playerList, Player[] player) {
        // 全てのプレイヤーを格納していく
        for (int playerElement = Constant.INITIAL_NUM; playerElement < playerNum; playerElement++) {
            // プレイヤーリストに指定IDのプレイヤークラスを格納
            playerList.add(player[playerElement]);
        }
    }

    // 配る処理
    public void distribution(Card trump, Player[] player) {
        // どのプレイヤーに配るかIDを用意しておく
        int playerID = Constant.INITIAL_NUM;
        // プレイヤーに渡すカード
        int inputCard = Constant.INITIAL_NUM;
        // 53枚配り終わるまで繰り返す
        for (int trumpID = Constant.INITIAL_NUM; trumpID < Constant.MAX_TRUMP_NUM; trumpID++) {
            // プレイヤーに渡すカードを取得する
            inputCard = getCard(trump, trumpID);
            // プレイヤーに配る処理を行う
            distributionPlayer(player, inputCard, trumpID, playerID);
            // 次のプレイヤーに配る人を変える
            playerID = playerID + 1;
            // プレイヤーがmax行くまで繰り返す
            if (playerID == playerNum) {
                // 初期化する
                playerID = Constant.INITIAL_NUM;
            }
        }
    }

    // 全員の手札を確認させる処理
    public void makeAllPlayerHandsCheck(Player[] player) {
        // 全てのプレイヤーに手札を確認させる
        for (int playerID = Constant.INITIAL_NUM; playerID < playerNum; playerID++) {
            // プレイヤーの手札に同じ数字があるか確認させる
            player[playerID].checkSameNumHand();
        }
    }

    // 個人の手札を確認させる処理
    public void makePlayerHandsCheck(Player[] player, int playerId, List<Player> playerList) {
        // 指定されたプレイヤーの手札に同じ数字がないか確認
        playerList.get(playerId).checkSameNumHand();
        // 手札が0になっていないか確認させる
        checkPlayerIsFinish(playerId, playerList);

    }

    // 手札が0になってないか確認
    public void checkPlayerIsFinish(int playerId, List<Player> playerList) {
        // 残りプレイヤーが一人じゃないとき
        if (!checkRemainPlayer(playerList)) {
            // プレイヤーの手札が0枚だったら
            if (playerList.get(playerId).isFinish()) {
                // 勝者リストに格納する
                rankingList.add(playerList.get(playerId));
                System.out.println(playerList.get(playerId).getPlayerName() + "さんは上がりました。");

                // プレイヤーリストから除外する
                playerList.remove(playerId);
            }
            // 最後の一人の時は問答無用でリストに格納
        } else {
            // 勝者リストに格納する
            rankingList.add(playerList.get(playerId - Constant.ADJUST_ELEMENT_NUM));
        }
    }

    // 手札を見せる処理(デバッグ用)
    public void showHand(String[] userName, Player[] player) {
        // プレイヤーの人数分繰り返す
        for (int i = Constant.INITIAL_NUM; i < playerNum; i++) {
            if (!player[i].isFinish()) {
                // 表示用の名前を格納
                String user = userName[i];
                // プレイヤーの手札を返す
                player[i].showHands(user);
            }
        }
    }

    // プレイヤークラスに手札としてカードを配る
    public void distributionPlayer(Player[] player, int card, int element, int playerID) {
        // 引数に渡されたカードをプレイヤーに渡す
        player[playerID].setPlayerHand(card);
    }

    // カードクラスから指定された番号のカードを返す
    public int getCard(Card trump, int element) {
        // カードクラスから受け取ったトランプを格納する変数
        int card = Constant.INITIAL_NUM;
        // 指定された番号の位置のカードをカードクラスから受け取ってくる
        card = trump.returnCard(element);
        // 加える手札として返す
        return card;
    }

    // 他プレイヤーからカードを引かせる
    public void drawCard(Player[] player, int drawUserID, List<Player> playerList) {

        // カードを引かれるプレイヤーIDのための変数
        int giveCardUser = drawUserID + Constant.NEXT_PLAYER;

        // カードを引かれるプレイヤーが最大人数より多いときの処理
        if (giveCardUser > (playerList.size() - Constant.ADJUST_ELEMENT_NUM)) {
            // 最初のプレイヤーに指定する
            giveCardUser = Constant.INITIAL_NUM;
        }
        // 次のプレイヤーからカードを引く
        playerList.get(drawUserID).drawPlayersHand(playerList.get(giveCardUser));
    }

    public void checkHandAfterDraw(Player[] player, int drawUserID, List<Player> playerList) {
        // カードを引かれるプレイヤーIDのための変数
        int giveCardUser = drawUserID + Constant.NEXT_PLAYER;
        if (drawUserID > giveCardUser) {
            // 引いた人のカードがそろっていないか確認させる
            makePlayerHandsCheck(player, drawUserID, playerList);
            // 引かれた人の手札が0枚になってるか確認させる
            checkPlayerIsFinish(giveCardUser, playerList);
        } else {
            // 引かれた人の手札が0枚になってるか確認させる
            checkPlayerIsFinish(giveCardUser, playerList);
            // 引いた人のカードがそろっていないか確認させる
            makePlayerHandsCheck(player, drawUserID, playerList);
        }
    }

    // 最後のプレイヤーか判定
    public boolean checkRemainPlayer(List<Player> playerList) {
        // 全ての人が終わっているかどうかを判定する変数
        boolean allFinish = false;
        // プレイヤーリストの人数が残り一人なら
        if (playerList.size() == Constant.FINISH_GAME_NUM) {
            // 残り一人はJokerが残っている人なのでゲーム終了
            allFinish = true;
        }
        // 最後プレイヤーか判定する
        return allFinish;
    }

    public void callRank(List<Player> winnerPlayerList) {
        for (int playerRank = Constant.INITIAL_NUM; playerRank < playerNum; playerRank++) {
            String winnerPlayerName = winnerPlayerList.get(playerRank).getPlayerName();
            System.out.println(playerRank + Constant.ADJUST_ELEMENT_NUM + "位は" + winnerPlayerName + "さんです");
        }
    }
}
