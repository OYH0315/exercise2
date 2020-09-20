package pojo;

public class downloadlist {
    private int id;
    private String name;
    private String path;
    private String description;
    private int size;
    private int star;
    private String image;

    public downloadlist() {
    }

    public downloadlist(int id, String name, String path, String description, int size, int star, String image) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.description = description;
        this.size = size;
        this.star = star;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public int getSize() {
        return size;
    }

    public int getStar() {
        return star;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "downloadlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", star=" + star +
                ", image='" + image + '\'' +
                '}';
    }
}
