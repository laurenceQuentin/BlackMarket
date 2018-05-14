
import java.util.ArrayList;
import java.util.Set;

public class Vagone {
    
    private Set<Posto> posti;
    private Tipologia  tipo;

    public Vagone(Set<Posto> posti, Tipologia tipo) {
        this.posti = posti;
        this.tipo = tipo;
    }

    public Set<Posto> getPosti() {
        return posti;
    }

    public Tipologia getTipo() {
        return tipo;
    }
    
    
    
}
