package whatever.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lijc on 15/4/10.
 */
@Entity
@Table(name = "category")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@cat_id")
public class Category extends BaseModel{

    private String name;

//    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
//    @JsonBackReference("cate")
//    private List<Article> articles = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setArticles(List<Article> articles) {
//        this.articles = articles;
//    }
//
//    public List<Article> getArticles() {
//        return articles;
//    }
}
