package others;

import java.util.ArrayList;
import java.util.List;

/**
 * @author long.yl.
 */
public class UnitVO {

    private List<Unit> list;

    public static void main(String[] args) {
        UnitVO vo = new UnitVO();
        List<Unit> list = new ArrayList<Unit>();
        list.add(new Unit());
        list.add(new Unit());
        list.add(new Unit());
        list.add(new Unit());
        vo.setList(list);
        for (Unit unit : vo.getList()) {
            System.out.println("aaaaaaaaa");
        }
    }

    public List<Unit> getList() {
        System.out.println("--------");
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

    public static class Unit {
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
}
