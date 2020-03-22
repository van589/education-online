package com.van589.mooc.commons.persistence;

/**
 * 默认回调方法
 *
 * @param <S>
 * @param <T>
 */
@FunctionalInterface
public interface BeanCopyUtilCallBack <S, T> {

    /**
     * 定义默认回调方法
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}