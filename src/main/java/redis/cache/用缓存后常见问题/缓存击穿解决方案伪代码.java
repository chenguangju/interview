package redis.cache.用缓存后常见问题;



/**
 * redission 版本可以看到，读取请求全部串行化，击穿问题全部避免，但是性能低
 * nx+循环版本，市的只有一个线程去构建缓存，其他线程等待构建完成后，直接查询缓存，防止请求打到DB
 */
public class 缓存击穿解决方案伪代码 {

    /**
     *读取数据 redisson 版本
     */
    public void getDataForRedission(String key){
        /*
        Lock lock=Redission.lock;
        Object value=cache.get(key);
        if(value==null){
            try{
                updateData(key,obj);
                return cache.get(key);;
            }finally {
                lock.unlock;
            }
        }else{
            return value;
        }
        */
    }

    /**
     * nx+循环版本
     */
    public void getDataForSetNx(String key){
        /*
        Object value=cache.get(key);
        if(value==null){
            //使用nx参数 并设置过期时间
            if(redis.setnx(key,1000)){
                //重新构建缓存
                updateData(key,obj);
                //删除锁
                redis.delete(key)
                return cache.get(key);
            }else{
                //其他线程休息50ms后重试
                Thread.sleep(50);
                getDataForSetNx(key)
            }
        }else{
            return value;
        }
        */
    }

    /**
     * key不设置过期时间，在value中保存过期时间
     */
    public void getDataForNoTimeout(String key){
        /*
        Object v=cache.get(key);
        String value=v.getValue();
        //逻辑过期时间
        Long timeout=v.getTimeOut();
        //逻辑时间小于当前时间，表示过期了
        if(timeout<=System.currentTimeMillis()){
            //使用nx参数 并设置过期时间
            if(redis.setnx(key,1000)){
                //异步构建缓存
                threadPool.execute(new Runnable(){
                    public void run(){
                        //重新构建缓存
                        updateData(key,obj);
                        //删除锁
                        redis.delete(key)
                    }
                });
            }
        }
        //返回旧数据
        return value;
        */
    }

}
