package zhouxu.site.notice.utils;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:json 工具
 * User: zhouxu
 * Date: 2018-11-26 10:32
 */
public class JsonUtils {

    /**
     * @Author zhouxu
     * @Description 对象转String
     * @Date 2018/11/26 10:33
     * @Param [object]
     * @return java.lang.String
     * @throws
     **/
    public static String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    /**
     * @Author zhouxu
     * @Description //object转map
     * @Date 2018/12/25 17:06
     * @Param [object]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     **/
    public static Map<String,Object> parse(Object object){
        String json = toJson(object);
        return parse(json);
    }

    /**
     * @Author zhouxu
     * @Description //String转map
     * @Date 2018/12/25 17:09
     * @Param [data]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     **/
    public static Map<String,Object> parse(String data){
        Gson gson = new Gson();
        return gson.fromJson(data,Map.class);
    }

    /**
     * @Author zhouxu
     * @Description //String转对象
     * @Date 2018/11/26 10:35
     * @Param [data, tClass]
     * @return T
     * @throws
     **/
    public static <T> T parse(String data,Class<T> tClass){
        Gson gson = new Gson();
        return gson.fromJson(data,tClass);
    }
}
