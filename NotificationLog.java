public class NotificationLog {

    private Notification[] items = new Notification[30];
    private int count = 0;

    public boolean addRecord(String date, String app, int messages, boolean readAll) {
        if (count >= 30) {
            return false;
        }
        Notification n = new Notification();
        n.setDate(date);
        n.setApp(app);
        n.setMessages(messages);
        n.setReadAll(readAll);
        items[count] = n;
        count++;
        return true;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        int total = 0;
        int i = 0;
        while (i < count) {
            total = total + items[i].getMessages();
            i++;
        }
        return total;
    }

    public int getAverage() {
        if (count == 0) {
            return 0;
        }
        return getTotal() / count;
    }

    public Notification findMax() {
        if (count == 0) {
            return null;
        }
        Notification max = items[0];
        int i = 1;
        while (i < count) {
            if (items[i].getMessages() > max.getMessages()) {
                max = items[i];
            }
            i++;
        }
        return max;
    }

    public int countMatches() {
        int matches = 0;
        int i = 0;
        while (i < count) {
            if (items[i].isNoisyApp()) {
                matches++;
            }
            i++;
        }
        return matches;
    }

    public void printAll() {
        int i = 0;
        while (i < count) {
            System.out.print((i + 1) + ". ");
            items[i].printInfo();
            i++;
        }
    }

    public void printByCategory(String value) {
        boolean found = false;
        int i = 0;
        while (i < count) {
            if (items[i].getApp().equals(value)) {
                items[i].printInfo();
                found = true;
            }
            i++;
        }
        if (!found) {
            System.out.println("Мұндай жазба табылмады");
        }
    }

    public void printAboveAverage() {
        int average = getAverage();
        boolean found = false;
        int i = 0;
        while (i < count) {
            if (items[i].getMessages() > average) {
                items[i].printInfo();
                found = true;
            }
            i++;
        }
        if (!found) {
            System.out.println("Орташадан көп хабарлама келген жазба жоқ");
        }
    }
}
