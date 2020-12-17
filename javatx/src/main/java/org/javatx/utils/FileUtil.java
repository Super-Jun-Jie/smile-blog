package org.javatx.utils;

import org.javatx.pojo.FileBean;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 9:41
 */
public class FileUtil {

    /**
     * 创建一个Upload实体对象
     * @param multipartFile MultipartFile对象
     */
    public static FileBean getFile(MultipartFile multipartFile){
        if (multipartFile.getSize() == 0){
            throw new RuntimeException("文件不能为空");
        }
        FileBean fileBean = new FileBean();
        fileBean.setMime(multipartFile.getContentType());
        fileBean.setSize(multipartFile.getSize());
        System.out.println("原文件名"+multipartFile.getOriginalFilename());
        System.out.println("处理过的文件名"+genFileName(multipartFile.getOriginalFilename()));
        fileBean.setName(genFileName(multipartFile.getOriginalFilename()));
        fileBean.setPath("https://java-tx.oss-cn-shanghai.aliyuncs.com/"+ fileBean.getName());
        return fileBean;
    }

    /**
     * 判断文件是否为支持的格式
     * @param multipartFile MultipartFile对象
     * @param types 支持的文件类型数组
     */
    public static boolean isContentType(MultipartFile multipartFile, String[] types){

        return Arrays.stream(types).filter(a->a.contains(multipartFile.getContentType())).count()>0?true:false;
        //List<String> typeList = Arrays.asList(types);
        //return typeList.contains(multipartFile.getContentType());
    }

    /**
     * 获取文件上传保存路径
     */
    public static String getUploadPath(){
        UploadProjectProperties properties = SpringContextUtil.getBean(UploadProjectProperties.class);
        return properties.getFilePath();
    }

    /**
     * 获取文件上传目录的静态资源路径
     */
    public static String getPathPattern(){
        UploadProjectProperties properties = SpringContextUtil.getBean(UploadProjectProperties.class);
        String staticPath = properties.getStaticPath().replace("/**", "");
        return staticPath;
    }

    /**
     * 生成随机且唯一的文件名
     */
    public static String genFileName(String originalFilename){
        String fileSuffix = ToolUtil.getFileSuffix(originalFilename);
        return UUID.randomUUID().toString().replace("-", "") + fileSuffix;
    }

    /**
     * 生成指定格式的目录名称(日期格式)
     */
    public static String genDateMkdir(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return "/" + sdf.format(new Date()) + "/";
    }

    /**
     * 获取目标文件对象
     * @param fileBean 上传实体类
     */
    public static File getDestFile(FileBean fileBean) throws IOException {

        // 创建保存文件对象
        //String path = upload.getPath().replace(getPathPattern(), "");
        //String filePath = getUploadPath() + path;
        // 原来 String filePath = getUploadPath() + path;
        //String replace = filePath.replace("//", "/");
        File dest = new File(fileBean.getPath());
        if(!dest.exists()){
            dest.getParentFile().mkdirs();
            dest.createNewFile();
        }

        return dest;
    }

    /**
     * 保存文件及获取文件MD5值和SHA1值
     * @param multipartFile MultipartFile对象
     * @param fileBean fileBean
     */
    public static void transferTo(MultipartFile multipartFile, FileBean fileBean) throws IOException, NoSuchAlgorithmException {

        byte[] buffer = new byte[4096];
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        String baocun = fileBean.getPath();
        fileBean.setPath("C:"+fileBean.getPath());

        try (OutputStream fos = Files.newOutputStream(getDestFile(fileBean).toPath()); InputStream fis = multipartFile.getInputStream()) {
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                md5.update(buffer, 0, len);
                sha1.update(buffer, 0, len);
            }
            fos.flush();
        }catch (Exception e){
            e.printStackTrace();;
        }
        fileBean.setPath(baocun);
        BigInteger md5Bi = new BigInteger(1, md5.digest());
        BigInteger sha1Bi = new BigInteger(1, sha1.digest());
        fileBean.setMd5(md5Bi.toString(16));
        fileBean.setSha1(sha1Bi.toString(16));
    }

    /**
     * 获取文件的SHA1值
     */
    public static String getFileSha1(MultipartFile multipartFile) {
        if (multipartFile.getSize() == 0){
            throw new RuntimeException("文件不能为空");
        }
        byte[] buffer = new byte[4096];
        try (InputStream fis = multipartFile.getInputStream()) {
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                sha1.update(buffer, 0, len);
            }
            BigInteger sha1Bi = new BigInteger(1, sha1.digest());
            return sha1Bi.toString(16);
        } catch (IOException | NoSuchAlgorithmException e) {
            return null;
        }
    }

}
