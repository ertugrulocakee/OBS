/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneller;

import UIKullanici.UIOkul;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author ocak
 */
public class PanelOkul extends Panel{
    
    UIOkul uiOkul = new UIOkul();

    public PanelOkul(JToggleButton jToogleButton, JPanel jpanel) {
        super(jToogleButton, jpanel);
    }

    public UIOkul getUiOkul() {
        return uiOkul;
    }
    
    
    
}
