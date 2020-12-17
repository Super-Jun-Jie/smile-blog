package org.javatx.result;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/2 9:41
 */
public interface ResultInterface {
    /**
     * 获取状态编码
     * @return 编码
     */
    Integer getCode();

    /**
     * 获取提示信息
     * @return 提示信息
     */
    String getMessage();
}
