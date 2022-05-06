package com.upc.homemade.communicationservice.resource;

public class MessageResource {
    private Long id;
    private String text;
    private String file;

    public Long getId() {
        return id;
    }

    public MessageResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getText() {
        return text;
    }

    public MessageResource setText(String text) {
        this.text = text;
        return this;
    }

    public String getFile() {
        return file;
    }

    public MessageResource setFile(String file) {
        this.file = file;
        return this;
    }

}
