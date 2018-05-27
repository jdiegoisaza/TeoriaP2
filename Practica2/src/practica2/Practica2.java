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
        ArrayList<String> vectorAnu = new ArrayList<>();
        ArrayList<Integer> vectorPAnu = new ArrayList<>();
        ArrayList<String> vectorNTPrime = new ArrayList<>();
        String vector[]= new String[10];
        
        String s="A = BC\n" +
                 "A = bBc\n" +
                 "B = aA\n" +
                 "B = B\n" +
                 "C = aCa\n" +
                 "C = bBcc\n" +
                 "D = bBcc\n" +
                 "C = |";
        reconocer reco = new reconocer();
        reco.obtenerNT(s,vectorNT,vectorProdu);
        reco.anulables2 (vectorNT,vectorProdu,vectorAnu);
        reco.pAnulables(vectorProdu, vectorAnu, vectorPAnu);
        reco.NTprimeros(vectorProdu, vectorAnu, vectorNT, vectorNTPrime);
        mostar2(vectorNT);
        mostar2(vectorProdu);
        mostar2(vectorAnu);
        mostar2(vectorPAnu);        
        mostar2(vectorNTPrime);

    }

    
    public static void mostar(String[] v) {
        for (int i = 0; i < v.length; i++) {
            if (v[i]!= "")System.out.println(v[i]);
        }
    }
    public static String eliminarRepetidos(String v) {
        v = v.replaceAll("(.)\\1", "$1");
        return v;
    }
    public static void mostar2(ArrayList v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }
    }
}
