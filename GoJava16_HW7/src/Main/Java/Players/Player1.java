package Main.Java.Players;

import java.math.BigDecimal;

public class Player1 extends SuperPlayer {

    final BigDecimal price;

    public Player1(double price) {
        this.price = new BigDecimal(price);
        this.song = "The best song";
    }

    public BigDecimal getPrice() {
        return price;
    }


}
