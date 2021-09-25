/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneller;

import UIKullanici.UISinav;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author ocak
 */
public class PanelSinav extends Panel {
    
    private UISinav uiSinav = new UISinav();
    
    
    public PanelSinav(JToggleButton jToogleButton, JPanel jpanel) {
        super(jToogleButton, jpanel);
    }

    public UISinav getUiSinav() {
        return uiSinav;
    }
    

    
}
