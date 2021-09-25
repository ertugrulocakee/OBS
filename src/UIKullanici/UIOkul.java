/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIKullanici;

import Okullar.Okul;
import java.util.LinkedList;

/**
 *
 * @author ocak
 */
public class UIOkul {
    
    private Okul okul1 = new Okul(1,"Çağlayan İ.Ö.Ö","İstanbul",1000,25,50);
    private Okul okul2 = new Okul(2,"Gürsel O.Ö.Ö","İstanbul",899,21,45);
    private Okul okul3 = new Okul(3,"Cevdet İ.Ö.Ö","İstabul",987,23,72);
    private Okul okul4 = new Okul(4,"Ziya Paşa İ.Ö.Ö","İstanbul",876,21,65);
    private Okul okul5 = new Okul(5,"Dilnihat Özyeğin ADL","İstabul",1200,30,90);

    public UIOkul() {
        
    }
    
    
    public Okul okulBul(Integer okulId){
        
        if(okulId == 1){
            
            return this.okul1;
                    
        }else if(okulId == 2){
            
            return this.okul2;
            
        }else if(okulId == 3){
            
            return this.okul3;
            
        }else if(okulId == 4){
            
            return this.okul4;
            
        }else if(okulId == 5){
            
            return this.okul5;
            
        }else{
            
            return null;
            
        }
 
    }
    
    
    public LinkedList<Okul> tumOkullariBul(){
        
      LinkedList<Okul> tumOkullar = new LinkedList<>();  
        
      
      tumOkullar.add(okul1);
      tumOkullar.add(okul2);
      tumOkullar.add(okul3);
      tumOkullar.add(okul4);
      tumOkullar.add(okul5);
      
      return tumOkullar;
    }
    
    
    public Okul okulBul(String okulAdi){
        
       Okul okul = null; 
        
       if(okulAdi.equals(okul1.getOkulAdi())){
           
          okul = okul1;

       }else if(okulAdi.equals(okul2.getOkulAdi())){
           
           okul = okul2;
       }else if(okulAdi.equals(okul3.getOkulAdi())){
           
           okul = okul3;
           
       }else if(okulAdi.equals(okul4.getOkulAdi())){
           
           okul = okul4;
           
       }else if(okulAdi.equals(okul5.getOkulAdi())){
           
           okul = okul5;
           
       }else{
           
           okul = null;
       }
 
       return okul;    
    }

    public Okul getOkul1() {
        return okul1;
    }

    public Okul getOkul2() {
        return okul2;
    }

    public Okul getOkul3() {
        return okul3;
    }

    public Okul getOkul4() {
        return okul4;
    }

    public Okul getOkul5() {
        return okul5;
    }
    
  
    
    
}
