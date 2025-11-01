import java.util.ArrayList;

public class Collection {
    public static void main(String[] args) {
        ArrayList < String > items = new ArrayList< String >();
        items.add("red");
        items.add(0, "yellow");

        System.out.print("Display list contents with counter-controlled loop:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" %s", items.get(i));
        }

        // display colors using foreach in the display method
        display(items, 
            "\nDisplay list contents with enhanced for statement:"
        );

        items.add("green");
        items.add("yellow");
        display(items, "List with two new elements:");

        items.remove("yellow");
        display(items, "Remove first instance of yellow:");
        

        items.remove(1);
        display(items, "Remove first instance of element(green):");

        items.remove("red");
        display(items, "Remove red:");

        System.out.printf("\"red\" is %sin the list\n",
            items.contains("red") ? "" : "not "
        );
        display(items, "The number of elements:");
        System.out.printf("Size: %s\n", items.size());
    }

    public static void display(ArrayList <String> items, String header) {
        System.out.print(header);
        for (String item : items)
            System.out.printf(" %s", item);
        
        System.out.println();
    }
}
