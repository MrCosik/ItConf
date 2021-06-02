package pl.staz.ItConf;


import jdk.jfr.ContentType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import pl.staz.ItConf.controller.UserController;
import pl.staz.ItConf.model.Lecture;
import pl.staz.ItConf.model.User;
import pl.staz.ItConf.model.dao.LectureDao;
import pl.staz.ItConf.repository.LectureRepository;
import pl.staz.ItConf.repository.UserRepository;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@DataJpaTest
public class DataBaseConnectionTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void addingNewUserToDBShouldReturnTrue() {
        User newUser = new User("Test", "Test1@gmail.com");
        entityManager.persist(newUser);

        User savedUser = userRepository.findUserByUsername(newUser.getUsername());

        assertThat(savedUser.getUsername()).isEqualTo(newUser.getUsername());
    }


    @Test
    public void signInUpForLectureShouldAddLectureEntityToDB(){
        User newUser = new User("Test", "Test1@gmail.com");
        Lecture testLecture = new Lecture(1L,1L,0);
        newUser.addLecture(testLecture);

        entityManager.persist(newUser);

        Lecture savedLecture = lectureRepository.findById(1L).get();

        assertThat(savedLecture.getLectureNumber()).isEqualTo(testLecture.getLectureNumber());
        assertThat(savedLecture.getTopicNumber()).isEqualTo(testLecture.getTopicNumber());
    }



}
