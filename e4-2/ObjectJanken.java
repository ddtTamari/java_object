/*
  演習4-2 Playerクラスを継承して、それぞれの手の出し方の異なるMurataクラスとYamadaクラスを作成し、
          実行結果を確認してください。ただし、既存のプログラムで変更できるのはObjectJanken.javaのみとします。
          MurataクラスとYamadaクラスの手の出し方は以下のようにします。
          Murataクラス…必ずグーを出す
          Yamadaクラス…必ずパーを出す
  演習日  8月29日
  製作者  玉利仁美
 */
package work4_2;

//ジャンケンを行うクラス
public class ObjectJanken {
    /**メインメソッド
     * @author 玉利
     * @param args コマンドライン
     */
    //メインメソッド
    public static void main(String[] args) {

        //ゲームを進行させる審判クラスの斎藤さんを準備する
        Judge saito = new Judge();


        //リスト4-2の内容=====================================================
        //Murataクラスの村田さんを作成する
        Player murata = new Murata("村田さん");
        //Yamadaクラスの山田さんを作成する
        Player yamada = new Yamada("山田さん");

        //startJankenで村田さんと山田さんの勝負の結果を求める
        saito.startJanken(murata, yamada);

        //=====================================================================

    }
}
