package org.javatx.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 10:10
 */
@Data
@Component
public class UploadProjectProperties {

    /** 上传文件路径 */
    private String filePath;

    /** 上传文件静态访问路径 */
    private String staticPath = "/upload/**";

    /** 获取文件路径 */
    public String getFilePath() {
        if (filePath == null) {
            return ToolUtil.getProjectPath() + "/upload/";
        }
        if (!filePath.endsWith("/")) {
            return filePath + "/";
        }
        return filePath;
    }
}
