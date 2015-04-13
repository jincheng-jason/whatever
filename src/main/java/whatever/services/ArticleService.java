package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import whatever.daos.ArticleDao;
import whatever.models.Article;

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

}
