package Main.Java.Players;

import java.math.BigDecimal;

public class Player2 extends SuperPlayer {

    final BigDecimal price;

    public Player2(double price) {
        this.price = new BigDecimal(price);
        this.song = "The best song";
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void playSong(String songName) {
        System.out.println("error");
    }
}