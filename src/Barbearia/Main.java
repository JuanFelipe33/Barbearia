/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbearia;

/**
 *
 * @author Juan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Barbearia b1 = new Barbearia(5, 2, "Juan");
        Thread t1 = new Thread(b1);
        Barbearia b2 = new Barbearia(5, 2, "Guy");
        Thread t2 = new Thread(b2);
        t1.start();
        t2.start();
    }
    
}
