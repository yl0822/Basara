package longstring.revert;

/**
 * @author long.yl.
 * @Date 2016/6/3
 */
public class StringRevertTask implements Task {
    @Override
    public String execute(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
