package ch.zhaw.roma.helpers;

import ch.zhaw.roma.helpers.TestRepo;
import ch.zhaw.roma.model.BookModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/** 
* TestRepo Tester. 
* 
* @author <Authors name> 
* @since <pre>Jan 19, 2019</pre> 
* @version 1.0 
*/ 
public class TestRepoTest {

    /**
     * Method: getSessionFactory()
     */
    @Test
    public void testGetSessionFactory() throws Exception {
        Session session = new TestRepo().getSessionFactory().openSession();
        Assert.assertNotNull(session);
        Assert.assertTrue(session.isOpen());
        session.close();
    }
}
