/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArayuzIslemleri;

import java.util.Objects;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ocak
 */
public class GirisEkranIslemleri {
    
    
    private JTextField jTextField_KullaniciAdi;
    private JPasswordField jPasswordField_KullaniciSifresi;
    private JTextField jTextField_KurtarmaKodu;
    
    
    private String girilenSifre;
    private String girilenKullaniciAdi;
    private String girilenKurtarmaKodu;
    
    private String sonucMesaj;
   
    
    private String sonucKurtarma_BosAlan;
    private String sonucKurtarma_Mesaj;

    public GirisEkranIslemleri(JTextField jTextField_KullaniciAdi, JPasswordField jPasswordField_KullaniciSifresi, JTextField jTextField_KurtarmaKodu) {
        this.jTextField_KullaniciAdi = jTextField_KullaniciAdi;
        this.jPasswordField_KullaniciSifresi = jPasswordField_KullaniciSifresi;
        this.jTextField_KurtarmaKodu = jTextField_KurtarmaKodu;
        
        this.girilenKullaniciAdi = jTextField_KullaniciAdi.getText().toString();
        this.girilenSifre = new String(jPasswordField_KullaniciSifresi.getPassword());
        this.girilenKurtarmaKodu = jTextField_KurtarmaKodu.getText().toString();
        
        
    }
    
    
    // Giriş yap metodları
    
   
    
    public boolean bosGirisKontrol(){
        
        if(this.girilenKullaniciAdi.equals("") && this.girilenSifre.equals("")){
            
            
            this.sonucMesaj = "Kullanıcı adı ve şifresi giriniz.";
            
            return false;
            
        }else if(this.girilenKullaniciAdi.equals("")){
            
            
              this.sonucMesaj = "Kullanıcı adı giriniz.";
            
              return false;
            
        }else if(this.girilenSifre.equals("")){
            
             this.sonucMesaj = "Kullanıcı şifresi giriniz.";
            
              return false;
            
            
        }else{
            
             this.sonucMesaj = "Başarılı";
            
             return true;
             
        }
        
        
    }
    
   
    
    
    // Şifre Kurtarma Metodları 
    
    
    protected boolean bosKurtarmaKontrol(){
        
        
        if(! this.girilenKurtarmaKodu.equals("")){
            
            
            this.sonucKurtarma_BosAlan = "Başarılı";
            
            return true;
            
        }else{
            
            
            this.sonucKurtarma_BosAlan = "Kurtarma kodu girmediniz!";
            
            
            return false;
            
            
        }
                
       }
    
    
    protected boolean kurtarmaKoduKontrol(String kurtarmaKodu){
        
        
        if(this.girilenKurtarmaKodu.equals(kurtarmaKodu)){
            
             this.sonucKurtarma_Mesaj = "Başarılı";
             
             return true;
            
            
        }else{
            
            this.sonucKurtarma_Mesaj = "Kurtarma kodu eşleşmedi!";
            
            return false;
            
        }
        
 
    }
    
    
    
    
    public boolean sifreKurtar(String kurtarmaKodu){
        
      boolean bosKurtarmaAlani = bosKurtarmaKontrol();
      boolean kurtarmaKoduKontrol = kurtarmaKoduKontrol(kurtarmaKodu);
      
      if(!bosKurtarmaAlani){
          
          this.sonucMesaj = this.sonucKurtarma_BosAlan;
          return false;
          
      }else if(!kurtarmaKoduKontrol){
          
          this.sonucMesaj = this.sonucKurtarma_Mesaj;
          return false;
          
          
      }else{
          
          this.sonucMesaj = "Başarılı";
          return true;
          
      }  

    }
    
    

    public String getSonucMesaj() {
        return sonucMesaj;
    }
    

    
}
