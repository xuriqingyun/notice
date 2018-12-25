package zhouxu.site.notice.dao.ipml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhouxu.site.notice.dao.BaseScheduleDao;
import zhouxu.site.notice.utils.JsonUtils;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-25 16:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseScheduleDaoIpmlTest {

    @Autowired
    private BaseScheduleDao baseScheduleDao;

    @Test
    public void getJobRuntimeInfo() throws Exception {
        Map map = baseScheduleDao.getJobRuntimeInfo("生日提醒-周旭->周云-2019-20181225125008", "生日提醒");
        String s = JsonUtils.toJson(map);
        System.out.println(s);
    }
}