package teacherweb.com.dto;


import lombok.Data;
import lombok.Getter;
import teacherweb.com.entity.Users;

import java.util.Date;

@Data
public class LessonPlanDTO {
    private int id;
    private String name;
    private Date time;
    private String note;
    private int userId;


    public LessonPlanDTO(String name, Date time, String note, int userId){
        this.name = name;
        this.time = time;
        this.note = note;
        this.userId = userId;
    }
}
