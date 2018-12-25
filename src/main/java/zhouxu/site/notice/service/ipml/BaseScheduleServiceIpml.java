package zhouxu.site.notice.service.ipml;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhouxu.site.notice.dao.BaseScheduleDao;
import zhouxu.site.notice.service.BaseScheduleService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:任务调度服务实现
 * User: zhouxu
 * Date: 2018-12-06 16:24
 */
@Service
public class BaseScheduleServiceIpml implements BaseScheduleService {

    private Logger logger = LoggerFactory.getLogger(BaseScheduleServiceIpml.class);

    @Autowired
    private BaseScheduleDao baseScheduleDao;

    @Override
    public void addOnceJob(Class<? extends Job> clazz, String jobName, String groupName, Map<String, Object> params) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String postfix=simpleDateFormat.format(date);
        jobName= jobName+"-"+postfix;
        String info="add task =>{clazz:%s,jobName:%s,groupName:%s";
        List<Object> values=new ArrayList<Object>();
        values.add(clazz.toString());
        values.add(jobName);
        values.add(groupName);
        if(params==null||params.size()==0){
            info+="}";
        }else{
            for(String key:params.keySet()){
                info+=","+key+":%s";
                values.add(params.get(key).toString());
            }
            info+="}";
        }
        logger.info(String.format(info,values.toArray()));
        baseScheduleDao.addOnceJob(clazz,jobName,groupName,params);
    }

    @Override
    public void addOnceJobAt(Class<? extends Job> clazz, String jobName, String groupName, Date startTime, Map<String, Object> params) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String postfix=simpleDateFormat.format(date);
        jobName= jobName+"-"+postfix;
        String info="add task =>{clazz:%s,jobName:%s,groupName:%s";
        List<Object> values=new ArrayList<Object>();
        values.add(clazz.toString());
        values.add(jobName);
        values.add(groupName);
        if(params==null||params.size()==0){
            info+="}";
        }else{
            for(String key:params.keySet()){
                info+=","+key+":%s";
                values.add(params.get(key).toString());
            }
            info+="}";
        }
        logger.info(String.format(info,values.toArray()));
        baseScheduleDao.addOnceJobAt(clazz,jobName,groupName,startTime,params);
    }

    @Override
    public void addCronJob(Class<? extends Job> clazz, String jobName, String groupName, String cronExpression, Map<String, Object> params) {
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
        logger.info(String.format(info,values.toArray()));
        baseScheduleDao.addCronJob(clazz,jobName,groupName,cronExpression,params);
    }

    @Override
    public void resumeJob(String jobName, String groupName) {
        baseScheduleDao.resumeJob(jobName,groupName);
    }

    @Override
    public void pauseJob(String jobName, String groupName) {
        baseScheduleDao.pauseJob(jobName,groupName);
    }

    @Override
    public void updateCronJob(String jobName, String groupName, String cronExpression, Map<String, Object> params) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String postfix=simpleDateFormat.format(date);
        jobName= jobName+"-"+postfix;
        String info="update task =>{jobName:%s,groupName:%s,cronExpression:%s";
        List<Object> values=new ArrayList<Object>();
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
        logger.info(String.format(info,values.toArray()));
        baseScheduleDao.updateCronJob(jobName,groupName,cronExpression,params);
    }

    @Override
    public void deleteJob(String jobName, String groupName) throws Exception {
        baseScheduleDao.deleteJob(jobName,groupName);
    }

    @Override
    public List<JobDetail> queryJobs(Map<String, Object> map) {
        return baseScheduleDao.queryJobs(map);
    }
}
