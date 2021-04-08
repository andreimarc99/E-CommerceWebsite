package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "imageId")
    private Long imageId;

    private String imageName;

    private String type;

    @Lob
    private byte[] data;

    public Image(){}

    public Image(Long imageId, String name, String type, byte[] data) {
        this.imageId = imageId;
        this.imageName = name;
        this.type = type;
        this.data = data;
    }

    public Image(String name, String type, byte[] data) {
        this.imageId = imageId;
        this.imageName = name;
        this.type = type;
        this.data = data;
    }


    public String getName() {
        return imageName;
    }

    public void setName(String name) {
        this.imageName = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "ID: " + imageId + ", name: " + imageName + " - " + type;
    }
}
