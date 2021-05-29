package pl.staz.ItConf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.staz.ItConf.model.Lecture;

@Repository
public interface LectureRepository extends CrudRepository<Lecture, Long> {


}
