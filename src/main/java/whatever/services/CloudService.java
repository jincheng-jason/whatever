package whatever.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.models.CloudUser;
import whatever.models.User;
import whatever.utils.HttpClientUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
* Created by lijc on 15/4/29.
*/
@Service
public class CloudService {

    private static final Logger LOG = LoggerFactory.getLogger(CloudService.class);

    @Autowired
    private ObjectMapper mapper;
//    private static ObjectMapper mapper = new ObjectMapper();

    //创建leancloud用户
    public CloudUser userCreate(User user) throws IOException {

        String url = "https://api.leancloud.cn/1.1/users";
        Map<String,String> params = new HashMap<>();
        params.put("username",user.getPhoneNum());
        params.put("password",user.getPassword());
        String response = HttpClientUtil.post(url,mapper.writeValueAsString(params));
        System.out.println(response);
        if (response.equals("error"))
            return null;
        CloudUser cloudUser = mapper.readValue(response,CloudUser.class);
        return cloudUser;
    }

    public void requestSmsCode(String phoneNum) throws IOException{
        String url = "https://api.leancloud.cn/1.1/requestSmsCode";
        Map<String,String> params = new HashMap<>();
        params.put("mobilePhoneNumber",phoneNum);
        String response = HttpClientUtil.post(url,mapper.writeValueAsString(params));
        System.out.println(response);
    }

    public boolean verifySmsCode(String code,String mobilePhoneNumber) throws IOException{
        String url = "https://api.leancloud.cn/1.1/verifySmsCode/" + code + "?mobilePhoneNumber=" + mobilePhoneNumber;
        String response = HttpClientUtil.post(url,null);
        if (response.equals("error"))
            return false;
        return true;
    }

    public CloudUser usersByMobilePhone(String code,String mobilePhoneNumber) throws IOException{
        String url = "https://api.leancloud.cn/1.1/usersByMobilePhone";
        Map<String,String> params = new HashMap<>();
        params.put("mobilePhoneNumber",mobilePhoneNumber);
        params.put("smsCode",code);
        String response = HttpClientUtil.post(url,mapper.writeValueAsString(params));
        if (response.equals("error"))
            return null;
        CloudUser user = mapper.readValue(response,CloudUser.class);
        return user;
    }

}
