package zhouxu.site.notice.utils;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:发送短信工具
 * User: zhouxu
 * Date: 2018-12-24 14:55
 */
public class SmsUtils {

    //本站用户名
    private static final String UID="本站用户名";
    //安全密钥
    private static final String KEY="安全密钥";

    /**
     * @Author zhouxu
     * @Description //发送短信服务
     * @Date 2018/12/24 15:13
     * @Param [phone, content]
     * @return void
     * @throws
     **/
    public static boolean send(String phone,String content) throws IOException {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", UID),new NameValuePair("Key", KEY),new NameValuePair("smsMob",phone),new NameValuePair("smsText",content)};
        post.setRequestBody(data);
        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        post.releaseConnection();
        if("1".equals(result)){
            return true;
        }
        return false;
    }
}
