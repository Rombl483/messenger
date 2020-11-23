import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

public class Server implements ConnectionListener {
    private Set<Connection> connections;
    private ServerSocket serverSocket;

    //
    public Server() {
        try {
            serverSocket = new ServerSocket(Connection.PORT);
            connections = new LinkedHashSet<>();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void startServer() {
        System.out.println("Server started.");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                connections.add(new ConnectionImpl(socket, this));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void connectionCreated(Connection connection) {
        connections.add(connection);
        System.out.println("Connection was added.");
    }

    @Override
    public void connectionClosed(Connection connection) {
        connections.remove(connection);
        connection.close();
        System.out.println("Connection was closed.");
    }

    @Override
    public void connectionException(Connection connection, Exception exception) {
        connections.remove(connection);
        connection.close();
        System.out.println("Connection was closed.");
        exception.printStackTrace();
    }

    @Override
    public void receivedContent(Message message) {
        for (Connection connection : connections) {
            connection.send(message);
        }
    }
}
