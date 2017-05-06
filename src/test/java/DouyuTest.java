import com.zhoulychn.bean.entity.AnchorBase;
import com.zhoulychn.bean.entity.AnchorBaseExample;
import com.zhoulychn.common.utils.Validator;
import com.zhoulychn.dao.base.AnchorBaseMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lewis on 2017/1/18.
 * 测试
 */
public class DouyuTest extends BaseTestContext {

    private static final Logger logger = LoggerFactory.getLogger(DouyuTest.class);

    @Autowired
    private AnchorBaseMapper mapper;

    private final String pageUrl = "https://www.douyu.com/directory/all?isAjax=1&page=1";

    private final String baseUrl = "https://www.douyu.com";

    @Test
    public void loadData() {
        List<AnchorBase> list = mapper.selectByExample(new AnchorBaseExample());
        HashMap<String, AnchorBase> data = new HashMap<>(list.size() * 2);
        for (AnchorBase item : list) {
            data.put(item.getUrl(), item);
        }
        try {
            Document document = Jsoup.connect(pageUrl).get();
            Elements rooms = document.getElementsByTag("a");
            for (Element item : rooms) {
                String roomUrl = baseUrl + item.attr("href"); //房间号
                try {
                    String str = item.getElementsByAttributeValue("class", "dy-num fr").get(0).html(); //人数
                    if (!str.contains("万")) {
                        continue;
                    }
                    Double population = Double.parseDouble(str.replace("万", ""));
                    Document roomDocument = Jsoup.connect(roomUrl).get();
                    String title = roomDocument.title();    //标题
                    String name = roomDocument.getElementsByAttributeValue("class", "zb-name").get(0).html();   //姓名
                    if (Validator.isBlank(name))
                        continue;
                    Elements divs = roomDocument.getElementsByAttributeValue("class", "column-body");//人数div列表
                    String groupNumber = this.extract(divs);

                    AnchorBase anchorBase = data.get(roomUrl);
                    if (null == anchorBase) {
                        anchorBase = new AnchorBase();
                        anchorBase.setUrl(roomUrl);
                        anchorBase.setName(name);
                        anchorBase.setPopluation(population);
                        anchorBase.setTitle(title);
                        anchorBase.setGroupNumber(groupNumber);
                        anchorBase.setPlatform("douyu");
                        anchorBase.setUpdateTime(new Date());
                        mapper.insertSelective(anchorBase);
                    } else {
                        anchorBase.setName(name);
                        anchorBase.setPopluation(this.compare(anchorBase.getPopluation(), population));
                        anchorBase.setTitle(title);
                        if (!"1".equals(anchorBase.getState()))
                            anchorBase.setGroupNumber(groupNumber);
                        anchorBase.setUpdateTime(new Date());
                        mapper.updateByPrimaryKeySelective(anchorBase);
                    }
                    System.out.println(anchorBase);
                } catch (Exception e) {
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>业务异常," + roomUrl + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                }
            }
        } catch (RuntimeException e) {
            System.out.println("数据库操作异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("网络连接异常");
            e.printStackTrace();
        }
    }

    private String extract(Elements divs) {
        List<String> list = new ArrayList<>();
        for (Element element : divs) {

            String value = null;
            /*qq群链接*/
            if (element.getElementsByTag("a").size() != 0) {
                value = element.getElementsByTag("a").get(0).attr("data-qqgroup");
                if (!Validator.isBlank(value)) {
                    list.add(value);
                    continue;
                }
            }

            /*HTML中匹配*/
            String str = element.html();
            int index = str.indexOf("群");
            if (index == -1) {
                continue;
            }
            try {
                str = str.substring(index + 1, index + 15);
            } catch (Exception e) {
                str = str.substring(index + 1);
            }
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String matched = matcher.group(0);
                if (matched.length() >= 5)
                    list.add(matched);
            }
        }
        if (list.size() == 0)
            return null;
        StringBuilder sb = new StringBuilder().append("[");
        for (String str : list) {
            sb.append(str).append(",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        return substring + "]";
    }

    private Double compare(Double v1, Double v2) {
        return v1 >= v2 ? v1 : v2;
    }
}
