package com.zhoulychn.common.utils;

import java.io.*;
import java.util.*;

/**
 * Created by lewis on 2016/12/22.
 * 工具类：根据属性文件替换页面上的中文为国际化key
 */
public class LanguageTransform {

    public static void main(String[] args) throws IOException {
        /*用来替换i18n的属性文件*/
        String propertiesName = "MallApplicationResources.properties";

        /*vm模板路径，idea直接文件上右键copy path，原样粘贴过来（转义已处理）*/
        //例如：String filePath = "E:\\GIT\\HK-Ocean\\ocean\\src\\main\\webapp\\WEB-INF\\views\\frontend\\default\\template\\mobilecugstore\\my-order.vm";

        String filePath = "";
        execute(propertiesName, filePath);
    }

    /**
     * 执行方法
     *
     * @param propertiesName i18n的属性文件
     * @param vmPath         vm模板路径
     * @throws IOException io异常
     */
    private static void execute(String propertiesName, String vmPath) throws IOException {
        if ("".equals(propertiesName) || "".equals(vmPath)) {
            System.out.println("文件路径错误");
            return;
        }
        String prop = new File("").getCanonicalPath().replace("\\", "/") + "/ocean/src/main/resources/i18n/" + propertiesName;
        try (FileInputStream fis = new FileInputStream(prop)) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(vmPath.replace("\\\\", "/"))));
            Properties properties = new Properties();
            properties.load(fis);
            Map<String, String> map = extract(properties);
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            int value;
            while ((value = bufferedReader.read()) != -1) {
                char item = (char) value;

                /*中文添加到temp*/
                if ((item >= 0x4e00) && (item <= 0x9fbb)) {
                    temp.append(item);
                    continue;
                }

                /*temp没有添加内容*/
                if ("".equals(temp.toString())) {
                    result.append(item);
                    continue;
                }

                String key = map.get(temp.toString());
                if (null != key) {
                    System.out.println(temp.toString() + "<---------------------------->" + key);
                    result.append("#springMessage(\"" + key + "\")");
                } else {
                    result.append(temp);
                }
                result.append(item);
                temp = new StringBuilder();
            }
            bufferedReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(vmPath)));
            bufferedWriter.write(result.toString());
            bufferedWriter.flush();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>success<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        } catch (FileNotFoundException e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>属性文件不存在<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        } catch (IOException e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>读取文件流错误<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }


    private static Map<String, String> extract(Properties properties) {
        Map<String, String> result = new HashMap<>();
        Enumeration<?> keyName = properties.propertyNames();
        while (keyName.hasMoreElements()) {
            String key = (String) keyName.nextElement();
            result.put(properties.getProperty(key), key);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>属性文件读取成功<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return result;
    }
}
