import java.util.Scanner;
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an Option");
            System.out.println("1. Add Elements to HashSet");
            System.out.println("2. Display Hashset Elements");
            System.out.println("3. Exit");

            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Elements to add in Hashset: ");
                    int elem = sc.nextInt();
                    if (h.contains(elem)) {
                        System.out.println("This element is already in HashSet");
                    } else {
                        h.add(elem);
                        System.out.println(elem + " added to set.");
                    }
                    break;

                case 2:
                    System.out.println("HashSet Elements: " + h);
                    break; 

                case 3:
                    System.out.println("Exiting....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.Please Try Again");
                    break;
            }
        }
    }
}
