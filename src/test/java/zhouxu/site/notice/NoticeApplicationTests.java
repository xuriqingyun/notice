package zhouxu.site.notice;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhouxu.site.notice.schedule.ExcuteNoticeJob;

import java.text.SimpleDateFormat;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class NoticeApplicationTests {

    @Test
    public void contextLoads() {
        Logger logger = LoggerFactory.getLogger(NoticeApplicationTests.class);
        String jobName="jobName";
        Class clazz = ExcuteNoticeJob.class;
        String groupName="DEFAULT";
        String cronExpression="0 15 17 24 12 ? ";
        Map<String,Object> params = new HashMap<>();
        params.put("key","value");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String postfix=simpleDateFormat.format(date);
        jobName= jobName+"-"+postfix;
        String info="add task =>{clazz:%s,jobName:%s,groupName:%s,cronExpression:%s";
        List<String> values=new ArrayList<String>();
        values.add(clazz.toString());
        values.add(jobName);
        values.add(groupName);
        values.add(cronExpression);
        if(params==null||params.size()==0){
            info+="}";
        }else{
            for(String key:params.keySet()){
                info+=","+key+":%s";
                values.add(params.get(key).toString());
            }
            info+="}";
        }
        logger.info(Arrays.toString(values.toArray()));
        logger.info(String.format(info,values.toArray()));
    }

}

