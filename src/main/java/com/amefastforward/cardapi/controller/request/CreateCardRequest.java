package com.amefastforward.cardapi.controller.request;

public class CreateCardRequest {

    private String name;
    private String description;
    private int strength;
    private int speed;
    private int skill;
    private int gear;
    private int intellect;
    private String imageUrl;


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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "CreateCardRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", strength=" + strength +
                ", speed=" + speed +
                ", skill=" + skill +
                ", gear=" + gear +
                ", intellect=" + intellect +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
