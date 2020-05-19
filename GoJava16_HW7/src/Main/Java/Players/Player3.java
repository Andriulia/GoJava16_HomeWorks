package Main.Java.Players;

import java.math.BigDecimal;

public class Player3 extends SuperPlayer {

    final BigDecimal price;

    public Player3(double price) {
        this.price = new BigDecimal(price);
        playlist = new String[] {"The best song", "Good song", "Super Song"};
        song = playlist[0];
    }

    private BigDecimal getPrice() {
        return price;
    }
}
