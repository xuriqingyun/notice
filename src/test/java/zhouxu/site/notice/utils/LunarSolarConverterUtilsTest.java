package zhouxu.site.notice.utils;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: zhouxu
 * Date: 2018-12-24 22:23
 */
public class LunarSolarConverterUtilsTest {

    @Test
    public void lunarYearToGanZhi() {
    }

    @Test
    public void lunarToSolar() throws ParseException {
//        Lunar lunar = new Lunar(2019,6,3);
//        Solar solar = LunarSolarConverterUtils.lunarToSolar(lunar);
//        System.out.println(solar);
        Date date = new Date();
        Date date1 = LunarSolarConverterUtils.lunarToSolar(date);
        System.out.println(DateUtils.format(date1));
    }

    @Test
    public void solarToLunar() throws ParseException {
//        Solar solar = new Solar(2019,12,24);
//
//        Lunar lunar = LunarSolarConverterUtils.solarToLunar(solar);
//
//        System.out.println(lunar);
        Date date = new Date();
        Date date1 = LunarSolarConverterUtils.solarToLunar(date);
        System.out.println(DateUtils.format(date1));
    }

    @Test
    public void getLunar() throws ParseException {
        Date date = new Date();
        Lunar lunar = Lunar.getLunar(date);
        System.out.println(lunar);

        Date date1 = Lunar.getDate(lunar);
        System.out.println(DateUtils.format(date1));

    }
}