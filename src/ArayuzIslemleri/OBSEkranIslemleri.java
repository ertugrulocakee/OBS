/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArayuzIslemleri;

import javax.swing.JToggleButton;
import kullanicilar.Kullanici;
import paneller.PanelAtama;
import paneller.PanelKullanici;
import paneller.PanelOkul;
import paneller.PanelSinav;
import paneller.PanelSinif;

/**
 *
 * @author ocak
 */
public class OBSEkranIslemleri {
    
    private PanelKullanici panelKullanici;
    private PanelAtama panelAtama;
    private PanelOkul panelOkul;
    private PanelSinav panelSinav;
    private PanelSinif panelSinif;
    private Kullanici kullanici;
    
    RenkVeIkonlar renkveiconlar = new RenkVeIkonlar();
    

    public OBSEkranIslemleri(PanelKullanici panelKullanici, PanelAtama panelAtama, PanelOkul panelOkul, PanelSinav panelSinav, PanelSinif panelSinif,Kullanici kullanici) {
       
        this.panelKullanici = panelKullanici;
        this.panelAtama = panelAtama;
        this.panelOkul = panelOkul;
        this.panelSinav = panelSinav;
        this.panelSinif = panelSinif;
        this.kullanici = kullanici;
        
        
    }
    
    public void initComponentsUI(){
    
       this.panelKullanici.getKullanici().kullaniciEkBilgilerBaslangic();
       this.panelKullanici.getKullanici().dosyaOku();
       
        
        if(this.kullanici.getRole().equals("Mudur")){
            
           mudurEkrani();
            
        }else if(this.kullanici.getRole().equals("Admin")){
            
           adminEkrani(); 
            
        }else if(this.kullanici.getRole().equals("Ogretmen")){
            
            ogretmenEkrani();
            
        }else if(this.kullanici.getRole().equals("Ogrenci")){
            
            ogrenciEkrani();
            
        }else{
            
            System.out.println("Kullanıcı rolü tanımlanamadı!");
            
        }
        
        
        
    }
    
    protected void mudurEkrani(){
        
         this.panelKullanici.getKullanici().getjComboBox_Rol().setModel(renkveiconlar.getModelMudur());
         
         this.panelKullanici.getjToogleButton().setSelected(true);
         this.panelSinav.getjToogleButton().setVisible(false);
         this.panelSinif.getjToogleButton().setVisible(false);
         this.panelAtama.getjToogleButton().setVisible(false);
         this.panelOkul.getjToogleButton().setVisible(false);
        
         
         
         
    }
    
    protected void adminEkrani(){
        
         this.panelKullanici.getKullanici().getjComboBox_Rol().setModel(renkveiconlar.getModelAdmin());
        
         this.panelKullanici.getjToogleButton().setSelected(true);
         this.panelSinav.getjToogleButton().setVisible(false);
         this.panelSinif.getjToogleButton().setVisible(false);
    
    }

    protected void ogretmenEkrani(){
        
         this.panelSinif.getjToogleButton().setSelected(true);
         this.panelKullanici.getjToogleButton().setVisible(false);
         this.panelSinav.getjToogleButton().setVisible(false);
         this.panelAtama.getjToogleButton().setVisible(false);
         this.panelOkul.getjToogleButton().setVisible(false);
        
        
        
    }
    
    protected void ogrenciEkrani(){
        
         this.panelSinav.getjToogleButton().setSelected(true);
         this.panelKullanici.getjToogleButton().setVisible(false);
         this.panelSinif.getjToogleButton().setVisible(false);
         this.panelAtama.getjToogleButton().setVisible(false);
         this.panelOkul.getjToogleButton().setVisible(false);
        
        
        
        
    }
    
    
    
    public void btnItemChanged(JToggleButton jToggleButton){
        
        if(jToggleButton == this.panelKullanici.getjToogleButton()){
            
         if(panelKullanici.getjToogleButton().isSelected() && ! panelKullanici.isBtnSeciliMi()){
             
             ekran_Kullanici();
             
         }
         
         if(panelKullanici.isBtnSeciliMi()){
             
             panelKullanici.getjToogleButton().setSelected(true);
         }
        
            
        }else if((jToggleButton == this.panelAtama.getjToogleButton())){
            
       if(panelAtama.getjToogleButton().isSelected() && ! panelAtama.isBtnSeciliMi()){
             
             ekran_Atama();
             
         }
         
         if(panelAtama.isBtnSeciliMi()){
             
             panelAtama.getjToogleButton().setSelected(true);
         }
        
           
            
            
        }else if((jToggleButton == this.panelOkul.getjToogleButton())){
            
     if(panelOkul.getjToogleButton().isSelected() && ! panelOkul.isBtnSeciliMi()){
             
             ekran_Okul();
             
         }
         
         if(panelOkul.isBtnSeciliMi()){
             
             panelOkul.getjToogleButton().setSelected(true);
         }
        
        
              
            
            
        }else if((jToggleButton == this.panelSinif.getjToogleButton())){
            
            if(panelSinif.getjToogleButton().isSelected() && ! panelSinif.isBtnSeciliMi()){
             
             ekran_Sinif();
             
         }
         
         if(panelSinif.isBtnSeciliMi()){
             
             panelSinif.getjToogleButton().setSelected(true);
         }
            
       
               
            
            
            
        }else if((jToggleButton == this.panelSinav.getjToogleButton())){
            
      if(panelSinav.getjToogleButton().isSelected() && ! panelSinav.isBtnSeciliMi()){
             
             ekran_Sinav();
             
         }
         
         if(panelSinav.isBtnSeciliMi()){
             
             panelSinav.getjToogleButton().setSelected(true);
         }
        
        
           
            
            
        }
        
        
        
    }
    
