package zawadka.adam.covid19.model;


import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserInfo {

    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Parameter(example = "swagger@gmail.com")
    private String username;

    private String password;

    private String fullname;

    public UserInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
