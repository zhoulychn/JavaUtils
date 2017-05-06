import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lewis on 2017/1/18.
 * 数据库连接测试环境
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/spring-database.xml")
public class BaseTestContext extends AbstractJUnit4SpringContextTests {

    @Before
    public void before() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Testing Start<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    @After
    public void after() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Testing End<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
