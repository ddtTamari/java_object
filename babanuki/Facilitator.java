package babanuki;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facilitator {
    // キーボードからの入力を取得する
    Scanner userImput = new Scanner(System.in);
    private List<Player> rankingList = new ArrayList<>(); // 勝利したプレイヤーの名前を格納するリスト

    //  トランプ53枚を用意する
    private Card trump = new Card();
    /**
     * メソッド名：doOldMaid
     * @author Tamari
     * @param
     * @return
     * 処理内容：ババ抜きを行う
     */
    // ゲーム開始処理
    public void doOldMaid() {
        int playerNum = Constant.INITIAL_NUM; //  プレイヤーの人数を格納する変数
        // プレイヤーの人数を確認する
        playerNum = askPlayerNum();

        String[] userName = new String[playerNum]; // ユーザの名前を格納しておく配列
        Player[] player = new Player[playerNum]; // 人数分のプレイヤーを格納する配列
        List<Player> playerList = new ArrayList<Player>(); // 現在プレイしているプレイヤーリスト

        boolean finish = false; // ゲームが終了しているか判断する変数
        int turnUserID = Constant.INITIAL_NUM; // カードを引くプレイヤーのID
        String turnUserName = "";//引く人の名前

        // 初回しか行わない動作を呼び出す
        initialOperation(userName, player, playerNum);
        //プレイヤーリストを作成
        makePlayerList(playerList, player, playerNum);
        //手札を見せる行為
        showHand(userName, player, playerNum);

        // ゲーム終了していないとき繰り返す処理
        while (!finish) {
            //次のプレイヤーから手札を引く
            drawCard(turnUserID, playerList);
            //引く人の名前
            turnUserName = playerList.get(turnUserID).getPlayerName();
            //手札を引いた後にそろってるか確認
            checkHandAfterDraw(turnUserID, playerList);

            //前のターンで次の引く前の人が終了した時の処理
            if (playerList.size() > 1 && playerList.size() != turnUserID) {
                //前の引いた人がインクリメントする前の名前と同じとき次の人にターンを変更する
                if (turnUserName == playerList.get(turnUserID).getPlayerName()) {
                    //次の人にターンを変更する
                    turnUserID++;
                }
            }
            //残りプレイヤーよりターンが大きければ引く人をリセットする
            if (turnUserID >= playerList.size()) {
                //引く人を一番目の人に設定する
                turnUserID = 0;
            }

            //手札を見せる(デバッグ用)
            showHand(userName, player, playerNum);
            //残りプレイヤーが一人になっているか確認
            finish = checkRemainPlayer(playerList, turnUserID);
        }
        //勝った順でメッセージ表示
        callRank(playerNum);
        //ゲーム処理の終了メッセージ表示
        System.out.println(Constant.FINISH_GAME_MASSAGE);

    }

    // プレイヤー人数の取得
    private int askPlayerNum() {
        int ret = 0;//戻り値用
        // プレイヤーの人数を聞く
        System.out.print(Constant.ASK_NUM_OF_PLAYER);
        // トランプの最大枚数以上でも1人以下ではない人数にする
        while (ret <= Constant.MIN_PLAYER_NUM || ret > Constant.MAX_PLAYER_NUM) {
            // プレイヤー人数用の変数に格納
            ret = userImput.nextInt();
        }
        //プレイヤーの人数を返す
        return ret;
    }

    // 初回一回目のみ行う動作
    private void initialOperation(String[] userName, Player[] player, int playerNum) {
        // プレイヤークラスの作成
        createPlayer(userName, player, playerNum);
        // カードをシャッフル
        trump.shuffleCards();
        // カードを配る
        distribution(trump, player, playerNum);
        // 手札を見せる(完璧デバッグ用)
        showHand(userName, player, playerNum);
        // 同じ数字の手札がないか確認させる
        makeAllPlayerHandsCheck(player, playerNum);
    }

    // プレイヤー作成処理
    private void createPlayer(String[] userName, Player[] player, int playerNum) {
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
    private void makePlayerList(List<Player> playerList, Player[] player, int playerNum) {
        // 全てのプレイヤーを格納していく
        for (int playerElement = Constant.INITIAL_NUM; playerElement < playerNum; playerElement++) {
            // プレイヤーリストに指定IDのプレイヤークラスを格納
            playerList.add(player[playerElement]);
        }
    }

    // 配る処理
    private void distribution(Card trump, Player[] player, int playerNum) {
        // どのプレイヤーに配るかIDを用意しておく
        int playerID = Constant.INITIAL_NUM;
        // プレイヤーに渡すカード
        int inputCard = Constant.INITIAL_NUM;
        // 53枚配り終わるまで繰り返す
        for (int trumpID = Constant.INITIAL_NUM; trumpID < Constant.MAX_TRUMP_NUM; trumpID++) {
            // プレイヤーに渡すカードを取得する
            inputCard = getCard(trump, trumpID);
            // プレイヤーに配る処理を行う
            distributionPlayer(player, inputCard, playerID);
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
    private void makeAllPlayerHandsCheck(Player[] player, int playerNum) {
        // 全てのプレイヤーに手札を確認させる
        for (int playerID = Constant.INITIAL_NUM; playerID < playerNum; playerID++) {
            // プレイヤーの手札に同じ数字があるか確認させる
            player[playerID].checkSameNumHand();
        }
    }

    // 個人の手札を確認させる処理
    private void makePlayerHandsCheck(int playerId, List<Player> playerList) {
        // 指定されたプレイヤーの手札に同じ数字がないか確認
        playerList.get(playerId).checkSameNumHand();
        // 手札が0になっていないか確認させる
        checkPlayerIsFinish(playerId, playerList);

    }

    // 手札が0になってないか確認
    private void checkPlayerIsFinish(int playerId, List<Player> playerList) {
        // 残りプレイヤーが一人じゃないとき
        if (!checkRemainPlayer(playerList, playerId)) {
            // プレイヤーの手札が0枚だったら
            if (playerList.get(playerId).isFinish()) {
                // 勝者リストに格納する
                rankingList.add(playerList.get(playerId));
                //勝利者宣言をする
                System.out.println(playerList.get(playerId).getPlayerName() + Constant.FINISH_PLAYER_MASSAGE);
                // プレイヤーリストから除外する
                playerList.remove(playerId);
            }
        }
    }

    // 手札を見せる処理(デバッグ用)
    private void showHand(String[] userName, Player[] player, int playerNum) {
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
    private void distributionPlayer(Player[] player, int card, int playerID) {
        // 引数に渡されたカードをプレイヤーに渡す
        player[playerID].setPlayerHand(card);
    }

    // カードクラスから指定された番号のカードを返す
    private int getCard(Card trump, int element) {
        // カードクラスから受け取ったトランプを格納する変数
        int card = Constant.INITIAL_NUM;
        // 指定された番号の位置のカードをカードクラスから受け取ってくる
        card = trump.returnCard(element);
        // 加える手札として返す
        return card;
    }

    // 他プレイヤーからカードを引かせる
    private void drawCard(int drawUserID, List<Player> playerList) {

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

    //手札を引かれた後の確認作業
    private void checkHandAfterDraw(int drawUserID, List<Player> playerList) {
        // カードを引かれるプレイヤーIDのための変数
        int giveCardUser = drawUserID + Constant.NEXT_PLAYER;
        // カードを引かれるプレイヤーが最大人数より多いときの処理
        if (giveCardUser > (playerList.size() - Constant.ADJUST_ELEMENT_NUM)) {
            // 最初のプレイヤーに指定する
            giveCardUser = Constant.INITIAL_NUM;
        }

        //引いた人のIDが引かれた人のIDより大きいときは引いた人から確認を行う
        if (drawUserID > giveCardUser) {
            // 引いた人のカードがそろっていないか確認させる
            makePlayerHandsCheck(drawUserID, playerList);
            // 引かれた人の手札が0枚になってるか確認させる
            checkPlayerIsFinish(giveCardUser, playerList);
            //引かれた人のIDが引いた人のIDより大きいときは引いた人から確認を行う
        } else {
            // 引かれた人の手札が0枚になってるか確認させる
            checkPlayerIsFinish(giveCardUser, playerList);
            // 引いた人のカードがそろっていないか確認させる
            makePlayerHandsCheck(drawUserID, playerList);
        }
    }

    // 最後のプレイヤーか判定
    private boolean checkRemainPlayer(List<Player> playerList, int playerId) {
        // 全ての人が終わっているかどうかを判定する変数
        boolean allFinish = false;
        // プレイヤーリストの人数が残り一人なら
        if (playerList.size() == Constant.FINISH_GAME_NUM) {

            // 勝者リストに格納する
            rankingList.add(playerList.get(playerId));

            // 残り一人はJokerが残っている人なのでゲーム終了
            allFinish = true;
        }
        // 最後プレイヤーか判定する
        return allFinish;
    }

    //ランキングを表示する処理
    private void callRank(int playerNum) {
        String winnerPlayerName = "";
        //全てのプレイヤーをコールする
        for (int playerRank = Constant.INITIAL_NUM; playerRank < playerNum; playerRank++) {
            //ランクの上から順に名前を格納する
            winnerPlayerName = rankingList.get(playerRank).getPlayerName();
            //プレイヤーの順位を表示
            System.out.println(playerRank + Constant.ADJUST_ELEMENT_NUM + Constant.RANK_MESSAGE + winnerPlayerName
                    + Constant.PLAYER_MESSAGE);
        }
    }
}
