package Main.Java.Players;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class Player5 extends SuperPlayer {


    final BigDecimal price;

    public Player5(double price) {
        this.price = new BigDecimal(price);
        playlist = new String[] {"The best song", "Good song", "Super Song"};
        song = this.playlist[0];
    }

    private BigDecimal getPrice() {
        return price;
    }

    @Override
    public void playAllSongs(String[] playlist) {
        Object[] invertedPlaylist = IntStream.rangeClosed(1, playlist.length)
                .mapToObj(i -> playlist[playlist.length - i])
                .toArray();

        for (Object song : invertedPlaylist) {
            System.out.println("Playing: " + song);
        }

        /*for (int i = playlist.length; i > 0 ; i--) {
            System.out.println("Playing: " + playlist[i-1]);
        }*/
    }
}
