package ch.zhaw.roma.model.excel;

import java.util.HashMap;
import java.util.Map;

public enum Indexes {

    //region Indexes
    TITLE(0), HEADER1(1), HEADER2(2);
    //endregion

    private static Map map = new HashMap<>();

    //region Construction
    static {
        for (Indexes pageType : Indexes.values()) {
            map.put(pageType.value, pageType);
        }
    }
    //endregion

    //region Private Stuff
    private int value;

    private Indexes(int value) {
        this.value = value;
    }
    //endregion

    //region Public Members
    public static Indexes valueOf(int pageType) {
        return (Indexes) map.get(pageType);
    }
    //endregion

    //region Getters and SettersGetters and Setters
    public int getValue() {
        return value;
    }
    //endregion
}
