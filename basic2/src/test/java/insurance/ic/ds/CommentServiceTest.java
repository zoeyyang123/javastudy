package insurance.ic.ds;

import insurance.ic.model.CommentSpec;
import insurance.ic.model.ResponsePage;
import insurance.ic.pub.Guid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.IntStream;

/**
 * Created by admin on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testSave(){
        CommentSpec commentSpec = new CommentSpec();
        commentSpec.setUuid(Guid.generateStrId());
        commentSpec.setCommentator("ywd");
        commentSpec.setCommentDate(new Date());
        commentSpec.setContent("我是一条评论");
        commentSpec.setTopic("450117553054814208");
        commentService.save(commentSpec);
    }

    @Test
    public void testDeleteById(){
        commentService.deleteById("450123227155402752");
    }

    @Test
    public void testFindPageByTopic(){
        Sort sort = new Sort(Sort.Direction.DESC, "commentDate");
        Pageable pageable = new PageRequest(0,10,sort);
        ResponsePage<CommentSpec> pageByTopic = commentService.findPageByTopic("450117551528087552", pageable);
        System.out.println(pageByTopic.getTotalCount());
    }

    @Test
    public void testV(){
        IntStream.rangeClosed(0,15).forEach(i -> {
            try {
                testSave();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
