package whatever.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lijc on 15/4/7.
 */
@MappedSuperclass
public abstract class BaseModel {

    @Id
//    @GeneratedValue(generator="idGenerator")
//    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private Date createTime;

//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm:ss")
    private Date updateTime;

    @PrePersist
    protected void onCreate(){
        createTime = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updateTime = new Date();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
