package Main.Java;

import Main.Java.Flowers.Flower;
import Main.Java.Shop.*;

import java.io.File;

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
        System.out.println(FlowerStore.getProfit() + "\n\n");

        File file = new File("D:\\AndrUlia\\Программирование\\Java\\GoJava-16\\GoJava16_HW8.bouquet_1.txt");
        FlowersSaver.save(file, FlowerStore.sell(5,2,3));

        StringBuilder bouquet = new StringBuilder();
        for (Flower f : FlowersLoader.load(file)) {
        bouquet.append(f.getClass().getSimpleName()).append(" ");
        }
        System.out.println(bouquet);
    }
}
