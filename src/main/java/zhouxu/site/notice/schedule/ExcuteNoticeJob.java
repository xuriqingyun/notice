package zhouxu.site.notice.schedule;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zhouxu.site.notice.utils.SmsUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-24 12:00
 */
public class ExcuteNoticeJob extends BaseJob {
    private static Logger logger = LoggerFactory.getLogger(ExcuteNoticeJob.class);
    //设置事件内容
    private String noticeContent;
    //设置事件时间
    private String date;
    //设置电话号码
    private String phone;

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void excuteJob(JobExecutionContext jobExecutionContext) throws Exception {
        //[zhouxu]提醒你
        boolean send = SmsUtils.send(phone, noticeContent);
        if(send){
            logger.info(String.format("phone:%s noticeContent:%s send success!",this.phone,this.noticeContent));
        }else{
            logger.info(String.format("phone:%s noticeContent:%s send failed!",this.phone,this.noticeContent));
        }
    }
}
