package whatever.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import whatever.utils.DateSerialize;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 活动
 * Created by lijc on 15/5/6.
 */
@Entity
@Table(name = "event")
public class Event extends BaseModel{

    @NotNull
    private String title;

    @NotNull
    private String url;

    private String img;

    //是否正在进行
    private boolean isInProcess;

    private boolean status;

    private Date beginAt;

    private Date endAt;

    private String largeImg;

    private String smallImg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getIsInProcess() {
        return isInProcess;
    }

    public void setIsInProcess(boolean isInProcess) {
        this.isInProcess = isInProcess;
    }

    @JsonSerialize(using = DateSerialize.class)
    public Date getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(Date beginAt) {
        this.beginAt = beginAt;
    }

    @JsonSerialize(using = DateSerialize.class)
    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLargeImg() {
        return largeImg;
    }

    public void setLargeImg(String largeImg) {
        this.largeImg = largeImg;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
