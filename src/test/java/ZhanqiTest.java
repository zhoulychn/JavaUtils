import com.zhoulychn.bean.entity.AnchorBase;
import com.zhoulychn.bean.entity.AnchorBaseExample;
import com.zhoulychn.common.utils.Validator;
import com.zhoulychn.dao.base.AnchorBaseMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lewis on 2017/1/18.
 * 测试
 */
public class ZhanqiTest extends BaseTestContext {

    private static final Logger logger = LoggerFactory.getLogger(ZhanqiTest.class);

    @Autowired
    private AnchorBaseMapper mapper;

    private final String pageUrl = "https://www.zhanqi.tv/lives";

    private final String baseUrl = "https://www.zhanqi.tv";

    //    @Test
    public void loadData() throws Exception {
        List<AnchorBase> list = mapper.selectByExample(new AnchorBaseExample());
        HashMap<String, AnchorBase> data = new HashMap<>(list.size() * 2);
        for (AnchorBase item : list) {
            data.put(item.getUrl(), item);
        }
        Element roomContainer = Jsoup.connect(pageUrl).get().getElementById("hotList");
        try {
            for (Element item : roomContainer.getElementsByTag("a")) {
                String temp = item.getElementsByAttributeValue("class", "dv").get(0).html();    //人数
                if (!temp.contains("万"))
                    continue;
                Double population = Double.parseDouble(temp.replace("万", ""));
                String roomUrl = item.attr("href") + baseUrl;

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
            }
        } catch (RuntimeException e) {
        } catch (IOException e) {
        }
    }
}

