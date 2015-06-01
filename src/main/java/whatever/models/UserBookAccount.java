package whatever.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lijc on 15/4/25.
 */
@Entity
@Table(name = "user_book_account")
public class UserBookAccount extends BaseModel{

    private long userId;

    private long accountId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
