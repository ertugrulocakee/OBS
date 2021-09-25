/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLIslemleri;

import MailConfig.MailIslemleri;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import kullanicilar.Kullanici;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import kullanicilar.Admin;
import kullanicilar.Ogrenci;
import kullanicilar.Ogretmen;
import kullanicilar.OkulMuduru;

/**
 *
 * @author ocak
 */
public class SQLKullaniciIslemleri  extends SQLBaglanti{
    
  // Değişkenler  
 
    // SQL - kullanıcı Tablosu
    
   private final String kullaniciAdiSifresi = "SELECT * FROM kullanıcı WHERE kullaniciAdi = ? AND kullaniciSifre = ? ";
  
   
   // SQL - admin tablosu 
   
   private final String adminTablosu = "SELECT * FROM admin WHERE id = ?";
   
   // SQL - öğrenci tablosu
   
   private final String ogrenciTablosu = "SELECT * FROM ogrenci WHERE id = ?";
   
   // SQL - öğretmen tablosu
   
   private final String ogretmenTablosu = "SELECT * FROM ogretmen WHERE id = ?";
   
   // SQL - okulmuduru tablosu
   
   private final String okulMuduruTablosu = "SELECT * FROM ogretmen INNER JOIN okulmuduru WHERE ogretmen.id = ?";

   
   
   private final String kullaniciOlustur = "INSERT INTO kullanıcı VALUES (NULL,?,?,?,?,?,?,?)";
   private final String ogretmenOlustur = "INSERT INTO ogretmen VALUES(?,?,?,?,0)";
   private final String mudurOlustur = "INSERT INTO okulmuduru VALUES(?,?)";
   private final String ogrenciOlustur = "INSERT INTO ogrenci VALUES(?,?,0,-100)";
   
   
   private final String ogrenciNotuGuncelle = "UPDATE ogrenci SET sinavPuani = ? WHERE id = ?"; 
   private final String tumOkulMudurleri = "SELECT * FROM okulmuduru INNER JOIN kullanıcı INNER JOIN ogretmen WHERE kullanıcı.role = 'Mudur' AND okulmuduru.id = kullanıcı.id AND kullanıcı.id = ogretmen.id";
   private final String tumOgretmenlerSQL = "SELECT * FROM ogretmen INNER JOIN kullanıcı WHERE kullanıcı.role = 'Ogretmen' AND ogretmen.id = kullanıcı.id AND ogretmen.atanilanOkulId = ?";
   private final String ogretmenAtama = "UPDATE ogretmen SET atanilanOkulId = ? WHERE id = ?";
   
// Classlar
    
  //  MailIslemleri mailIslemi = new MailIslemleri();
    
    private MailIslemleri mailIslemi;

    
    public SQLKullaniciIslemleri(MailIslemleri mailIslemi, String DBIsmi) {
        super(DBIsmi);
        this.mailIslemi = mailIslemi;
    }
    
