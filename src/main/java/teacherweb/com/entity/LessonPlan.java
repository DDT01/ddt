package teacherweb.com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lesson_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonPlan implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "time")
    private Date time;

    @Column(name = "note")
    private String note;


    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false)
    private Users userId;

    public LessonPlan(String name, Date time, String note, Users userId){
        this.name = name;
        this.time = time;
        this.note = note;
        this.userId = userId;

    }

}
