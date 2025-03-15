import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an Option:");
            System.out.println("1. Add Entry (Key-Value)");
            System.out.println("2. Retrieve Value by Key");
            System.out.println("3. Remove Entry by Key");
            System.out.println("4. Display All Entries");
            System.out.println("5. Exit");

            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Key (Integer): ");
                    int key = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Value (String): ");
                    String value = sc.nextLine();
                    map.put(key, value);
                    System.out.println("Entry Added: " + key + " -> " + value);
                    break;

                case 2:
                    System.out.print("Enter Key to Retrieve Value: ");
                    int searchKey = sc.nextInt();
                    if (map.containsKey(searchKey)) {
                        System.out.println("Value: " + map.get(searchKey));
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Key to Remove Entry: ");
                    int removeKey = sc.nextInt();
                    if (map.containsKey(removeKey)) {
                        map.remove(removeKey);
                        System.out.println("Entry Removed.");
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;

                case 4:
                    System.out.println("HashMap Entries: " + map);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        }
    }
}