    protected void ekran_Kullanici(){
        
        panelKullanici.setBtnSeciliMi(true);
        panelAtama.setBtnSeciliMi(false);
        panelOkul.setBtnSeciliMi(false);
        panelSinif.setBtnSeciliMi(false);
        panelSinav.setBtnSeciliMi(false);
        
        panelKullanici.getjToogleButton().setSelected(true);
        panelAtama.getjToogleButton().setSelected(false);
        panelOkul.getjToogleButton().setSelected(false);
        panelSinif.getjToogleButton().setSelected(false);
        panelSinav.getjToogleButton().setSelected(false);
        
        
        panelKullanici.getJpanel().setVisible(true);
        panelAtama.getJpanel().setVisible(false);
        panelOkul.getJpanel().setVisible(false);
        panelSinif.getJpanel().setVisible(false);
        panelSinav.getJpanel().setVisible(false);
        
        
        
    }
    
    protected void ekran_Atama(){
        
        panelKullanici.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(true);
        panelOkul.setBtnSeciliMi(false);
        panelSinif.setBtnSeciliMi(false);
        panelSinav.setBtnSeciliMi(false);
        
        panelKullanici.getjToogleButton().setSelected(false);
        panelAtama.getjToogleButton().setSelected(true);
        panelOkul.getjToogleButton().setSelected(false);
        panelSinif.getjToogleButton().setSelected(false);
        panelSinav.getjToogleButton().setSelected(false);
        
        
        panelKullanici.getJpanel().setVisible(false);
        panelAtama.getJpanel().setVisible(true);
        panelOkul.getJpanel().setVisible(false);
        panelSinif.getJpanel().setVisible(false);
        panelSinav.getJpanel().setVisible(false);
        
        
        
    }
    
     protected void ekran_Okul(){
        
        panelKullanici.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(false);
        panelOkul.setBtnSeciliMi(true);
        panelSinif.setBtnSeciliMi(false);
        panelSinav.setBtnSeciliMi(false);
        
        panelKullanici.getjToogleButton().setSelected(false);
        panelAtama.getjToogleButton().setSelected(false);
        panelOkul.getjToogleButton().setSelected(true);
        panelSinif.getjToogleButton().setSelected(false);
        panelSinav.getjToogleButton().setSelected(false);
        
        
        panelKullanici.getJpanel().setVisible(false);
        panelAtama.getJpanel().setVisible(false);
        panelOkul.getJpanel().setVisible(true);
        panelSinif.getJpanel().setVisible(false);
        panelSinav.getJpanel().setVisible(false);
        
        
        
    }
    
     protected void ekran_Sinif(){
        
        panelKullanici.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(false);
        panelOkul.setBtnSeciliMi(false);
        panelSinif.setBtnSeciliMi(true);
        panelSinav.setBtnSeciliMi(false);
        
        panelKullanici.getjToogleButton().setSelected(false);
        panelAtama.getjToogleButton().setSelected(false);
        panelOkul.getjToogleButton().setSelected(false);
        panelSinif.getjToogleButton().setSelected(true);
        panelSinav.getjToogleButton().setSelected(false);
        
        
        panelKullanici.getJpanel().setVisible(false);
        panelAtama.getJpanel().setVisible(false);
        panelOkul.getJpanel().setVisible(false);
        panelSinif.getJpanel().setVisible(true);
        panelSinav.getJpanel().setVisible(false);
        
        
        
    }
     
     protected void ekran_Sinav(){
        
        panelKullanici.setBtnSeciliMi(false);
        panelAtama.setBtnSeciliMi(false);
        panelOkul.setBtnSeciliMi(false);
        panelSinif.setBtnSeciliMi(false);
        panelSinav.setBtnSeciliMi(true);
        
        panelKullanici.getjToogleButton().setSelected(false);
        panelAtama.getjToogleButton().setSelected(false);
        panelOkul.getjToogleButton().setSelected(false);
        panelSinif.getjToogleButton().setSelected(false);
        panelSinav.getjToogleButton().setSelected(true);
        
        
        panelKullanici.getJpanel().setVisible(false);
        panelAtama.getJpanel().setVisible(false);
        panelOkul.getJpanel().setVisible(false);
        panelSinif.getJpanel().setVisible(false);
        panelSinav.getJpanel().setVisible(true);
        
        
        
    }

    public PanelKullanici getPanelKullanici() {
        return panelKullanici;
    }

    public PanelAtama getPanelAtama() {
        return panelAtama;
    }

    public PanelSinav getPanelSinav() {
        return panelSinav;
    }

    public PanelSinif getPanelSinif() {
        return panelSinif;
    }

    public PanelOkul getPanelOkul() {
        return panelOkul;
    }
     
     
     
    
}
