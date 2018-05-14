/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author QUENTIN
 */
class Occupazione {
    
    private String stazionepartenza;
    private String stazionearrivo;

    public Occupazione(String stazionepartenza, String stazionearrivo) {
        this.stazionepartenza = stazionepartenza;
        this.stazionearrivo = stazionearrivo;
    }

    public String getStazionepartenza() {
        return stazionepartenza;
    }

    public String getStazionearrivo() {
        return stazionearrivo;
    }
    
    
    
}
