package teacherweb.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teacherweb.com.dto.LessonPlanDTO;
import teacherweb.com.entity.LessonPlan;
import teacherweb.com.entity.Users;
import teacherweb.com.exception.NotFoundException;
import teacherweb.com.repository.LessonPlanRepository;
import teacherweb.com.service.LessonPlanService;
import teacherweb.com.service.UserService;

import java.util.List;

@Service
public class LessonPlanServiceImpl implements LessonPlanService {

    @Autowired
    private LessonPlanRepository lessonPlanRepository;

    @Autowired
    private UserService userService;

    @Override
    public LessonPlan findById(int id){

        return lessonPlanRepository.findById(id);
    }

    @Override
    public List<LessonPlan> findAll(){
        return lessonPlanRepository.findAll();
    }

    @Override
    public List<LessonPlan> findByUserId(int userId){
        return lessonPlanRepository.findByUserId(userId);
    }

    @Override
    public LessonPlan createLessonPlan(LessonPlanDTO lessonPlanDTO) throws NotFoundException {
        return lessonPlanRepository.save(LDTOtoLessonPlan(lessonPlanDTO ));
    }

    @Override
    public int maxIdOfUser(int userId){
        return lessonPlanRepository.maxIdOfUser(userId);
    }

    @Override
    public void updateLessonPlan(LessonPlanDTO lessonPlanDTO) {
        lessonPlanRepository.updateLessonPlan(lessonPlanDTO.getId(), lessonPlanDTO.getName(), lessonPlanDTO.getTime(), lessonPlanDTO.getNote());
    }

    @Override
    public void deleteLessonPlan(int lessonPlanId) throws NotFoundException {
//        if (!checkUser(lessonPlanId)){
//            throw new NotFoundException("Bạn phải là Admin hoặc chủ sở hữu của giáo án.");
//        }
        lessonPlanRepository.deleteLessonPlan(lessonPlanId);
    }

    private LessonPlan LDTOtoLessonPlan(LessonPlanDTO lessonPlanDTO) throws NotFoundException {
        int userId = lessonPlanDTO.getUserId();
        Users users = userService.findbyId(userId);
        if (users.getRole().getId() > 4) {
            throw new NotFoundException("Bạn không phải là giáo viên.");
        }
        LessonPlan lessonPlan = new LessonPlan( lessonPlanDTO.getName(), lessonPlanDTO.getTime(),
                lessonPlanDTO.getNote(), users);
        return lessonPlan;
    }

    private boolean checkUser(int lessonPlanId){
        Users users = userService.findbyId(lessonPlanId);
        if ((users.getId() == lessonPlanId)||(users.getId() == 1)){
            return true;
        }
        return false;
    }



}
