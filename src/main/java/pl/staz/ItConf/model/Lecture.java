package pl.staz.ItConf.model;

import javax.persistence.*;

@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "lecture_id")
    private Long lectureId;
    @Column(name = "topic_number")
    private int topicNumber;

}
