public class NotificationTestDrive {

    public static void main(String[] args) {

        Notification a = new Notification();
        a.setMessages(40);
        a.setMessages(2001);
        if (a.getMessages() == 40) {
            System.out.println("ТЕСТ 1 (жоғарғы шектен асқан мән қабылданбайды): OK");
        } else {
            System.out.println("ТЕСТ 1: ҚАТЕ");
        }

        a.setMessages(-1);
        if (a.getMessages() == 40) {
            System.out.println("ТЕСТ 2 (төменгі шектен кем мән қабылданбайды): OK");
        } else {
            System.out.println("ТЕСТ 2: ҚАТЕ");
        }

        NotificationLog log = new NotificationLog();
        log.addRecord("01.10", "Instagram", 40, true);
        log.addRecord("01.10", "WhatsApp", 75, false);
        log.addRecord("02.10", "Telegram", 120, false);

        if (log.getTotal() == 235) {
            System.out.println("ТЕСТ 3 (қосынды): OK");
        } else {
            System.out.println("ТЕСТ 3: ҚАТЕ");
        }

        Notification max = log.findMax();
        if (max != null && max.getMessages() == 120 && max.getApp().equals("Telegram")) {
            System.out.println("ТЕСТ 4 (ең үлкен мән): OK");
        } else {
            System.out.println("ТЕСТ 4: ҚАТЕ");
        }

        if (log.countMatches() == 2) {
            System.out.println("ТЕСТ 5 (ереже бойынша санау): OK");
        } else {
            System.out.println("ТЕСТ 5: ҚАТЕ");
        }
    }
}
