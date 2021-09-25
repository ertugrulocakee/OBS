/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kullanicilar;

/**
 *
 * @author ocak
 */
public class Kullanici {
    
    private int id;
    private int yas;
    private String isim;
    private String soyIsim;
    private String kullaniciAdi;
    private String kullaniciSifre;
    private String role;
    private String eMail;

    public Kullanici(int id,int yas, String isim, String soyIsim, String kullaniciAdi, String kullaniciSifre, String role, String eMail) {
        this.id = id;
        this.yas = yas;
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSifre = kullaniciSifre;
        this.role = role;
        this.eMail = eMail;
    }

    public int getYas() {
        return yas;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public String getRole() {
        return role;
    }

    public String geteMail() {
        return eMail;
    }

    public int getId() {
        return id;
    }
    
 
}
