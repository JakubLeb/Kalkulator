package application;

public class Modulo implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length < 2) {
            throw new IllegalArgumentException("Operacja modulo wymaga przekazania przynajmniej dwóch liczb!");
        }
        
        double wynik = liczby[0];
        for (int i = 1; i < liczby.length; i++) {
            if (liczby[i] == 0) {
                throw new IllegalArgumentException("Nie można wykonać operacji modulo przez 0!");
            }
            wynik %= liczby[i]; 
        }
        return wynik;
    }
}
