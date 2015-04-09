package whatever.daos;

import org.springframework.data.repository.CrudRepository;
import whatever.models.Article;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/7.
 */
@Transactional
public interface ArticleDao extends CrudRepository<Article,Long> {

    public Article findById(String id);

}
