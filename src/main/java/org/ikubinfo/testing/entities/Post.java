package org.ikubinfo.testing.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "date_created")
    private String dateCreated;
    @Column(name = "date_modified")
    private String dateModified;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Post() {
    }

    public Post(Integer id, String title, String body, String dateCreated, String dateModified, Integer user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.user = Post.this.user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = Post.this.user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", user=" + user +
                '}';
    }
}
