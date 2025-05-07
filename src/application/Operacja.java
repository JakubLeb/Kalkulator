package application;

public enum Operacja {
    DODAWANIE(new Dodawanie()),
    ODEJMOWANIE(new Odejmowanie()),
    MNOZENIE(new Mnozenie()),
    DZIELENIE(new Dzielnie()),
    PIERWIASTEK(new Pierwiastkowanie()),
    LOGARYTM(new Logarytm()),
    KWADRAT(new Kwadrat()), 
    MODULO(new Modulo());

    private StrategiaObliczeń strategia;

    private Operacja(StrategiaObliczeń strategia) {
        this.strategia = strategia;
    }

    public StrategiaObliczeń getStrategiaObliczeń() {
        return this.strategia;
    }
}
