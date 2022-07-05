package NordChat;

import java.io.*;

public class Message implements Serializable {
    protected static final long serialVersionUID = 1112122200L;

    static final
        int WHOISIN = 0,
            MESSAGE = 1,
            LOGOUT = 2,
            PRIVATE_MESSAGE = 3,
            WHO_IS_IN_TO_PRIVATE = 4;

    private int type;
    private String message;
    private int recipientId;

    Message(int type, String message) {
        this.type = type;
        this.message = message;
    }

    public Message(int type, String message, int recipientId) {
        this.type = type;
        this.message = message;
        this.recipientId = recipientId;
    }

    int getType() {
        return type;
    }

    String getMessage() {
        return message;
    }

    public int getRecipient() {
        return recipientId;
    }

    public void setRecipient(int recipientId) {
        this.recipientId = recipientId;
    }
}
