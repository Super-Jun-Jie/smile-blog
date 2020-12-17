package org.javatx.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/3 14:31
 */
public class OOSImage {
    public static void main(String[] args) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
        String accessKeyId = "LTAI4G1a9jwwXfvRfRgyzeZ3";
        String accessKeySecret = "P7HsAukeZxjQiJHMV64H6m8WVg6Npg";
        String bucketName = "java-tx";
        // <yourObjectName>上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定的存储空间（bucketName）并将其保存为指定的文件名称（objectName）。


        File file = new File("D:\\123/djz.jpg");

        FileInputStream fileInputStream = new FileInputStream(file);
        ossClient.putObject(bucketName, file.getName(), fileInputStream);
        ossClient.shutdown();
    }
}
