package whatever.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.Comment;

/**
 * Created by lijc on 15/4/26.
 */
public interface CommentDao extends JpaRepository<Comment, Long> {

    public Comment findById(long id);

    public Iterable<Comment> findByArticleId(long articleId);

}
