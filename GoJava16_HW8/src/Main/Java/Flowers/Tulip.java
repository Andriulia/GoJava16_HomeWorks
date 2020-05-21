package Main.Java.Flowers;

import java.math.BigDecimal;

public class Tulip extends Flower {

    public Tulip() {
        this.name = "Tulip";
        this.price = BigDecimal.valueOf(45);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
