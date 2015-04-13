package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.daos.CategoryDao;
import whatever.models.Category;

/**
 * Created by lijc on 15/4/10.
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public Category findById(Long id){
        return categoryDao.findOne(id);
    }

    public Iterable<Category> findAll(){
        return categoryDao.findAll();
    }

}
