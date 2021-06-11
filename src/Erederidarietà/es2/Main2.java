package Erederidarietà.es2;

import Erederidarietà.es2.Autocarro;
import Erederidarietà.es2.Automobile;
import Erederidarietà.es2.Veicolo;

public class Main2 {
    public static void main(String[] args) {
        Veicolo autoMobile = new Automobile("blabla", "iao","justeat",5,4);
        System.out.println(autoMobile);
        Veicolo autoCarro = new Autocarro("pas2348", "giovannidocet","raf",6,15);
        System.out.println(autoCarro);
    }
}


