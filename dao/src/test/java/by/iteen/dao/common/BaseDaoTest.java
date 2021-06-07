package by.iteen.dao.common;

import by.iteen.config.TestConfig;
import by.iteen.entity.BaseEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public abstract class BaseDaoTest<T extends BaseEntity> {

    protected abstract BaseDao<T> getDao();

    protected abstract T getModel();

    @Test
    public void testSave(){
        T model = getModel();
        getDao().save(model);
        T entity = getDao().findOne(1L);
        assertNotNull(entity);
    }

    @Test
    public void testUpdate(){
        T model = getModel();
        getDao().save(model);

        T model2 = getModel();
        getDao().update(model);

        List<T> entity = getDao().findAll();
        assertNotNull(entity);
        assertNotSame(model, model2);
    }

    @Test
    public void testDelete(){
        T model = getModel();
        getDao().save(model);
        getDao().delete(model);
        T entity = getDao().findOne(1L);
        assertNull(entity);
    }
}