    public SQLKullaniciIslemleri(String DBIsmi){
        super(DBIsmi);
       
    }
    
    
    public LinkedList<Ogretmen> tumOgretmenleriBul(Integer id) throws SQLException{
        
       LinkedList<Ogretmen> tumOgretmenler = new LinkedList<>(); 
       
       komutTamamlayici = baglanti.prepareStatement(tumOgretmenlerSQL);
       komutTamamlayici.setInt(1,id);
       
       ResultSet sonuc = komutTamamlayici.executeQuery();
       
       while(sonuc.next()){
           
             Ogretmen ogretmen = new Ogretmen(sonuc.getInt("atamaPuani"),sonuc.getInt("ogretmenlikBaslangicTarihi"),sonuc.getString("Brans"),sonuc.getInt("atanilanOkulId"),sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email"));
             tumOgretmenler.add(ogretmen);
       }
       
       return tumOgretmenler;
    }
    
    public LinkedList<OkulMuduru> tumOkulMudurleriBul(){
        
        LinkedList<OkulMuduru> tumOkulMudurleriListesi = new LinkedList<>();
        
       try {
           komutTamamlayici = baglanti.prepareStatement(tumOkulMudurleri);
           ResultSet sonuc = komutTamamlayici.executeQuery();
           
           while(sonuc.next()){
               
               tumOkulMudurleriListesi.add(new OkulMuduru(sonuc.getInt("mudurlukBaslangic"),sonuc.getInt("atamaPuani"),sonuc.getInt("ogretmenlikBaslangicTarihi"),sonuc.getString("Brans"),sonuc.getInt("atanilanOkulId"),sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email")));
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        return tumOkulMudurleriListesi;
    }
    
    public boolean ogretmenAtamasiYap(Integer atanilanOkulId,Integer ogretmenId){
        
        boolean ogretmenAtamasiYapildiMi = false;
       
       try {
        baglanti.setAutoCommit(false);
        komutTamamlayici = baglanti.prepareStatement(ogretmenAtama);
        komutTamamlayici.setInt(1,atanilanOkulId);
        komutTamamlayici.setInt(2,ogretmenId);
        
        komutTamamlayici.executeUpdate();
        baglanti.commit();
        ogretmenAtamasiYapildiMi = true;
        
       } catch (SQLException ex) {
            try {
                baglanti.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
            }
           Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
       return ogretmenAtamasiYapildiMi; 
        
    }
    
    public boolean kullaniciNotuGir(Kullanici kullanici, Integer puan){
        
        boolean ogrenciNotuGuncellendiMi = false;
        
        
       try {
           baglanti.setAutoCommit(false);
           komutTamamlayici = baglanti.prepareStatement(ogrenciNotuGuncelle);
           komutTamamlayici.setInt(1,puan);
           komutTamamlayici.setInt(2,kullanici.getId());
           komutTamamlayici.executeUpdate();
           baglanti.commit();
           
           ogrenciNotuGuncellendiMi = true;
           
       } catch (SQLException ex) {
            try {
                baglanti.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
            }
           Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
        
        
        
        return ogrenciNotuGuncellendiMi; 
    }
    
    public boolean kullaniciOlustur(Kullanici kullanici){
      
        boolean kullaniciOlusturulduMu = false;
        Integer yeniKullaniciId;
        
        
      try{
          baglanti.setAutoCommit(false);
          
          
          komutTamamlayici = baglanti.prepareStatement(kullaniciOlustur);
          
          komutTamamlayici.setInt(1,kullanici.getYas());
          komutTamamlayici.setString(2,kullanici.getIsim());
          komutTamamlayici.setString(3,kullanici.getSoyIsim());
          komutTamamlayici.setString(4,kullanici.getKullaniciAdi());
          komutTamamlayici.setString(5,kullanici.getKullaniciSifre());
          komutTamamlayici.setString(6,kullanici.getRole());
          komutTamamlayici.setString(7,kullanici.geteMail());
          
          komutTamamlayici.executeUpdate();
          baglanti.commit();

          
          yeniKullaniciId = yeniKullaniciIdBul(kullanici);
          
          if(yeniKullaniciId != -100){
              
              kullaniciEkBilgileriOlustur(kullanici,yeniKullaniciId);
              
          }else{
              
              System.out.println("Kullanıcı id bulunamadı!");
              
          }
          
          
          kullaniciOlusturulduMu = true;
          
      }catch(SQLException e){
          
            try {
                baglanti.rollback(); // Olası hata durumunda yaptığımız işlemleri geri alıcaktır..
                
            } catch (SQLException ex) {
                Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }
          
      }
       
        
       return kullaniciOlusturulduMu;
        
    };
    
    protected void kullaniciEkBilgileriOlustur(Kullanici kullanici,Integer id){
        
        if(kullanici.getRole().equals("Ogrenci")){
            
            Ogrenci ogrenci = (Ogrenci) kullanici;
            
            try {
                
                baglanti.setAutoCommit(false);
                
                komutTamamlayici = baglanti.prepareStatement(ogrenciOlustur);
                
                komutTamamlayici.setInt(1,id);
                komutTamamlayici.setInt(2,ogrenci.getOkulaBaslamaTarihi());
               
                
                komutTamamlayici.executeUpdate();
                
                baglanti.commit();
                
            } catch (SQLException ex) {
                
                try {
                    baglanti.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }
         
         
            
        }else if(kullanici.getRole().equals("Ogretmen")){
            
           ogretmenTablosuOlustur(kullanici,id);
            
        }else if(kullanici.getRole().equals("Mudur")){
          
            
          ogretmenTablosuOlustur(kullanici,id);
          
          Ogretmen ogretmen = (Ogretmen) kullanici;
          OkulMuduru mudur = (OkulMuduru) ogretmen;  
            
            try {
                
                baglanti.setAutoCommit(false);
                
                komutTamamlayici = baglanti.prepareStatement(mudurOlustur);
                komutTamamlayici.setInt(1, id);
                komutTamamlayici.setInt(2, mudur.getMudurlukBaslamaYili());
           
                komutTamamlayici.executeUpdate();
                
                baglanti.commit();
          
            } catch (SQLException ex) {
                
              try {
                  baglanti.rollback();
              } catch (SQLException ex1) {
                  Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
              }
                Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            
        }
  
    }
    
    protected void ogretmenTablosuOlustur(Kullanici kullanici,Integer id){
        
        
        
         Ogretmen ogretmen = (Ogretmen) kullanici;    
            
            try {
                
                baglanti.setAutoCommit(false);
                
                komutTamamlayici = baglanti.prepareStatement(ogretmenOlustur);
                komutTamamlayici.setInt(1,id);
                komutTamamlayici.setInt(2,ogretmen.getAtamaPuani());
                komutTamamlayici.setInt(3,ogretmen.getOgretmenlikBaslamaTarihi());
                komutTamamlayici.setString(4,ogretmen.getBrans());
              
                
                komutTamamlayici.executeUpdate();
                
                baglanti.commit();
               
                
            } catch (SQLException ex) {
                
             try {
                 baglanti.rollback();
             } catch (SQLException ex1) {
                 Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex1);
             }
                Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
    }
    
    protected Integer yeniKullaniciIdBul(Kullanici kullanici){
        
       Integer id = -100;
       
       try {
           
           komutTamamlayici = baglanti.prepareStatement("SELECT * FROM kullanıcı WHERE kullaniciAdi = ?");
           komutTamamlayici.setString(1,kullanici.getKullaniciAdi());
           
           
           ResultSet resultSet = komutTamamlayici.executeQuery();
           
           while(resultSet.next()){
               
              id = resultSet.getInt("id");
              
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(SQLKullaniciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
        
        return id;
    }
    
    
    public Kullanici kullaniciBul(String kullaniciAdi) throws SQLException{
        
        Kullanici kullanici = null;
        
        komutTamamlayici = baglanti.prepareStatement("SELECT * FROM kullanıcı WHERE kullaniciAdi = ?");
        komutTamamlayici.setString(1,kullaniciAdi);
        
        ResultSet sonuc = komutTamamlayici.executeQuery();
        
        while(sonuc.next()){
            
            kullanici = new Kullanici(sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email"));
            
            
        }
 
        return kullanici;
    }
    
    
    public Kullanici kullaniciBul(String girilenKullaniciAdi, String girilenKullaniciSifre) throws SQLException{
        
      

           Kullanici kullanici = null;
           
           String role;
           
        
           
           komutTamamlayici = baglanti.prepareStatement(kullaniciAdiSifresi);
           
       
               komutTamamlayici.setString(1, girilenKullaniciAdi);
               komutTamamlayici.setString(2, girilenKullaniciSifre);
              
           ResultSet sonuc = komutTamamlayici.executeQuery();
           
           while(sonuc.next()){
               
           role = sonuc.getString("role");
           
            System.out.println(role);
           
           if(role.equals("Admin")){
              
               kullanici = ekBilgileriBul(adminTablosu,sonuc);  
               
           }else if(role.equals("Ogretmen")){
               
               
                kullanici = ekBilgileriBul(ogretmenTablosu,sonuc);  
               
           }else if(role.equals("Ogrenci")){
               
                kullanici = ekBilgileriBul(ogrenciTablosu,sonuc);  
                
                System.out.println(kullanici.getKullaniciAdi());
                
           }else if(role.equals("Mudur")){
               
               kullanici = ekBilgileriBul(okulMuduruTablosu,sonuc);  
               
           }
            
      
           }
           
          
           System.out.println(kullanici.getKullaniciSifre());
           
           return kullanici;
   
    }
    
    
    protected Kullanici ekBilgileriBul(String SQL, ResultSet sonuc) throws SQLException{
        
        Kullanici kullanici = null;
        
        Integer id = sonuc.getInt("id");
        
        String role = sonuc.getString("role");
        
        komutTamamlayici = baglanti.prepareStatement(SQL);
        
        komutTamamlayici.setInt(1,id);
        
        ResultSet sonucYeni = komutTamamlayici.executeQuery();
        
        while(sonucYeni.next()){
            
            if(role.equals("Admin")){
                
              kullanici = new Admin(sonucYeni.getInt("adminSifresi"),sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email"));
                
            }else if(role.equals("Ogretmen")){
                
              kullanici = new Ogretmen(sonucYeni.getInt("atamaPuani"),sonucYeni.getInt("ogretmenlikBaslangicTarihi"),sonucYeni.getString("Brans"),sonucYeni.getInt("atanilanOkulId"),sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email"));
                
                
            }else if(role.equals("Ogrenci")){
                
               kullanici = new Ogrenci(sonucYeni.getInt("okulaBaslamaTarihi"),sonucYeni.getInt("kayitliOlunanOkulId"),sonucYeni.getInt("sinavPuani"),sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email"));
                
            }else if(role.equals("Mudur")){
                
                kullanici = new OkulMuduru(sonucYeni.getInt("mudurlukBaslangic"),sonucYeni.getInt("atamaPuani"),sonucYeni.getInt("ogretmenlikBaslangicTarihi"),sonucYeni.getString("Brans"),sonucYeni.getInt("atanilanOkulId"),sonuc.getInt("id"),sonuc.getInt("yas"),sonuc.getString("isim"),sonuc.getString("soyIsim"),sonuc.getString("kullaniciAdi"),sonuc.getString("kullaniciSifre"),sonuc.getString("role"),sonuc.getString("email"));
                
                
            }else{
            
                 kullanici = null; // role yanlış girilmişse null dönsün !!!
                
            }
       
        }
        
        
        
        return kullanici;
        
    }
    
    
    public boolean sifremiUnuttum(Kullanici kullanici) throws MessagingException{
        
      
        
        if(!kullanici.geteMail().equals("")){
            
            System.out.println("Mail işlemlerine devam edilecek!");
            

                mailIslemi.mailGonder(kullanici.geteMail());
                return true;
                
  
        }else{
            
            System.out.println("Bulunamadı!");
            return false;
        }
        
    }
    
}
