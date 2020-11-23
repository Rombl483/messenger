import java.io.Serializable;

public interface Message extends Serializable {
    public String getNock();

    public String getContent();

    public int getType();
}
