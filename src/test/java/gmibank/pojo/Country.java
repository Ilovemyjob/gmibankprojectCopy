package gmibank.pojo;

public class Country {

    private int id;
    private String name;
    private String states;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states='" + states + '\'' +
                '}';
    }
}
