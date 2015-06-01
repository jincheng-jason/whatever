package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.daos.AccountDao;
import whatever.daos.ArticleDao;
import whatever.models.Account;
import whatever.models.Article;

/**
 * Created by lijc on 15/4/7.
 */
@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    @Autowired
    ArticleDao articleDao;

    public void save(Account account){
        accountDao.save(account);
    }

    public Iterable<Account> findAll(){
        return accountDao.findAll();
    }

    public Account findByAccountName(String accountName){
        return accountDao.findByAccountName(accountName);
    }

    public Account findByAccount(String account){
        return accountDao.findByAccount(account);
    }

    public Account findById(long id){
        return accountDao.findById(id);
    }

    public Account findByOpenId(String openId){
        return accountDao.findByOpenId(openId);
    }

    public Iterable<Account> findCommend(){
        return accountDao.findByIsCommended(true);
    }

    public void updateAccountAndArticle(){
        Iterable<Article> articles = articleDao.findAll();
        for (Article article : articles){
            String accountName = article.getAccountName();
            Account account = accountDao.findByAccountName(accountName);
            if (null != article.getHeadImage() && null != account) {
                account.setImg(article.getHeadImage());
                accountDao.save(account);
            }

            article.setAccountId(account.getId());
            articleDao.save(article);
        }
    }
}
