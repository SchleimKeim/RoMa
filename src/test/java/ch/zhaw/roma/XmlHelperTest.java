package ch.zhaw.roma;

import ch.zhaw.roma.model.RoMaSettings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/** 
* XmlHelper Tester. 
* 
* @author Mathias Mader
* @since <pre>Dec 30, 2018</pre> 
* @version 1.0 
*/ 
public class XmlHelperTest {
    private final Path testPath = Paths.get(System.getProperty("user.dir"), "TestSettings.xml");

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
        testPath.toFile().delete();
    }

    /**
     * Method: deserialize(String path)
     */
    @Test
    public void testDeserialize() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: serialize(String path, Object o)
     */
    @Test
    public void testSerialize() throws Exception {
        try {
            RoMaSettings s = RoMaSettings.getDefaultSettings();
            Assert.assertTrue(s != null);
            s.save(testPath.toString());
            Assert.assertTrue(testPath.toFile().isFile());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
