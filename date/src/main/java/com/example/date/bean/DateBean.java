package com.example.date.bean;

import java.util.List;

public class DateBean {

    /**
     * date : 20171210
     * stories : [{"images":["https://pic1.zhimg.com/v2-7ca99795f7331e64c2946f0e8c6ef53c.jpg"],"type":0,"id":9660402,"ga_prefix":"121022","title":"小事 · 一百万赚到了，然后呢"},{"title":"何止少儿不宜，连成人看了都脊背发凉","ga_prefix":"121021","images":["https://pic2.zhimg.com/v2-6c54635031f6844a9c65b526dd010009.jpg"],"multipic":true,"type":0,"id":9660454},{"title":"「姑娘，知道你想美，但你这妆容是不是有点过了\u2026\u2026」","ga_prefix":"121019","images":["https://pic1.zhimg.com/v2-0c141706a8fdd16f86f59848f5832c04.jpg"],"multipic":true,"type":0,"id":9660315},{"images":["https://pic2.zhimg.com/v2-73595422f4c939a5488f6acb6eb92b7d.jpg"],"type":0,"id":9658708,"ga_prefix":"121018","title":"别胡乱操作，乳房按摩保健什么的，很容易出问题的\u2026\u2026"},{"title":"想给家里添点圣诞节的气氛，但买一棵圣诞树又不太现实\u2026\u2026","ga_prefix":"121017","images":["https://pic2.zhimg.com/v2-b2c99eb98c5b61b56cb8c9a14a196e39.jpg"],"multipic":true,"type":0,"id":9660322},{"images":["https://pic1.zhimg.com/v2-f7ef9c4491a77fd0921b39d0ce71ff9c.jpg"],"type":0,"id":9660440,"ga_prefix":"121016","title":"《塞尔达传说：旷野之息》获 TGA 2017 年度最佳游戏，名至实归"},{"images":["https://pic1.zhimg.com/v2-e88b85b62e17b2f7bcc643c1e2161158.jpg"],"type":0,"id":9660342,"ga_prefix":"121014","title":"该用的东西永远找不到、永远乱糟糟，其实厨房收纳有技巧"},{"images":["https://pic2.zhimg.com/v2-c8411ecbb96cdaacacc76402fc134a85.jpg"],"type":0,"id":9659553,"ga_prefix":"121012","title":"大误 · 在魔法次元你主修什么？"},{"images":["https://pic1.zhimg.com/v2-4b403aab5f1728ca8dcc81cb3b8d7bc0.jpg"],"type":0,"id":9660290,"ga_prefix":"121011","title":"刚学开车，要是不注意这些经验，怕是要「送人头」的"},{"images":["https://pic2.zhimg.com/v2-5163ab7218452fced95c39b427b320a1.jpg"],"type":0,"id":9660389,"ga_prefix":"121010","title":"「商业模式」，见过无数次，从来也没人解释这词什么意思"},{"images":["https://pic3.zhimg.com/v2-a1d9bc75eb5f833c7dd7a110ece0c6d6.jpg"],"type":0,"id":9659495,"ga_prefix":"121009","title":"后来我才知道，这个世上并不存在没有任何「残」「障」的人"},{"images":["https://pic3.zhimg.com/v2-85aad5f9d12407b768b72c48d4994686.jpg"],"type":0,"id":9660420,"ga_prefix":"121008","title":"本周热门精选 · 不安的时代"},{"images":["https://pic1.zhimg.com/v2-3b3598e906c694016ae6b3ad82d7c300.jpg"],"type":0,"id":9660432,"ga_prefix":"121007","title":"有哪些设计很棒的学校宿舍楼？"},{"images":["https://pic4.zhimg.com/v2-92c3e744296c1785dd8121269be9a5f7.jpg"],"type":0,"id":9660422,"ga_prefix":"121007","title":"在微博就能找到梅西的年代，信虫还在用最原始的方法追星"},{"images":["https://pic1.zhimg.com/v2-38b60458db353bc0fca4b640e7f974a0.jpg"],"type":0,"id":9659975,"ga_prefix":"121007","title":"消失中的线下服装市场：一个时代已远去"},{"images":["https://pic3.zhimg.com/v2-cd12dc594ecef927aabf1f1fa98e2bc2.jpg"],"type":0,"id":9660412,"ga_prefix":"121006","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

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

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-7ca99795f7331e64c2946f0e8c6ef53c.jpg"]
         * type : 0
         * id : 9660402
         * ga_prefix : 121022
         * title : 小事 · 一百万赚到了，然后呢
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

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

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
