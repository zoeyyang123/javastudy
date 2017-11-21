package insurance.ic.ds.impl;

import insurance.ic.ds.UpvoteService;
import insurance.ic.model.UpvoteSpec;
import insurance.ic.pub.Guid;
import insurance.ic.repository.UpvoteDao;
import insurance.ic.repository.pojo.TUpvote;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/11/20.
 */
@Service
public class UpvoteServiceImpl implements UpvoteService{

    @Autowired
    private UpvoteDao upvoteDao;

    @Override
    public void doUpvote(UpvoteSpec upvoteSpec) {
        TUpvote po = new TUpvote();
        if (upvoteSpec.getUuid() == null) {
            upvoteSpec.setUuid(Guid.generateStrId());
        }
        BeanUtils.copyProperties(upvoteSpec, po);
        upvoteDao.save(po);
    }

    @Override
    public List<UpvoteSpec> findByUser(String userId) {
        return null;
    }

    @Override
    public List<UpvoteSpec> findByUserAndTopic(String userId, String topicId) {
        return null;
    }
}
