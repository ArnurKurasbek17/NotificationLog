public class Notification {

    private String date;
    private String app;
    private int messages;
    private boolean readAll;

    public String getDate() {
        return date;
    }

    public void setDate(String d) {
        if (d.equals("")) {
            System.out.println("Қате: күн бос болмауы керек");
        } else {
            date = d;
        }
    }

    public String getApp() {
        return app;
    }

    public void setApp(String a) {
        if (a.equals("")) {
            System.out.println("Қате: қосымша атауы бос болмауы керек");
        } else {
            app = a;
        }
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int m) {
        if (m < 0 || m > 2000) {
            System.out.println("Қате: хабарлама саны 0..2000 аралығында болуы керек");
        } else {
            messages = m;
        }
    }

    public boolean isReadAll() {
        return readAll;
    }

    public void setReadAll(boolean r) {
        readAll = r;
    }

    public boolean isNoisyApp() {
        return messages > 50;
    }

    public void printInfo() {
        String readText = "жоқ";
        if (readAll) {
            readText = "иә";
        }
        System.out.println(date + " | " + app + " | " + messages + " дана | барлығы оқылды: " + readText);
    }
}
