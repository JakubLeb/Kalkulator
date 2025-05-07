package application;

public class Odejmowanie implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length < 2)
            throw new IllegalArgumentException("Operacja odejmowanie "
            		+ "wymaga przekazania przynajmniej dwóch liczb!");
        double wynik = liczby[0];
        for (int i = 1; i < liczby.length; i++) {
            wynik -= liczby[i];
        }
        return wynik;
    }
}
