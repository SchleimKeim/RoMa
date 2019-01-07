package ch.zhaw.roma.helpers;

import ch.zhaw.roma.model.settings.RoMaSettings;
import com.thoughtworks.xstream.XStream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;

public class XmlHelper<T> {

    //region Public Members
    public T deserialize(String path) throws Exception {
        return (T) getStream().fromXML(Paths.get(path).toString());
    }

    public void serialize(String path, Object o) throws Exception {
        getStream().toXML(o, new OutputStreamWriter(new FileOutputStream(path)));
    }
    //endregion

    //region Private Helpers
    private XStream getStream() {
        XStream x = new XStream();
        x.alias("romaSettings", RoMaSettings.class);
        return x;
    }
    //endregion
}