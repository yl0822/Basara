package tools.netease.basara;

import java.io.Serializable;
import java.util.List;

/**
 * @author long.yl.
 */
public class MobileChristmasUnitVO implements Serializable{


    private static final long serialVersionUID = 5623463743823197977L;
    private List<Unit> list;

    public static class Unit{
        private int id;
        private String imgUrl;
        private String linkUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        @Override
        public String toString() {
            return "Unit{" +
                    "id=" + id +
                    ", imgUrl='" + imgUrl + '\'' +
                    ", linkUrl='" + linkUrl + '\'' +
                    '}';
        }
    }

    public List<Unit> getList() {
        return list;
    }

    public void setList(List<Unit> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Unit unit : this.list) {
            sb.append(unit).append("\n");
        }
        return sb.toString();
    }
}
