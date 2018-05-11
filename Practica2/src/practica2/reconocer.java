/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.StringTokenizer;


public class reconocer {
    
    
    
      public void obtenerNT (String s, String[] vector){
            
        StringTokenizer st = new StringTokenizer(s,"\n");
        int i=0;
        while (st.hasMoreTokens()) {
            if (true) {
                vector[i]= (Character.toString(st.nextToken().charAt(3))) ;
            }

            i++;
        }
    }
}
