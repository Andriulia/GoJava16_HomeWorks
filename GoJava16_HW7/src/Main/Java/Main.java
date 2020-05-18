package Main.Java;

import Main.Java.Players.*;

public class Main {
    public static void main(String[] args) {
        SuperPlayer player = new Player2(6.60);
        System.out.println(player.getSong());
        player.playSong(player.getSong());
    }
}
