package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.daos.BookDao;
import whatever.models.UserBookAccount;

import java.util.List;

/**
 * Created by lijc on 15/4/25.
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public UserBookAccount save(UserBookAccount book){
        UserBookAccount result = bookDao.save(book);
        bookDao.flush();
        return result;
    }

    public List<UserBookAccount> save(Iterable<UserBookAccount> iterable){
        return bookDao.save(iterable);
    }

    public Iterable<UserBookAccount> getByUser(long userId){
        return bookDao.findByUserId(userId);
    }

}
