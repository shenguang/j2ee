package littiletest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @className DiamondParse
 * @Description
 * @Date 2019/8/14 14:37
 * @Author shenguang
 * @Version 1.0
 **/
public class DiamondParse {
    /* *
     * @Author shenguang
     * @Description //目标地区是否在diamond中开放的地区当中
     * @Date 15:50 2019/8/14
     * @Param [diamondCityStr:42@2&3&4,53@7&8&9, targetIdcard(身份证头两位):42, targetCity(城市id):11]
     * @return boolean true:没有禁止该城市，false：禁止该城市
     **/
    public static boolean parseAbleCity(String diamondCityStr,String targetIdcard,String targetCity){
        if(StringUtils.isBlank(diamondCityStr)){
            return true;
        }
        String[] split = diamondCityStr.split(",");
        for (String str : split) {
            String[] citys = str.split("@");
            if(citys[0].equals(targetIdcard)){
                if(citys.length==2){
                    String[] split2 = citys[1].split("&");
                    return ArrayUtils.contains(split2,targetCity);
                }
                return false;
            }
        }
        return true;
    }

    /* *
     * @Author shenguang
     * @Description //目标少数名族是否在diamond中禁止的名族当中
     * @Date 16:21 2019/8/14
     * @Param [minorities：维吾尔族，藏族, targetMinorities：汉]
     * @return boolean ：禁止，false没有
     **/
    public static boolean parseUnableMinorities(String minorities,String targetMinorities){
        if(StringUtils.isBlank(minorities)){
            return false;
        }
        String[] split = minorities.split(",");
        return ArrayUtils.contains(split,targetMinorities);
    }


    public static void main(String[] args) {
        parseAbleCity("42@2&3&4,53@7&8&9","42","6");
        System.out.println( parseUnableMinorities("维吾尔族,藏族",null));
    }
}
