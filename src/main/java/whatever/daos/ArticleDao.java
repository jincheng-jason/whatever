package whatever.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import whatever.models.Article;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by lijc on 15/4/7.
 */
@Transactional
public interface ArticleDao extends JpaRepository<Article,Long> {

    public Article findById(String id);

    public Page<Article> findByAccountId(long id, Pageable pageable);

    public Iterable<Article> findByCategoryId(long id);

    public Page<Article> findByCategoryId(long id, Pageable pageable);

    public Page<Article> findByCategoryIdAndPubDateGreaterThan(long id,Date date,Pageable pageable);

    public Page<Article> findByCategoryIdAndPubDateLessThanEqual(long id,Date date,Pageable pageable);

    public Page<Article> findByCategoryIdAndPubDateLessThan(long id,Date date,Pageable pageable);

    public Page<Article> findByAccountIdAndPubDateGreaterThan(long id,Date date,Pageable pageable);

    public Page<Article> findByAccountIdAndPubDateLessThanEqual(long id,Date date,Pageable pageable);

    public Page<Article> findByAccountIdAndPubDateLessThan(long id,Date date,Pageable pageable);

    @Modifying
    @Query("update Article a set a.likeCount = a.likeCount + 1 where a.id = ?1")
    public void increaseLikeCount(long id);

    @Modifying
    @Query("update Article a set a.likeCount = a.likeCount - 1 where a.id = ?1 and a.likeCount > 0")
    public void decreaseLikeCount(long id);

    @Modifying
    @Query("update Article a set a.dislikeCount = a.dislikeCount + 1 where a.id = ?1")
    public void increaseDislikeCount(long id);

    @Modifying
    @Query("update Article a set a.dislikeCount = a.dislikeCount - 1 where a.id = ?1 and a.dislikeCount > 0")
    public void decreaseDislikeCount(long id);

    @Modifying
    @Query("update Article a set a.commentCount = a.commentCount + 1 where a.id = ?1")
    public void increaseCommentCount(long id);

    @Modifying
    @Query("update Article a set a.commentCount = a.commentCount - 1 where a.id = ?1 and a.commentCount > 0")
    public void decreaseCommentCount(long id);

}
