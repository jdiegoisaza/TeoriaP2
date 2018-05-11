/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.StringTokenizer;

/**
 *
 * @author jdiego.isaza
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n=0;
        
        String s="1. A = aC\n" +
                 "2. A = bBc\n" +
                 "3. B = aA\n" +
                 "4. B = bB\n" +
                 "5. C = aCa\n" +
                 "6. C = bBcc\n" +
                 "7. C = |";
        
        StringTokenizer st = new StringTokenizer(s, "\n");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken().charAt(3));
            
        }
        
    }
    public void reconocedor (String s){
            
        StringTokenizer st = new StringTokenizer("this is a test");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
    
}
