
import java.util.ArrayList;
import java.util.HashMap;


public class Registro {
    
    
    private HashMap<Posto,ArrayList<Occupazione>> riservazioni;

    public Registro() {
        riservazioni=new HashMap();
    }

    public HashMap<Posto, ArrayList<Occupazione>> getRiservazioni() {
        return riservazioni;
    }
    
    
    public void registrazione(Treno t){
        int i,j;
        
        for(i=1;i<=t.getVagoni().size();i++){
        
            for(j=0;j<t.getVagoni().get(i).getPosti().size();j++){
            
                riservazioni.put(t.getVagoni().get(i).getPosti().iterator().next(), new ArrayList());
            
            }
        
        
        
        }
    
    
    
    }
    
    
    
}
