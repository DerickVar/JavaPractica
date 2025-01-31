public class Casa {
    private double ancho;
    private double largo;
    private double alto;
    private int pisos;

    public Casa(double ancho, double largo, double alto, int pisos) {
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
        this.pisos = pisos;
    }

    // Getters y Setters
    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    public double getAlto() {
        return alto;
    }

    public int getPisos() {
        return pisos;
    }

    // Método para comparar casas
    public boolean esHomónima(Casa otraCasa) {
        return this.ancho == otraCasa.ancho && this.largo == otraCasa.largo && this.alto == otraCasa.alto && this.pisos == otraCasa.pisos;
    }

    @Override
    public String toString() {
        return "Casa [Ancho: " + ancho + ", Largo: " + largo + ", Alto: " + alto + ", Pisos: " + pisos + "]";
    }
}
