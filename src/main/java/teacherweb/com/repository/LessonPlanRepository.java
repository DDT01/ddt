package teacherweb.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teacherweb.com.entity.LessonPlan;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface LessonPlanRepository extends JpaRepository<LessonPlan, Integer> {
   LessonPlan findById(int id);

    List<LessonPlan> findAll();

    @Query(value = "SELECT l FROM LessonPlan l WHERE l.userId.id = :userId")
    List<LessonPlan> findByUserId(@Param("userId") int userId);

    @Query(value = "SELECT Max(l.id) from LessonPlan l where l.userId.id= :userId")
    int maxIdOfUser(@Param("userId") int userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE LessonPlan l SET name= :name, time= :time, note= :note WHERE l.id= :id")
    void updateLessonPlan(@Param("id") int id, @Param("name") String name, @Param("time") Date time, @Param("note") String note);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LessonPlan l WHERE l.id = :lessonPlanId")
    void deleteLessonPlan(@Param("lessonPlanId") int lessonPlanId);

}
