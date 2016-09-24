import java.util.HashMap;

/**
 * Created by Joseph on 9/20/16.
 */
public class hashMapSandBox {
    public static void main (String[] params) {

        //HashMap Happy Path - Create a HashMap and add some items to it
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "Travis");
        hashMap.put("B", "Sarah");
        hashMap.put("C", "Anthony");
        hashMap.put("D", "Melody");

        for (String key : hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }


        //Nasty path - outputting hashMap - if we want to output hashMap we need to use the key to get specific elements
        // or else it will just spit out the entire map instead of just what you want. You must also use the key to
        // get the value or else you will just get a null. Remember that a value and a key are not the same thing.
        System.out.println(hashMap);
        try {
            System.out.println(hashMap.get("A"));
            System.out.println(hashMap.get("Travis"));
        }
        catch (Exception e){
            System.out.println("You have to use a key value pair to output your hashMap value!");
        }

        //Happy Path - remove
        hashMap.remove("D");
        System.out.println(hashMap);

        //Nasty Path - can I delete an item based off its value rather than its key?
        try {
            hashMap.remove("Travis");
            for (String key : hashMap.keySet()) {
                System.out.println(key + ": " + hashMap.get(key));
            }
        }
        catch (Exception e) {
            System.out.println("Travis is still there! There isn't even an exception thrown!");
        }
        //When you use the remove method, you have to specify a key. If you try to use a value or you use a key that
        //doesn't exist you will not get an error, you will not get an exception, or any message. Simply, the computer
        //notices that there is no key like the one you typed in and thus it must have been removed. You have to be careful
        //because there isn't anything to tell you that you succeeded with this command. If you have automated
        //this removal, you will need to make sure the key is correctly passed to the remove method.

        //Nasty Path - what happens if I try to put a null into hashMap as a key or a value? Will it allow it or will
        //it spit out an exception?
        try {
            hashMap.put("E", null);
        }
        catch (Exception e) {
            System.out.println("Will this work?");
        }

        try {
            hashMap.put(null, "F");
        }
        catch (Exception e) {
            System.out.println("Will that work?");
        }

        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get("E"));
        //Both of these work! Be careful, because if you store a null key then you need to make sure not override it.
        //If it is in an automated function you might have a hard time getting a null value to produce that result, it might
        //be useful in some error handling situations though. Also be careful, that if a program produces a null value
        // for a value, then it will store it without an error, which may go unnoticed and be unintentional, and cause
        //greater problems later on.

        //Happy Path - create an integer hashmap with some values put in it.
        HashMap<Integer, Integer> integerMap = new HashMap<>();
        integerMap.put(0, 0);
        integerMap.put(1, 1);
        integerMap.put(2, 2);
        integerMap.put(3, 3);

        //Nasty Path - lets try a null value as a key and as a value and see what happens
        integerMap.put(null, 4);
        integerMap.put(4, null);

        for(Integer key : integerMap.keySet()) {
            System.out.println(key + ": " + integerMap.get(key));
        }
        System.out.println("\n");
        //It outputs everything! even the null key and null value, it accepts them without errors even though it
        //probably shouldn't. At least we can use this as a way to handle errors or something like that.

        //Nasty Path - What happens if I use a negative key?
        integerMap.put(-1, -1);

        for(Integer key : integerMap.keySet()) {
            System.out.println(key + ": " + integerMap.get(key));
        }

        System.out.println('\n');
        System.out.println(integerMap);

        //Now in GIT!!!

    }
}
