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
        }int m=0;
        while(m<vectorProdu.size()){
        i=0;
        while (i<vectorProdu.size()) { 
            int j=4;
            while (j<=vectorProdu.get(i).length()){  
                if (j==vectorProdu.get(i).length()) {
                    vectorAnu.add(Character.toString(vectorProdu.get(i).charAt(0)));
                    j++;
                    break;
                }
                if (Character.isUpperCase(vectorProdu.get(i).charAt(j))) { 
                    if (Character.toString(vectorProdu.get(i).charAt(0)).equals(Character.toString(vectorProdu.get(i).charAt(j)))) {
                        j++;
                        continue;
                    }
                    if(buscaVector(Character.toString(vectorProdu.get(i).charAt(j)), vectorAnu)){
                        j++;
                        continue;
                    }
                    break;
                }else{
                    break;
                }
             }
            if(j==vectorProdu.get(i).length()){
                vectorAnu.add(Character.toString(vectorProdu.get(i).charAt(0)));
            }
            i++;
        }
        m++;
        }
        
        
        //Vamos a eliminar NT repetidos
        Set<String> hs = new HashSet<>();
        hs.addAll(vectorAnu);
        vectorAnu.clear();
        vectorAnu.addAll(hs);

    }
    
    public void pAnulables(ArrayList<String> vectorProdu,ArrayList<String> vectorAnu,ArrayList<Integer> vectorPAnu){
        int i=0;
        while (i<vectorProdu.size()) { 
            int j=4;
            if("|".equals(Character.toString(vectorProdu.get(i).charAt(j)))){
                vectorPAnu.add(i);
                i++;
                continue;
            }
            while (j<=vectorProdu.get(i).length()){  
                if (j==vectorProdu.get(i).length()) {
                    vectorPAnu.add(i);
                    j++;
                    break;
                }
                if (Character.isUpperCase(vectorProdu.get(i).charAt(j))) { 
                    if(buscaVector(Character.toString(vectorProdu.get(i).charAt(j)), vectorAnu)){
                        j++;
                        continue;
                    }
                    break;
                }else{
                    break;
                }
            }
            i++;
        }
    }
    
    public void Pprimeros(ArrayList<String> vectorProdu,ArrayList<String> vectorAnu,ArrayList<String> vectorPPrime){
        int i=0;
        while (i<vectorProdu.size()) { 
            int j=4;
            if("|".equals(Character.toString(vectorProdu.get(i).charAt(j)))){
                i++;
                continue;
            }
            while (j<=vectorProdu.get(i).length()){  
                if (j==vectorProdu.get(i).length()) {
                    j++;
                    continue;
                }
                if (Character.isUpperCase(vectorProdu.get(i).charAt(j))) { 
                    if(Character.toString(vectorProdu.get(i).charAt(0)).equals(Character.toString(vectorProdu.get(i).charAt(j)))){
                        j++;
                        continue;
                    }
                    if(NTesAnulable(Character.toString(vectorProdu.get(i).charAt(j)), vectorAnu)){
                        
                        j++;
                        continue;
                    }
                    break;
                }else{
                    vectorPPrime.add(Character.toString(vectorProdu.get(i).charAt(j)));
                    break;
                }
            }
            i++;
        }
        
    }
    
    public boolean NTesAnulable(String s,ArrayList<String> vectorAnu){
        int i=0;
        while(i<vectorAnu.size()){
            if(s.equals(vectorAnu.get(i))){
                return true;
            }
            i++;                 
        }
        return false;
    }
    
    public boolean buscaVector(String s, ArrayList<String> vector){
        int k=0;
                while(k<vector.size()){
                    if(s.equals(vector.get(k))){
                        return true;
                    }
                    k++;
                }
        return false;
    }
}
