package application;

public class Mnozenie implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length < 2)
            throw new IllegalArgumentException("Operacja mnożenie "
            		+ "wymaga przekazania przynajmniej dwóch liczb!");
        double wynik = 1;
        for (double d : liczby) {
            wynik *= d;
        }
        return wynik;
    }
}
