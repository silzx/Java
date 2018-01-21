package com.zl.service;

import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.zl.service.inter.InterfaceService;
import com.zl.tool.contool;

@Service
public class InterfaceServiceImpl implements InterfaceService{

	@Override
	public JSONObject phone(String phone,String content) {
		JSONObject json = new JSONObject();
		
		
		try {
			content = URLEncoder.encode(content, "UTF-8");
			System.out.println(content);
			json.put("type", "短信验证接口");
			if(phone!=null){
				contool c = new contool();
				String fh = c.get("https://way.jd.com/BABO/sms?mobile="+phone+"&msg="+content+"&appkey=16ac6d2b603729fed36d1cafcd12ad9a");				
				json.put("re", "返回成功");
				json.put("phone", new JSONObject(fh));
			}else{
			
				json.put("re", "返回失败");
			}
			
		} catch (Exception e) {
			try {
				json.put("re", "返回失败");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		
		return json;
	}

}
