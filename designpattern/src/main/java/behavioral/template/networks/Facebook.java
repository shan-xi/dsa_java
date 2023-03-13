package behavioral.template.networks;

public class Facebook extends NetWork {
    public Facebook(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    boolean sendData(byte[] data) {
        System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
        return true;
    }

    @Override
    void logOut() {
        System.out.println("User: '" + userName + "' was logged out from Facebook");
    }

    @Override
    boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.userName);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simlateNetwrokLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    private void simlateNetwrokLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
