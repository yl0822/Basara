package spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author long.yl.
 * @Date 2016/6/16
 */
public class TxService implements InvocationHandler{

    @Autowired
    DataSourceTransactionManager transactionManager;

    /**
     * 下面就是@Transactional注解对方法进行代理的机制，为被注解的方法会被自动commit
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        //该对象持有事务处理的属性
        TransactionDefinition td = new DefaultTransactionDefinition();
        //该对象获取事务状态
        TransactionStatus ts = transactionManager.getTransaction(td);
        Object ret = null;
        try {
            ret = method.invoke(proxy, args);
        }catch (Exception e){
            //在被代理对象调用过程中出现任何异常，事务回滚
            transactionManager.rollback(ts);
            e.printStackTrace();
        }
        //如果调用顺利，则提交变更
        transactionManager.commit(ts);
        return ret;
    }
}
