package shichinarabe;

public class Constant {
    //共通用定数
    public static final int CARD_INITIAL_NUM = 0; //値を初期化する汎用定数
    public static final int ADJUST_ELEMENT_NUM = 1; //要素数などを調整する汎用定数
    public static final int HALF_NUM = 2; //値を半分にするための汎用定数
    public static final int FINISH_GAME_NUM = 1;//ゲームが終了するときの定数
    public static final int NEXT_PLAYER = 1;//次のプレイヤーを指定するときの定数

    //カード用定数
    public static final int MAX_TRUMP_NUM = 53; //総トランプ数用定数
    public static final int MAX_TRUMP_NUM_WO_JPKER = 52;//Jokerなしの総トランプ数
    public static final int MAX_NUMBER_OF_TRUMP = 13; //トランプの最大数用定数
    public static final int TRUMP_SUIT_HEART = 0; //スートのハートのbit用定数
    public static final int TRUMP_SUIT_HEART_ELEMENT = 0; //スートのハートを表す定数
    public static final int TRUMP_SUIT_DIAMOND = 16; //スートのダイアのbit用定数
    public static final int TRUMP_SUIT_DIAMOND_ELEMENT = 1; //スートのダイアを表す定数
    public static final int TRUMP_SUIT_SPADE = 32; //スートのスペードのbit用定数
    public static final int TRUMP_SUIT_SPADE_ELEMENT = 2; //スートのスペードを表す定数
    public static final int TRUMP_SUIT_CLUB = 48; //スートのクラブのbit用定数
    public static final int TRUMP_SUIT_CLUB_ELEMENT = 3; //スートのクラブを表す定数
    public static final int TRUMP_SUIT_JOKER = 63; //トランプのjokerを表す定数
    public static final int TRUMP_NUM_KING = 13; //トランプのキングを表す定数
    public static final int TRUMP_NUM_QUEEN = 12; //トランプのクイーンを表す定数
    public static final int TRUMP_NUM_JACK = 11; //トランプのジャックを表す定数
    public static final int TRUMP_SUIT_NUM = 4; //スートの総数を表す定数
    public static final int TRUMP_LOSE_SUIT = 15; //スートBit削除用定数

    //トランプに使用しない数字
    public static final int MISSING_NUM_001110 = 14; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_001111 = 15; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_011110 = 30; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_011111 = 31; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_101110 = 46; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_101111 = 47; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_111110 = 62; //ビット管理時に使用しない数字
    public static final int MISSING_NUM_ELEMENT = 7; //ビット管理時に使用しない数字

    //プレイヤー
    public static final int MAX_PLAYER_NUM = 10;//プレイヤーの最大人数
    public static final int MIN_PLAYER_NUM = 2;//プレイヤーの最小人数
    public static final int PLAYER_INITIAL_NUM = 0;

    //七並べ用
    public static final int PASS_TIME = 3;
}
