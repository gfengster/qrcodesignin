package org.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hutool.extra.qrcode.QrCodeUtil;

@Controller
public class QRController {
	@Autowired
	QRService userService;
	/**
     * 确认身份接口：确定身份以及判断是否二维码过期等
     * @param token
     * @param userId
     * @return
     */
    @RequestMapping(value = "/bindUserIdAndToken" ,method = RequestMethod.GET)
    @ResponseBody
    public Object bindUserIdAndToken(@RequestParam("token") String token ,
                                     @RequestParam("userId") Integer userId,
                                     @RequestParam(required = false,value = "projId") Integer projId){
 
        try {
            
        	userService.bindUserIdAndToken(userId,token,projId);
        	return new SuccessTip("Will be in ");
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorTip(500,e.getMessage());
        }
 
    }
    
    @RequestMapping(value = "/user/getLoginQr" ,method = RequestMethod.GET)
    public void createCodeImg(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
 
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
 
        try {
            //这里没啥操作 就是生成一个UUID插入 数据库的表里
            String uuid = "1234ABC";
            response.setHeader("uuid", uuid);
            // 这里是开源工具类 hutool里的QrCodeUtil 
            // 网址：http://hutool.mydoc.io/
            QrCodeUtil.generate(uuid, 300, 300, "jpg",response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
