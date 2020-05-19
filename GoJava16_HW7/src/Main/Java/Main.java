package Main.Java;

import Main.Java.Players.*;

public class Main {
    public static void main(String[] args) {
        SuperPlayer player = new Player6(6.60);
        System.out.println(player.getSong());
        System.out.println();
        player.playSong(player.getSong());
        System.out.println();
        player.playAllSongs(player.getPlaylist());
        ((Player6) player).shuffle();
        System.out.println();
        player.playAllSongs(player.getPlaylist());
    }
}
