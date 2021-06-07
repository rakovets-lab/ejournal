package by.iteen.service;

import by.iteen.config.TestRootConfig;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by Edenmond on 7/16/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestRootConfig.class)
@TestPropertySource(locations = "classpath:database.properties")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public abstract class BaseServiceTest {
}
