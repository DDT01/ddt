package teacherweb.com.service;

import teacherweb.com.dto.LessonPlanDTO;
import teacherweb.com.entity.LessonPlan;
import teacherweb.com.exception.NotFoundException;

import java.util.List;

public interface LessonPlanService {
    LessonPlan findById(int id);

    List<LessonPlan> findAll();

    List<LessonPlan> findByUserId(int id);

    LessonPlan createLessonPlan(LessonPlanDTO lessonPlanDTO) throws NotFoundException;

    void updateLessonPlan(LessonPlanDTO lessonPlanDTO) throws NotFoundException;

    void deleteLessonPlan(int lessonPlanId) throws NotFoundException;

    int maxIdOfUser(int userId);


}
