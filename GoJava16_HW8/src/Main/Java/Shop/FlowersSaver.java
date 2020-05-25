package Main.Java.Shop;

import Main.Java.Flowers.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FlowersSaver {

    public static void save(File file, ArrayList<Flower> bouquet) {
        if (!file.exists()) {
            file = new File(file.getAbsolutePath());
        }

        try (FileWriter writer = new FileWriter(file, false)) {
            for (Flower f : bouquet) {
                if (f instanceof Rose) {
                    writer.write(Rose.class.getSimpleName() + " ");
                } else if (f instanceof Chamomile) {
                    writer.write(Chamomile.class.getSimpleName() + " ");
                } else if (f instanceof Tulip) {
                    writer.write(Tulip.class.getSimpleName() + " ");
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
