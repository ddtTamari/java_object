
package babanuki;

public class Card {

    /*
     ハート：000000
     ダイア：010000
     スペード：100000
     クラブ：110000
     */

    byte heartSuit = 0x00; //ハート
    byte diamondSuit = 0x16; // ダイア
    byte spadeSuit = 0x32; //スペード
    byte crabeSuit = 0x48; // クラブ

    private int usedCard[] = new int[Constract.TOTAL_TRUMP_NUM];

}
