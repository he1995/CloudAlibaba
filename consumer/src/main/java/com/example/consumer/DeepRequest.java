package com.example.consumer;

import java.io.Serializable;
import java.util.List;

//{
//        "model": "deepseek-chat",
//        "messages": [
//          {"role": "system", "content": "You are a helpful assistant."},
//          {"role": "user", "content": "Hello!"}
//        ],
//        "stream": false
//      }
public class DeepRequest implements Serializable {

    private String model;

    private List<Message> messages;

    private boolean stream;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public boolean getStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }
}

class Message implements Serializable {
    private String role;
    private String content;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
