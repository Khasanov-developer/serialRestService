package presentation.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty
    private String message;

    @JsonProperty
    private int code;

    public Message(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
