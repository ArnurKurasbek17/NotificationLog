import java.util.Scanner; 

import java.util.Scanner;

public class NotificationApp {

    public static void main(String[] args) {

        NotificationLog log = new NotificationLog();

        log.addRecord("05.10", "Instagram", 6, true);
        log.addRecord("05.10", "WhatsApp", 120, true);
        log.addRecord("06.10", "Instagram", 2, true);
        log.addRecord("06.10", "WhatsApp", 99, true);
        log.addRecord("07.10", "Instagram", 1, true);
        log.addRecord("07.10", "WhatsApp", 89, true);
        log.addRecord("08.10", "Instagram", 8, true);
        log.addRecord("08.10", "WhatsApp", 107, true);
        log.addRecord("09.10", "Instagram", 4, true);
        log.addRecord("09.10", "WhatsApp", 56, true);
        log.addRecord("10.10", "Instagram", 9, true);
        log.addRecord("10.10", "WhatsApp", 215, true);

        Scanner scanner = new Scanner(System.in); 
        int choice = -1;

        while (choice != 0) {
            System.out.println();
            System.out.println("=== Телефондағы хабарламалар ===");
            System.out.println("1 - Барлық жазбалар");
            System.out.println("2 - Жазбалар саны, қосынды, орташа мән");
            System.out.println("3 - Ең үлкен мәні бар жазба");
            System.out.println("4 - Ереже: хабарлама 50-ден көп");
            System.out.println("5 - Сүзу: қосымша");
            System.out.println("6 - Өз функциям: орташадан көп хабарлама");
            System.out.println("0 - Шығу");
            System.out.print("Таңдауыңыз: ");
            choice = scanner.nextInt(); 
            scanner.nextLine(); 

            if (choice == 1) {
                log.printAll();
            } else if (choice == 2) {
                System.out.println("Жазбалар саны: " + log.getCount());
                System.out.println("Қосынды: " + log.getTotal() + " дана");
                System.out.println("Орташа мән: " + log.getAverage() + " дана");
            } else if (choice == 3) {
                Notification max = log.findMax();
                if (max != null) {
                    max.printInfo();
                }
            } else if (choice == 4) {
                System.out.println("Ережеге сай жазбалар: " + log.countMatches());
            } else if (choice == 5) {
                System.out.print("Қосымша: ");
                String text = scanner.nextLine(); 
                log.printByCategory(text);
            } else if (choice == 6) {
                log.printAboveAverage();
            } else if (choice != 0) {
                System.out.println("Мұндай пункт жоқ");
            }
        }

        System.out.println("Сау болыңыз!");
        scanner.close();
    }
}
