
public class Tratta {
    
    private String Stazione1;
    private String Stazione2;
    private int durata;

    public Tratta(String Stazione1, String Stazione2, int durata) {
        this.Stazione1 = Stazione1;
        this.Stazione2 = Stazione2;
        this.durata = durata;
    }

    public String getStazione1() {
        return Stazione1;
    }

    public String getStazione2() {
        return Stazione2;
    }

    public int getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        return Stazione1+"--"+Stazione2+" : "+durata;
    }
    
    
}
