package org.javatx.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.javatx.pojo.FileBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/10 19:14
 * 阿里云工具类
 */
public class ALYUtil {
    //上传图片
    public static void uploadImg(MultipartFile multipartFile, FileBean fileBean){
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
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ossClient.putObject(bucketName, fileBean.getName(), inputStream);
        ossClient.shutdown();
    }
    /**
     * 保存文件及获取文件MD5值和SHA1值
     * @param multipartFile MultipartFile对象
     * @param fileBean fileBean
     */
    public static void transferTo(MultipartFile multipartFile, FileBean fileBean) throws IOException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        String baocun = fileBean.getPath();
        fileBean.setPath("C:"+fileBean.getPath());
        uploadImg(multipartFile,fileBean);
        fileBean.setPath(baocun);
        BigInteger md5Bi = new BigInteger(1, md5.digest());
        BigInteger sha1Bi = new BigInteger(1, sha1.digest());
        fileBean.setMd5(md5Bi.toString(16));
        fileBean.setSha1(sha1Bi.toString(16));
    }

}
