/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArayuzIslemleri;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ocak
 */
public class RenkVeIkonlar {
    
    // Icons
    
    private Icon cancel= new ImageIcon(this.getClass().getResource("/images/cancel.png"));
    private Icon cancel2= new ImageIcon(this.getClass().getResource("/images/cancelBlack.png"));
    private Icon minimize = new ImageIcon(this.getClass().getResource("/images/minimize.png"));
    private Icon minimize2 = new ImageIcon(this.getClass().getResource("/images/minimizeBlack.png"));
    private Icon user = new ImageIcon(this.getClass().getResource("/images/user.png"));
    private Icon user2 = new ImageIcon(this.getClass().getResource("/images/warning.png"));
    private Icon schoolColor = new ImageIcon(this.getClass().getResource("/images/schoolcolor.png"));
    private Icon schoolBlack = new ImageIcon(this.getClass().getResource("/images/schoolblack.png"));
    private Icon success = new ImageIcon(this.getClass().getResource("/images/success.png"));
    
    
    // Renkler
     private Color mavi = new Color(51,255,255);
     private Color mor = new Color(75,0,130);
     
     private Font fontArialBold_16 = new Font("Arial",Font.BOLD,16);
     
     // Modeller
     
     String[] roleMudur = new String[]{" ","Ogrenci"};
     String[] roleAdmin = new String[]{" ","Ogretmen","Mudur"};
     
     private DefaultComboBoxModel  modelMudur = new DefaultComboBoxModel(roleMudur);
     private DefaultComboBoxModel  modelAdmin = new DefaultComboBoxModel(roleAdmin);

    public Icon getSchoolColor() {
        return schoolColor;
    }

    public Icon getSchoolBlack() {
        return schoolBlack;
    }

    public Icon getSuccess() {
        return success;
    }


    public DefaultComboBoxModel getModelMudur() {
        return modelMudur;
    }

    public DefaultComboBoxModel getModelAdmin() {
        return modelAdmin;
    }

    public Color getMor() {
        return mor;
    }

    public Font getFontArialBold_16() {
        return fontArialBold_16;
    }
     
     
             
             
     
     

    public Icon getCancel() {
        return cancel;
    }

    public Icon getCancel2() {
        return cancel2;
    }

    public Icon getMinimize() {
        return minimize;
    }

    public Icon getMinimize2() {
        return minimize2;
    }

    public Color getMavi() {
        return mavi;
    }

    public Icon getUser() {
        return user;
    }

    public Icon getUser2() {
        return user2;
    }
    
   
    
    
}
