package fr.istic.capteurs;

public class Capteur implements Comparable<Capteur> {

  protected String nom;
  private final CapteurType type;
  private float precision = 0.999f;

  public Capteur(String nom, CapteurType type) {
    // super(); // implicitement fait par Java
    this.nom = nom;
    this.type = type;
  }

  public Capteur(String nom, CapteurType type, float precision) {
    this(nom, type);
    setPrecision(precision);
    int a = 4;
  }

  public String getNom() {
    return nom;
  }

  public CapteurType getType() {
    return type;
  }

  public float getPrecision() {
    return precision;
  }

  public void setPrecision(float precision) {
    if (precision > 0 && precision < 1.0f) {
      this.precision = precision;
    } else {
      throw new IllegalArgumentException(precision + " is not in ]0..1[");
    }
  }

  @Override
  public String toString() {
    // return "[" + nom + "]" + "[" + type + "]";
    return String.format("Capteur (nom = %s)(type = %s)(precision = %.3f)",
        nom, type, precision);
  }

  @Override
  public boolean equals(Object obj) {
    // Je dois toujours vérifier que l'objet est de bon type :
    if (obj instanceof Capteur) {
      // Je veux voir mon objet comme un capteur :
      Capteur autreCapteur = (Capteur) obj;
      System.out.printf("Equals %s a %s %n", this.nom, autreCapteur.nom);

      // Surtout pas :
      // if (this.nom == autreCapteur.nom) {

      if (this.nom.equals(autreCapteur.nom)) {
        return this.type == autreCapteur.type;
      }

    } else {
      System.out
          .println("Essaye de comparer a un objet qui n'est pas un capteur");
    }
    return false;

  }

  @Override
  public int hashCode() {
    // System.out.println("Call hashcode");
    return nom.hashCode();// super.hashCode();
  }

  @Override
  public int compareTo(Capteur autreCapteur) {
    System.out.printf("Compare %s a %s %n", this.nom, autreCapteur.nom);
    return -this.nom.compareTo(autreCapteur.nom);
  }

}
