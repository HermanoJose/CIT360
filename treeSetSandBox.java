import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Ayancy on 10/4/2016.
 */
public class treeSetSandBox {public static void main(String[] args) {

    Set<Integer> a = new TreeSet<Integer>(Arrays.asList(new Integer[]{0, 2, 4, 5, 6, 8, 10}));
    Set<Integer> b = new TreeSet<Integer>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9, 10}));
    //nasty path adding a null
    Set<Integer> f = new TreeSet<Integer>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9, null}));
    //nasty path adding an empty set
    Set<Integer> g = new TreeSet<Integer>(Arrays.asList(new Integer[]{}));
    
    //happy path create union
    Set<Integer> c = new TreeSet<Integer>(a);
    c.addAll(b);
    System.out.println(c);

    //happy path create intersection
    Set<Integer> d = new TreeSet<Integer>(a);
    d.retainAll(b);
    System.out.println(d);


    //happy path create difference
    Set<Integer> e = new TreeSet<Integer>(a);
    e.removeAll(b);
    System.out.println(e);



}
    }
