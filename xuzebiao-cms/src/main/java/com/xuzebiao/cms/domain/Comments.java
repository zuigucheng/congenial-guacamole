package com.xuzebiao.cms.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 文章评论表
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@TableName("cms_comments")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章评论ID
     */
    @TableId("id")
    private Integer id;

    /**
     * 文章标识
     */
    @TableField("articleid")
    private Integer articleid;

    /**
     * 评论用户ID
     */
    @TableField("userid")
    private Integer userid;

    /**
     * 评论内容摘要
     */
    @TableField("content")
    private String content;

    /**
     * 评论时间
     */
    @TableField("created")
    private Timestamp created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Comments{" +
            "id=" + id +
            ", articleid=" + articleid +
            ", userid=" + userid +
            ", content=" + content +
            ", created=" + created +
        "}";
    }
}
