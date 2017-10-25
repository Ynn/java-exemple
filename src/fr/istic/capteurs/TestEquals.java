package fr.istic.capteurs;

public class TestEquals {

  public static void main(String[] args) {

    /**
     * == Avec des objets pointe sur la meme case memoire ?
     */
    System.out.println("Objets =");

    Capteur c1 = new Capteur(new String("A"), CapteurType.KNX);
    Capteur c1bis = new Capteur(new String("A"), CapteurType.KNX);
    Capteur c2 = new Capteur("B", CapteurType.BACNET);
    Capteur c1bisbis = c1;

    if (c1 == c1bis) {
      System.out.println("pointe sur la meme case");
    } else {
      System.out.println("ne pointe pas sur la même case");
    }
    System.out.println(c1 == c2);
    System.out.println(c1 == c1bisbis);

    System.out.println("\nCapteurs avec equals : ");
    System.out.println(c1.equals(c1bis));
    System.out.println(c1.equals(c2));
    System.out.println(c1.equals(c1bisbis));
    System.out.println(c1.equals("Toto"));

    /**
     * == avec des primitifs
     */
    int a = 5;
    int b = 6;
    int a1 = 5;
    int a2 = a;
    System.out.println("\nPrimitifs =");
    System.out.println(a == a1);
    System.out.println(a == b);
    System.out.println(a == a2);

    /**
     * Avec le type String
     */
    System.out.println("\nString :");

    System.out.println(new String("Toto") == new String("Toto"));
    System.out.println("Toto" == "Toto"); // Fonctionne de temps en temps
                                          // (optimisation Java) NE JAMAIS
                                          // UTILISER CA
    System.out.println("Toto".equals("Toto"));

  }
}
