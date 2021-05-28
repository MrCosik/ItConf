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
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    @OneToMany
    Set<Lecture> attendedLectures = new HashSet<>();

}
