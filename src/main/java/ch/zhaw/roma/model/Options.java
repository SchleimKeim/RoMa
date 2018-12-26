
package ch.zhaw.roma.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

public class Options {

    //region Private Fields
    private String host;
    private String user;
    private String password;
    //endregion


    //region Construction
    public Options(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }

    public Options() {

    }

    public static Options getDefaultOptions() {
        return new Options("localhost", "roma", "roma");
    }
    //endregion

    //region getters and setters
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

    public Options load(String path) {
        if(path == null || path.isEmpty())
            return null;

        File f = new File(path);
        if(!f.exists())
            return null;

        if(f.isDirectory())
            return null;

        return Options.deserialize(path);
    }


    private static Options deserialize(String path) {
        // TODO: XML Deserialization
        throw new NotImplementedException();
    }

    public void save(String path) {
        if(path == null || path.isEmpty())
            return;

    }

    private void overWrite(File f) {
    }

    private void createNew(File f) {
        try {
            f.createNewFile();
            serialize(f.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serialize(String absolutePath) {
        // TODO: XML Serialization
        throw new NotImplementedException();
    }
    //endregion
}
