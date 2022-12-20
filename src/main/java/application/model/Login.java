package application.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_login", nullable = false)
    private int idLogin;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "pwd", nullable = false)
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "expired_at")
    private Timestamp expired_at;

    public Login(int idLogin, String username, String password, Timestamp date_creation, Timestamp expiration_date) {
        this.idLogin = idLogin;
        this.username = username;
        this.password = password;
        this.created_at = date_creation;
        this.expired_at = expiration_date;
    }

    public Login() {
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(Timestamp expired_at) {
        this.expired_at = expired_at;
    }
}
