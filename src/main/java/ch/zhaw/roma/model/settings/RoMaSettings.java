
package ch.zhaw.roma.model.settings;

import ch.zhaw.roma.helpers.XmlHelper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RoMaSettings {

    //region Private Fields
    public static String DEFUALT_PATH = Paths.get(System.getProperty("user.dir"), "RoMaSettings.xml").toString();

    private Integer port;
    private String host;
    private String user;
    private String password;
    //endregion

    //region Construction
    public RoMaSettings() {
        this("", -1, "", "");
    }

    public RoMaSettings(String host, int port, String user, String password) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }
    //endregion

    //region Getters and Setters
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getString() {
        return password;
    }

    public void setString(String password) {
        this.password = password;
    }
    //endregion

    //region Public Members
    public void save(String path) {
        if(path == null || path.isEmpty())
            return;

        Path f = Paths.get(path);
        try {
            serialize(f.toFile().getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static RoMaSettings load(String path)
    {
        File f = ((path != null) && !path.isEmpty())
            ? new File(path)
            : null;

        return ((f != null) && f.isFile())
            ? deserialize(f.getPath())
            : RoMaSettings.getDefaultSettings();
    }

    public static RoMaSettings getDefaultSettings() {
        return new RoMaSettings("localhost", 3306 ,"roma", "roma");
    }
    //endregion

    //region Private Helpers
    private void serialize(String absolutePath) throws Exception {
        new XmlHelper<RoMaSettings>().serialize(absolutePath, this);
    }

    private static RoMaSettings deserialize(String path) {
        try {
            return new XmlHelper<RoMaSettings>().deserialize(path);
        } catch (Exception e) {
            e.printStackTrace();
            return RoMaSettings.getDefaultSettings();
        }
    }
    //endregion
}
