/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class reconocer {
    
    
    
      public void obtenerNT (String s, ArrayList<String> vector, ArrayList<String> vectorPodu){
            
        StringTokenizer st = new StringTokenizer(s,"\n");
        int i=0;
        while (st.hasMoreTokens()) {
            String p = st.nextToken();
            String c =Character.toString(p.charAt(3));
                        vector.add(c);
                        vectorPodu.add(p);
            i++;
        }        
        //Vamos a eliminar NT repetidos
        Set<String> hs = new HashSet<>();
        hs.addAll(vector);
        vector.clear();
        vector.addAll(hs);

    }
      
      public void anulables (){
          
      }
}
