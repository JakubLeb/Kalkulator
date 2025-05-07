package application;

public class Dzielnie implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length < 2) {
            throw new IllegalArgumentException("Operacja dzielenie "
            		+ "wymaga przekazania przynajmniej dwóch liczb!");
        }

        double wynik = liczby[0];

        for (int i = 1; i < liczby.length; i++) {
            if (liczby[i] == 0) {
                throw new ArithmeticException("Nie można dzielić przez 0!"); 
            }
            wynik /= liczby[i];
        }

        return wynik;
    }
}
