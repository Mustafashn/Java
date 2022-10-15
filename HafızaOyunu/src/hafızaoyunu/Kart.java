/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hafızaoyunu;

/**
 *
 * @author musta
 */
public class Kart {
    private char deger;
    private boolean tahmin = false;
    public Kart (char deger) {
        this.deger = deger;
    }
    public void setDeger(char deger){
        this.deger=deger;
        
    }
    public char getDeger() {
        return deger;
    }
    public void setTahmin(boolean tahmin){
        this.tahmin=tahmin;
    }
    public boolean getTahmin() {
        return tahmin;
    }
}
