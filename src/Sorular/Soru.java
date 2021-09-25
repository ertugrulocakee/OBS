/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorular;

/**
 *
 * @author ocak
 */
public class Soru {
    
    private String soru;
    private String cevapA;
    private String cevapB;
    private String cevapC;
    private String cevapD;
    private String dogruCevap;

    public Soru(String soru, String cevapA, String cevapB, String cevapC, String cevapD, String dogruCevap) {
        this.soru = soru;
        this.cevapA = cevapA;
        this.cevapB = cevapB;
        this.cevapC = cevapC;
        this.cevapD = cevapD;
        this.dogruCevap = dogruCevap;
    }

    public String getSoru() {
        return soru;
    }

    public String getCevapA() {
        return cevapA;
    }

    public String getCevapB() {
        return cevapB;
    }

    public String getCevapC() {
        return cevapC;
    }

    public String getCevapD() {
        return cevapD;
    }

    public String getDogruCevap() {
        return dogruCevap;
    }
 
}
