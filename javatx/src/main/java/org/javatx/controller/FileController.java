package org.javatx.controller;

import org.javatx.common.ResultException;
import org.javatx.common.UploadResultEnum;
import org.javatx.pojo.FileBean;
import org.javatx.pojo.ResultVo;
import org.javatx.service.FileService;
import org.javatx.utils.ALYUtil;
import org.javatx.utils.FileUtil;
import org.javatx.utils.ResultVoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: 胡俊杰
 * @Date: 2020/8/5 9:41
 */
@Controller
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 上传web格式图片
     */
    @PostMapping("/file/image")
    @ResponseBody
    public ResultVo<FileBean> uploadImage(@RequestParam("image") MultipartFile multipartFile) {

        // 创建Upload实体对象
        FileBean fileBean = FileUtil.getFile(multipartFile);
        try {
            return saveImage(multipartFile, fileBean);
        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传图片失败");
        }
    }
    /**
     * 保存上传的web格式图片
     */
    private ResultVo saveImage(MultipartFile multipartFile, FileBean fileBean) throws IOException, NoSuchAlgorithmException {
        // 判断是否为支持的图片格式
        String[] types = {
                "image/gif",
                "image/jpg",
                "image/jpeg",
                "image/png", "image/bmp"
        };
        if(!FileUtil.isContentType(multipartFile, types)){
            throw new ResultException(UploadResultEnum.NO_FILE_TYPE);
        }

        // 判断图片是否存在
        FileBean uploadSha1 = fileService.getBySha1(FileUtil.getFileSha1(multipartFile));
        if (uploadSha1 != null) {
            return ResultVoUtil.success(uploadSha1);
        }

        //保存到本地
        //FileUtil.transferTo(multipartFile, fileBean);
        //保存到阿里云oss
        ALYUtil.transferTo(multipartFile, fileBean);
        // 将文件信息保存到数据库中
        fileService.save(fileBean);
        return ResultVoUtil.success(fileBean);
    }
}
