/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kullanicilar;

import java.util.logging.Logger;

/**
 *
 * @author ocak
 */
public class Ogretmen extends Kullanici{
    
    private Integer atamaPuani;
    private Integer ogretmenlikBaslamaTarihi;
    private String brans;
    private Integer atanilanOkulId;

    public Ogretmen(Integer atamaPuani, Integer ogretmenlikBaslamaTarihi, String brans, Integer atanilanOkulId, int id, int yas, String isim, String soyIsim, String kullaniciAdi, String kullaniciSifre, String role, String eMail) {
        super(id, yas, isim, soyIsim, kullaniciAdi, kullaniciSifre, role, eMail);
        this.atamaPuani = atamaPuani;
        this.ogretmenlikBaslamaTarihi = ogretmenlikBaslamaTarihi;
        this.brans = brans;
        this.atanilanOkulId = atanilanOkulId;
    }
    
 
    public Integer getAtamaPuani() {
        return atamaPuani;
    }

    public Integer getOgretmenlikBaslamaTarihi() {
        return ogretmenlikBaslamaTarihi;
    }

    public String getBrans() {
        return brans;
    }

    public Integer getAtanilanOkulId() {
        return atanilanOkulId;
    }
   
    
    
    
    
}
