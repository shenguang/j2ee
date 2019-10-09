package java8.javadate;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class TestSign {


    public static void main(String[] args) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("phone", "18301256254");
        params.put("name", "sg");
        params.put("idCardNum", "411522199307041589");
        params.put("appKey", "8B9FZFDMFFE64E949089661ABBCF6616");
        params.put("appSecret", "823A6E72E6ZF4AC1122AFC3G0369DF8F");
        params.put("reason", "就是拉黑你");
        params.put("status", 2);
        params.put("source", 6);
        String signStr = generateSign(params);
        //生成验签sign
        System.out.println(signStr);
    }

    private static String generateSign(HashMap<String, Object> params)  {
        List<String> keyList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() == null || "sign".equals(entry.getKey())) {
                continue;
            }
            keyList.add(entry.getKey());
        }
        Collections.sort(keyList);
        StringBuilder paramValues = new StringBuilder();
        for (String key : keyList) {
            try {
                if (StringUtils.isBlank(paramValues.toString())) {
                    paramValues.append(key).append("=").append(URLDecoder.decode(params.get(key).toString(), "UTF-8"));
                }
                paramValues.append("&").append(key).append("=").append(URLDecoder.decode(params.get(key).toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                System.out.println("......");
            }
        }
        return DigestUtils.md5Hex(paramValues.toString()).toUpperCase();
    }
}
