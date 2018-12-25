package zhouxu.site.notice.service.ipml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhouxu.site.notice.schedule.ExcuteBirthdayJob;
import zhouxu.site.notice.service.BaseScheduleService;
import zhouxu.site.notice.service.BirthdayScheduleService;
import zhouxu.site.notice.utils.DateUtils;
import zhouxu.site.notice.utils.LunarSolarConverterUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:生日提醒服务实现
 * User: zhouxu
 * Date: 2018-12-24 22:48
 */
@Service
public class BirthdayScheduleServiceImpl implements BirthdayScheduleService {

    private Logger logger = LoggerFactory.getLogger(BirthdayScheduleServiceImpl.class);
    //设置提醒年限
    private static int INTERVAL=8;
    //设置开始提醒时间
    private static int START_NOTICE=Calendar.getInstance().get(Calendar.YEAR);

    @Autowired
   private BaseScheduleService baseScheduleService;

    //jobName:zhouxu->zhouyun
    //toPerson:zhouyun
    //date:11-20
    @Override
    public void addBirthdayNoticeJob(String jobName,Map<String, Object> params) {
        String postfix = params.get("date").toString();
        String toPerson = params.get("toPerson").toString();
        params.put("noticeContent","祝"+toPerson+"生日快乐!");
        jobName="生日提醒-"+jobName;
        String groupName="生日提醒";
        for(int i=0;i<INTERVAL;i++){
            //确定日期的时间设置
            String noticeTime=(START_NOTICE+i)+"-"+postfix+" 9:00:0";
            try {
                //阴历
                Date lunarYesterday = DateUtils.getYesterday(noticeTime);
                Date date = LunarSolarConverterUtils.lunarToSolar(lunarYesterday);
                date.setHours(9);
                date.setMinutes(0);
                date.setMinutes(0);
                String newJobName=jobName;
                newJobName = newJobName+"-"+(START_NOTICE+i);
                logger.info(String.format("jobName:%s 下次触发时间为:%s",newJobName,DateUtils.format(date)));
                baseScheduleService.addOnceJobAt(ExcuteBirthdayJob.class,newJobName,groupName,date,params);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    //jobName:zhouxu->zhouyun
    //toPerson:zhouyun
    //date:11-20
    @Override
    public void addBirthdayGiftJob(String jobName, Map<String, Object> params) {
        String postfix = params.get("date").toString();
        String toPerson = params.get("toPerson").toString();
        params.put("noticeContent",toPerson+"生日 记得提前准备礼物！");
        jobName="生日礼物-"+jobName;
        String groupName="生日礼物";
        for(int i=0;i<INTERVAL;i++){
            //确定日期的时间设置
            String noticeTime=(START_NOTICE+i)+"-"+postfix+" 9:00:0";
            try {
                //阴历
                Date lunarYesterday = DateUtils.getAWakeAgo(noticeTime);
                Date date = LunarSolarConverterUtils.lunarToSolar(lunarYesterday);
                date.setHours(9);
                date.setMinutes(0);
                date.setMinutes(0);
                String newJobName=jobName;
                newJobName = newJobName+"-"+(START_NOTICE+i);
                logger.info(String.format("jobName:%s 下次触发时间为:%s",newJobName,DateUtils.format(date)));
                baseScheduleService.addOnceJobAt(ExcuteBirthdayJob.class,newJobName,groupName,date,params);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
