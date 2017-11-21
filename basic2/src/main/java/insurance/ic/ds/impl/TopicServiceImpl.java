package insurance.ic.ds.impl;

import insurance.ic.ds.TopicService;
import insurance.ic.model.ResponsePage;
import insurance.ic.model.TopicSpec;
import insurance.ic.pub.Guid;
import insurance.ic.repository.TopicDao;
import insurance.ic.repository.pojo.TTopic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by admin on 2017/11/20.
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public void save(TopicSpec topicSpec) {
        TTopic po = new TTopic();
        if (topicSpec.getUuid() == null) {
            topicSpec.setUuid(Guid.generateStrId());
        }
        BeanUtils.copyProperties(topicSpec, po);
        topicDao.save(po);
    }

    @Override
    public void deleteById(String uuid) {
        topicDao.delete(uuid);
    }

    @Override
    public ResponsePage<TopicSpec> findPage(Pageable pageable) {
        Page<TTopic> tTopics = topicDao.findAll(pageable);
        List<TTopic> content = tTopics.getContent();
        List<TopicSpec> rs = content.stream().map(tp -> copy(tp)).collect(toList());
        ResponsePage<TopicSpec> responsePage = new ResponsePage<>(tTopics, rs);
        return responsePage;
    }

    @Override
    @Cacheable(value = "topicId", key = "#id")
    public TopicSpec findById(String id) {
        TTopic one = topicDao.findOne(id);
        return copy(one);
    }

    private TopicSpec copy(TTopic tp) {
        TopicSpec topicSpec = new TopicSpec();
        BeanUtils.copyProperties(tp, topicSpec);
        return topicSpec;
    }
}
