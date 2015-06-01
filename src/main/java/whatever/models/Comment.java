package whatever.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lijc on 15/4/26.
 */
@Entity
@Table(name = "comment")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Comment extends BaseModel {

    private String content;

    private long articleId;

//    @OneToOne(optional = true)
//    @JoinColumn(name = "quoteId",referencedColumnName = "id",nullable = true)
//    @PrimaryKeyJoinColumn
    private String quoteContent;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "quoteComment")
//    private Comment quote;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getQuoteContent() {
        return quoteContent;
    }

    public void setQuoteContent(String quoteContent) {
        this.quoteContent = quoteContent;
    }
}
