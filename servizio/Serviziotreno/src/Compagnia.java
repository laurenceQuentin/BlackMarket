
import java.util.ArrayList;
import java.util.*;


public class Compagnia {
    
    private String nome;
    private HashMap<String,Treno> treni;
    private ArrayList<Viaggio> viaggi;
    private HashMap<Tipologia,Double> prezzi;

    public Compagnia(String nome) {
        this.nome = nome;
        this.treni=new HashMap();
        this.viaggi=new ArrayList();
        this.prezzi=new HashMap();
    }

    public String getNome() {
        return nome;
    }

    public HashMap<String,Treno> getTreni() {
        return treni;
    }

    public ArrayList<Viaggio> getViaggi() {
        return viaggi;
    }
    
    
    public boolean aggiungitreno(Treno t){
    
       t.setCodice(nome+"-Treno"+treni.size());
       treni.put(t.getCodice(), t);
       return true;
       
    }
    public boolean aggiungiviaggio(Viaggio v){
        
        
        v.setCodviaggio(nome+"-"+viaggi.size());
        if(!(treni.keySet().contains(v.getTreno().getCodice()))){
            System.out.println("treno non esistente");
            return false;
    
        }
        
        if(v.getData().compareTo(new Date())<0){
            System.out.println("Non si può programmare un viaggio nel passato");
            return false;
        }
        
        Viaggio temp1=null,temp2=null;
        Collections.sort(viaggi);
        
        int i,j;
       
                
                
        for(i=0;i<viaggi.size();i++){
            
            if(viaggi.get(i).getTreno().getCodice().equals(v.getTreno().getCodice())){
                
                if(viaggi.get(i).getData().getYear()==v.getData().getYear() && viaggi.get(i).getData().getMonth()== v.getData().getMonth()){
                    if(viaggi.get(i).getData().getDay()==v.getData().getDay()){
                        if(viaggi.get(i).getPercorso()!=v.getPercorso()){
                            System.out.println("treno già in uso su un'altra linea");
                            return false;
                        }
                    
                    }
                
                }
            
                if(viaggi.get(i).getData().compareTo(v.getData())==0){
                
                    System.out.println("Treno già in uso");
                    return false;
                }
                else if(viaggi.get(i).getData().compareTo(v.getData())<0){
                    temp1=viaggi.get(i);
                    
                }    
            }
        }
        for(j=0;j<viaggi.size();j++){
                    
                        if(viaggi.get(j).getTreno().getCodice().equals(v.getTreno().getCodice())){
                        
                            if(viaggi.get(j).getData().compareTo(v.getData())==0){
                                System.out.println("Treno già in uso");
                                return false;
                            }
                            else if(viaggi.get(j).getData().compareTo(v.getData())>0){
                            
                                temp2=viaggi.get(j);
                                break;
                            
                            }
                        
                        
                        }
                     
        }
                
                
        if(temp1==null && temp2==null){
            viaggi.add(v);
            System.out.println("ok");
            return true;
        }
       else if(temp1!=null && temp2==null){
            if(temp1.getModalita()==v.getModalita()){
                
                temp1.getData().setMinutes(temp1.getData().getMinutes()+(2*temp1.getPercorso().calcoloduratatot()));
                    if(temp1.getData().compareTo(v.getData())<=0){
                        viaggi.add(v);
                        System.out.println("yes");
                        temp1.getData().setMinutes(temp1.getData().getMinutes()-(2*temp1.getPercorso().calcoloduratatot())); 
                        return true;
                    }
                    else{
                        System.out.println("kTreno in uso");
                        temp1.getData().setMinutes(temp1.getData().getMinutes()-(2*temp1.getPercorso().calcoloduratatot())); 
                        return false;
                    } 
            }
            else if(temp1.getModalita()!=v.getModalita()){
                
                temp1.getData().setMinutes(temp1.getData().getMinutes()+(temp1.getPercorso().calcoloduratatot()));
                    if(temp1.getData().compareTo(v.getData())<=0){
                        viaggi.add(v);
                        System.out.println("top");
                        temp1.getData().setMinutes(temp1.getData().getMinutes()-(temp1.getPercorso().calcoloduratatot())); 
                        return true;
                    }
                    else{
                        System.out.println("nTreno in uso");
                        temp1.getData().setMinutes(temp1.getData().getMinutes()-(temp1.getPercorso().calcoloduratatot())); 
                        return false;
                    }    
            }
        }
        
       else if(temp1!=null && temp2!=null){
           
            if(temp1.getModalita()==v.getModalita()){
                
                temp1.getData().setMinutes(temp1.getData().getMinutes()+(2*temp1.getPercorso().calcoloduratatot()));
                    if(temp1.getData().compareTo(v.getData())>0){
                        
                        System.out.println("fTreno in uso");
                        temp1.getData().setMinutes(temp1.getData().getMinutes()-(2*temp1.getPercorso().calcoloduratatot())); 
                        return false;
                    }
                    else{
                   
                        Date d=v.getData();
                        if(v.getModalita()==temp2.getModalita()){
                            
                            d.setMinutes(d.getMinutes()+(2*v.getPercorso().calcoloduratatot()));
                            if(d.compareTo(temp2.getData())<=0){
                                viaggi.add(v);
                                d.setMinutes(d.getMinutes()-(2*v.getPercorso().calcoloduratatot()));
                                System.out.println("putain");
                                return true;
                            }
                            else{
                                System.out.println("ktreno gia in uso");
                                return false;
                            }
                        }
                        
                         if(v.getModalita()!=temp2.getModalita()){
                            
                            d.setMinutes(d.getMinutes()+(v.getPercorso().calcoloduratatot()));
                            if(d.compareTo(temp2.getData())<=0){
                                viaggi.add(v);
                                d.setMinutes(d.getMinutes()-(v.getPercorso().calcoloduratatot()));
                                System.out.println("merda");
                                return true;
                            }
                            else{
                                System.out.println("qtreno gia in uso");
                                return false;
                            }
                        }
                    } 
            }
            
            else if(temp1.getModalita()!=v.getModalita()){
                
                temp1.getData().setMinutes(temp1.getData().getMinutes()+(temp1.getPercorso().calcoloduratatot()));
                    if(temp1.getData().compareTo(v.getData())>0){
                        System.out.println("putana");
                        temp1.getData().setMinutes(temp1.getData().getMinutes()-(temp1.getPercorso().calcoloduratatot()));
                        System.out.println("itreno gia in uso");
                        return false;
                    }
                    else{
                        
                        Date d=v.getData();
                        if(v.getModalita()==temp2.getModalita()){
                            
                            d.setMinutes(d.getMinutes()+(2*v.getPercorso().calcoloduratatot()));
                            if(d.compareTo(temp2.getData())<=0){
                                System.out.println("cheap thrills");
                                d.setMinutes(d.getMinutes()-(2*v.getPercorso().calcoloduratatot()));
                                viaggi.add(v);
                                return true;
                            }
                            else{
                                System.out.println("7treno gia in uso");
                                return false;
                            }
                        }
                        
                         if(v.getModalita()!=temp2.getModalita()){
                            
                            d.setMinutes(d.getMinutes()+(v.getPercorso().calcoloduratatot()));
                            if(d.compareTo(temp2.getData())<=0){
                                System.out.println("7 years");
                                d.setMinutes(d.getMinutes()-(v.getPercorso().calcoloduratatot()));
                                viaggi.add(v);
                                return true;
                            }
                            else{
                                System.out.println("8treno gia in uso");
                                return false;
                            }
                        }
                        
                       
                    }    
            
            }
        }
        else if(temp1==null && temp2!=null){
          Date d=v.getData();
                        if(v.getModalita()==temp2.getModalita()){
                            
                            d.setMinutes(d.getMinutes()+(2*v.getPercorso().calcoloduratatot()));
                            if(d.compareTo(temp2.getData())<=0){
                                viaggi.add(v);
                                d.setMinutes(d.getMinutes()-(2*v.getPercorso().calcoloduratatot()));
                                System.out.println("human");
                                return true;
                            }
                            else{
                                System.out.println("1treno gia in uso");
                                return false;
                            }
                        }
                        
                         if(v.getModalita()!=temp2.getModalita()){
                            
                            d.setMinutes(d.getMinutes()+(v.getPercorso().calcoloduratatot()));
                            if(d.compareTo(temp2.getData())<=0){
                                System.out.println("hymn for the weekend");
                                d.setMinutes(d.getMinutes()-(v.getPercorso().calcoloduratatot()));
                                viaggi.add(v);
                                return true;
                            }
                            else{
                                System.out.println("btreno gia in uso");
                                return false;
                            }
                        }
         
        }
        
        Collections.sort(viaggi);
        return true;
    }
        
    
    public boolean cancellaviaggio(String codviaggio){
    
        int i;
        
        for(i=0;i<viaggi.size();i++){
      
            if(codviaggio.equals(viaggi.get(i))){
            
                viaggi.remove(i);
                return true;
            }
        
        }
        
        return false; 
    }
    
    
    public boolean cancellatreno(String codicetreno){
    
        if(treni.containsKey(codicetreno)){
        
            treni.remove(codicetreno);
            int i;
            for(i=0;i<viaggi.size();i++){
                if(viaggi.get(i).getTreno().getCodice().equals(codicetreno)){
                    viaggi.remove(i);
                }
            
            }
            return true;
        }
        return false;
    }
    
    
    public void refreshviaggi(){
    
        int i;
    
        for(i=0;i<viaggi.size();i++){
    
            if(viaggi.get(i).getData().compareTo(new Date())<0){
        
                viaggi.remove(i);
            }
    
        }
    }
    
    public ArrayList<Viaggio> checkviaggi(Itinerario it,Modalita m,Date d){
    
        ArrayList<Viaggio> v=new ArrayList();
        int i;
        
        for(i=0;i<viaggi.size();i++){
            if(viaggi.get(i).getData().getYear()==d.getYear() &&viaggi.get(i).getData().getMonth()==d.getMonth()){
                if(viaggi.get(i).getData().getDay()==d.getDay()){
                
                    if(viaggi.get(i).getPercorso()==it){
                        
                        if(viaggi.get(i).getModalita()==m){
                        
                            v.add(viaggi.get(i));
                        
                        }
                    
                    }
                
                }
            
            }
        }
        return v;
    }
    
    public void setprezzo(Tipologia t,double pr){
        
        prezzi.put(t, pr);
    
    }

    public HashMap<Tipologia, Double> getPrezzi() {
        return prezzi;
    }
    
    
}
