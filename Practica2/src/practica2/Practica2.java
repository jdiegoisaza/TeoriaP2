/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.ArrayList;

/**
 *
 * @author jdiego.isaza
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    String VectorNT [] =new String[10];
    public static void main(String[] args) {
        // TODO code application logic here
        int n=0;
        ArrayList<String> vectorNT = new ArrayList<>();
        ArrayList<String> vectorProdu = new ArrayList<>();
        String vector[]= new String[10];
        
        String s="1. A = aC\n" +
                 "2. A = bBc\n" +
                 "3. B = aA\n" +
                 "4. B = bB\n" +
                 "5. C = aCa\n" +
                 "6. C = bBcc\n" +
                 "7. C = |";
        reconocer reco = new reconocer();
        reco.obtenerNT(s,vectorNT,vectorProdu);
        mostar2(vectorNT);
        mostar2(vectorProdu);
        
    }

    
    public static void mostar(String[] v) {
        for (int i = 0; i < v.length; i++) {
            if (v[i]!= "")System.out.println(v[i]);
        }
    }
    public static void mostar2(ArrayList v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}
