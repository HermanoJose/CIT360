import java.util.*;

public class Sandbox {

    public static void main(String[] args) {
        // happy path - adding names to a linkedhashset
        LinkedHashSet<String> setC = new LinkedHashSet<>();
        setC.add("Bob");
        setC.add("Jenny");
        setC.add("Tom");
        setC.add("Anna");
        setC.add("Zara");

        System.out.println("---Happy Path---");
        // displaying our set of names
        Iterator iteratorC1 = setC.iterator();
        while (iteratorC1.hasNext()) {
            System.out.println(iteratorC1.next());
        }

        // nasty path - adding null to a set and adding a couple names after it
        setC.add(null);
        setC.add("Carol");
        setC.add("Darren");

        System.out.println("---Nasty Path---");
        // null successfully is inserted to the set along with the other two names
        Iterator iteratorC2 = setC.iterator();
        while (iteratorC2.hasNext()) {
            System.out.println(iteratorC2.next());
        }

        // nasty path - adding special characters
        setC.add("#%@$@*");

        System.out.println("---Nasty Path---");
        // displaying our set of names, successfully adds the special characters string
        Iterator iteratorC3 = setC.iterator();
        while (iteratorC3.hasNext()) {
            System.out.println(iteratorC3.next());
        }

        // nasty path - adding a special character without escaping it
        setC.add("Johnson's");

        System.out.println("---Nasty Path---");
        // displaying our set of names, successfully appends the ' without escaping it
        Iterator iteratorC4 = setC.iterator();
        while (iteratorC4.hasNext()) {
            System.out.println(iteratorC4.next());
        }

        System.out.println("*********************");

        // happy path - creating a set of numbers and removing a value successfully
        LinkedHashSet setD = new LinkedHashSet<>();
        setD.add(5);
        setD.add(4);
        setD.add(1);
        setD.add(7);
        setD.add(9);
        setD.add(0);

        setD.remove(1);
        System.out.println("---Happy Path---");
        // displaying our set of numbers
        Iterator iteratorD = setD.iterator();
        while (iteratorD.hasNext()) {
            System.out.print(iteratorD.next() + " ");
        }


        // nasty path - removing a value that does not exist in the set
        setD.remove(12);

        System.out.println("\n\n---Nasty Path---");
        // it doesn't make any changes
        Iterator iteratorD2 = setD.iterator();
        while (iteratorD2.hasNext()) {
            System.out.print(iteratorD2.next() + " ");
        }

        // nasty path - removing a null value that doesn't exist in the set
        setD.remove(null);

        System.out.println("\n---Nasty Path---");
        // it doesn't make any changes
        Iterator iteratorD3 = setD.iterator();
        while (iteratorD3.hasNext()) {
            System.out.print(iteratorD3.next() + " ");
        }


        // nasty path - removing the min_value
        setD.remove(Integer.MIN_VALUE);

        System.out.println("\n---Nasty Path---");
        // it doesn't make any changes
        Iterator iteratorD4 = setD.iterator();
        while (iteratorD4.hasNext()) {
            System.out.print(iteratorD4.next() + " ");
        }


        LinkedHashSet <String> setE = new LinkedHashSet <String>();

        // populate hash set
        setE.add("Ayancy");
        setE.add("Heather");
        setE.add("Travis");

        // check the existence of element
        boolean exist = setE.contains("Heather");

        System.out.println("\n\nDoes setD contain 'Heather'? "+ exist);
    }
}
