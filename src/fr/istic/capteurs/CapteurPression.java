package fr.istic.capteurs;

public class CapteurPression extends Capteur {

  private double pression;

  public CapteurPression(String nom, CapteurType type) {
    super(nom, type);
    pression = 0;
  }

  public CapteurPression(String nom, CapteurType type, double pression) {
    super(nom, type);
    this.pression = pression;
  }

  public double getPression() {
    return pression;
  }

  public void setPression(double pression) {
    this.pression = pression;
  }

  @Override
  public String toString() {
    // mauvaise solution :
    // return String.format("Capteur [nom = %s][type = %s] [precision = %.3f]",
    // nom, getType(), getPrecision())
    // + "[Temperature  ="
    // + this.getTemperature() + "]";

    // Attention (boucle :)
    // return this.toString() + "(Temperature = " + temperature + ")";

    return super.toString() + "(Pression = " + pression + ")";

  }
}
