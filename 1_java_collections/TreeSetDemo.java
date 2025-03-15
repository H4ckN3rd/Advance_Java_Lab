import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeset = new TreeSet<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an Option");
            System.out.println("1. Add Elements to TreeSet");
            System.out.println("2. Display TreeSet Elements");
            System.out.println("3. Exit");

            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add in TreeSet: ");
                    int elem = sc.nextInt();

                    if (treeset.contains(elem)) {
                        System.out.println("This element is already in TreeSet");
                    } else {
                        treeset.add(elem);
                        System.out.println(elem + " added to TreeSet.");
                    }
                    break;

                case 2:
                    System.out.println("TreeSet Elements " + treeset);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.Please Try Again");
                    break;
            }

        }
    }
}
