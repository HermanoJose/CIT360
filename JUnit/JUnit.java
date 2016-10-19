import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Heather on 9/16/2016.
 */
public class JUnit {
    JUnit(){

    }

    public double addFive(double number){
        double result = number + 5;
        return result;
    }

    public double subtractSeven(double number){
        double result = number - 7;
        return result;
    }

    public double divideTwo(double number){
        double result = number / 2;
        return result;
    }

    public double multiplyThree(double number){
        double result = number * 3;
        return result;
    }

    public String helloWorld(String phrase){
        return phrase;
    }

    public boolean containsLetterA(String phrase){
        String lowerCase = phrase.toLowerCase();
        Integer value = lowerCase.indexOf('a');

        if (value >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int[] array (Integer a1, Integer a2, Integer a3) {
        int[] array = {a1, a2, a3};
        return array;
    }

    public Integer nullMethod() {
        return null;
    }

    public void throwExceptionMessage() {
        throw new NullPointerException();
    }

}
