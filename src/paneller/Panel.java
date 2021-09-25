/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneller;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author ocak
 */
public class Panel {
    
    private boolean btnSeciliMi = false;
    private JToggleButton  jToogleButton; 
    private JPanel jpanel;

    
    public Panel(JToggleButton jToogleButton, JPanel jpanel) {
        this.jToogleButton = jToogleButton;
        this.jpanel = jpanel;
    }
    

    public boolean isBtnSeciliMi() {
        return btnSeciliMi;
    }

    public void setBtnSeciliMi(boolean btnSeciliMi) {
        this.btnSeciliMi = btnSeciliMi;
    }

    
    public JToggleButton getjToogleButton() {
        return jToogleButton;
    }

    public JPanel getJpanel() {
        return jpanel;
    }
   
    
    
    
    
}
