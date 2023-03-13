package behavioral.template;

import behavioral.template.networks.Facebook;
import behavioral.template.networks.NetWork;
import behavioral.template.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NetWork network = null;
        System.out.println("Input user name: ");
        String userName = reader.readLine();
        System.out.println("Input password: ");
        String password = reader.readLine();

        System.out.println("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());
        if(choice == 1){
            network = new Facebook(userName, password);
        } else if(choice == 2){
            network = new Twitter(userName, password);
        }
        assert network != null;
        network.post(message);
    }
}
