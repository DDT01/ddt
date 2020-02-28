package teacherweb.example.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Đời Không Như Là Mơ on 22/11/2018
 * @project truyenonline
 */

@Component
public class ScheduledTasks {
    
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    
    @Scheduled(fixedRate = 300000)
    public void updateStatusVipChapter() {

    }

}
