package zhouxu.site.notice.service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:生日通知服务
 * User: zhouxu
 * Date: 2018-12-24 22:46
 */
public interface BirthdayScheduleService {
    /**
     * @Author zhouxu
     * @Description //生日提醒(提前一天)
     * @Date 2018/12/25 12:23
     * @Param [jobName, groupName, params]
     * @return void
     * @throws
     **/
    void addBirthdayNoticeJob(String jobName,Map<String, Object> params);
    /**
     * @Author zhouxu
     * @Description //生日礼物提醒
     * @Date 2018/12/25 12:24
     * @Param [jobName, groupName, params]
     * @return void
     * @throws
     **/
    void addBirthdayGiftJob(String jobName,Map<String, Object> params);
}
