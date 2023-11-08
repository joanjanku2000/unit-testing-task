package org.ikubinfo.testing.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "post_categories")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @Column(name = "date_created")
    private String dateCreated;
    @Column(name = "date_modified")
    private String dateModified;

    public PostCategory() {
    }

    public PostCategory(Integer id, Post post, Category category, String dateCreated, String dateModified) {
        this.id = id;
        this.post = post;
        this.category = category;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "PostCategory{" +
                "id=" + id +
                ", postId=" + post +
                ", categoryId=" + category +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                '}';
    }
}
