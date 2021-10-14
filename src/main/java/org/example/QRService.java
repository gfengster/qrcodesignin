package org.example;

import java.util.Date;

import org.springframework.stereotype.Service;

import cn.hutool.json.JSONObject;


@Service
public class QRService {

	public String bindUserIdAndToken(Integer userId, String token,Integer projId) throws Exception {
 
//        QrLoginToken qrLoginToken = new QrLoginToken();
//        qrLoginToken.setToken(token);
//        qrLoginToken = qrLoginTokenMapper.selectOne(qrLoginToken);
// 
//        if(null == qrLoginToken){
//            throw  new Exception("错误的请求！");
//        }
// 
//        Date createDate = new Date(qrLoginToken.getCreateTime().getTime() + (1000 * 60 * 1));
//        Date nowDate = new Date();
//        if(nowDate.getTime() > createDate.getTime()){//当前时间大于校验时间
// 
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("code",500);
//            jsonObject.put("msg","二维码失效！");
//            WebSocketServer.sendInfo(jsonObject.toJSONString(2),token);
// 
//            throw  new Exception("二维码失效！");
//        }
// 
//        qrLoginToken.setLoginTime(new Date());
//        qrLoginToken.setUserId(userId);
// 
//        int i = qrLoginTokenMapper.updateById(qrLoginToken);
// 
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",200);
//        jsonObject.put("msg","ok");
//        jsonObject.put("userId",userId);
//        if(ToolUtil.isNotEmpty(projId)){
//            jsonObject.put("projId",projId);
//        }
//        WebSocketServer.sendInfo(jsonObject.toJSONString(),token);
 
//        if(i > 0 ){
//            return null;
//        }else{
//            throw  new Exception("服务器异常！");
//        }
		
		JSONObject jsonObject = new JSONObject();
      jsonObject.put("code",200);
      jsonObject.put("msg","ok");
      jsonObject.put("userId",userId);
      
          jsonObject.put("projId",projId);
      
		 WebSocketServer.sendInfo(jsonObject.toJSONString(2),"1234ABC");
		 
		 return null;
    }
}
