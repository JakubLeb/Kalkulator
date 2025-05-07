package application;

public class KalkulatorStrategiczny {
	private StrategiaObliczeń strategiaObliczen;
	
	public void setStrategiaObliczeń(StrategiaObliczeń strategiaObliczen) {
		this.strategiaObliczen = strategiaObliczen;
	}
	public double oblicz (double... liczby) {
		return this.strategiaObliczen.oblicz(liczby);
	}
	public double oblicz(StrategiaObliczeń strategiaObliczen, double... liczby) {
		return strategiaObliczen.oblicz(liczby);
	}

}
