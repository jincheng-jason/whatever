package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.daos.ArticleDao;
import whatever.daos.CommentDao;
import whatever.models.Comment;

/**
 * Created by lijc on 15/4/26.
 */
@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    ArticleDao articleDao;

    public Comment save(Comment comment){
        articleDao.increaseCommentCount(comment.getArticleId());
        return commentDao.saveAndFlush(comment);
    }

    public Iterable<Comment> findCommentsOfArticle(long articleId){
        return commentDao.findByArticleId(articleId);
    }


}
