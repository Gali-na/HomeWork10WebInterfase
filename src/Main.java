import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Group group = WorkWithDatabase.databaseConnection();
        try (ServerSocket soc = new ServerSocket(8080)) {
            for (; ; ) {
                Socket clisoc = soc.accept();
                ClientSoket cli = new ClientSoket(clisoc, group);
            }
        } catch (IOException e) {
            System.out.println("Error to server Socket Open!!!");
        }
    }
}

