package application;

public class Dodawanie implements StrategiaObliczeń{

	@Override
	public double oblicz(double... liczby) {
		if (liczby==null || liczby.length < 2)
			throw new IllegalArgumentException("Operacja dodawanie wymaga "
					+ "przekazania przynajmniej dwóch liczb!");
		double wynik = 0;
		for (double d : liczby) {
			wynik += d;
		}
		// TODO Auto-generated method stub
		return wynik;
	}

}
