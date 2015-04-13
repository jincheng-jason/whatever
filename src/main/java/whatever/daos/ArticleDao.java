package whatever.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.Article;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/7.
 */
@Transactional
public interface ArticleDao extends JpaRepository<Article,Long> {

    public Article findById(String id);

    public Iterable<Article> findByCategoryId(long id);

    public Page<Article> findByCategoryId(long id, Pageable pageable);

}
