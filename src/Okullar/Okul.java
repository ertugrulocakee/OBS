/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Okullar;

/**
 *
 * @author ocak
 */
public class Okul {
    
   private Integer id; 
   private String okulAdi; 
   private String sehir; 
   private Integer ogrenciSayisi; 
   private Integer ogretmenSayisi;
   private Integer sinifSayisi;
   private Integer sinifOgrenciSayisi;

    public Okul(Integer id, String okulAdi, String sehir, Integer ogrenciSayisi, Integer ogretmenSayisi, Integer sinifSayisi) {
        this.id = id;
        this.okulAdi = okulAdi;
        this.sehir = sehir;
        this.ogrenciSayisi = ogrenciSayisi;
        this.ogretmenSayisi = ogretmenSayisi;
        this.sinifSayisi = sinifSayisi;
        
        this.sinifOgrenciSayisi = this.ogrenciSayisi / this.sinifSayisi;
    }

    public Integer getId() {
        return id;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public String getSehir() {
        return sehir;
    }

    public Integer getOgrenciSayisi() {
        return ogrenciSayisi;
    }

    public Integer getOgretmenSayisi() {
        return ogretmenSayisi;
    }

    public Integer getSinifSayisi() {
        return sinifSayisi;
    }

    public Integer getSinifOgrenciSayisi() {
        return sinifOgrenciSayisi;
    }
   
   
    
    
    
}
