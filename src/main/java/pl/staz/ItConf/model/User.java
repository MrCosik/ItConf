package pl.staz.ItConf.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "appUserId",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    Set<Lecture> attendedLectures = new HashSet<>();


    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

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

    public Set<Lecture> getAttendedLectures() {
        return attendedLectures;
    }

    public void setAttendedLectures(Set<Lecture> attendedLectures) {
        this.attendedLectures = attendedLectures;
    }
}
