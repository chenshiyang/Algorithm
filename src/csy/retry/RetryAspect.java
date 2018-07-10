package csy.retry;

/**
 * 异常重试切面实现
 *
 * Created by allenchen on 2018/5/23.
 */

public class RetryAspect {

}

// 该工程没有导入spring 依赖,因此将以下实际内容注释掉.

//@Aspect
//public class RetryAspect implements Ordered {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    public int getOrder() {
//        return 0;
//    }
//
//    @Pointcut("execution(* *(..)) && @annotation(cn.facility.annotation.Retryable)")
//    public void retry() {
//
//    }
//
//    @Around("retry()")
//    public Object doWithRetry(ProceedingJoinPoint pjp) throws Throwable{
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        Method method = methodSignature.getMethod();
//        Retryable annotation = method.getAnnotation(Retryable.class);
//        int retryTime = annotation.retryTime();
//        long sleepTime = annotation.sleepTime();
//        Class<?>[] exceptionClasses = annotation.exceptionClasses();
//        int attemptTime = 0;
//        while (attemptTime < retryTime) {
//            attemptTime += 1;
//            try {
//                return pjp.proceed();
//            } catch (Throwable t) {
//                boolean isMatch = false;
//                for (Class<?> exceptionClass : exceptionClasses) {
//                    Throwable cause = ExceptionUtil.findException(t, exceptionClass);
//                    if(cause != null) {
//                        isMatch = true;
//                        logger.info("第{}次异常重试，休眠时间{}毫秒",attemptTime,sleepTime);
//                        if(sleepTime > 0) {
//                            Thread.sleep(sleepTime);
//                        }
//                        break;
//                    } else {
//                        continue;
//                    }
//                }
//                if(!isMatch) {
//                    throw t;
//                }
//            }
//        }
//        logger.info("{}.{}超过重试次数", method.getClass(), method.getName());
//        return null;
//    }
//}
