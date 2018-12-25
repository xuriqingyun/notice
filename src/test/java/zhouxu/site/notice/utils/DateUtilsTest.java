package zhouxu.site.notice.utils;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-25 9:41
 */
public class DateUtilsTest {

    @Test
    public void getYesterday() throws ParseException {
        String dateStr="2019-1-1 9:30:0";
        Date yesterday = DateUtils.getYesterday(dateStr);
        System.out.println(DateUtils.format(yesterday));
    }
}