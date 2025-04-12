package com.example.liferank;

@Entity
@Table(name = "usuarios")
public class Usuario {
  	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    private LocalDateTime fechaRegistro;

    // Getters, setters, constructor...
}
