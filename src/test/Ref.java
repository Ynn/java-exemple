package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.istic.capteurs.Capteur;
import fr.istic.capteurs.CapteurType;

public class Ref {

  public static void main(String[] args) {

    Capteur c = new Capteur("C1", CapteurType.KNX);
    c.setPrecision(0.50f);

    List<Capteur> l = new ArrayList<>();
    l.add(c);

    System.out.println(l.size());

    c.setPrecision(0.1f);
    System.out.println(c.getPrecision());
    System.out.println(l.get(0).getPrecision());

    l.get(0).setPrecision(0.2f);
    System.out.println(c.getPrecision());
    System.out.println(l.get(0).getPrecision());

    System.out.println(l.size());

    List<Capteur> l2 = Collections.unmodifiableList(l);
    l2.add(new Capteur("TEST", CapteurType.BACNET));
    for (Capteur ca : l2) {
      System.out.println(ca);

    }
    System.out.println(l.size());

  }
}
