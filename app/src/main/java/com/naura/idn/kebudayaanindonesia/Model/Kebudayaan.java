package com.naura.idn.kebudayaanindonesia.Model;

import java.io.Serializable;

public class Kebudayaan implements Serializable {
    private String name, info, photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
