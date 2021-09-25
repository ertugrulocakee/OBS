/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atamalar;

import Okullar.Okul;
import Tablolar.Tablo;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author ocak
 */
public class Atama {
    
    private Tablo tablo_1;
    private Tablo tablo_2;          
    private JList jlist;
    
    private DefaultListModel listeModel = new DefaultListModel();

    public Atama(Tablo tablo_1, Tablo tablo_2, JList jlist) {
        this.tablo_1 = tablo_1;
        this.tablo_2 = tablo_2;
        this.jlist = jlist;
        this.jlist.setModel(listeModel);
    }
    
    public void listeDoldur(LinkedList<Okul> tumOkullar){
        
       this.listeModel.clear();
       Integer toplamOkulSayisi = tumOkullar.size();
       
       for(int i=0; i< toplamOkulSayisi;i++){
           
          this.listeModel.addElement(tumOkullar.get(i).getOkulAdi());
           
       }
        
    }

    public Tablo getTablo_1() {
        return tablo_1;
    }

    public Tablo getTablo_2() {
        return tablo_2;
    }

    public JList getJlist() {
        return jlist;
    }

    public DefaultListModel getListeModel() {
        return listeModel;
    }
            
    
    
    
    
    
}
