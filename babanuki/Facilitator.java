package babanuki;

import java.util.Scanner;

public class Facilitator {
    Scanner userImput = new Scanner(System.in);

    public void startOldMaid() {

    }

    public int getUserNum() {
        System.out.print(Constract.ASK_NUM_OF_PLAYER);
        int playerNum = userImput.nextInt();
        return playerNum;
    }

    public void createUserArray() {
        String userName[] = new String[getUserNum()];
        for (int i = 0; i < getUserNum(); i++) {
            userName[i] = setUserName(i);
        }
    }

    public String setUserName(int i) {
        System.out.println(i + Constract.ASK_PLAYER_NAME);
        String userName = userImput.next();
        return userName;
    }
}
