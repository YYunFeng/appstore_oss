package com.jd.appstore.domain;

/**
 * Created by IntelliJ IDEA.
 * User: gaoyang
 * Date: 12-9-5
 * Time: 上午10:17
 * To change this template use File | Settings | File Templates.
 */
public enum PicResolutionEnum {
    /*public static final String;N0 = "n0";//800*800
    public static final String N1 = "n1";//350*350
    public static final String N2 = "n2";//160*160
    public static final String N3 = "n3";//130*130
    public static final String N4 = "n4";//100*100
    public static final String N5 = "n5";//50*50
    public static final String N11 = "n11";//280*280*/

    COVER_NO("NO","N0"),
    COVER_N1("N1","appstore"),
    COVER_N2("N2","appstore"),
    COVER_N3("N3","appstore"),
    COVER_N4("N4","appstore"),
    COVER_N5("N5","N5"),
    COVER_N11("N11","appstore"),
    IMG_N0("N0", "s800x800_"),
    IMG_N1("N1", "s350x350_"),
    IMG_N2("N2", "s160x160_"),
    IMG_N3("N3", "s130x130_"),
    IMG_N4("N4", "s100x100_"),
    IMG_N5("N5", "s50x50_");

    private String name;
    private String prefix;

    private PicResolutionEnum(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }
}
