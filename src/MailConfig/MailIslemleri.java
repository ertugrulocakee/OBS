/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailConfig;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ocak
 */
public class MailIslemleri {
    
    private String mailAdresim = "ertugrulocakee@gmail.com";
    private String mailSifrem = "Karakartal96-";
    private String sifreKurtarmaKodu = "";
    private String mailIcerigi_1 = "Merhaba,\n\nŞifrenizi öğrenmek için aşağıdaki kodu kullanınız;\n\n";
    private String mailIcerigi_2 = "\n\nİyi Günler";
    private String mailBasligi = "OBSUI Şifre Kurtarma Kodu";
    
    
    Properties properties;
    Session session;
    Message message;

    public MailIslemleri() {
        
        propertiesDegerleriniOlustur();
        sessionDegerleriOlustur();
        
    }
    
    protected void propertiesDegerleriniOlustur(){
        
        properties = System.getProperties();
        
     
        this.properties.put("mail.smtp.auth","true");
        this.properties.put("mail.smtp.starttls.enable","true");
        this.properties.put("mail.smtp.host","smtp.gmail.com");
        this.properties.put("mail.smtp.port","587");
    
       

    }
    
    protected void sessionDegerleriOlustur(){
        
        session = Session.getInstance(properties,new Authenticator(){
            
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                
                
                return new PasswordAuthentication(mailAdresim,mailSifrem);
                
            }
           

        });
             
    }
    
    
    
    public void mailGonder(String mailAtilacakAdres) throws AddressException, MessagingException{
        
        this.sifreKurtarmaKodu = kurtarmaSifresiUret(); 
        
        message = new MimeMessage(session);
        
        message.setFrom(new InternetAddress(mailAdresim));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailAtilacakAdres));
        message.setText(mailIcerigi_1+this.sifreKurtarmaKodu+mailIcerigi_2);
        
        message.setSubject(mailBasligi);


        
        
        Transport.send(message);
        
 
    }
    
    
     public String kurtarmaSifresiUret(){
         
        int sifreUzunlugu = 10;
     
     String buyukHarfler = "ABCDEFGHIJKLMONPRSTWQYZ";
     String kucukHarfler = buyukHarfler.toLowerCase();
     String rakamlar = "1234567890";
     String karisik = buyukHarfler+kucukHarfler+rakamlar;
     
     StringBuilder sifreOlusturucu = new StringBuilder(); // StringBuilder string oluşturuyor...
     Random rand = new Random(); // Random sınıfı ise rastgeleliği sağlıyor...
     
     for(int i=0; i< sifreUzunlugu ; i++){
         
         sifreOlusturucu.append(karisik.charAt(rand.nextInt(karisik.length())));
         
         
     }
         
     return sifreOlusturucu.toString();
        
    }

    public String getSifreKurtarmaKodu() {
        return sifreKurtarmaKodu;
    }
    
    

}
