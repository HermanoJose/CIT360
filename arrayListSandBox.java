import jdk.nashorn.internal.runtime.ECMAException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Joseph on 9/15/16.
 */
public class arrayListSandBox {

    public static void main(String[] params) {
        //sandbox constructor for ArrayList

        //Happy Path - constructing an ArrayList of a String type
        ArrayList<Integer> intArray = new ArrayList<Integer>();

        intArray.add(15);
        intArray.add(30);
        intArray.add(45);
        intArray.add(60);

        System.out.println(intArray);
        //result - the array is created and prints [] because it is unpopulated.

        //Nasty Path - add null, what will happen if I add null. In C it will end the array because a lot of arrays
        //are null terminated
        intArray.add(null);
        intArray.add(75);
        System.out.println(intArray + "\n");
        //It just continues through the array. It doesn't seem to care that there is a null in there. Not good if we
        // are expecting a value in our program

        //Nasty Path - adding a number to an index that is not in our array yet, will it then add it to the array if
        // the array gets bigger or will it resize the array or will we have a problem?
        try {
            intArray.add(75, null);
        } catch (Exception e) {
            System.out.println("You get an OutOfBounds Exception! You can't do this at all!\n");
        }
        //You get an error. and it won't let you do this. Its just too big, you have to insert items into an index
        //that is already there.

        //Nasty Path - inserting something into a negative index. Why would you want to do this? I don't know
        try {
            intArray.add(-1, -1);
        } catch (Exception e) {
            System.out.println("This can't be done either! You don't want negative array indexes!\n");
        }
        //When I try to do this we get an exception saying that we cannot do this. Arrays go up, not down, you cannot
        //Have a negative index.

        //Happy Path - get method
        System.out.println(intArray.get(0));

        //Nasty Path - what happens if I try to get a negative index? will it convert it to positive?
        try {
            System.out.println(intArray.get(-1));
        } catch (Exception e) {
            System.out.println("You can't do this! It looks for this spot in the array! You only have items in " +
                    "0, 1, 2, 3, 4, and 5\n");
        }
        //You can't have a negative index, and this throws our exception.

        //Happy Path - adding inside the array to get an index value
        System.out.println(intArray.get(1 + 2) + "\n");

        //Nasty Path - what happens if I try to add something at the min value and then subtract one from it?
        try {
            intArray.add(Integer.MIN_VALUE);
            System.out.println(intArray.get(6) - 1 + "\n");
        } catch (Exception e) {
            System.out.println("Anything past min value wraps to the max value!\n");
        }
        //It wraps! when you subtract one from -2147483647 it becomes 2147483647! Same thing happens if I go in reverse

        //Nasty path - what happens when I try dividing a result by 0?
        try {
            System.out.println(intArray.get(3) / 0);
        } catch (Exception e) {
            System.out.println("You can't divide by zero\n");
        }

        //index too big
        // index is negative, biggest or smallest possible integer + adding it. divide by 0 double.min / something

        //Happy Path - add all
        ArrayList<Integer> intArray2 = new ArrayList<>();
        intArray2.add(0);
        intArray2.add(1);
        intArray2.add(2);
        intArray2.add(3);

        intArray.addAll(intArray2);

        System.out.println(intArray);

        //Nasty Path - Merging an empty collection
        ArrayList<Integer> emptyArray = new ArrayList<>();

        try {
            intArray.addAll(emptyArray);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(intArray);
        //Doesnt error out, doesn't give you a warning, just does it, which might not be something that you want to happen


        //Happy Path - remove
        intArray.remove(0);
        System.out.println(intArray);

        //Nasty Path - remove an element based off of value instead of position
        try {
            intArray.remove(75);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //GOes to the index no matter what, you cannot use values. You get an out of bounds exception


        //Nasty Path - Try to remove a null value
        try {
            intArray.remove(null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(intArray);
        //It goes through, no warnings, no nothing. It removes both the null value and the null reference!

        //Now in GIT!!!


    }
}