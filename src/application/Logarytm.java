package application;

public class Logarytm implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length != 1) {
            throw new IllegalArgumentException("Operacja logarytmu "
            		+ "wymaga jednej liczby!");
        }
        if (liczby[0] <= 0) {
            throw new IllegalArgumentException("Logarytm jest "
            		+ "zdefiniowany tylko dla liczb większych od 0!");
        }
        return Math.log10(liczby[0]); 
    }
}
