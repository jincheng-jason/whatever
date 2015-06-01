package whatever.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lijc on 15/4/5.
 */
@Entity
@Table(name = "user")
public class User extends BaseModel{
    // ==============
    // PRIVATE FIELDS
    // ==============


//    @NotNull
    private String phoneNum;

//    @NotNull
    private String password;

    private String nikeName;

    //微信账号
    private String weixin;

    //微博账号
    private String weibo;

    //附加信息
    private String append;

    //cloud id
    private String cloudId;

    // ==============
    // PUBLIC METHODS
    // ==============

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append;
    }

    public String getCloudId() {
        return cloudId;
    }

    public void setCloudId(String cloudId) {
        this.cloudId = cloudId;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
