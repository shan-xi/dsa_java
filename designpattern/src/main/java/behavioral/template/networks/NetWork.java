package behavioral.template.networks;

public abstract class NetWork {
    String userName;
    String password;

    public NetWork() {
    }

    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean sendData(byte[] bytes);

    abstract void logOut();

    abstract boolean logIn(String userName, String password);
}
