package ShopDemo;

import java.util.Scanner;

public class AppUtil {
    private Scanner scanner;

    public AppUtil() {
        this.scanner = new Scanner(System.in);
    }

    public String appRead() {
        return scanner.next();
    }

    public int readInt() throws Exception {
        String data = appRead();
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException e) {
            appWrite(ShopMessages.WRONG_INPUT);
            throw new Exception("Not read line as number");
        }
    }

    public void appWrite(String messages) {
        System.out.println(messages);
    }
}
