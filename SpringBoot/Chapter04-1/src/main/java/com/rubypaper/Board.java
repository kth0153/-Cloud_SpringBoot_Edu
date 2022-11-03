package com.rubypaper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate;
    private long cnt;

    public Long getSeq() {
        return this.seq;
    }

    public void setSeq(final Long seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(final String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public long getCnt() {
        return this.cnt;
    }

    public void setCnt(final long cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", cnt=" + cnt +
                '}';
    }
}
