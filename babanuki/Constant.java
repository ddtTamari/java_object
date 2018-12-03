package babanuki;

public class Constant {
    //共通用定数
    public static final int INITIAL_NUM = 0; //値を初期化する汎用定数
    public static final int ADJUST_ELEMENT_NUM = 1; //要素数などを調整する汎用定数
    public static final int HALF_NUM = 2; //値を半分にするための汎用定数
    public static final int FINISH_GAME_NUM = 1;

    //カード用定数
    public static final int MAX_TRUMP_NUM = 53; //総トランプ数用定数
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

    //出力メッセージ
    public static final String ASK_NUM_OF_PLAYER = "プレイヤーは何人でプレーしますか？";
    public static final String ASK_PLAYER_NAME = "人目のプレイヤーの名前はなんですか？";
    public static final String USER_NAME_TITLE = "さん";
    public static final String USER_HAS = "さんは";
    public static final String NUM_OF_USER_HANDS = "枚持っている‼";
    public static final String ASK_DRAW_POSITION = "さん、どの位置のカードを引きますか？";
    public static final String DRAW_USER = "さんから";
    public static final String DRAW_CARD = "番目の位置のカードを引いた";

}
