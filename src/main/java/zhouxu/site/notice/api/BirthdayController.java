package zhouxu.site.notice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhouxu.site.notice.service.BirthdayScheduleService;
import zhouxu.site.notice.utils.RestResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:提醒服务接口
 * User: zhouxu
 * Date: 2018-12-06 16:50
 */
@RestController
@RequestMapping("/birthday")
public class BirthdayController {

    @Autowired
    private BirthdayScheduleService birthdayScheduleService;

    @GetMapping("/health")
    public RestResult health(String code){
        return RestResult.Success(code);
    }

    /**
     * @Author zhouxu
     * @Description //创建生日提醒任务
     * @Date 2018/12/6 17:01
     * @Param [jobName, groupName, params] date为10-28
     * @return void
     * @throws
     **/
    //jobName:zhouxu->zhouyun
    //toPerson:zhouyun
    //date:11-20
    @PostMapping("/addBirthdayNoticeJob")
    public RestResult addBirthdayNoticeJob(String jobName,String phone,String date,String toPerson){
        Map<String,Object> params = new HashMap<>();
        params.put("phone",phone);
        params.put("date",date);
        params.put("toPerson",toPerson);
        birthdayScheduleService.addBirthdayNoticeJob(jobName,params);
        return RestResult.Success(true);
    }

    /**
     * @Author zhouxu
     * @Description //创建生日礼物任务
     * @Date 2018/12/6 17:01
     * @Param [jobName, groupName, params] date为10-28
     * @return void
     * @throws
     **/
    //jobName:zhouxu->zhouyun
    //toPerson:zhouyun
    //date:11-20
    @PostMapping("/addBirthdayGiftJob")
    public RestResult addBirthdayGiftJob(String jobName,String phone,String date,String toPerson){
        Map<String,Object> params = new HashMap<>();
        params.put("phone",phone);
        params.put("date",date);
        params.put("toPerson",toPerson);
        birthdayScheduleService.addBirthdayGiftJob(jobName,params);
        return RestResult.Success(true);
    }
}
