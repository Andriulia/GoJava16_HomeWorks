package Main.Java;

import Main.Java.Shop.*;

public class Main {
    public static void main(String[] args) {
        FlowerStore.sellBouquet(4, 0, 0, false);
        System.out.println();
        System.out.println(FlowerStore.getProfit() + "\n");
        FlowerStore.sellBouquet(1, 2, 0, false);
        System.out.println();
        System.out.println(FlowerStore.getProfit() + "\n");
        FlowerStore.sellBouquet(0, 0, 2, false);
        System.out.println();
        System.out.println(FlowerStore.getProfit());
    }
}
