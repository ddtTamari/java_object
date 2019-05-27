package shichinarabe;

public interface PlayerInterface {

    //手札を確認
    public int getTheNumHand(int targetNum);

    //手札の枚数を確認
    public int getNumOfHand();

    //カードを捨てる
    public void disCardHand(int card);

    //プレイヤーが上がったかどうか確認
    public boolean isFinish();

}