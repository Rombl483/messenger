public interface ConnectionListener {
    public void connectionCreated(Connection connection);

    public void connectionClosed(Connection connection);

    public void connectionException(Connection connection, Exception exception);

    public void receivedContent(Message message);
}
