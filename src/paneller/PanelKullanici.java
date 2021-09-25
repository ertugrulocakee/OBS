/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneller;

import UIKullanici.UIKullanici;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author ocak
 */
public class PanelKullanici extends Panel{
    
    
    private UIKullanici kullanici;

    public PanelKullanici(UIKullanici kullanici, JToggleButton jToogleButton, JPanel jpanel) {
        super(jToogleButton, jpanel);
        
        this.kullanici = kullanici;
    }

    public UIKullanici getKullanici() {
        return kullanici;
    }

 
    
}
