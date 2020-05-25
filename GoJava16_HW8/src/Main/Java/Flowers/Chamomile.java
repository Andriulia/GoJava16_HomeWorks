package Main.Java.Flowers;

import java.math.BigDecimal;

public class Chamomile extends Flower {

    public Chamomile() {
        this.price = BigDecimal.valueOf(70);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
