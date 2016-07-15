package others;

import java.io.Serializable;

/**
 * @author long.yl.
 */
public class ChristmasSockVO implements Serializable {

    private static final long serialVersionUID = 495958417491772194L;

    private long type;

    private String name;

    private long date;

    public ChristmasSockVO() {

    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ChristmasSockVO{" +
                "date=" + date +
                '}';
    }
}
