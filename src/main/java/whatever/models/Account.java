package whatever.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 公众号
 * Created by lijc on 15/4/7.
 */
@Entity
@Table(name = "account")
public class Account extends BaseModel{


    @NotNull
    private String openId;

    @NotNull
    private String accountName;

    @NotNull
    private String account;

    private String info;

    private String img;

    private String QRImg;

    private int sn;

//    @OneToMany(mappedBy = "accountId",fetch = FetchType.LAZY)
//    private List<Article> articles;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getQRImg() {
        return QRImg;
    }

    public void setQRImg(String QRImg) {
        this.QRImg = QRImg;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

//    public List<Article> getArticles() {
//        return articles;
//    }
//
//    public void setArticles(List<Article> articles) {
//        this.articles = articles;
//    }
}
