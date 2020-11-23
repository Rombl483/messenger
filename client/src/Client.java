import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int c;

        System.out.print("Welcome! Messenger 1.0 client");

        // TODO сделать загрузку параметров изконфигурационного файла
        Scanner scanner = new Scanner(System.in);
        System.out.println("IP:");
        String ip = scanner.nextLine();

        int port = 43;

        Socket socket = new Socket(ip, port);

        InputStream inMsg = socket.getInputStream();
        OutputStream outMsg = socket.getOutputStream();

        while ((c = inMsg.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
