//package org.javatx.controller;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.javatx.pojo.Article;
//import org.javatx.pojo.ArticleInfo;
//import org.javatx.pojo.Tags;
//import org.javatx.service.ArticleService;
//import org.javatx.vue.bean.ArticleListDto;
//import org.javatx.vue.bean.Data;
//import org.javatx.vue.bean.ResponseMessage;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @Author: 胡俊杰
// * @Date: 2020/11/23 10:16
// */
//@RestController
//public class VueController {
//
//    private final ArticleService articleService;
//
//    public VueController( ArticleService articleService) {
//        this.articleService = articleService;
//    }
//
//    //标签  /getTagList?keyword=&pageNum=1&pageSize=100
////    @GetMapping("/getTagList")
////    public ResponseMessage getTagList(String keyword,Integer pageNum,Integer pageSize){
////
////        ResponseMessage responseMessage = new ResponseMessage();
////        responseMessage.setCode(0);
////        responseMessage.setMessage("success");
////        Data data = new Data();
////
////        responseMessage.setData(data);
////        return responseMessage;
////    }
//    //文章 /getArticleList?keyword=&likes=&state=1&tag_id=&category_id=&pageNum=1&pageSize=10
//    @GetMapping("/getArticleList")
//    public ResponseMessage getTagList(String keyword,String state,String categoryId,Integer pageNum,Integer pageSize){
//        ArticleInfo articleInfo = new ArticleInfo(666,66,6);
//        List<String> list = new ArrayList<>();
//        list.add("java");
//        list.add("后端");
//        List<Article> articleList = articleService.findAll();
//
//
//        List<ArticleListDto> articleListDtoList = articleList.stream().map(article -> {
//            ArticleListDto articleListDto = new ArticleListDto();
//            articleListDto.setId(article.getId());
//            articleListDto.setTitle(article.getTitle());
//            articleListDto.setImgUrl(article.getImgUrl());
//            articleListDto.setDesc(article.getMdContent());
//            articleListDto.setArticleInfo(articleInfo);
//            articleListDto.setCreateTime(article.getCreateDate());
//            articleListDto.setTags(list);
//            articleListDto.setCategory(list);
//            return articleListDto;
//        }).collect(Collectors.toList());
//
//
//        ResponseMessage responseMessage = new ResponseMessage();
//        responseMessage.setCode(0);
//        responseMessage.setMessage("success");
//        Data data = new Data();
//        data.setCount(articleListDtoList.size());
//        data.setList(articleListDtoList);
//        responseMessage.setData(data);
//        return responseMessage;
//    }
//
//    // getArticleDetail
//    @PostMapping("/getArticleDetail")
//    public String getArticleDetail(@RequestBody RequestParam param){
//        Integer id = param.getId();
//        Integer type = param.getType();
//        String json = "{\"code\":0,\"message\":\"操作成功 ！\",\"data\":{\"meta\":{\"views\":1434,\"likes\":1,\"comments\":6},\"keyword\":[\"想学得快，就得有自己的服务器来折腾才行\"],\"desc\":\"想学得快，就得有自己的服务器来折腾才行（低于 1 折、89/年、229/3年，比学生机还便宜）\",\"numbers\":\"1663\",\"img_url\":\"https://upload-images.jianshu.io/upload_images/12890819-fda7c243bf14a981?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240\",\"type\":1,\"state\":1,\"origin\":0,\"tags\":[{\"_id\":\"5bf013d2bc1e7805eb83db9d\",\"name\":\"随笔\",\"desc\":\"随笔\",\"create_time\":\"2018-11-17T13:12:50.777Z\",\"update_time\":\"2018-11-17T13:12:50.777Z\",\"id\":7,\"__v\":0}],\"comments\":[{\"user\":{\"name\":\"jeasonzone\",\"type\":2,\"avatar\":\"https://avatars3.githubusercontent.com/u/50410578?v=4\",\"user_id\":\"5df3771c3e4d2516272feb05\"},\"is_top\":false,\"likes\":0,\"state\":1,\"is_handle\":1,\"_id\":\"5df377253e4d2516272feb06\",\"article_id\":\"5de65dd90283dc742f8f633a\",\"content\":\"nice\",\"user_id\":\"5df3771c3e4d2516272feb05\",\"other_comments\":[],\"create_time\":\"2019-12-13T11:33:57.722Z\",\"update_time\":\"2019-12-13T11:33:57.722Z\",\"id\":182,\"__v\":0},{\"user\":{\"name\":\"3460741663\",\"type\":2,\"avatar\":\"https://avatars0.githubusercontent.com/u/37336885?v=4\",\"user_id\":\"5de608390283dc742f8f6330\"},\"is_top\":false,\"likes\":0,\"state\":1,\"is_handle\":1,\"_id\":\"5ec12c7b492f7f464ab9aae2\",\"article_id\":\"5de65dd90283dc742f8f633a\",\"content\":\"大佬，看到你的GitHub，这个项目真的写的很棒\",\"user_id\":\"5de608390283dc742f8f6330\",\"other_comments\":[],\"create_time\":\"2020-05-17T12:22:19.005Z\",\"update_time\":\"2020-05-17T12:22:19.005Z\",\"id\":279,\"__v\":0},{\"user\":{\"name\":\"3460741663\",\"type\":2,\"avatar\":\"https://avatars0.githubusercontent.com/u/37336885?v=4\",\"user_id\":\"5de608390283dc742f8f6330\"},\"is_top\":false,\"likes\":0,\"state\":1,\"is_handle\":1,\"_id\":\"5ec12cb2492f7f464ab9aae3\",\"article_id\":\"5de65dd90283dc742f8f633a\",\"content\":\"借楼，看下接口嗷\",\"user_id\":\"5de608390283dc742f8f6330\",\"other_comments\":[{\"user\":{\"name\":\"3460741663\",\"type\":2,\"avatar\":\"https://avatars0.githubusercontent.com/u/37336885?v=4\",\"user_id\":\"5de608390283dc742f8f6330\"},\"to_user\":{\"name\":\"3460741663\",\"type\":2,\"avatar\":\"https://avatars0.githubusercontent.com/u/37336885?v=4\",\"user_id\":\"5de608390283dc742f8f6330\"},\"likes\":0,\"state\":1,\"create_time\":\"2020-05-17T12:42:44.567Z\",\"_id\":\"5ec13144492f7f464ab9aae4\",\"content\":\"二级评论\"},{\"user\":{\"name\":\"3460741663\",\"type\":2,\"avatar\":\"https://avatars0.githubusercontent.com/u/37336885?v=4\",\"user_id\":\"5de608390283dc742f8f6330\"},\"to_user\":{\"name\":\"3460741663\",\"type\":2,\"avatar\":\"https://avatars0.githubusercontent.com/u/37336885?v=4\",\"user_id\":\"5de608390283dc742f8f6330\"},\"likes\":0,\"state\":1,\"create_time\":\"2020-05-17T12:43:26.308Z\",\"_id\":\"5ec1316e492f7f464ab9aae6\",\"content\":\"三级评论\"}],\"create_time\":\"2020-05-17T12:23:14.597Z\",\"update_time\":\"2020-05-17T12:23:14.597Z\",\"id\":280,\"__v\":0},{\"user\":{\"name\":\"321\",\"type\":1,\"avatar\":\"user\",\"user_id\":\"5ee73f1a5eca6e5233494305\"},\"is_top\":false,\"likes\":0,\"state\":1,\"is_handle\":1,\"_id\":\"5efae6615eca6e5233494346\",\"article_id\":\"5de65dd90283dc742f8f633a\",\"content\":\"哈哈\",\"user_id\":\"5ee73f1a5eca6e5233494305\",\"other_comments\":[],\"create_time\":\"2020-06-30T07:14:41.523Z\",\"update_time\":\"2020-06-30T07:14:41.523Z\",\"id\":289,\"__v\":0}],\"category\":[{\"desc\":\"随笔\",\"_id\":\"5bf4088f245730373274df56\",\"name\":\"随笔\",\"create_time\":\"2018-11-20T13:13:51.304Z\",\"update_time\":\"2018-11-20T13:13:51.304Z\",\"id\":5,\"__v\":0}],\"_id\":\"5de65dd90283dc742f8f633a\",\"title\":\"想学得快，就得有自己的服务器来折腾才行（低至 0.7折、84/年、254/3年，比学生机 114/年 还便宜）\",\"author\":\"biaochenxuying\",\"content\":\"![](https://upload-images.jianshu.io/upload_images/12890819-1180a5ab910befb6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n全栈君觉得每个开发者都应该拥有自己的网站和服务器，这可是很酷的事情，学习 Linux、跑跑脚本、建站、搭博客啥的都行啊。\\n\\n因为全栈君就有自己的服务器，而且有两台了，用于平时的学习，还搭建了自己的网站。\\n\\n有不少读者问过我，**为什么我学的那么快的呢 ？ 怎么在一年内学了那么知识的...**\\n\\n其实也没什么秘决，就是平时有自己的服务器了，就爱折腾，学到的知识能很快得到验证，所以学起来兴致高一点。\\n\\n特别是大三和大四的学生，买了服务器，搭建个项目给面试官看也香，对找工作和面试都加分，还可以熟悉技术栈。\\n\\n\\n## 阿里云\\n\\n\\n之前很多读者问我有没有阿里云组队拉新有优惠，现在来了，阿里云服务器，对新用户直接 0.7 折哦，老用户 9 折哦。\\n\\n现在服务器 84/年、254/3 年，比学生套餐的 9.9元每月 还便宜，还有 2 核 4G 3M 和 2 核 8G 5M 及更高配置的。\\n\\n一台 24 小时不关机的电脑，一年电费都不止 84 元。\\n\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-55d51527aebac1df.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-229680aa8b141d02.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n\\n\\n不是新用户，借用家人朋友身份重新注册新用户，这个价格，重新注册也不亏。\\n\\n**很多朋友问我买哪个好 ？**\\n\\n如果是学生人群，平时练手我建议是 1 核 2g 3 年期的，新用户才 254， 只买一年期真的亏了，因为你下一年又得重新找朋友家人的身份证注册新用户才有优惠了。\\n\\n如果对性能要求比较高，建议直接上 2 核 4g 3 年期的 ，新用户才 664 ，有需要的，直接长按复制。\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-4ddfee501c05c72c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-5f8a45706fa86cb0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n而且企业用户也是用优惠的哦\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-1c75c80f5e7aab5d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n\\n**下面的链接到浏览器注册购买就是最便宜的**\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\\n\\n> 阿里云：https://www.aliyun.com/1111/pintuan-share?ptCode=MTQ4OTc4NzIxNjI3OTk2M3x8MTE0fDE%3D&userCode=g6evk7n0\\n\\n## 腾讯云\\n\\n\\n【腾讯云】11.11 云上盛惠，云产品限时抢购，1 核 2G 云服务器首年 88 元，288元/3年\\n\\n4 核 8G-200G数据盘 只需要 793元/1年。\\n\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-42712a9ffe4b1c8e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-10db03f474f7adcc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n而且老用户续费也有优惠哦：\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-42a4ba6eeb31eb52.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n还有代金券·大礼包：一键领取大额代金券，总价值11000元，新购、续费、升级不用愁\\n\\n![](https://upload-images.jianshu.io/upload_images/12890819-e10d49948d14f834.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)\\n\\n\\n**下面的链接到浏览器注册购买就是最便宜的**\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\\n\\n> 腾讯云：https://cloud.tencent.com/act/cps/redirect?redirect=33867&cps_key=bf4c8d4531fea0e9731181c278a9299c&from=activity\\n\\n## 最好\\n\\n\\n全栈君觉得，阿里和腾讯云因为在竟争、在抢市场，所以优惠力度很大。\\n\\n但是搞了几年的服务器营销了，估计往后的优惠力度会变弱，**早就是优势**。\\n\\n所以越早买越好，最好是买 3 年的那种更划算。\\n\\n最优惠就在这几天了，要买的就赶紧上车了，再过就要再等一年了。\\n\\n\\n再说一遍，**下面的链接到浏览器注册购买就是最便宜的**\uD83D\uDC47\uD83D\uDC47\uD83D\uDC47\\n\\n> 阿里云：https://www.aliyun.com/1111/pintuan-share?ptCode=MTQ4OTc4NzIxNjI3OTk2M3x8MTE0fDE%3D&userCode=g6evk7n0\\n\\n> 腾讯云：https://cloud.tencent.com/act/cps/redirect?redirect=33867&cps_key=bf4c8d4531fea0e9731181c278a9299c&from=activity\\n\",\"like_users\":[{\"name\":\"clearlove520\",\"type\":2,\"introduce\":\"\",\"avatar\":\"https://avatars3.githubusercontent.com/u/44993365?v=4\",\"create_time\":\"2019-12-06T07:36:08.931Z\",\"_id\":\"5dea054c0283dc742f8f634d\",\"id\":\"5dea04e80283dc742f8f634c\"}],\"create_time\":\"2019-12-03T13:06:33.737Z\",\"update_time\":\"2019-12-03T13:06:33.737Z\",\"id\":71,\"__v\":0}}";
//        return json;
//    }
//}
//@Setter@Getter
//class RequestParam{
//    private Integer type;
//    private Integer id;
//}
