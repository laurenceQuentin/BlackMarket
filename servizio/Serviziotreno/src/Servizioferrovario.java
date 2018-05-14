
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Servizioferrovario {
    
    private ArrayList<Compagnia> compagnie;
    private ArrayList<Itinerario> itinerari;
    private ArrayList<Viaggio> viaggicorr=new ArrayList();
    private ArrayList<Viaggio> viaggip=new ArrayList();
    private ArrayList<Viaggio> viaggia=new ArrayList();
    private String stazioneincroccio=null;
    private Itinerario i1=null;
    private Itinerario i2=null;

    public Servizioferrovario(ArrayList<Compagnia> compagnie, ArrayList<Itinerario> itinerari) {
        this.compagnie = compagnie;
        this.itinerari = itinerari;
    }

    public Servizioferrovario() {
        this.compagnie=new ArrayList();
        this.itinerari=new ArrayList();
    }
    
                            
            
    public ArrayList<Compagnia> getCompagnie() {
        return compagnie;
    }

    public ArrayList<Itinerario> getItinerari() {
        return itinerari;
    }
    
    public void checktreno(Prenotazione p){
        
        int i,j,k,l,m,b1,b2;
        ArrayList<Viaggio> viaggi1=new ArrayList();
        ArrayList<Viaggio> viaggi2=new ArrayList();
        
        SimpleDateFormat str=new SimpleDateFormat("hh:mm");
        
        viaggicorr.clear();
        viaggip.clear();
        viaggia.clear();
        
        
        
        for(i=0;i<itinerari.size();i++){
            
            b1=itinerari.get(i).controllostazione(p.getStazionepartenza());
            b2=itinerari.get(i).controllostazione(p.getStazionearrivo());
            
            if(b1!=0 && b2!=0){
                
               i1=itinerari.get(i);
  
                for(j=0;j<compagnie.size();j++){
                    
                    viaggicorr.addAll(compagnie.get(j).checkviaggi(itinerari.get(i),itinerari.get(i).checkmodalita(p.getStazionepartenza(),p.getStazionearrivo()), p.getDatapartenza()));
                
                }
                for(j=0;j<viaggicorr.size();j++){
                    viaggicorr.get(j).getData().setMinutes(viaggicorr.get(j).getData().getMinutes()+i1.calcolodurata(i1.getTratte().get(1).getStazione1(),p.getStazionepartenza()));
                    System.out.print(j+1+"-"+viaggicorr.get(j).toString()+" - ");
                    viaggicorr.get(j).getData().setMinutes(viaggicorr.get(j).getData().getMinutes()+i1.calcolodurata(p.getStazionepartenza(),p.getStazionearrivo()));
                    System.out.println(str.format(viaggicorr.get(j).getData()));
                    viaggicorr.get(j).getData().setMinutes(viaggicorr.get(j).getData().getMinutes()-i1.calcolodurata(i1.getTratte().get(1).getStazione1(),p.getStazionepartenza()));
                    viaggicorr.get(j).getData().setMinutes(viaggicorr.get(j).getData().getMinutes()-i1.calcolodurata(p.getStazionepartenza(),p.getStazionearrivo()));
                
                }
        
            }
            if(b1!=0 && b2==0){
                i1=itinerari.get(i);
                for(j=0;j<itinerari.size();j++){
                    b2=itinerari.get(j).controllostazione(p.getStazionearrivo());
                    
                    if(b2!=0){
                        i2=itinerari.get(j);
                        for(k=1;k<=i2.getTratte().size();k++){
                            if(i1.controllostazione(i2.getTratte().get(k).getStazione1())!=0){
                                stazioneincroccio=i2.getTratte().get(k).getStazione1();
     
                                for(l=0;l<compagnie.size();l++){
                                    viaggi1.addAll(compagnie.get(l).checkviaggi(i1,i1.checkmodalita(p.getStazionepartenza(), stazioneincroccio), p.getDatapartenza()));
                                    viaggi2.addAll(compagnie.get(l).checkviaggi(i2,i2.checkmodalita(stazioneincroccio,p.getStazionearrivo()), p.getDatapartenza()));
                                }
                                
                                for(l=0;l<viaggi1.size();l++){
                                
                                    for(m=0;m<viaggi2.size();m++){
                                        if(viaggi1.get(l).getTreno().getCodice().split("-")[0].equals(viaggi2.get(m).getTreno().getCodice().split("-")[0])){
                                            viaggi1.get(l).getData().setMinutes(viaggi1.get(l).getData().getMinutes()+i1.calcolodurata(p.getStazionepartenza(), stazioneincroccio));
                                            viaggi2.get(m).getData().setMinutes(viaggi2.get(m).getData().getMinutes()+i2.calcolodurata(i2.getTratte().get(1).getStazione1(), stazioneincroccio));
                                            if(viaggi1.get(l).getData().compareTo(viaggi2.get(m).getData())<=0){
                                                
                                                viaggi1.get(l).getData().setMinutes(viaggi1.get(l).getData().getMinutes()-i1.calcolodurata(p.getStazionepartenza(), stazioneincroccio));
                                                System.out.print(viaggip.size()+1+"-"+viaggi1.get(l).toString()+" - ");
                                                viaggi1.get(l).getData().setMinutes(viaggi1.get(l).getData().getMinutes()+i1.calcolodurata(p.getStazionepartenza(), stazioneincroccio));
                                                System.out.print(str.format(viaggi1.get(l).getData())+"\t");
                                                viaggi1.get(l).getData().setMinutes(viaggi1.get(l).getData().getMinutes()-i1.calcolodurata(p.getStazionepartenza(), stazioneincroccio));
                                                System.out.print(viaggia.size()+1+"-"+viaggi2.get(m).toString()+" - ");
                                                viaggi2.get(m).getData().setMinutes(viaggi2.get(m).getData().getMinutes()+i2.calcolodurata( stazioneincroccio,p.getStazionearrivo()));
                                                System.out.println(str.format(viaggi2.get(m).getData()));
                                                viaggi2.get(m).getData().setMinutes(viaggi2.get(m).getData().getMinutes()-i2.calcolodurata(i2.getTratte().get(1).getStazione1(), stazioneincroccio));
                                                viaggi2.get(m).getData().setMinutes(viaggi2.get(m).getData().getMinutes()-i2.calcolodurata( stazioneincroccio,p.getStazionearrivo()));
                                                viaggip.add(viaggi1.get(l));
                                                viaggia.add(viaggi2.get(m));
                                                break;
                                            
                                            }
                                            viaggi2.get(m).getData().setMinutes(viaggi2.get(m).getData().getMinutes()-i2.calcolodurata(i2.getTratte().get(1).getStazione1(), stazioneincroccio));
                                            viaggi1.get(l).getData().setMinutes(viaggi1.get(l).getData().getMinutes()-i1.calcolodurata(p.getStazionepartenza(), stazioneincroccio));
                                        }
                                    
                                    }
                                }
                               
                            
                            }
                        
                        
                        }
                    
                    }
                
                }
            
            
            }
       
        }
        
  
    }
    
    public void stampaprezzi(int num,Prenotazione p){
    
        int i,j=1,d=0;
        Compagnia c=null;
        
        if(stazioneincroccio==null){
            d=viaggicorr.get(num-1).getPercorso().calcolodurata(p.getStazionepartenza(),p.getStazionearrivo());
            System.out.println(d);
            for(i=0;i<compagnie.size();i++){
                if(compagnie.get(i).getNome().equals(viaggicorr.get(num-1).getCodviaggio().split("-")[0])){
                    c=compagnie.get(i);
                
                }
            }
            for(i=0;i<Tipologia.values().length;i++){
        
                if(c.getPrezzi().size()==Tipologia.values().length)
                    System.out.println(j+"-"+Tipologia.values()[i]+"\t"+(d*c.getPrezzi().get(Tipologia.values()[i]))+" euros");
                    j++;
            }
        }
    }
       
    
      
}
