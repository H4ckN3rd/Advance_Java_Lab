import java.util.Scanner;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an Option");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add in Middle");
            System.out.println("3. Add at Ending");
            System.out.println("4. Display List");
            System.out.println("5. Exit...");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add at the beginning: ");
                    String beginelem = sc.nextLine();
                    list.addFirst(beginelem);
                    System.out.println("Added at Beginning: " + beginelem);
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No Elements in list..adding at beginning instead");
                        System.out.print("Enter the element: ");
                        String firstelem = sc.nextLine();
                        list.add(firstelem);
                    } else {
                        System.out.print("Enter element to add in middle: ");
                        String middleelem = sc.nextLine();
                        int mid = list.size() / 2;
                        list.add(mid, middleelem);
                        System.out.println("Added at index " + mid + ":" + middleelem);
                    }
                    break;

                case 3:
                    System.out.print("Enter the element to add at end: ");
                    String endelem = sc.nextLine();
                    list.addLast(endelem);
                    System.out.println("Added at end: " + endelem);
                    break;

                case 4:
                    System.out.println("LinkedList Elements: " + list);
                    break;

                case 5:
                    System.out.println("Exiting....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.Please Try Again.");
            }
        }
    }
}
