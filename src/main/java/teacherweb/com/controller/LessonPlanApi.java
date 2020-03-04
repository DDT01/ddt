package teacherweb.com.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import teacherweb.com.dto.LessonPlanDTO;
import teacherweb.com.exception.NotFoundException;
import teacherweb.com.service.LessonPlanService;

@Controller
@RequestMapping("lessonplan")
@Api(tags = "lessonplan")
public class LessonPlanApi {

    @Autowired
    private LessonPlanService lessonPlanService;

    @RequestMapping(path = "/findId", method = RequestMethod.GET)
    public ResponseEntity<?> findId(@RequestParam("id") int id) {
        return ResponseEntity.ok(lessonPlanService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(lessonPlanService.findAll());
    }

    @RequestMapping(path = "/findByTeacher", method = RequestMethod.GET)
    public ResponseEntity<?> findByTeacher(@RequestParam("userId") int userId) {
        return ResponseEntity.ok(lessonPlanService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<?> creatLessonPlan(@RequestBody LessonPlanDTO lessonPlanDTO) throws NotFoundException {
        return ResponseEntity.ok(lessonPlanService.createLessonPlan(lessonPlanDTO));
    }

    @PutMapping
    public ResponseEntity<?> updateLessonPlan(@RequestBody LessonPlanDTO lessonPlanDTO) throws NotFoundException {
        lessonPlanService.updateLessonPlan(lessonPlanDTO);
        return ResponseEntity.ok(lessonPlanService.findById(lessonPlanService.maxIdOfUser(lessonPlanDTO.getUserId())));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteLessonPlan(@RequestParam("id") int id) throws NotFoundException {
        lessonPlanService.deleteLessonPlan(id);
        if(lessonPlanService.findById(id) != null) {
            return ResponseEntity.ok("Xóa không thành công.");
        }
        return ResponseEntity.ok("Xóa thành công.");
    }

}
