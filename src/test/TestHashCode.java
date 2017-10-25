package test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import fr.istic.capteurs.Capteur;
import fr.istic.capteurs.CapteurTemperature;
import fr.istic.capteurs.CapteurType;

public class TestHashCode {

  public static void main(String[] args) {
    Collection<Capteur> collection = new HashSet<Capteur>();
    // Collection<Capteur> collection = new CopyOnWriteArraySet<Capteur>();

    System.out.printf("est un ensemble ? : %s %n", collection instanceof Set);

    Capteur c1 = new Capteur("c1", CapteurType.KNX, 0.89f);
    Capteur c2 = new CapteurTemperature("temp1", CapteurType.LON);
    Capteur c3 = new CapteurTemperature("temp1", CapteurType.LON);

    collection.add(c1);
    collection.add(c2);
    collection.add(c3);
    collection.add(new CapteurTemperature("temp1", CapteurType.LON));
    collection.add(new CapteurTemperature("temp1", CapteurType.LON));
    collection.add(new CapteurTemperature("temp1", CapteurType.LON));
    collection.add(new CapteurTemperature("temp1", CapteurType.LON));
    collection.add(new CapteurTemperature("temp3", CapteurType.BACNET));

    for (Capteur capteur : collection) {
      System.out.println(capteur);
    }

  }
}
