package zhouxu.site.notice.service;

import org.quartz.Job;
import org.quartz.JobDetail;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:任务调度接口定义
 * User: zhouxu
 * Date: 2018-12-06 16:23
 */
public interface BaseScheduleService {
    /**
     * @Author zhouxu
     * @Description //添加一次性任务
     * @Date 2018/12/6 15:56
     * @Param [clazz, jobName, groupName, params]
     * @return void
     * @throws
     **/
    void addOnceJob(Class<? extends Job> clazz, String jobName, String groupName, Map<String, Object> params);

    /**
     * @Author zhouxu
     * @Description //
     * @Date 2018/12/24 22:49
     * @Param [clazz, jobName, groupName,startTime, params]
     * @return void
     * @throws
     **/
    void addOnceJobAt(Class<? extends Job> clazz, String jobName, String groupName, Date startTime, Map<String, Object> params);

    /**
     * @Author zhouxu
     * @Description //添加定时任务
     * @Date 2018/12/6 15:58
     * @Param [clazz, jobName, groupName,cronExpression,params]
     * @return void
     * @throws
     **/
    void addCronJob(Class<? extends Job> clazz, String jobName, String groupName, String cronExpression, Map<String, Object> params);
    /**
     * @Author zhouxu
     * @Description //暂停后继续任务
     * @Date 2018/12/6 16:00
     * @Param [jobName, groupName]
     * @return void
     * @throws
     **/
    void resumeJob(String jobName, String groupName);

    /**
     * @Author zhouxu
     * @Description //暂停任务
     * @Date 2018/12/6 16:00
     * @Param [jobName, groupName]
     * @return void
     * @throws
     **/
    void pauseJob(String jobName, String groupName);

    /**
     * @Author zhouxu
     * @Description //更新任务
     * @Date 2018/12/6 15:36
     * @Param [jobClassName, jobGroupName, cronExpression]
     * @return void
     * @throws
     **/
    void updateCronJob(String jobName, String groupName, String cronExpression, Map<String, Object> params);


    /**
     * @Author zhouxu
     * @Description //删除任务
     * @Date 2018/12/6 15:39
     * @Param [jobClassName, jobGroupName]
     * @return void
     * @throws
     **/
    void deleteJob(String jobName, String groupName) throws Exception;

    /**
     * @Author zhouxu
     * @Description //
     * @Date 2018/12/6 15:42
     * @Param [map]
     * @return org.quartz.JobDetail
     * @throws
     **/
    List<JobDetail> queryJobs(Map<String, Object> map);

    /**
     * @Author zhouxu
     * @Description //通过名称和组获取运行信息详细信息
     * @Date 2018/12/25 16:22
     * @Param [jobName, groupName]
     * @return java.util.Map
     * @throws
     **/
    Map getJobRuntimeInfo(String jobName, String groupName) throws Exception;
}
