package com.rintarou.navidemo;

import javax.swing.*;
import java.net.URL;

/**
 * 存的都是常量，实际大作业只会有一些素材的URL，因为坐标数据需要从文件读取，路线需要现场规划。<br/>
 * 这个演示程序没有实现导航，所以路线我就直接打表了。
 */
public class Data {
    public static URL mapURL = Data.class.getResource("/resource/map.png");
    public static ImageIcon map = new ImageIcon(mapURL);
    public static URL charaURL = Data.class.getResource("/resource/chara.png");
    public static ImageIcon chara = new ImageIcon(charaURL);
    public static URL warningURL = Data.class.getResource("/resource/warning.png");
    public static ImageIcon warning = new ImageIcon(warningURL);
    public static int Ax = 0;
    public static int Ay = 150;
    public static int Bx = 750;
    public static int By = 450;
    public static int Cx = 500;
    public static int Cy = 900;
    public static int Xx = 0;
    public static int Xy = 750;
    public static int A2A = 0;
    public static String D_A2A = "";
    public static int A2B = 210;
    public static String D_A2B = "RRRRRRRRRR" + "DDDDDD" + "RRRRR";
    public static int A2C = 250;
    public static String D_A2C = "RRRRRRRRRR" + "DDDDDDDDDDDDDDD";
    public static int A2X = 320;
    public static String D_A2X = "RRRRRRRRRR" + "DDDDDDDDDDDD" + "LLLLLLLLLL";
    public static int B2A = 210;
    public static String D_B2A = "LLLLL" + "UUUUUU" + "LLLLLLLLLL";
    public static int B2B = 0;
    public static String D_B2B = "";
    public static int B2C = 140;
    public static String D_B2C = "LLLLL" + "DDDDDDDDD";
    public static int B2X = 210;
    public static String D_B2X = "LLLLL" + "DDDDDD" + "LLLLLLLLLL";
    public static int C2A = 250;
    public static String D_C2A = "UUUUUUUUUUUUUUU" + "LLLLLLLLLL";
    public static int C2B = 140;
    public static String D_C2B = "UUUUUUUUU" + "RRRRR";
    public static int C2C = 0;
    public static String D_C2C = "";
    public static int C2X = 130;
    public static String D_C2X = "UUU" + "LLLLLLLLLL";
    public static int X2A = 320;
    public static String D_X2A = "RRRRRRRRRR" + "UUUUUUUUUUUU" + "LLLLLLLLLL";
    public static int X2B = 210;
    public static String D_X2B = "RRRRRRRRRR" + "UUUUUU" + "RRRRR";
    public static int X2C = 130;
    public static String D_X2C = "RRRRRRRRRR" + "DDD";
    public static int X2X = 0;
    public static String D_X2X = "";
}
