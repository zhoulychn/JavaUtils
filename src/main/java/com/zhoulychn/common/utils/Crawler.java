package com.zhoulychn.common.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lewis on 2017/1/16.
 * 爬虫
 */
public class Crawler {

    public static void main(String[] args) throws Exception {
        Crawler.loadZhanqi();
//        Crawler.loadDouyu();
    }

    public static void loadZhanqi() throws Exception {
        String all = "https://www.zhanqi.tv/lives";
        String baseUrl = "https://www.zhanqi.tv";
        String filePath = "C:/Users/lewis/Desktop/zhanqi.properties";

        FileInputStream fis = new FileInputStream(filePath);
        Properties prop = new Properties();
        prop.load(fis);
        List<String> names = new ArrayList<>();
        Enumeration<String> propertyNames = (Enumeration<String>) prop.propertyNames();
        while (propertyNames.hasMoreElements()) {
            names.add(propertyNames.nextElement());
        }

        Element roomContainer = Jsoup.connect(all).get().getElementById("hotList");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)))) {
            bufferedWriter.write(new Date().toString() + "=" + new Date().toString());
            bufferedWriter.newLine();
            for (Element item : roomContainer.getElementsByTag("a")) {
                String size = item.getElementsByAttributeValue("class", "dv").get(0).html();
                if (!size.contains("万"))
                    continue;
                String roomUrl = item.attr("href");
                if (names.contains(roomUrl))
                    continue;
                Document room = Jsoup.connect(baseUrl + roomUrl).get();
                if (Validator.isEmpty(room.getElementById("js-room-module-area")))
                    continue;
                String detail = room.getElementById("js-room-module-area").html();
                int index = detail.indexOf("群");
                if (index == -1)
                    continue;
                detail = detail.substring(index + 1, index + 16);
                String value = null;
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(detail);
                while (matcher.find()) {
                    String matched = matcher.group(0);
                    if (matched.length() >= 5 && (value == null || matched.length() >= value.length()))
                        value = matched;
                }
                if (Validator.isBlank(value))
                    continue;
                String str = roomUrl + "=" + value + "----" + size;
                System.out.println(str);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }
    }

    public static void loadDouyu() throws Exception {
        String pageUrl = "https://www.douyu.com/directory/all?isAjax=1&page=";
        String baseUrl = "https://www.douyu.com";
        String filePath = "C:/Users/lewis/Desktop/douyu.properties";

        FileInputStream fis = new FileInputStream(filePath);
        Properties prop = new Properties();
        prop.load(fis);

        List<String> names = new ArrayList<>();
        Enumeration<String> propertyNames = (Enumeration<String>) prop.propertyNames();
        while (propertyNames.hasMoreElements()) {
            names.add(propertyNames.nextElement());
        }
            /*获取群号*/
        List<String> list = new ArrayList<>();
        for (Object item : prop.values()) {
            String temp = (String) item;
            list.add(temp.split("----")[0]);
        }
        fis.close();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true)))) {
            bufferedWriter.write(new Date().toString() + "=" + new Date().toString());
            bufferedWriter.newLine();
            int i = 1;
            Document document = Jsoup.connect(pageUrl + i).get();
            Elements rooms = document.getElementsByTag("a");
            for (Element item : rooms) {
                try {
                    String size = item.getElementsByAttributeValue("class", "dy-num fr").get(0).html(); //人数
                    if (!size.contains("万"))
                        continue;
                    String roomUrl = item.attr("href"); //房间号
                    if (names.contains(roomUrl))
                        continue;
                    Document roomDocument = Jsoup.connect(baseUrl + roomUrl).get();
                    Elements divs = roomDocument.getElementsByAttributeValue("class", "column-body");
                    for (Element div : divs) {
                        String value = Crawler.findValue(div);  //群号
                        if (!Validator.isBlank(value) && !list.contains(value)) {
                            names.add(roomUrl);
                            String entry = roomUrl + "=" + value + "----" + size;
                            System.out.println(entry);
                            bufferedWriter.write(entry);
                            bufferedWriter.newLine();
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("异常");
                }
            }
            bufferedWriter.flush();
        }
    }

    /**
     * 寻找column-body下的数据
     *
     * @param element 元素
     * @return 数据
     */
    public static String findValue(Element element) {
        String value = null;
        if (element.getElementsByTag("a").size() != 0) {
            value = element.getElementsByTag("a").get(0).attr("data-qqgroup");
            if (!Validator.isBlank(value))
                return value;
        }
        String str = element.html();
        int index = str.indexOf("群");
        if (index == -1) {
            return value;
        }
        try {
            str = str.substring(index + 1, index + 13);
        } catch (Exception e) {
            return null;
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String matched = matcher.group(0);
            if (matched.length() >= 5 && (value == null || matched.length() >= value.length()))
                value = matched;
        }
        return value;
    }

    /**
     * 读取每一行文件
     *
     * @param filePath 文件路径
     * @return LinkedHashSet
     * @throws Exception 异常
     */
    public static LinkedHashSet<String> loadExist(String filePath) throws Exception {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String temp = null;
            while ((temp = br.readLine()) != null) {// 使用readLine方法，一次读一行
                System.out.println(temp);
                set.add(temp);
            }
        }
        return set;
    }

    public static class Anchor {
        private String name;
        private String url;
        private String population;
        private String groupNumber;
    }
}
