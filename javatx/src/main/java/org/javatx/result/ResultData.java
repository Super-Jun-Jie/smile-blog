package org.javatx.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: 胡俊杰
 * @Date: 2020/12/2 9:43
 */
@Getter
@Setter
public class ResultData<T> {
    private ResultInterface info;
    private Long count;
    private List<T> data;

    public ResultData(ResultInterface info, List<T> data, Long count) {
        this.info = info;
        this.count = count;
        this.data = data;
    }

    public ResultData(ResultInterface info, List<T> data) {
        this.info = info;
        this.data = data;
    }

    public ResultData(ResultInterface info) {
        this.info = info;
    }
}
