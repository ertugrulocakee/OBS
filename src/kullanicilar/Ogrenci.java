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
public class Ogrenci extends Kullanici{
    
    private Integer okulaBaslamaTarihi;
    private Integer kayitliOlunanOkul;
    private Integer sinavPuani;

    public Ogrenci(Integer okulaBaslamaTarihi, Integer kayitliOlunanOkul, Integer sinavPuani, int id, int yas, String isim, String soyIsim, String kullaniciAdi, String kullaniciSifre, String role, String eMail) {
        super(id, yas, isim, soyIsim, kullaniciAdi, kullaniciSifre, role, eMail);
        this.okulaBaslamaTarihi = okulaBaslamaTarihi;
        this.kayitliOlunanOkul = kayitliOlunanOkul;
        this.sinavPuani = sinavPuani;
    }

    
    public Integer getOkulaBaslamaTarihi() {
        return okulaBaslamaTarihi;
    }

    public Integer getKayitliOlunanOkul() {
        return kayitliOlunanOkul;
    }

    public Integer getSinavPuani() {
        return sinavPuani;
    }
    
    
    
    
}
