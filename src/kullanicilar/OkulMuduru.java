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
public class OkulMuduru extends Ogretmen{
    
    private Integer mudurlukBaslamaYili;

    public OkulMuduru(Integer mudurlukBaslamaYili, Integer atamaPuani, Integer ogretmenlikBaslamaTarihi, String brans, Integer atanilanOkulId, int id, int yas, String isim, String soyIsim, String kullaniciAdi, String kullaniciSifre, String role, String eMail) {
        super(atamaPuani, ogretmenlikBaslamaTarihi, brans, atanilanOkulId, id, yas, isim, soyIsim, kullaniciAdi, kullaniciSifre, role, eMail);
        this.mudurlukBaslamaYili = mudurlukBaslamaYili;
    }

  

    public Integer getMudurlukBaslamaYili() {
        return mudurlukBaslamaYili;
    }
    

}
