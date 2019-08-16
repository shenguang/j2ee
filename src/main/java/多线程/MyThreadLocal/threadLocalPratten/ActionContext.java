package 多线程.MyThreadLocal.threadLocalPratten;

/**
 * @className ActionContext
 * @Description
 * @Date 2019/8/15 15:44
 * @Author shenguang
 * @Version 1.0
 **/
public class ActionContext {
    ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }

    };
    private ActionContext(){}
    //单例
    private static class ContextHolder{
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getInstanceContext() {
        return  ContextHolder.actionContext;
    }
    public Context getContext(){
        return  threadLocal.get();
    }

}
