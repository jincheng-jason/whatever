package whatever.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.Category;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/10.
 */
@Transactional
public interface CategoryDao extends JpaRepository<Category,Long> {

    public Category findByName(String name);

}
