package Main.Java.Shop;

import Main.Java.Flowers.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FlowersLoader {

    public static ArrayList<Flower> load(File file) {
        ArrayList<Flower> bouquet = new ArrayList<>();

        if (file.exists()) {
            StringBuilder fileBouquet = new StringBuilder();
            try (FileReader reader = new FileReader(file)) {
                int c;
                while ((c = reader.read()) != -1) {
                    fileBouquet.append((char) c);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            String[] preBouquet = fileBouquet.toString().trim().split(" ");
            for (String s : preBouquet) {
                if (s.equals("Rose")) {
                    bouquet.add(new Rose());
                } else if (s.equals("Chamomile")) {
                    bouquet.add(new Chamomile());
                } else if (s.equals("Tulip")) {
                    bouquet.add(new Tulip());
                }
            }
        } else {
            System.out.println("Bouquet not found.");
        }

        return bouquet;
    }
}

//https://devcolibri.com/java-%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D0%B0-%D1%81-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0%D0%BC%D0%B8/
//https://metanit.com/java/tutorial/6.8.php
