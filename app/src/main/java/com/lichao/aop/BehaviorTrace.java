package com.lichao.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018-01-06.
 */
@Target(ElementType.METHOD)//注解用在那里
@Retention(RetentionPolicy.CLASS)//注解用在代码的类型
public @interface BehaviorTrace {
    String value();
    int type();
}
