package application;

public class Pierwiastkowanie implements StrategiaObliczeń {

    @Override
    public double oblicz(double... liczby) {
        if (liczby == null || liczby.length != 1) {
            throw new IllegalArgumentException("Operacja pierwiastkowanie wymaga przekazania jednej liczby!");
        }
        if (liczby[0] < 0) {
            throw new IllegalArgumentException("Liczba nie może być mniejsza niż 0");
        }

        return Math.sqrt(liczby[0]);
    }
}
