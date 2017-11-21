package insurance.ic.ds;

import insurance.ic.model.UpvoteSpec;
import insurance.ic.pub.Guid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by admin on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpvoteServiceTest {

    @Autowired
    private UpvoteService upvoteService;

    @Test
    public void testDoUpvote(){
        UpvoteSpec upvoteSpec = new UpvoteSpec();
        upvoteSpec.setUuid(Guid.generateStrId());
        upvoteSpec.setComment("450123227155402752");
        upvoteSpec.setTopic("450117551528087552");
        upvoteSpec.setUpvoteDate(new Date());
        upvoteSpec.setUpvoter("ywd");
        upvoteService.doUpvote(upvoteSpec);
    }
}
