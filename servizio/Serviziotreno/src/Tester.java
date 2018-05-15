
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Tester {
    
    
    public static void main(String args[]){
        
        HashMap<Integer,Tratta> strada=new HashMap();
        strada.put(1,new Tratta("GENOVA","PAVIA",20));
        strada.put(2,new Tratta("PAVIA","MILANO",25));
        strada.put(3,new Tratta("MILANO","MODENA",30));
        strada.put(4,new Tratta("MODENA","BOLOGNA",15));
        
        
        HashMap<Integer,Tratta> strada1=new HashMap();
        strada1.put(1,new Tratta("FIRENZE","TORINO",60));
        strada1.put(2,new Tratta("TORINO","MILANO",35));
        strada1.put(3,new Tratta("MILANO","PISA",25));
        strada1.put(4,new Tratta("PISA","VENEZIA",45));
        
        Itinerario linea1=new Itinerario("A",strada);
        Itinerario linea2=new Itinerario("B",strada1);
        
    
        
        Set<Posto> p=new HashSet();
        p.add(new Posto("1A"));
        p.add(new Posto("2A"));
        p.add(new Posto("3A"));
        p.add(new Posto("4A"));
        
    
        
        Vagone v1=new Vagone(p,Tipologia.PRIMA_STANDARD);
        
        Set<Posto> p1=new HashSet();
        p1.add(new Posto("1B"));
        p1.add(new Posto("2B"));
        p1.add(new Posto("3B"));
        p1.add(new Posto("4B"));
        
        Vagone v2=new Vagone(p1,Tipologia.PRIMA_CUCCETTA);
        
        HashMap<Integer,Vagone> m=new HashMap();
        m.put(1, v1);
        m.put(2, v2);
        
        Treno t=new Treno(m);
        Treno t3=new Treno(m);
        Treno t1=new Treno(m);
        Treno t2=new Treno(m);
        
        
        Compagnia it=new Compagnia("Trenitalia");
        Compagnia fr=new Compagnia("Trenord");
        
        it.aggiungitreno(t);
        it.aggiungitreno(t3);
        fr.aggiungitreno(t1);
        fr.aggiungitreno(t2);
       
        
       Viaggio v=new Viaggio(t,linea2,new Date(118,6,2,9,00),Modalita.DIRETTO);
       Viaggio w=new Viaggio(t3,linea1,new Date(118,6,2,9,45),Modalita.DIRETTO);
       Viaggio y=new Viaggio(t3,linea1,new Date(118,6,2,14,00),Modalita.DIRETTO);
       Viaggio x=new Viaggio(t,linea2,new Date(118,6,2,17,30),Modalita.DIRETTO);
        
        
       Viaggio vo=new Viaggio(t1,linea2,new Date(118,6,2,18,00),Modalita.DIRETTO);
       Viaggio wo=new Viaggio(t2,linea1,new Date(118,6,2,15,30),Modalita.DIRETTO);
        
       it.aggiungiviaggio(v);
       it.aggiungiviaggio(w);
       it.aggiungiviaggio(y);
       it.aggiungiviaggio(x);
       
       fr.aggiungiviaggio(vo);
       fr.aggiungiviaggio(wo);
       
       it.setprezzo(Tipologia.PRIMA_STANDARD, 0.50);
       it.setprezzo(Tipologia.PRIMA_CUCCETTA, 1.00);
       it.setprezzo(Tipologia.SECONDA_STANDARD,0.20);
       it.setprezzo(Tipologia.SECONDA_CUCETTA, 0.45);
       
       fr.setprezzo(Tipologia.PRIMA_STANDARD, 0.60);
       fr.setprezzo(Tipologia.PRIMA_CUCCETTA, 0.95);
       fr.setprezzo(Tipologia.SECONDA_STANDARD, 0.25);
       fr.setprezzo(Tipologia.SECONDA_CUCETTA, 0.45);
    
       ArrayList<Compagnia> c=new ArrayList();
       c.add(fr);
       c.add(it);
       
       ArrayList<Itinerario> I=new ArrayList();
       I.add(linea1);
       I.add(linea2);
       
       
       
       Servizioferrovario servizio=new Servizioferrovario(c,I);
       
       Prenotazione pr=new Prenotazione("MILANO","BOLOGNA",new Date(118,6,2));
       
       servizio.checktreno(pr);
       
       
      // servizio.stampaprezzi(3, pr);
       
      // servizio.visualizzaposti(2);
     
      
     
    
    }
    
}
