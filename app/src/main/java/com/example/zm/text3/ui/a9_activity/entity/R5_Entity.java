package com.example.zm.text3.ui.a9_activity.entity;

import java.util.List;

/**
 * Created by zm on 2016/12/12.
 */

public class R5_Entity {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * pic_url :
         * type : 1
         * title :
         * url :
         * lunbo : [{"baner":"http://pic.repaiapp.com/pic/69/53/e8/6953e858138ae22b4fb916fac0b1ef19c4086631.png","pic":"http://pic.repaiapp.com/pic/47/b4/d6/47b4d6d7b53fb124cdbaa8bc49754b6f1c7d5507.png","title":"女朋友","url":"http://zhekou.repai.com/jkjby/view/rp_b2c_update1.php?type=1&jid=10&snew=1"},{"baner":"http://pic.repaiapp.com/pic/86/46/64/864664f81b1aa850a17526a5393262eca02ecc33.png","pic":"http://pic.repaiapp.com/pic/61/d9/e2/61d9e2195e35d2d8cdba4a646eaf0ee0795314a1.png","title":"男朋友","url":"http://zhekou.repai.com/jkjby/view/rp_b2c_update1.php?type=1&jid=11&snew=1"},{"baner":"http://pic.repaiapp.com/pic/8d/73/4a/8d734abb6bc36735a6874d4d974ad711f74ba849.png","pic":"http://pic.repaiapp.com/pic/78/2a/4d/782a4d5a0bcd608d8f641e4907d620f0159de422.png","title":"闺蜜","url":"http://zhekou.repai.com/jkjby/view/rp_b2c_update1.php?type=1&jid=12&snew=1"},{"baner":"http://pic.repaiapp.com/pic/72/c1/98/72c1987598dec47550b2b69c69f4d64a73f4d41e.png","pic":"http://pic.repaiapp.com/pic/53/05/8c/53058c0b8f60f4bea7c51206a011e4c5b98bf177.png","title":"妈妈","url":"http://zhekou.repai.com/jkjby/view/rp_b2c_update1.php?type=1&jid=13&snew=1"}]
         * heng : [{"item_urls":"https://m.repai.com/item/view/id/2014592438926442","pic_url":"http://pic.repaiapp.com/pic/0d/03/c2/0d03c2a1ace68dfaa432c801656debef48667d36.jpg","title":"不锈钢小号汤勺 一只"},{"item_urls":"https://m.repai.com/item/view/id/2014609658171739","pic_url":"http://pic.repaiapp.com/pic/7a/04/d3/7a04d32f28d5e4e37c36dead1d0689344b5cfe66.jpg","title":"握笔器铅笔套1版"},{"item_urls":"https://m.repai.com/item/view/id/2014573396431879","pic_url":"http://pic.repaiapp.com/pic/83/c7/d2/83c7d27d2afc837fa78e643b5fb83f832d04e690.jpg","title":"可弯曲软毛刷一个"},{"item_urls":"https://m.repai.com/item/view/id/2014665013753231","pic_url":"http://pic.repaiapp.com/pic/49/22/01/4922019daf394fed91d6d1b37506acf38c335a36.jpg","title":"户外旅行简约尼龙防水鞋袋 一个"},{"item_urls":"https://m.repai.com/item/view/id/2014672591268458","pic_url":"http://pic.repaiapp.com/pic/cf/82/38/cf823832d51633db0a5785e28e951eadcfd574ac.jpg","title":"麦靡202安卓手机数据线一根"},{"item_urls":"https://m.repai.com/item/view/id/2014684783703719","pic_url":"http://pic.repaiapp.com/pic/e7/bb/26/e7bb26a2071d3b13565d764100b7afe0ff3ac963.jpg","title":"创意帆布手机包零钱包"},{"item_urls":"https://m.repai.com/item/view/id/2014695114898662","pic_url":"http://pic.repaiapp.com/pic/ea/a1/5f/eaa15f56edc5d24a95e888d5b2cf686714b0f770.jpg","title":"2个装韩国钢丝球刷清洁用具"},{"item_urls":"https://m.repai.com/item/view/id/2014576830908049","pic_url":"http://pic.repaiapp.com/pic/52/d3/16/52d316188de354ebcb9dc4957fc2a58a7e3c7c60.jpg","title":"多用途手持迷你簸箕垃圾清洁桶 一个"},{"item_urls":"https://m.repai.com/item/view/id/2014587999384233","pic_url":"http://pic.repaiapp.com/pic/4b/46/95/4b4695aca60fd2f73369bdad1b192c64c4f5b3ec.jpg","title":"橡胶握力圈 一个"}]
         */

        private String pic_url;
        private String type;
        private String title;
        private String url;
        private List<LunboBean> lunbo;
        private List<HengBean> heng;

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<LunboBean> getLunbo() {
            return lunbo;
        }

        public void setLunbo(List<LunboBean> lunbo) {
            this.lunbo = lunbo;
        }

        public List<HengBean> getHeng() {
            return heng;
        }

        public void setHeng(List<HengBean> heng) {
            this.heng = heng;
        }

        public static class LunboBean {
            /**
             * baner : http://pic.repaiapp.com/pic/69/53/e8/6953e858138ae22b4fb916fac0b1ef19c4086631.png
             * pic : http://pic.repaiapp.com/pic/47/b4/d6/47b4d6d7b53fb124cdbaa8bc49754b6f1c7d5507.png
             * title : 女朋友
             * url : http://zhekou.repai.com/jkjby/view/rp_b2c_update1.php?type=1&jid=10&snew=1
             */

            private String baner;
            private String pic;
            private String title;
            private String url;

            public String getBaner() {
                return baner;
            }

            public void setBaner(String baner) {
                this.baner = baner;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class HengBean {
            /**
             * item_urls : https://m.repai.com/item/view/id/2014592438926442
             * pic_url : http://pic.repaiapp.com/pic/0d/03/c2/0d03c2a1ace68dfaa432c801656debef48667d36.jpg
             * title : 不锈钢小号汤勺 一只
             */

            private String item_urls;
            private String pic_url;
            private String title;

            public String getItem_urls() {
                return item_urls;
            }

            public void setItem_urls(String item_urls) {
                this.item_urls = item_urls;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
