
import java.util.HashMap;
import java.util.Map;


public class Itinerario {
    
    private String nome;
    private Map<Integer,Tratta> tratte;

    public Itinerario(String nome, Map<Integer, Tratta> tratte) {
        this.nome = nome;
        this.tratte=new HashMap();
        this.tratte = tratte;
    }

    public String getNome() {
        return nome;
    }

    public Map<Integer, Tratta> getTratte() {
        return tratte;
    }
    
    

    public int controllostazione(String stazione){
    
        int i;
        
        for(i=1;i<=tratte.size();i++){
        
            if(tratte.get(i).getStazione1().equals(stazione))
                return i;
            else if(tratte.get(i).getStazione2().equals(stazione))
                return i;
        
        }
    
        return 0;
    }
    
    public int calcolodurata(String st1,String st2){
    
    int i,j,b1,b2,somma=0;
    String temp;
    
    b1=controllostazione(st1);
    b2=controllostazione(st2);
    
    if(b2<b1){
        temp=st1;
        st1=st2;
        st2=temp;
    }
    else if(b2==b1 && st1.equals(tratte.get(b2).getStazione2())){
        temp=st1;
        st1=st2;
        st2=temp;
    
    }
    
        for(i=1;i<=tratte.size();i++){
        
            if(tratte.get(i).getStazione1().equals(st1)){
            
                somma+=tratte.get(i).getDurata();
                if(!(tratte.get(i).getStazione2().equals(st2))){
                
                    for(j=i+1;j<=tratte.size();j++){
                        
                        somma+=tratte.get(j).getDurata();
                    
                        if(tratte.get(j).getStazione2().equals(st2))
                            return somma;
                    }
                }
                return somma;
            
            }
                
        }
        
        return 0;
    }
    
    public int calcoloduratatot(){
    
        int i,somma=0;
        
        for(i=1;i<=tratte.size();i++){
        
            somma+=tratte.get(i).getDurata();
            
        }
    
        return somma;
    }
    
    public Modalita checkmodalita(String st1,String st2){
        
        int i,b1,b2;
        
        b1=controllostazione(st1);
        b2=controllostazione(st2);
        
        if(st1.equals(st2)){
            return null;
        }
        
        if(b1<b2){
                return Modalita.DIRETTO;
        }       
        
        else if(b1>b2){
            return Modalita.INVERSO;
        }
        
        else if(b1==b2 && tratte.get(b1).getStazione1().equals(st1)){
            return Modalita.DIRETTO;
        }
        return Modalita.INVERSO;
    }
    
}
