package Main.Java.Shop;

import Main.Java.Flowers.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class FlowerStore {

    static BigDecimal profit = BigDecimal.valueOf(0);

    public static ArrayList<Flower> sell(int roses, int chamomiles, int tulips) {
        ArrayList<Flower> bouquet = new ArrayList<>();
        for (int i = 0; i < roses; i++) {
            bouquet.add(new Rose());
        }
        for (int i = 0; i < chamomiles; i++) {
            bouquet.add(new Chamomile());
        }
        for (int i = 0; i < tulips; i++) {
            bouquet.add(new Tulip());
        }

        return bouquet;
    }

    public static ArrayList<Flower> sellSequence(int roses, int chamomiles, int tulips) {
        ArrayList<Flower> bouquet = new ArrayList<>();
        do {
            if(roses != 0) {
                bouquet.add(new Rose());
                roses--;
            }
            if(chamomiles != 0) {
                bouquet.add(new Chamomile());
                chamomiles--;
            }
            if(tulips != 0) {
                bouquet.add(new Tulip());
                tulips--;
            }
        } while (roses != 0 || chamomiles != 0 || tulips != 0);

        return bouquet;
    }

    public static void sellBouquet(int roses, int chamomiles, int tulips, boolean sequence) {
        ArrayList<Flower> bouquet;
        if (sequence) {
            bouquet = sellSequence(roses, chamomiles, tulips);
        } else {
            bouquet = sell(roses, chamomiles, tulips);
        }
        for (Flower flower : bouquet) {
            System.out.print(flower.getName() + " ");
        }
        setProfit(roses, chamomiles, tulips);
    }

    public static BigDecimal getProfit() {
        return profit;
    }

    private static void setProfit(int roses, int chamomiles, int tulips) {
        profit = profit.add(BigDecimal.valueOf(roses* new Rose() .getPrice().intValue() +
                chamomiles*new Chamomile().getPrice().intValue() +
                tulips* new Tulip() .getPrice().intValue()));
    }
}
