package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import whatever.daos.ArticleDao;
import whatever.models.Article;

import java.util.Date;

/**
 * Created by lijc on 15/4/10.
 */
@Service
public class ArticleService {

    @Autowired
    ArticleDao articleDao;

    public Article findById(long id){
        return articleDao.findOne(id);
    }

    public Iterable<Article> findByCategoryId(long id){
        return articleDao.findByCategoryId(id);
    }

    public Page<Article> findByCategoryIdPaged(long id, Pageable pageable){
        return articleDao.findByCategoryId(id, pageable);
    }

    public Page<Article> findNewerByCategoryIdPaged(long id,Date date, Pageable pageable){
        return articleDao.findByCategoryIdAndPubDateGreaterThan(id, date, pageable);
    }

    public Page<Article> findOlderByCategoryIdPaged(long id,Date date, Pageable pageable){
        return articleDao.findByCategoryIdAndPubDateLessThan(id, date, pageable);
    }

    public Page<Article> findInitByCategoryIdPaged(long id,Date date, Pageable pageable){
        return articleDao.findByCategoryIdAndPubDateLessThanEqual(id, date, pageable);
    }

    public Page<Article> findByAccountIdPaged(long id, Pageable pageable){
        return articleDao.findByAccountId(id,pageable);
    }

    public Page<Article> findNewerByAccountIdPaged(long id,Date date, Pageable pageable){
        return articleDao.findByAccountIdAndPubDateGreaterThan(id, date, pageable);
    }

    public Page<Article> findOlderByAccountIdPaged(long id,Date date, Pageable pageable){
        return articleDao.findByAccountIdAndPubDateLessThan(id, date, pageable);
    }

    public Page<Article> findInitByAccountIdPaged(long id,Date date, Pageable pageable){
        return articleDao.findByAccountIdAndPubDateLessThanEqual(id, date, pageable);
    }

    public void like(long id){
        articleDao.increaseLikeCount(id);
    }

    public void cancelLike(long id){
        articleDao.decreaseLikeCount(id);
    }

    public void dislike(long id){
        articleDao.increaseDislikeCount(id);
    }

    public void cacleDislike(long id){
        articleDao.decreaseDislikeCount(id);
    }

    public void increaseCommentCount(long id){
        articleDao.increaseCommentCount(id);
    }

    public void decreaseCommentCount(long id){
        articleDao.decreaseCommentCount(id);
    }

}
