/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn;

import java.util.Iterator;
import java.util.*;
/**
 *
 * @author cs_ch
 */
public class collection{ 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create Hashmap
        HashMap hm = new HashMap();
        
        hm.put(123,123);
        hm.put(124.55,"Anb");
        hm.put("dfdf","bnb");
        hm.put(true,"bnb");
        //nasty path
        hm.put(null,"bnb"); //null becomes a key
        hm.put(true, "plplp"); // the second key replace the first one with the same key and value
        
        
        hm.remove(124.55);
        hm.remove(true, "plplp");
        //nasty path
        hm.remove(false); // remove nothing
        hm.remove("bnb");//  show nothing and cant remove value alone
        
        HashMap hm1 = new HashMap();
        hm1.putAll(hm);
        hm1.putAll(hm1);
        //nasty path
        HashMap lp = new HashMap();
        hm1.putAll(lp); // empty map inserted but it still has keys
        
        Iterator i = hm1.keySet().iterator();
        
        while(i.hasNext()){
            Object E = i.next();
            Object v = hm1.get(E);
            System.out.println(E + " " +v);
        }
        
//        //hashset
        HashSet hs = new HashSet();
        
        hs.add("B");
        hs.add(1);
        hs.add(1.22);
        hs.add(hm);
        //nasty path
        hs.add("B"); //unique result and does not duplicate
        hs.add(null); //null value in the set
        hs.add(hm1);// same set and the result is unique 
        
        if (!hs.isEmpty()){
            System.out.println(hs);
        }

        
        hs.clear();
        System.out.println(hs);
        hs.clear(); //still nothing after second clear
        
        //Arrarylist
        ArrayList al = new ArrayList(10);
        al.add(0,1);
        al.add(1,1.112);
        al.add(2,"kkl");
        al.add(false);
        al.add(1);
        al.add(0,2);
        al.add(hm);
        //nasty path
        al.add(0,1); // doesnot replace but push the array one after
        al.add(null); //null value is inserted
        al.add(""); //result is empty string added and take a space
        
        al.set(5, true);
        //nassty path
        al.set(0,1); //duplicate move but doesnt change anything
        try{
            al.set(-1, 1); //-1 is not valid array index
        }catch(Exception e){
            System.out.println(e);
        }
        
        int num = al.indexOf(hm);
        //nasty path
        int f = al.indexOf(999); //result is -1
        
        System.out.println(al);
        System.out.println(f);
        
        //TreeSet
        TreeSet ts = new TreeSet();
        
        ts.add(1);
        ts.add(3);
        ts.add(6);
        ts.add(7);
        ts.add(8);
        ts.add(8);
        ts.add(100);
        ts.add(115);
        ts.add(126);
        //nasty path
        try{
            ts.add(null); 
            ts.add(true); //not the same type of data set
            ts.add("B");
        }catch(Exception e){
            System.out.println(e);
        }
        
        ts =(TreeSet)ts.subSet(6,126);
        //nastypath
        try{
            ts =(TreeSet)ts.subSet(-1000,1000); //out of range and cant run
        }catch(Exception e){
            System.out.println(e);
        }
        
        ts.pollFirst();
        //nasty
        ts.pollFirst();
        ts.pollFirst(); // result is it would work even if there is nothing to poll
        ts.pollFirst();
        ts.pollFirst();
        ts.pollFirst();
        ts.pollFirst();
        ts.pollFirst();
        ts.pollFirst();
        ts.pollFirst();
        ts.pollFirst();
        
        System.out.println(ts);
        
    }
}
