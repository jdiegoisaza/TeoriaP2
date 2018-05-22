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
      
    public void anulables (ArrayList<String> vectorNT,ArrayList<String> vectorProdu,ArrayList<String> vectorAnu){
        int i =0;
        while (i<vectorNT.size()) {            
            if(esAnulable(vectorNT.get(i),vectorProdu)){
                vectorAnu.add(vectorNT.get(i));
            }            
            i++;
        }
    }
    
    public boolean esAnulable(String s,ArrayList<String> vectorProdu){
        boolean bool = false;
        int i=0;
        while (i<vectorProdu.size()) {            
            if (s.equals(Character.toString(vectorProdu.get(i).charAt(3)))) {
                if("|".equals(Character.toString(vectorProdu.get(i).charAt(7)))){
                    return true;
                }
                int j=7;
                while (j<vectorProdu.get(i).length()) {                    
                    if (Character.isUpperCase(vectorProdu.get(i).charAt(j))) {
                        esAnulable(Character.toString(vectorProdu.get(i).charAt(j)), vectorProdu);
                    }else{
                        break;
                    }
                    j++;
                    
                }
                
                
            }
            i++;
        }
        
        return bool;
    }
}
