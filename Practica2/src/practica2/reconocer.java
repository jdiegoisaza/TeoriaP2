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
            //Creamos un arreglo con todas las producciones
        StringTokenizer st = new StringTokenizer(s,"\n");
        int i=0;
        while (st.hasMoreTokens()) {
            String p = st.nextToken();
            String c =Character.toString(p.charAt(0));
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
        int k=0;
        while (k<vectorProdu.size()) {            
            if (s.equals(Character.toString(vectorProdu.get(k).charAt(0)))) {
                if("|".equals(Character.toString(vectorProdu.get(k).charAt(4)))){
                    return true;
                }
                int j=4;
                while (j<vectorProdu.get(k).length()) {                    
                    if (Character.isUpperCase(vectorProdu.get(k).charAt(j))) {
                        if(esAnulable(Character.toString(vectorProdu.get(k).charAt(j)), vectorProdu)){
                            continue;
                        }
                    }
                    j++;
                    return false;
                }
                return true;
                
                
            }
            k++;
        }
        
        return bool;
    }
    
    public void anulables2 (ArrayList<String> vectorNT,ArrayList<String> vectorProdu,ArrayList<String> vectorAnu){
        int i =0;
        while (i<vectorProdu.size()) {            
            if("|".equals(Character.toString(vectorProdu.get(i).charAt(4)))){
                vectorAnu.add(Character.toString(vectorProdu.get(i).charAt(0)));
            }            
            i++;
        }
        i=0;
        int j=4;
        while (i<vectorProdu.size()) { 
            while (j<vectorProdu.get(i).length()){            
            if (Character.isUpperCase(vectorProdu.get(i).charAt(j))) { 
                int k=0;
                //while(k<vectorAnu.size()){
                    
                //}
            }else{
                break;
            }
            j++;
            }
            if(j==vectorProdu.get(i).length()){
                vectorAnu.add(Character.toString(vectorProdu.get(i).charAt(0)));
            }
            i++;
        }        
        
        
        //Vamos a eliminar NT repetidos
        Set<String> hs = new HashSet<>();
        hs.addAll(vectorAnu);
        vectorAnu.clear();
        vectorAnu.addAll(hs);

    }
}
