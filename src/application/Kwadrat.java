package application;

public class Kwadrat implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length == 0) {
            throw new IllegalArgumentException("Operacja kwadrat "
            		+ "wymaga przekazania liczby!");
        }
        double wynik = Math.pow(liczby[0], 2);
        return wynik;
    }
}
