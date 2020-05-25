package Main.Java.Flowers;

import java.math.BigDecimal;

public class Rose extends Flower {

    public Rose() {
        this.price = BigDecimal.valueOf(100);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
