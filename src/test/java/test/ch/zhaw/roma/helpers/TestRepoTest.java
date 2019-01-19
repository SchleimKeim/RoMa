package test.ch.zhaw.roma.helpers; 

import ch.zhaw.roma.helpers.TestRepo;
import ch.zhaw.roma.model.BookModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* TestRepo Tester. 
* 
* @author <Authors name> 
* @since <pre>Jan 19, 2019</pre> 
* @version 1.0 
*/ 
public class TestRepoTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getSessionFactory() 
* 
*/ 
@Test
public void testGetSessionFactory() throws Exception {
    Session session = new TestRepo().getSessionFactory().openSession();
    Assert.assertNotNull(session);
}


/** 
* 
* Method: buildSessionFactory() 
* 
*/ 
@Test
public void testBuildSessionFactory() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = TestRepo.getClass().getMethod("buildSessionFactory"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
