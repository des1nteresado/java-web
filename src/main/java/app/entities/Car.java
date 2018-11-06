package app.entities;

public class Car {
    private int id;
    private String name;
    private int user_id;

    public Car() {
    }

    public Car(int id, String name, int user_id) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "models.Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
