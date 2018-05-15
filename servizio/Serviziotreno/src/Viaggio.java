
import java.text.SimpleDateFormat;
import java.util.Date;


public class Viaggio implements Comparable {
    
    private Treno treno;
    private Itinerario percorso;
    private Date data;
    private Modalita modalita;
    private Registro registro;
    private String codviaggio;

    public Viaggio(Treno treno, Itinerario percorso, Date data,Modalita modalita) {
        
        this.treno = treno;
        this.percorso = percorso;
        this.data = data;
        this.modalita=modalita;
        this.registro=new Registro();
        this.registro.tracciaposti(treno);
    }

    public Treno getTreno() {
        return treno;
    }

    public Itinerario getPercorso() {
        return percorso;
    }

   
    public Date getData() {
        return data;
    }

    public Modalita getModalita() {
        return modalita;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setCodviaggio(String codviaggio) {
        this.codviaggio = codviaggio;
    }
    
    

    public String getCodviaggio() {
        return codviaggio;
    }
    
    
    
    
    @Override
    public int compareTo(Object t) {
        return this.getData().compareTo(((Viaggio)t).getData());
    }
    
   

    @Override
    public String toString() {
        SimpleDateFormat str=new SimpleDateFormat("dd/MM/yyyy EE hh:mm");
        return codviaggio+" \t"+str.format(data);
    }
    
    
    
}
