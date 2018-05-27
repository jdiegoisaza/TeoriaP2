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
    
    public void NTprimeros(ArrayList<String> vectorProdu,ArrayList<String> vectorAnu,ArrayList<String> vectorNT,ArrayList<String> vectorNTPrime){
        int i=0,j=0;
        while(i<vectorNT.size()){
            vectorNTPrime.add(vectorNT.get(i));
            concatenaArray(i, vectorNTPrime, primerosNT(vectorNT.get(i),vectorProdu, vectorAnu));
            i++;
        }
        //Borro T repetidos
        while(j<vectorNTPrime.size()){
            replaceArray(j, vectorNTPrime, vectorNTPrime.get(j).replaceAll("(.)\\1", "$1"));
            j++;
        }
        
    }
    
    public void Pprimeros(ArrayList<String> vectorProdu,ArrayList<String> vectorAnu,ArrayList<String> vectorPPrime,ArrayList<String> vectorNTPrime){
        int i=0;
        while (i<vectorProdu.size()) { 
            int j=4;
            if("|".equals(Character.toString(vectorProdu.get(i).charAt(j)))){
                vectorPPrime.add("");
                i++;
                continue;
            }
            String s="";
            while (j<=vectorProdu.get(i).length()){  
                if (j==vectorProdu.get(i).length()) {
                    vectorPPrime.add(s);
                    j++;
                    continue;
                }
                if (Character.isUpperCase(vectorProdu.get(i).charAt(j))) { 
                    s=buscaEnPrimeros(Character.toString(vectorProdu.get(i).charAt(j)), vectorNTPrime);
                    if(NTesAnulable(Character.toString(vectorProdu.get(i).charAt(j)), vectorAnu)){
                        
                        j++;
                        continue;
                    }
                    vectorPPrime.add(s);
                    break;
                }else{
                    vectorPPrime.add(s+Character.toString(vectorProdu.get(i).charAt(j)));
                    break;
                }
            }
            i++;
        }
        //Borro T repetidos
        int j=0;
        while(j<vectorPPrime.size()){
            replaceArray(j, vectorPPrime, eliminaRepetido(vectorPPrime.get(j)));
            replaceArray(j, vectorPPrime, vectorPPrime.get(j).replaceAll("(.)\\1", "$1"));
            String n="aba";
            n=n.replaceAll("(.)\\1", "$1");
            j++;
        }
        
    }
    
    public String primerosNT(String NT,ArrayList<String> vectorProdu,ArrayList<String> vectorAnu){
        String s="";
        int i=0;
        while (i<vectorProdu.size()) { 
            int j=4;
            if(!NT.equals(Character.toString(vectorProdu.get(i).charAt(0)))){
                i++;
                continue;
            }
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
                        if(NTesAnulable(Character.toString(vectorProdu.get(i).charAt(j)), vectorAnu)){
                            j++;
                            continue;                            
                        }else{
                            j++;
                            break;
                        }
                    }
                    
                    if(NTesAnulable(Character.toString(vectorProdu.get(i).charAt(j)), vectorAnu)){
                        s=s+primerosNT(Character.toString(vectorProdu.get(i).charAt(j)), vectorProdu, vectorAnu);
                        j++;
                        continue;
                    }
                    break;
                }else{
                    s=s+Character.toString(vectorProdu.get(i).charAt(j));
                    break;
                }
            }
            i++;
        }
        
        return s;
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
    
    public String buscaEnPrimeros(String NT, ArrayList<String> vectorNTPrime){
        int k=0;
                while(k<vectorNTPrime.size()){
                    if(NT.equals(Character.toString(vectorNTPrime.get(k).charAt(0)))){
                        return vectorNTPrime.get(k).substring(1);
                    }
                    k++;
                }return "";
    }
    
    public void concatenaArray(int posicion, ArrayList<String> vector,String t){
        String s= vector.get(posicion);
        vector.remove(posicion);
        vector.add(posicion, s+t);
    }
    
    public void replaceArray(int posicion, ArrayList<String> vector,String t){
        String s= vector.get(posicion);
        vector.remove(posicion);
        vector.add(posicion, t);
    }
    
    public String eliminaRepetido(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                
                if(s.charAt(i)==s.charAt(j)){
                    if (j==s.length()-1) {
                        s=s.substring(0,j);
                        continue;
                    }
                    s=s.substring(0,j-1)+s.substring(j+1);
                }
                //if(j==)
            }
        }
        return s;
    }
}
