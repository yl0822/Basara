package mode.neteas.basara;

/**
 * @author long.yl.
 * @Date 2015/12/31
 */
public abstract class SingletonBasara<T> {

    //����������˽��
    //������÷�����ʵ�ֵ�������ֱ�����ഴ�������Ͼ���ӵ������ԵĿ���չ��ͨ���Ը���
    private T instance;

    //�������ɵ���������ʵ��
    protected abstract T newInstance();

    /**
     * ��������Ϊ��ȡ������������
     * public final T getInstance() {
     *  if (instance == null) {
     *      instance = newInstance();
     *  }
     * ��
     * ��ô���������Ϊʲô������������ʵ�֣����������ʵ��
     * 1.��һ���ж�instance�Ƿ�Ϊnull���п��ܳ��ֶ��̳߳�ͻ�����������ȫ��֤�����ԣ�����֮����˸�����������֤������
     * 2.ΪʲôҪ���ϵڶ����жϣ�����˵ΪʲôҪ�ӵ�һ���жϣ���Ϊ��Ч�ʿ��ǣ���Ϊ�����Ķ��̳߳�ͻ���ֻ��������״ε������ɵ�ʱ��
     * 3.���ȥ����һ���жϣ���ô�����ÿ�ε��ö���ִ�м����������Ƿǳ�Ӱ��Ч�ʵģ������б�Ҫ���ϵ�һ�ε��ж�
     * */
    public final T getInstance() {
        if (instance == null) {
            synchronized (SingletonBasara.class) {
                if (instance == null) {
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
