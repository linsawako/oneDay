package com.example.linsawako.zhihu.bean;

import java.util.List;

/**
 * Created by linsawako on 2017/1/26.
 */

public class Comment {
    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * author : 沉默中走来
         * content : 看完心中一股气息升腾，这样的文章放在大误里？这个标题会让多少人错过？毫不犹豫转发到朋友圈里了，对比一下朋友圈整天发的都是什么乱七八糟的玩意
         * avatar : http://pic1.zhimg.com/da8e974dc_im.jpg
         * time : 1485413572
         * id : 27937255
         * likes : 0
         * reply_to : {"content":"看的热泪盈眶了，应该放在小事里呀，怎么放大误了，图也配得不好，对小编提出批评，有点敷衍了","status":0,"id":27936877,"author":"Yuki"}
         */

        private String author;
        private String content;
        private String avatar;
        private int time;
        private int id;
        private int likes;
        private ReplyToBean reply_to;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public ReplyToBean getReply_to() {
            return reply_to;
        }

        public void setReply_to(ReplyToBean reply_to) {
            this.reply_to = reply_to;
        }

        public static class ReplyToBean {
            /**
             * content : 看的热泪盈眶了，应该放在小事里呀，怎么放大误了，图也配得不好，对小编提出批评，有点敷衍了
             * status : 0
             * id : 27936877
             * author : Yuki
             */

            private String content;
            private int status;
            private int id;
            private String author;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }
        }
    }
}
