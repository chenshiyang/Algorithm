package csy.retry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 异常重试注解定义
 *
 * Created by allenchen on 2018/5/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Retryable {
    /**
     * 重试次数，默认3次
     *
     * @return
     */
    int retryTime() default 3;

    /**
     * 每次重试之前sleep的毫秒数，默认5毫秒
     *
     * @return
     */
    long sleepTime() default  5L;

    /**
     * 需要重试的异常，默认为乐观锁失败异常
     *
     * @return
     */
    Class<?>[] exceptionClasses() default {ArrayIndexOutOfBoundsException.class, NullPointerException.class};
}
