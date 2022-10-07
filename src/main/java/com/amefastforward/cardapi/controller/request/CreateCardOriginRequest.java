package com.amefastforward.cardapi.controller.request;

public class CreateCardOriginRequest {
    private String name;

    private String description;

    private String creator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String toString() {
        return "CreateCardOriginRequest(name=" + this.name +
                ", description=" + this.description +
                ", creator=" + this.creator + ")";
    }
}
