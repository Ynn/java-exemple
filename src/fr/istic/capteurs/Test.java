package fr.istic.capteurs;

import java.util.LinkedList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    Capteur c1 = new Capteur("c1", CapteurType.KNX, 0.89f);
    Capteur c2 = new CapteurTemperature("temp1", CapteurType.LON);

    List<Capteur> list = new LinkedList<>();// new ArrayList<>();
    list.add(c1);
    list.add(c2);
    for (int i = 0; i < 98; i++) {
      // c est de type Capteur donc je peux mettre un CapteurTemperature
      Capteur c = new CapteurTemperature("temp" + i, CapteurType.LON);
      list.add(c);
      c.setPrecision(i * 0.01f + 0.000001f);
      // Java considere c comme un Catpeur et pas un Capteur de Temperature:
      // Je dois lui expliquer que c est vraiment un CapteurTemperature
      ((CapteurTemperature) c).setTemperature(i * 2);
    }

    Capteur capteurPression = new CapteurPression("Pression",
        CapteurType.BACNET, 5);
    list.add(capteurPression);
    try {
      System.out.println("Ligne avant exception");
      capteurPression.setPrecision(10);
      System.out.println("Cette ligne ne sera pas affichée");
    } catch (IllegalArgumentException e) {
      // System.err.println("Appel impossible " + e.getMessage());
    } catch (ClassCastException e) {

    }

    for (Capteur capteur : list) {
      try {

        System.out.println(capteur);
        if (capteur instanceof CapteurTemperature) {
          System.out.println("T");
          ((CapteurTemperature) capteur).setTemperature(10);
        }

        if (capteur instanceof CapteurPression) {
          System.out.println("P");
        }

        if (capteur.getClass().equals(Capteur.class)) {
          System.out.println("C");
        }

      } catch (Exception e) {
        System.err.println("OUCH !");
      }

    }

  }
}
