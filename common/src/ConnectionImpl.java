import java.net.Socket;

public class ConnectionImpl implements Connection {
    private Socket socket;
    private ConnectionListener connectionListener;

    public ConnectionImpl(Socket socket, ConnectionListener connectionListener) {
        this.socket = socket;
        this.connectionListener = connectionListener;
    }

    @Override
    public void send(Message message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
