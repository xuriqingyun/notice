package zhouxu.site.notice.utils;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:map获取工具
 * User: zhouxu
 * Date: 2018-12-25 17:25
 */
public class MapUtils {

    /**
     * @Author zhouxu
     * @Description //通过级联的方式获取对象
     * @Date 2018/12/25 17:27
     * @Param [data, key]
     * @return java.lang.Object
     * @throws
     **/
    public static Object get(Map<String,Object> data,String key){
        if(key.indexOf(".")==-1){
            Object value = data.get(key);
            if(value==null){
                return "";
            }else{
                return data.get(key);
            }
        }else{

            String[] splitsKey = key.split("\\.");
            Object value =data;
            for(String splitKey:splitsKey){
                value=((Map)value).get(splitKey);
                if(value==null){
                    break;
                }
            }
            return value==null?"":value;
        }
    }
}
