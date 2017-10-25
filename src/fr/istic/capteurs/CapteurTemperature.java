package fr.istic.capteurs;

public class CapteurTemperature extends Capteur {

  private double temperature;

  public CapteurTemperature(String nom, CapteurType type) {
    super(nom, type);
    temperature = 0;
  }

  public CapteurTemperature(String nom, CapteurType type, double temperature) {
    super(nom, type);
    this.temperature = temperature;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
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

    return super.toString() + "(Temperature = " + temperature + ")";

  }
}
