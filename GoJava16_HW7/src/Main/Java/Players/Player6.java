package Main.Java.Players;

import java.math.BigDecimal;
import java.util.Random;

public class Player6 extends SuperPlayer {

    final BigDecimal price;

    public Player6(double price) {
        this.price = new BigDecimal(price);
        playlist = new String[]{"The best song", "Good song", "Super Song"};
        song = playlist[0];
    }

    private BigDecimal getPrice() {
        return price;
    }

    public void shuffle() {
        Random rnd = new Random();

        for (int i = 0; i < playlist.length; i++) {
            int randPos = rnd.nextInt(playlist.length);
            String tmp = playlist[i];
            playlist[i] = playlist[randPos];
            playlist[randPos] = tmp;
        }
    }
}
