package Main.Java.Shop;

import Main.Java.Flowers.*;

import java.util.ArrayList;
import java.util.Iterator;

public class FlowerStore {

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

    public static void sellBouquet(int roses, int chamomiles, int tulips) {
        ArrayList<Flower> bouquet = sell(roses, chamomiles, tulips);
        Iterator<Flower> iter = bouquet.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next().getName() + " ");
        }
    }

}
