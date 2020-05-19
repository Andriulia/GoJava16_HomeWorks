package Main.Java.Players;

import java.math.BigDecimal;

public class Player4 extends SuperPlayer {

    final BigDecimal price;

    public Player4(double price) {
        this.price = new BigDecimal(price);
        playlist = new String[] {"The best song", "Good song", "Super Song"};
        song = playlist[playlist.length-1];
    }

    private BigDecimal getPrice() {
        return price;
    }
}
