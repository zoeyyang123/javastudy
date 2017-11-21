package insurance.ic.ds;

import com.google.gson.Gson;
import insurance.ic.model.ResponsePage;
import insurance.ic.model.TopicSpec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * Created by admin on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void testSave() throws Exception {
        File file = new File("C:/Users/admin/Desktop/tx.jpg");
        byte[] image = new byte[1024*1024];
        InputStream in = new FileInputStream(file);
        in.read(image);
        in.close();
        TopicSpec topicSpec = new TopicSpec();
        topicSpec.setContent("这是一个测试");
        topicSpec.setImage(image);
        topicSpec.setPublishDate(new Date());
        topicSpec.setPublisher("ywd");
        topicSpec.setSubject("保险");
        topicService.save(topicSpec);
    }

    @Test
    public void testDeleteById(){
        topicService.deleteById("450104078358286336");
    }

    @Test
    public void testFindPage(){
        TopicSpec byId = topicService.findById("450104077733335040");
        System.out.println(byId.getContent());
    }

    @Test
    public void testFindPages(){
        Sort sort = new Sort(Sort.Direction.DESC, "publishDate");
        Pageable pageable = new PageRequest(0,10,sort);
        ResponsePage<TopicSpec> page = topicService.findPage(pageable);
        System.out.println(new Gson().toJson(page));
    }

    @Test
    public void testV() throws Exception{
        IntStream.rangeClosed(0,15).forEach(i -> {
            try {
                testSave();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
