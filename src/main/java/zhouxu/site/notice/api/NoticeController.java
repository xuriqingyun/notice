package zhouxu.site.notice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouxu.site.notice.schedule.ExcuteNoticeJob;
import zhouxu.site.notice.service.BaseScheduleService;
import zhouxu.site.notice.utils.DateUtils;
import zhouxu.site.notice.utils.RestResult;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:提醒服务接口
 * User: zhouxu
 * Date: 2018-12-06 16:50
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private BaseScheduleService baseScheduleService;

    @GetMapping("/health")
    public RestResult health(String code){
        return RestResult.Success(code);
    }

    /**
     * @Author zhouxu
     * @Description //创建一次性任务
     * @Date 2018/12/6 17:01
     * @Param [jobName, groupName, params]
     * @return void
     * @throws
     **/
    @PostMapping("/addOnceJob")
    public RestResult addOnceJob(String jobName, String groupName,String phone,String noticeContent){
        Map<String,Object> params = new HashMap<>();
        params.put("phone",phone);
        params.put("noticeContent",noticeContent);
        baseScheduleService.addOnceJob(ExcuteNoticeJob.class,jobName,groupName,params);
        return RestResult.Success(true);
    }

    /**
     * @Author zhouxu
     * @Description //TODO
     * @Date 2018/12/25 11:04
     * @Param [jobName, groupName, phone, date, noticeContent] date为:2018-10-12 10:00:00
     * @return zhouxu.site.notice.utils.RestResult
     * @throws
     **/
    @PostMapping("/addOnceJobAt")
    public RestResult addOnceJobAt(String jobName, String groupName,String phone,String date,String noticeContent) throws ParseException {
        Map<String,Object> params = new HashMap<>();
        params.put("phone",phone);
        params.put("date",date);
        params.put("noticeContent",noticeContent);
        baseScheduleService.addOnceJobAt(ExcuteNoticeJob.class,jobName,groupName,DateUtils.parse(date),params);
        return RestResult.Success(true);
    }

    /**
     * @Author zhouxu
     * @Description //创建定时任务
     * @Date 2018/12/6 17:01
     * @Param [jobName, groupName, cronExpression, params]
     * @return void
     * @throws
     **/
    @PostMapping("/addCronJob")
    public RestResult addCronJob(String jobName,String groupName,String cronExpression,String phone,String noticeContent){
        Map<String,Object> params = new HashMap<>();
        params.put("phone",phone);
        params.put("noticeContent",noticeContent);
        baseScheduleService.addCronJob(ExcuteNoticeJob.class,jobName,groupName,cronExpression,params);
        return  RestResult.Success(true);
    }
}
