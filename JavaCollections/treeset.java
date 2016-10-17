import java.util.Iterator;
import java.util.TreeSet;

public class treeset {

    public static void main(String[] args) {
        System.out.println("Java Collections: Tree Set Example!\n");
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(10);
        tree.add(89);
        tree.add(34);
        tree.add(45);

        // sorts data, 89 is the last element. see output below
        Iterator<Integer> iterator = tree.iterator();
        System.out.print("Tree set data: ");

        // Displaying the Tree set data
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Check empty or not
        if (tree.isEmpty()) {
            System.out.print("Tree Set is empty.");
        } else {
            System.out.println("Tree Set size: " + tree.size());
        }

        // Retrieve first data from tree set
        System.out.println("First data: " + tree.first());

        // Retrieve last data from tree set
        System.out.println("Last data: " + tree.last());

        if (tree.remove(45)) { // remove element by value
            System.out.println("Data is removed from tree set");
        } else {
            System.out.println("Data doesn't exist!");
        }
        System.out.print("Now the tree set contain: ");
        iterator = tree.iterator();

        // Displaying the Tree set data
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("Now the size of tree set: " + tree.size());

        // Remove all
        tree.clear();
        if (tree.isEmpty()) {
            System.out.print("Tree Set is empty.");
        } else {
            System.out.println("Tree Set size: " + tree.size());
        }
    }
}
