package models;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String location;
    private String birthday;
    private String email;
    private String password;

    public User( String name, String location, String birthday, String email, String password) {
        this.name = name;
        this.location = location;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSON() {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("name", this.name);
        userMap.put("location", this.location);
        userMap.put("birthday", this.birthday);
        userMap.put("email", this.email);
        userMap.put("password", this.password);

        return userMap.toString();
    }
}
