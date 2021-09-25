/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIKullanici;

import com.mysql.cj.util.StringUtils;
import java.awt.Color;
import java.util.List;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import kullanicilar.Kullanici;
import kullanicilar.Ogrenci;
import kullanicilar.Ogretmen;
import kullanicilar.OkulMuduru;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ocak
 */
public class UIKullanici {
    
    private JTextField jTextField_Isim;
    private JTextField jTextField_KullaniciAdi;
    private JTextField jTextField_SoyIsım; 
    private JTextField jTextField_KullaniciSifre;
    private JTextField jTextField_Email;
    
    private JButton jButton_Kayit_Olustur;
    private JButton jButton_Yenile;
    
    private JComboBox jComboBox_Rol;
    private JSpinner jSpinner_Yas;
    private JSpinner jSpinner_OgretmenAtamaPuani;
    
    private JComboBox jComboBox_OgretmenlikBaslangicYili;
    private JComboBox jComboBox_Brans;
    private JComboBox jComboBox_MudurlukBaslangicYili;
    
    private JComboBox jComboBox_OgrencilikBaslamaYili;
    private JPanel jPanel_DosyaOku;
    private JPanel jPanelOgrenci;
    private JPanel jPanelOgretmenBrans;
    
    private File secilenDosya;
    

    public UIKullanici(JTextField jTextField_Isim, JTextField jTextField_KullaniciAdi, JTextField jTextField_SoyIsım, JTextField jTextField_KullaniciSifre, JTextField jTextField_Email, JButton jButton_Kayit_Olustur, JButton jButton_Yenile, JComboBox jComboBox_Rol, JSpinner jSpinner_Yas, JSpinner jSpinner_OgretmenAtamaPuani, JComboBox jComboBox_OgretmenlikBaslangicYili, JComboBox jComboBox_Brans, JComboBox jComboBox_MudurlukBaslangicYili, JComboBox jComboBox_OgrencilikBaslamaYili, JPanel jPanel_DosyaOku, JPanel jPanelOgrenci, JPanel jPanelOgretmenBrans) {
        this.jTextField_Isim = jTextField_Isim;
        this.jTextField_KullaniciAdi = jTextField_KullaniciAdi;
        this.jTextField_SoyIsım = jTextField_SoyIsım;
        this.jTextField_KullaniciSifre = jTextField_KullaniciSifre;
        this.jTextField_Email = jTextField_Email;
        this.jButton_Kayit_Olustur = jButton_Kayit_Olustur;
        this.jButton_Yenile = jButton_Yenile;
        this.jComboBox_Rol = jComboBox_Rol;
        this.jSpinner_Yas = jSpinner_Yas;
        this.jSpinner_OgretmenAtamaPuani = jSpinner_OgretmenAtamaPuani;
        this.jComboBox_OgretmenlikBaslangicYili = jComboBox_OgretmenlikBaslangicYili;
        this.jComboBox_Brans = jComboBox_Brans;
        this.jComboBox_MudurlukBaslangicYili = jComboBox_MudurlukBaslangicYili;
        this.jComboBox_OgrencilikBaslamaYili = jComboBox_OgrencilikBaslamaYili;
        this.jPanel_DosyaOku = jPanel_DosyaOku;
        this.jPanelOgrenci = jPanelOgrenci;
        this.jPanelOgretmenBrans = jPanelOgretmenBrans;
    }

    public LinkedList<Ogrenci> exelOku() throws FileNotFoundException, IOException{
        
        LinkedList <Ogrenci> ogrenciler = new LinkedList<>();
        LinkedList <String> satirDegerleri = new LinkedList<>();
        
        Ogrenci ogrenci;
        
        Integer sutunSayisi = 7;
        
        FileInputStream dosya = new  FileInputStream(secilenDosya);
        XSSFWorkbook excel = new XSSFWorkbook(dosya);
        XSSFSheet sayfa = excel.getSheetAt(0);
        
        Iterator<Row> satirIterator = sayfa.iterator();
        
        while(satirIterator.hasNext()){
            
            Row satir = satirIterator.next();
            
            for(int i=0; i<sutunSayisi;i++){
                
                if(satir.getCell(i).getCellType() == CellType.NUMERIC){
                    
                    satirDegerleri.add(String.valueOf((int) satir.getCell(i).getNumericCellValue()));
                    
                    
                }else{
                    
                    satirDegerleri.add(satir.getCell(i).getStringCellValue());
                    
                }
                
            }
                ogrenci = new Ogrenci(
                                    Integer.valueOf(satirDegerleri.get(0))
                                    ,0
                                    ,-100
                                    ,0
                                    ,Integer.valueOf(satirDegerleri.get(1))
                                    ,satirDegerleri.get(2)
                                    ,satirDegerleri.get(3)
                                    ,satirDegerleri.get(4)
                                    ,satirDegerleri.get(5)
                                    ,"Ogrenci"
                                    ,satirDegerleri.get(6)
                                     ); 
                
                  satirDegerleri.clear();
                  ogrenciler.add(ogrenci);
                
                
            }
       
        excel.close();
        dosya.close();
        
        return ogrenciler;
    }
    
