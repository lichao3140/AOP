package com.lichao.aop;

import android.util.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 切面，想要分割出来的功能模块
 * Created by Administrator on 2018-01-06.
 */
@Aspect
public class BehaviorAspect {
    private static final String TAG = "lichao";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *  切点
     *  * *任何方法
     *  (..)任何参数
     */
    @Pointcut("execution(@com.lichao.aop.BehaviorTrace  * *(..))")
    public void annoBehavior() {

    }

    /**
     * 切面，拿到分割处理的功能模块进行处理
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("annoBehavior()")
    public Object dealPoint(ProceedingJoinPoint point) throws Throwable {
        //方法执行前
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        //拿到注解
        BehaviorTrace behaviorTrace = methodSignature.getMethod().getAnnotation(BehaviorTrace.class);
        String contentType = behaviorTrace.value();
        int type = behaviorTrace.type();
        Log.i(TAG, contentType + "使用时间：   " + simpleDateFormat.format(new Date()));
        long begin = System.currentTimeMillis();

        //方法执行时
        Object object = null;
        try {
            object = point.proceed();
        } catch (Exception e) {

        }

        //方法执行完成
        Log.i(TAG,"消耗时间：  "+(System.currentTimeMillis() - begin)+"ms");
        return object;
    }
}
