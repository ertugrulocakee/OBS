/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIKullanici;

import Sorular.Soru;

/**
 *
 * @author ocak
 */
public class UISinav {
    
    private Soru soruBir = new Soru("Türkiye Cumhuriyeti kaç yılında kuruldu ?","1906","1913","1903","1923","D");
    private Soru soruIki = new Soru("Hangi il Osmanlı İmparatorluğuna başkentlik yapmıştır ?","Konya","İstanbul","Şam","Trabzon","B");
    private Soru soruUc = new Soru("Ölçü birimlerinden hangisi bir uzunluk birimidir ?","mm","lt","ml","kg","A");
    private Soru soruDort = new Soru("20005 sayısının binler bölüğü hangi rakamlardan oluşmaktadır ?","3-1","0-5","2-0","2-5","C");
    private Soru soruBes = new Soru("Kalp kaç odacıktan oluşmaktadır ?","1","4","5","2","B");
    private Soru soruAlti = new Soru("Türkiye Cumhuriyeti başkenti hangi ilimizdir ?","İstanbul","Konya","Ankara","Bursa","C");
    private Soru soruYedi = new Soru("Bir kelimeden yeni bir kelime türeten eke ne ad verilmektedir ?","Çekim eki","Yapım eki","İyelik eki","Kip eki","B");
    private Soru soruSekiz = new Soru("İstanbul kaç yılında fethedilmiştir ?","1203","1506","1453","1753","C");
    private Soru soruDokuz = new Soru("Kalem kelimesinin ingilizce karşılığı nedir ?","Ruber","Pencil","Bag","Car","B");
    private Soru soruOn = new Soru("Türkiye kaç ile sahiptir ?","82","79","73","81","D");

    public UISinav() {
        
        
        
    }
     
     
    public Soru soruGetir(Integer soruId){
        
        if(soruId < 1){
            
            soruId = 1;
            
        }else if(soruId > 10){
            
            soruId = 10;
            
        }
  
            
        switch (soruId) {
            case 1:
                return soruBir;
            case 2:
                return soruIki;
            case 3:
                return soruUc;
            case 4:
                return soruDort;
            case 5:
                return soruBes;
            case 6:
                return soruAlti;
            case 7:
                return soruYedi;
            case 8:
                return soruSekiz;
            case 9:
                return soruDokuz;
            default:
                return soruOn;
        }
        
        
 
        
    }
    
    
     
}
