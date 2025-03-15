import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> Arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an Option");
            System.out.println("1. Add an Element");
            System.out.println("2. Remove an Element");
            System.out.println("3. Update Element");
            System.out.println("4. Retreive an Element");
            System.out.println("5. Display all Elements");
            System.out.println("6. Exit...");

            System.out.print("Enter your Choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter an element to add:");
                    String toadd = sc.nextLine();
                    Arr.add(toadd);
                    System.out.println("Added:" + toadd);
                    break;

                case 2:
                    System.out.print("Enter which element to be removed:");
                    String torem = sc.nextLine();
                    if (Arr.remove(torem)) {
                        System.out.println("Removed element:" + torem);
                    } else {
                        System.out.println("Element not found");
                    }

                case 3:
                    System.out.print("Enter the Index at Element to be replaced: ");
                    int indexupdate = sc.nextInt();
                    sc.nextLine();

                    if (indexupdate >= 0 && indexupdate < Arr.size()) {
                        System.out.print("Enter the Value to be replaced:");
                        String torep = sc.nextLine();
                        Arr.set(indexupdate, torep);
                        System.out.println("Updated Index " + indexupdate + "to: " + torep);
                    } else {
                        System.out.println("Invalid Index");
                    }

                case 4:
                    System.out.println("Enter an Index Value to Retreive and Element:");
                    int indexval = sc.nextInt();
                    if (indexval >= 0 && indexval < Arr.size()) {
                        System.out.println("Element at Index " + indexval + "is: " + Arr.get(indexval));
                    } else {
                        System.out.println("Invalid Index");
                    }

                case 5:
                    System.out.println("Arraylist Elements: " + Arr);
                    break;

                case 6:
                    System.out.println("Exiting....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice..Please Try Again");

            }
        }
    }
}