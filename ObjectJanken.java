/*
  演習4-1 Playerクラスのソースコードをコピーして、クラス名だけ変えたMurataクラスとYamadaクラスを用意し、ObjectJanken.javaをリスト4-2のように変更してください。
          なお、この段階ではMurataクラス、YamadaクラスのshowHandメソッドを変更する必要はありません。
          プログラムができたらコンパイル・実行してください。
  演習日  8月27日
  製作者  玉利仁美
 */
package work4_1;

import work3_2.Judge;

//ジャンケンを行うクラス
public class ObjectJanken {
    /**メインメソッド
     * @author 玉利
     * @param args コマンドライン
     */
    //メインメソッド
    public static void main(String[] args) {
        //斎藤を審判クラスを作成するJ
        Judge saito = new Judge();

        //リスト4-2の内容=====================================================
        //Murataクラスの村田さんを作成する
        //      Murata murata = new Murata("村田さん");
        //Yamadaクラスの山田さんを作成する
        //      Yamada yamada = new Yamada("山田さん");

        //startJankenで村田さんと山田さんの勝負の結果を求める
        //      saito.startJanken(murata, yamada);

        //=====================================================================

        //上記内容がコンパイルエラーになる理由は、
        //startJankenの引数はPlayerなのに対し渡している引数がMurataクラスとYamadaクラスだからです。
    }
}
