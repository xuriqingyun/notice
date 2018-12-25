package zhouxu.site.notice.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhouxu.site.notice.exception.BizException;
import zhouxu.site.notice.utils.ObjectUtils;


/**
 * Created with IntelliJ IDEA.
 * Description:基础任务类定义统一任务实现接口
 * User: zhouxu
 * Date: 2018-12-07 9:30
 */
public abstract class BaseJob implements Job {

    private Logger logger = LoggerFactory.getLogger(BaseJob.class);
    //任务名称
    private String jobName;

    //所属组
    private String groupName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @Author zhouxu
     * @Description //任务逻辑实现接口
     * @Date 2018/12/7 9:33
     * @Param [jobExecutionContext]
     * @return void
     * @throws
     **/
    public abstract void excuteJob(JobExecutionContext jobExecutionContext) throws Exception;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //注入jobName/groupName
        this.setJobName(jobExecutionContext.getJobDetail().getKey().getName());
        this.setGroupName(jobExecutionContext.getJobDetail().getKey().getGroup());
        //自动注入其他属性
        ObjectUtils.map2Object(this,jobExecutionContext.getMergedJobDataMap());
        logger.info(String.format("[jobName:%s,groupName%s]>>>>>>>>>>>>>>>>>>>>>>>>>>>>started",this.jobName,this.groupName));
        try {
            excuteJob(jobExecutionContext);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(e.getMessage());
        }
        logger.info(String.format("[jobName:%s,groupName%s]============================finished",this.jobName,this.groupName));
    }
}
