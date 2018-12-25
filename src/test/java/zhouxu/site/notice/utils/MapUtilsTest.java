package zhouxu.site.notice.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-25 17:29
 */
public class MapUtilsTest {

    @Test
    public void get() {
        Map map = new HashMap<>();
        map.put("key","value");
        Object key1 = MapUtils.get(map, "key1");
        System.out.println(key1+"--");
    }
}