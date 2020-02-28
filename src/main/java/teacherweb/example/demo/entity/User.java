package teacherweb.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column(name = "phone", unique = true, length = 50)
    private int phone;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "info_json", length = 255)
    private String infoJson;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role roleId;



}