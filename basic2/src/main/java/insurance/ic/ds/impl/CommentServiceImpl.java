package insurance.ic.ds.impl;

import insurance.ic.ds.CommentService;
import insurance.ic.model.CommentSpec;
import insurance.ic.model.ResponsePage;
import insurance.ic.model.TopicSpec;
import insurance.ic.pub.Guid;
import insurance.ic.repository.CommentDao;
import insurance.ic.repository.pojo.TComment;
import insurance.ic.repository.pojo.TTopic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by admin on 2017/11/20.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void save(CommentSpec commentSpec) {
        TComment po = new TComment();
        if (commentSpec.getUuid() == null) {
            commentSpec.setUuid(Guid.generateStrId());
        }
        BeanUtils.copyProperties(commentSpec, po);
        commentDao.save(po);
    }

    @Override
    public void deleteById(String uuid) {
        commentDao.delete(uuid);
    }

    @Override
    public ResponsePage<CommentSpec> findPageByTopic(String topicId, Pageable pageable) {
        Page<TComment> tComments = commentDao.findByTopic(topicId, pageable);
        List<TComment> content = tComments.getContent();
        List<CommentSpec> rs = content.stream().map(tp -> copy(tp)).collect(toList());
        ResponsePage<CommentSpec> responsePage = new ResponsePage<>(tComments, rs);
        return responsePage;
    }

    private CommentSpec copy(TComment tp) {
        CommentSpec commentSpec = new CommentSpec();
        BeanUtils.copyProperties(tp, commentSpec);
        return commentSpec;
    }
}