    public void dosyaOku(){
        
        jPanel_DosyaOku.setDropTarget(new DropTarget(){
            
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
               
                dtde.acceptDrop(DnDConstants.ACTION_COPY);
                
                try {
                    List<File> dropFiles = (List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    if(dropFiles.size() != 1){
                        
                        JOptionPane.showMessageDialog(null,"Seçilen dosya boş olamaz.");
                        
                    }else{
                        
                        for(File file : dropFiles){
                            
                            secilenDosya = file;
                            
                        }
                        
                          jPanel_DosyaOku.setBackground(Color.GREEN);
                          
                    }
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(UIKullanici.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(UIKullanici.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            
            
        });
     
    }
        
    public Kullanici kullaniciTanimla() throws Exception{
        
        Kullanici kullanici = null;
        
        bosComponentKontrol(jTextField_Isim,"İsim");
        bosComponentKontrol(jTextField_SoyIsım,"Soyisim");
        bosComponentKontrol(jTextField_KullaniciAdi,"Kullanıcı Adı");
        bosComponentKontrol(jTextField_KullaniciSifre,"Kullanıcı Şifre");
        bosComponentKontrol(jTextField_Email,"E-mail");
        
        bosComponentKontrol(jComboBox_Rol,"Rol");
       
        bosComponentKontrol(jSpinner_Yas,"Yaş",5,100);
        
        if(jComboBox_Rol.getSelectedItem().toString().equals("Ogretmen")){
            
            bosComponentKontrol(jComboBox_OgretmenlikBaslangicYili,"Öğretmenlik başlangıç yılı");
            bosComponentKontrol(jComboBox_Brans,"Öğretmen branş");
            bosComponentKontrol(jSpinner_OgretmenAtamaPuani,"Atama puanı",0,100);
            
            kullanici = yeniOgretmenOlustur();
            
        }else if(jComboBox_Rol.getSelectedItem().toString().equals("Mudur")){
            
            bosComponentKontrol(jComboBox_OgretmenlikBaslangicYili,"Öğretmenlik başlangıç yılı");
            bosComponentKontrol(jComboBox_Brans,"Öğretmen branş");
            bosComponentKontrol(jSpinner_OgretmenAtamaPuani,"Atama puanı",0,100);
            bosComponentKontrol(jComboBox_MudurlukBaslangicYili,"Müdürlük başlangıç yılı"); 
            
            kullanici = yeniMudurOlustur();
            
        }else if(jComboBox_Rol.getSelectedItem().toString().equals("Ogrenci")){
            
            
            bosComponentKontrol(jComboBox_OgrencilikBaslamaYili,"Öğrencilik başlama yılı");
            
            kullanici = yeniOgrenciOlustur();
            
        }
      
        
        
        
     return kullanici;   
    }
 
    
    protected Kullanici yeniMudurOlustur(){
        
       
        
       OkulMuduru okulMuduru = new OkulMuduru(Integer.valueOf(jComboBox_MudurlukBaslangicYili.getSelectedItem().toString())
               ,(Integer)jSpinner_OgretmenAtamaPuani.getValue()
               ,Integer.valueOf(jComboBox_OgretmenlikBaslangicYili.getSelectedItem().toString())
               ,jComboBox_Brans.getSelectedItem().toString()
               ,0
               ,0
               ,(Integer)jSpinner_Yas.getValue()
               ,jTextField_Isim.getText().toString()
               ,jTextField_SoyIsım.getText().toString()
               ,jTextField_KullaniciAdi.getText().toString()
               ,jTextField_KullaniciSifre.getText().toString()
               ,jComboBox_Rol.getSelectedItem().toString()
               ,jTextField_Email.getText().toString());
       
   
       return okulMuduru;
    }
    
    protected Kullanici yeniOgretmenOlustur(){
        
     
        
        Ogretmen ogretmen = new Ogretmen((Integer)jSpinner_OgretmenAtamaPuani.getValue()
                                         ,Integer.valueOf(jComboBox_OgretmenlikBaslangicYili.getSelectedItem().toString())
                                         ,jComboBox_Brans.getSelectedItem().toString()
                                         ,0
                                         ,0
                                        ,(Integer)jSpinner_Yas.getValue()
                                        ,jTextField_Isim.getText().toString()
                                        ,jTextField_SoyIsım.getText().toString()
                                        ,jTextField_KullaniciAdi.getText().toString()
                                        ,jTextField_KullaniciSifre.getText().toString()
                                        ,jComboBox_Rol.getSelectedItem().toString()
                                        ,jTextField_Email.getText().toString()
                                        );
        
        
       return ogretmen;
       
    }
    
    protected Kullanici yeniOgrenciOlustur(){

       Ogrenci ogrenci = new Ogrenci(Integer.valueOf(jComboBox_OgrencilikBaslamaYili.getSelectedItem().toString())
                                     ,0
                                     ,-100
                                     ,0
                                     ,(Integer)jSpinner_Yas.getValue()
                                     ,jTextField_Isim.getText().toString()
                                     ,jTextField_SoyIsım.getText().toString()
                                     ,jTextField_KullaniciAdi.getText().toString()
                                     ,jTextField_KullaniciSifre.getText().toString()
                                     ,jComboBox_Rol.getSelectedItem().toString()
                                     ,jTextField_Email.getText().toString()
               
                                     );
        
       return ogrenci;
       
    }
    
    protected void bosComponentKontrol(JTextField yaziAlani, String alanAdi)throws Exception{
        
        String deger = yaziAlani.getText().toString();
        deger = deger.replaceAll(" ", "");
        yaziAlani.setText(deger);
        
        if(StringUtils.isEmptyOrWhitespaceOnly(deger)){
            
            throw new Exception(alanAdi+" Alanı boş bırakılamaz.");
            
        }
        
        
    }
    
    
    protected void bosComponentKontrol(JComboBox combobox, String alanAdi)throws Exception{
        
        Integer secilenDeger = combobox.getSelectedIndex();
        boolean comboboxGorunurMu = combobox.isVisible();
        boolean comboboxEnabledMi = combobox.isEnabled();
        
        if(comboboxGorunurMu && comboboxEnabledMi ){
            
              if(secilenDeger == 0){
                  
                  throw new Exception(alanAdi+" kutusu boş bırakılamaz.");
                  
              }
            
        }
        
        
        
    }
            
    protected void bosComponentKontrol(JSpinner spinner , String alanAdi, Integer minDeger ,Integer maxDeger)throws Exception{
        
         boolean spinnerGorunurMu = spinner.isVisible();
         boolean spinnerEnabledMi = spinner.isEnabled();
         
         if(spinnerGorunurMu && spinnerEnabledMi ){
             
             Integer deger = (Integer) spinner.getValue();
             
             if(!(deger >= minDeger && deger <= maxDeger)){
                 
                 throw new Exception(alanAdi +"bu değere sahip olamaz.");
                 
             }
             
         }
         
        
        
        
    }
    
    
    
    public void kullaniciEkBilgilerBaslangic(){
        
        jPanelOgrenci.setVisible(false);
        jPanelOgretmenBrans.setVisible(true);
        
        jComboBox_Brans.setSelectedIndex(0);
        jComboBox_MudurlukBaslangicYili.setSelectedIndex(0);
        jComboBox_OgrencilikBaslamaYili.setSelectedIndex(0);
        jComboBox_OgretmenlikBaslangicYili.setSelectedIndex(0);
      
        jComboBox_Brans.setEnabled(false);
        jComboBox_MudurlukBaslangicYili.setEnabled(false);
        jComboBox_OgrencilikBaslamaYili.setEnabled(false);
        jComboBox_OgretmenlikBaslangicYili.setEnabled(false);
        
        jSpinner_OgretmenAtamaPuani.setValue(60);
        jSpinner_OgretmenAtamaPuani.setEnabled(false);
        jSpinner_Yas.setValue(5);
        
        
    }
    
    public void comboBoxRolSecimi(String role){
        
     if(role.equals(" ")){
         
         System.out.println("Rol seçilmedi!");
         
     }else if(role.equals("Ogretmen")){
         
        ogretmenSecimi();
        
     }else if(role.equals("Mudur")){
         
        mudurSecimi();
        
     }else if(role.equals("Ogrenci")){
         
        ogrenciSecimi();
        
     }
        
    }
    
    protected void ogretmenSecimi(){
        
       jPanelOgretmenBrans.setVisible(true);
       jPanelOgrenci.setVisible(false);
       
       jComboBox_OgretmenlikBaslangicYili.setEnabled(true);
       jComboBox_Brans.setEnabled(true);
       jSpinner_OgretmenAtamaPuani.setEnabled(true);
       jComboBox_MudurlukBaslangicYili.setEnabled(false);
       jComboBox_MudurlukBaslangicYili.setSelectedIndex(0);
       
       
    }
    
    protected void mudurSecimi(){
        
       jPanelOgretmenBrans.setVisible(true);
       jPanelOgrenci.setVisible(false);  
        
       jComboBox_OgretmenlikBaslangicYili.setEnabled(true);
       jComboBox_Brans.setEnabled(true);
       jSpinner_OgretmenAtamaPuani.setEnabled(true);
       jComboBox_MudurlukBaslangicYili.setEnabled(true);

       
    }
    
    protected void ogrenciSecimi(){
        
       jPanelOgretmenBrans.setVisible(false);
       jPanelOgrenci.setVisible(true);  
        
       jComboBox_OgrencilikBaslamaYili.setEnabled(true);
       
        jComboBox_Brans.setSelectedIndex(0);
        jComboBox_MudurlukBaslangicYili.setSelectedIndex(0);
        jComboBox_OgretmenlikBaslangicYili.setSelectedIndex(0);
      
        jComboBox_Brans.setEnabled(false);
        jComboBox_MudurlukBaslangicYili.setEnabled(false);
        jComboBox_OgretmenlikBaslangicYili.setEnabled(false);
        
        jSpinner_OgretmenAtamaPuani.setValue(60);
        jSpinner_OgretmenAtamaPuani.setEnabled(false);
      
        
       
    }
    
    public JTextField getjTextField_Isim() {
        return jTextField_Isim;
    }

    public JTextField getjTextField_KullaniciAdi() {
        return jTextField_KullaniciAdi;
    }

    public JTextField getjTextField_SoyIsım() {
        return jTextField_SoyIsım;
    }

    public JTextField getjTextField_KullaniciSifre() {
        return jTextField_KullaniciSifre;
    }

    public JTextField getjTextField_Email() {
        return jTextField_Email;
    }

    public JButton getjButton_Kayit_Olustur() {
        return jButton_Kayit_Olustur;
    }

    public JButton getjButton_Yenile() {
        return jButton_Yenile;
    }

    public JComboBox getjComboBox_Rol() {
        return jComboBox_Rol;
    }

    public JSpinner getjSpinner_Yas() {
        return jSpinner_Yas;
    }

    public JSpinner getjSpinner_OgretmenAtamaPuani() {
        return jSpinner_OgretmenAtamaPuani;
    }

    public JComboBox getjComboBox_OgretmenlikBaslangicYili() {
        return jComboBox_OgretmenlikBaslangicYili;
    }

    public JComboBox getjComboBox_Brans() {
        return jComboBox_Brans;
    }

    public JComboBox getjComboBox_MudurlukBaslangicYili() {
        return jComboBox_MudurlukBaslangicYili;
    }

    public JComboBox getjComboBox_OgrencilikBaslamaYili() {
        return jComboBox_OgrencilikBaslamaYili;
    }

    public JPanel getjPanel_DosyaOku() {
        return jPanel_DosyaOku;
    }

    public JPanel getjPanelOgrenci() {
        return jPanelOgrenci;
    }

    public JPanel getjPanelOgretmenBrans() {
        return jPanelOgretmenBrans;
    }

    public File getSecilenDosya() {
        return secilenDosya;
    }
    
    
    
    
}
