package com.example.linsawako.zhihu.bean;

import java.util.List;

/**
 * Created by linsawako on 2017/1/21.
 */

public class LatestNews {
    /**
     * date : 20170121
     * stories : [{"title":"味道浑厚，香气十足，东北杀猪菜里怎么能少得了它","ga_prefix":"012118","images":["http://pic3.zhimg.com/bf3dcc7247109bcef500c4f8ee657aaa.jpg"],"multipic":true,"type":0,"id":9157263},{"images":["http://pic1.zhimg.com/075277450c2378caa7733005e1474ff0.jpg"],"type":0,"id":9166209,"ga_prefix":"012117","title":"为什么有人说在银行工作越久，能力越差？"},{"title":"你可能没有注意到，电子游戏的世界里遍地是篝火","ga_prefix":"012116","images":["http://pic2.zhimg.com/bf54f37ad9a67d8d503be119fa517f15.jpg"],"multipic":true,"type":0,"id":9166323},{"images":["http://pic4.zhimg.com/061a7420ce290b7d95ef93d1c9ad9a83.jpg"],"type":0,"id":9166344,"ga_prefix":"012115","title":"模仿白蚁巢穴，建筑师造出了不需要空调设备的大楼"},{"images":["http://pic3.zhimg.com/dbd288e34e6ae62ab4b43e76f97c4a52.jpg"],"type":0,"id":9164160,"ga_prefix":"012114","title":"克服拖延，最好的方法是用未来哄骗现在的自己"},{"images":["http://pic4.zhimg.com/4841f66517bc856fc24243bdf98a115b.jpg"],"type":0,"id":9165945,"ga_prefix":"012113","title":"去卢浮宫看到了她，才理解「到此一游」有多重要"},{"images":["http://pic1.zhimg.com/7f2a386b526cc32d1cf76a9510c082b0.jpg"],"type":0,"id":9165353,"ga_prefix":"012112","title":"大误 · 神不会开门"},{"images":["http://pic4.zhimg.com/453b4161f31db87c96edaef56fc943a3.jpg"],"type":0,"id":9160013,"ga_prefix":"012111","title":"对于年轻人，阿拉斯加有一种终极诱惑"},{"images":["http://pic1.zhimg.com/c45250b6d82551e6a438b022038e5bb0.jpg"],"type":0,"id":9165517,"ga_prefix":"012110","title":"去酒店看婚礼场地有哪些因素是需要重点考量的？"},{"images":["http://pic2.zhimg.com/f1b65be20347de8e2628de55cba8ed65.jpg"],"type":0,"id":9159786,"ga_prefix":"012109","title":"想变美就去打「溶脂针」，小心留下终身遗憾"},{"images":["http://pic2.zhimg.com/c80dc1d75700edafd9ba9d0dc1413c79.jpg"],"type":0,"id":9165506,"ga_prefix":"012108","title":"自动驾驶技术是人们真的需要，还是资本一厢情愿？"},{"images":["http://pic2.zhimg.com/1a19fcc73107670340ad79760ba33df5.jpg"],"type":0,"id":9165038,"ga_prefix":"012107","title":"在剧组工作是怎样的体验？韩寒说有这三大错觉"},{"images":["http://pic4.zhimg.com/830b87ce21433433de311ff44e3be983.jpg"],"type":0,"id":9162759,"ga_prefix":"012107","title":"开灯睡觉危害挺大，还是关了吧"},{"images":["http://pic3.zhimg.com/3ecec846f1863047f346ae566726eeee.jpg"],"type":0,"id":9165195,"ga_prefix":"012107","title":"快过年了，这些关于孩子的老生常谈，你可要记在心里"},{"images":["http://pic3.zhimg.com/8f403403304b889465410dde96ca95ca.jpg"],"type":0,"id":9164451,"ga_prefix":"012106","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic1.zhimg.com/b8e929e4bb943609eb65d695a0f8bfac.jpg","type":0,"id":9165038,"ga_prefix":"012107","title":"在剧组工作是怎样的体验？韩寒说有这三大错觉"},{"image":"http://pic2.zhimg.com/5cce819c4ab771f8d5acf0dca8d50229.jpg","type":0,"id":9165195,"ga_prefix":"012107","title":"快过年了，这些关于孩子的老生常谈，你可要记在心里"},{"image":"http://pic3.zhimg.com/849c52ca628b9ec57513d5ec2d0039de.jpg","type":0,"id":9164247,"ga_prefix":"012017","title":"你没看错，《暮光之城》女主演发了篇关于人工智能的论文"},{"image":"http://pic4.zhimg.com/570f8cc8d30a3d36f224f7b24a2c1b83.jpg","type":0,"id":9163692,"ga_prefix":"012011","title":"《职人介绍所》第二季第三期：实不相瞒，这期会吓人"},{"image":"http://pic2.zhimg.com/12d99911ee0c0eaac9c650b4917747c1.jpg","type":0,"id":9162867,"ga_prefix":"012007","title":"那个老外操着中文骂脏话的游戏火了，我们采访了「红衣风潮」的带头大哥"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 味道浑厚，香气十足，东北杀猪菜里怎么能少得了它
         * ga_prefix : 012118
         * images : ["http://pic3.zhimg.com/bf3dcc7247109bcef500c4f8ee657aaa.jpg"]
         * multipic : true
         * type : 0
         * id : 9157263
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic1.zhimg.com/b8e929e4bb943609eb65d695a0f8bfac.jpg
         * type : 0
         * id : 9165038
         * ga_prefix : 012107
         * title : 在剧组工作是怎样的体验？韩寒说有这三大错觉
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
