import java.util.Scanner;
import java.util.TreeMap;

public class StudentGradingSystem {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>(); // Store names as keys, grades as values
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an Option:");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Retrieve Student's Grade");
            System.out.println("3. Remove Student");
            System.out.println("4. Display all Students");
            System.out.println("5. Exit");

            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student's Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student's Grade: ");
                    int grade = sc.nextInt();
                    treeMap.put(name, grade);
                    System.out.println(name + " has been added with grade: " + grade);
                    break;

                case 2:
                    System.out.print("Enter Student Name to Retrieve Grade: ");
                    String searchName = sc.nextLine();
                    if (treeMap.containsKey(searchName)) {
                        System.out.println(searchName + "'s Grade: " + treeMap.get(searchName));
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the Name of Student to be Removed: ");
                    String stuRem = sc.nextLine();
                    if (treeMap.remove(stuRem) != null) {
                        System.out.println(stuRem + " removed!");
                    } else {
                        System.out.println("Student Not Found.");
                    }
                    break;

                case 4:
                    System.out.println("Student Grades (Sorted Order):");
                    for (var entry : treeMap.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Option. Please try again.");
                    break;
            }
        }
    }
}
