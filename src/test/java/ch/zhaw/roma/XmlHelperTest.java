package ch.zhaw.roma;

import ch.zhaw.roma.model.settings.RoMaSettings;
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
    private final Path savePath = Paths.get(System.getProperty("user.dir"), "TestSettings.xml");
    private final Path loadPath = Paths.get("src/test/resources/TestSettings.xml");

    @Before
    public void before() throws Exception {
        Assert.assertTrue(loadPath.toFile().isFile());
    }

    @After
    public void after() throws Exception {
        savePath.toFile().delete();
    }

    /**
     * Method: deserialize(String path)
     */
    @Test
    public void testDeserialize() throws Exception {
        RoMaSettings s = RoMaSettings.load(loadPath.toString());
        Assert.assertTrue(s != null);
        Assert.assertTrue(s.getUser() == "roma");
        Assert.assertTrue(s.getHost() == "localhost");
    }

    /**
     * Method: serialize(String path, Object o)
     */
    @Test
    public void testSerialize() throws Exception {
        try {
            RoMaSettings s = RoMaSettings.getDefaultSettings();
            Assert.assertTrue(s != null);
            s.save(savePath.toString());
            Assert.assertTrue(savePath.toFile().isFile());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
