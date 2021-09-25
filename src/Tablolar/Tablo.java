/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablolar;

import ArayuzIslemleri.RenkVeIkonlar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import kullanicilar.Ogretmen;
import kullanicilar.OkulMuduru;

/**
 *
 * @author ocak
 */
public class Tablo {
    
    private JTable jTable;
    private DefaultTableModel tabloModel;
    private DefaultTableCellRenderer tabloSutun;
    
    RenkVeIkonlar  renkveIkonlar = new RenkVeIkonlar();

    public Tablo(JTable jTable) {
        this.jTable = jTable;
        this.tabloModel = (DefaultTableModel) this.jTable.getModel();
        this.tabloSutun = new DefaultTableCellRenderer();
        
        tabloDuzenle();
        
    }
    
    protected void tabloDuzenle(){
        
        int tabloSutunSayisi = this.jTable.getColumnCount();
        
        this.jTable.getTableHeader().setFont(renkveIkonlar.getFontArialBold_16());
        
        this.jTable.getTableHeader().setForeground(renkveIkonlar.getMor());
        
        for(int i=0; i<tabloSutunSayisi;i++){
            
            
            this.jTable.getColumnModel().getColumn(i).setCellRenderer(this.tabloSutun);
            
            
        }
        
        
        
    }
    
    public void tabloDoldur(OkulMuduru okulMuduru){
        
        tabloModel.insertRow(tabloModel.getRowCount(), new Object[]{
            
          okulMuduru.getId(),
          okulMuduru.getIsim(),
          okulMuduru.getSoyIsim(),
          okulMuduru.getYas(),
          okulMuduru.getAtamaPuani()

        });
        
        
    }

     public void tabloDoldur(Ogretmen ogretmen){
        
        tabloModel.insertRow(tabloModel.getRowCount(), new Object[]{
            
          ogretmen.getId(),
          ogretmen.getIsim(),
          ogretmen.getSoyIsim(),
          ogretmen.getBrans(),
          ogretmen.getAtanilanOkulId(),

        });
        
        
    }
    
    public DefaultTableModel getTabloModel() {
        return tabloModel;
    }
    
    
}
