package csy.retry;

public final class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static final Throwable findException(Throwable cause, Class<?> type) {
        return cause == null?cause:(type.isAssignableFrom(cause.getClass())?cause:findException(cause.getCause(), type));
    }
}