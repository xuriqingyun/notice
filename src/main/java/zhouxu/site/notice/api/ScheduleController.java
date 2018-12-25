package zhouxu.site.notice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouxu.site.notice.service.BaseScheduleService;
import zhouxu.site.notice.utils.RestResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-06 16:50
 */
@RestController
public class ScheduleController {

    @Autowired
    private BaseScheduleService baseScheduleService;

    @GetMapping("/health")
    public RestResult health(String code){
        return RestResult.Success(code);
    }

    /**
     * @Author zhouxu
     * @Description //暂停任务
     * @Date 2018/12/7 10:23
     * @Param [jobName, groupName, cronExpression]
     * @return zhouxu.site.jobpublish.utils.RestResult
     * @throws
     **/
    @PostMapping("/pauseJob")
    public RestResult pauseJob(String jobName,String groupName){
        baseScheduleService.pauseJob(jobName,groupName);
        return  RestResult.Success(true);
    }

    /**
     * @Author zhouxu
     * @Description //暂停后继续任务
     * @Date 2018/12/7 10:24
     * @Param [jobName, groupName, cronExpression]
     * @return zhouxu.site.jobpublish.utils.RestResult
     * @throws
     **/
    @PostMapping("/resumeJob")
    public RestResult resumeJob(String jobName,String groupName){
        baseScheduleService.resumeJob(jobName,groupName);
        return  RestResult.Success(true);
    }

    /**
     * @Author zhouxu
     * @Description //删除任务
     * @Date 2018/12/7 10:24
     * @Param [jobName, groupName, cronExpression]
     * @return zhouxu.site.jobpublish.utils.RestResult
     * @throws
     **/
    @PostMapping("/deleteJob")
    public RestResult deleteJob(String jobName,String groupName) throws Exception {
        baseScheduleService.deleteJob(jobName,groupName);
        return  RestResult.Success(true);
    }

    /**
     * @Author zhouxu
     * @Description //更新任务
     * @Date 2018/12/7 10:24
     * @Param [jobName, groupName, cronExpression]
     * @return zhouxu.site.jobpublish.utils.RestResult
     * @throws
     **/
    @PostMapping("/updateCronJob")
    public RestResult updateCronJob(String jobName,String groupName, String cronExpression,String phone,String date,String noticeContent)  {
        Map<String,Object> params = new HashMap<>();
        params.put("phone",phone);
        params.put("noticeContent",noticeContent);
        baseScheduleService.updateCronJob(jobName,groupName,cronExpression,params);
        return  RestResult.Success(true);
    }
}
