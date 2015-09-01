package com.ssthouse.model.database;

/**
 * Created by ssthouse on 2015/9/1.
 */
public class ProjectDbCons {

    public static String TABLE_PRJS = "Prjs";

    public static String TABLE_Markers="Markers";

    public static class Marker{
        public static String ITEM_PRJ_NAME = "prjName";

        public static String ITEM_LONGITUDE = "longitude";

        public static String ITEM_LATITUDE = "latitude";
    }

    public static class Prj{
        public static String ITEM_PRJ_NAME = "prjName";
    }
}
