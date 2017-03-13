package com.ghost.mianmianwwallpaper.entity;

import java.util.List;

/**
 * Created by hello on 2017/3/11.
 */

public class HotNewsEntity {

    /**
     * size : 10
     * list : [{"imgurl":"http://cms-bucket.nosdn.127.net/2f38ec4239ab41c58cae8131b25e47eb20170311095913.jpeg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF85RM0R000181KT.html","id":15070,"time":"2017-03-11 09:59:33","title":"中国打算在黄岩岛填海被美方劝阻？外交部回应","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/d/d2/d21a6362905c3fff67005c028ab86079.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF85FQFR000181KT.html","id":15061,"time":"2017-03-11 09:53:04","title":"外交部：中方正积极研究参与TPP智利会议","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/1/1a/1a841cdebe2b1c37406edaf34bfffb3d.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF857KT6000181KT.html","id":15062,"time":"2017-03-11 09:48:36","title":"菲防长炒作中国船只现身菲海域 中方作出5点回应","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/4/42/428f9b42315c81b3840e02ed7d3520b8.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF84T252000181KT.html","id":15063,"time":"2017-03-11 09:42:50","title":"专家:中国深海空间站主要是用于科学考察","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/2/22/22c643cb112cf248d46d55328be0a1c5.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF83VIVK000181KT.html","id":15049,"time":"2017-03-11 09:26:44","title":"媒体:韩国想起诉中国反\u201c萨德\u201d措施，笑话！","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/c/cf/cf00b0805e512543dd9078eddd9efb7e.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF83TF5O000181KT.html","id":15050,"time":"2017-03-11 09:25:34","title":"中方就半岛问题再喊话美韩:请打破思维定势","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/9033fa94cc584afb9ec2885a0e1a964520170311092143.jpeg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF83N0JR000181KT.html","id":15042,"time":"2017-03-11 09:22:03","title":"马来西亚警方证实死者是金正男 但拒透鉴定方式","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/6/62/62227957685ebf964eca8f9397166bc4.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF83EFT1000181KT.html","id":15041,"time":"2017-03-11 09:17:23","title":"央视证实歼20已服役 法媒：中国军队最新里程碑","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/035ed954a89c44719ef2f4d21307746d20170311091631.jpeg","has_content":true,"docurl":"http://war.163.com/17/0311/09/CF83CSHG000181KT.html","id":15034,"time":"2017-03-11 09:16:31","title":"德连续发生两起袭击事件 中国使领馆发安全提醒","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/b/bd/bd627bddb7ca07c7b921635cf64afea8.jpg","has_content":true,"docurl":"http://war.163.com/17/0311/08/CF81RP2K000181KT.html","id":15016,"time":"2017-03-11 08:49:42","title":"中科院院士:12米光学红外望远镜入选＂十三五＂规划","channelname":"war"}]
     */

    private int size;
    private List<ListBean> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * imgurl : http://cms-bucket.nosdn.127.net/2f38ec4239ab41c58cae8131b25e47eb20170311095913.jpeg
         * has_content : true
         * docurl : http://war.163.com/17/0311/09/CF85RM0R000181KT.html
         * id : 15070
         * time : 2017-03-11 09:59:33
         * title : 中国打算在黄岩岛填海被美方劝阻？外交部回应
         * channelname : war
         */

        private String imgurl;
        private boolean has_content;
        private String docurl;
        private int id;
        private String time;
        private String title;
        private String channelname;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public boolean isHas_content() {
            return has_content;
        }

        public void setHas_content(boolean has_content) {
            this.has_content = has_content;
        }

        public String getDocurl() {
            return docurl;
        }

        public void setDocurl(String docurl) {
            this.docurl = docurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelname() {
            return channelname;
        }

        public void setChannelname(String channelname) {
            this.channelname = channelname;
        }
    }
}
