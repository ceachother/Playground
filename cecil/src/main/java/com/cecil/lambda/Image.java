package com.cecil.lambda;

/**
 * Created by cecillee on 26/2/2017.
 */
public class Image {
    private Integer time;
    private String uid;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Image concat(Image image) {
        time += image.getTime();
        uid += image.getUid();
        return this;
    }
}
