package zhouxu.site.notice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouxu.site.notice.schedule.ExcuteShellJob;
import zhouxu.site.notice.service.BaseScheduleService;
import zhouxu.site.notice.utils.RestResult;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-06 16:50
 */
@RestController
@RequestMapping("/shell")
public class ShellController {

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
    public RestResult addOnceJob(String jobName, String groupName){
        baseScheduleService.addOnceJob(ExcuteShellJob.class,jobName,groupName,null);
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
    public RestResult addCronJob(String jobName,String groupName,String cronExpression){
        baseScheduleService.addCronJob(ExcuteShellJob.class,jobName,groupName,cronExpression,null);
        return  RestResult.Success(true);
    }
}
