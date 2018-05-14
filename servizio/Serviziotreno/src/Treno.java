
import java.util.Map;


public class Treno {
    
    private String codice;
    private Map<Integer,Vagone> vagoni;

    public Treno(Map<Integer, Vagone> vagoni) {
        this.vagoni = vagoni;
        
        
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
    
    

    public String getCodice() {
        return codice;
    }

    
    
    public Map<Integer, Vagone> getVagoni() {
        return vagoni;
    }
   
   
}
