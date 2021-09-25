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
public class Admin extends Kullanici {
    
    private Integer adminSifresi;

    public Admin(Integer adminSifresi, int id, int yas, String isim, String soyIsim, String kullaniciAdi, String kullaniciSifre, String role, String eMail) {
        super(id, yas, isim, soyIsim, kullaniciAdi, kullaniciSifre, role, eMail);
        this.adminSifresi = adminSifresi;
    }
    
   

    public Integer getAdminSifresi() {
        return adminSifresi;
    }
    

    
}
