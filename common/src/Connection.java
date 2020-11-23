public interface Connection {
    public static final int PORT = 8888;

    public void send(Message message);

    public void close();
}
