import  java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private LocalDateTime fechaRegistro;
    
    // Constructor vacío (necesario para frameworks como Spring o Jackson)
    public User() {}

    // Constructor útil para crear rápidamente un usuario
    public User(Long id, String username, String email, String passwordHash, LocalDateTime fechaRegistro) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
