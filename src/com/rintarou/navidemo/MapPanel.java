package com.rintarou.navidemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 定制的JPanel，实现的是地图上的动画。<br/>
 * 基本都是英语，自己体会吧，我不想打那么多字了。<br/>
 * 从这能看出来怎么遭遇伏击(doge)。
 */
public class MapPanel extends JPanel implements ActionListener {

    private final Loc curLoc = new Loc();
    private final Loc deLoc = new Loc();
    private final Timer timer = new Timer(500, this);
    private boolean isWarning;
    private boolean isOver;
    private boolean isStart;
    private int oil;
    private String dir;
    private int dir_i;


    public MapPanel() {
        curLoc.x = Data.Ax;
        curLoc.y = Data.Ay;
        deLoc.x = Data.Bx;
        deLoc.y = Data.By;
        oil = 0;
        timer.start();
    }


    public int run() {
        if (setLoc(curLoc)) {
            isWarning = false;
            isOver = false;
            this.repaint();
            return 0;
        }
        if (setLoc(deLoc)) {
            isWarning = false;
            isOver = false;
            this.repaint();
            return 0;
        }
        setOil();
        isWarning = setWarning();
        isStart = true;
        repaint();
        return oil;
    }

    private boolean setWarning() {
        isOver = false;
        return curLoc.text.equals("X") || deLoc.text.equals("X");
    }

    private void setOil() {
        switch (curLoc.text) {
            case "A":
                switch (deLoc.text) {
                    case "A" -> {
                        oil = Data.A2A;
                        dir = Data.D_A2A;
                    }
                    case "B" -> {
                        oil = Data.A2B;
                        dir = Data.D_A2B;
                    }
                    case "C" -> {
                        oil = Data.A2C;
                        dir = Data.D_A2C;
                    }
                    case "X" -> {
                        oil = Data.A2X;
                        dir = Data.D_A2X;
                    }
                }
                break;
            case "B":
                switch (deLoc.text) {
                    case "A" -> {
                        oil = Data.B2A;
                        dir = Data.D_B2A;
                    }
                    case "B" -> {
                        oil = Data.B2B;
                        dir = Data.D_B2B;
                    }
                    case "C" -> {
                        oil = Data.B2C;
                        dir = Data.D_B2C;
                    }
                    case "X" -> {
                        oil = Data.B2X;
                        dir = Data.D_B2X;
                    }
                }
                break;
            case "C":
                switch (deLoc.text) {
                    case "A" -> {
                        oil = Data.C2A;
                        dir = Data.D_C2A;
                    }
                    case "B" -> {
                        oil = Data.C2B;
                        dir = Data.D_C2B;
                    }
                    case "C" -> {
                        oil = Data.C2C;
                        dir = Data.D_C2C;
                    }
                    case "X" -> {
                        oil = Data.C2X;
                        dir = Data.D_C2X;
                    }
                }
                break;
            case "X":
                switch (deLoc.text) {
                    case "A" -> {
                        oil = Data.X2A;
                        dir = Data.D_X2A;
                    }
                    case "B" -> {
                        oil = Data.X2B;
                        dir = Data.D_X2B;
                    }
                    case "C" -> {
                        oil = Data.X2C;
                        dir = Data.D_X2C;
                    }
                    case "X" -> {
                        oil = Data.X2X;
                        dir = Data.D_X2X;
                    }
                }
                break;
        }
        dir_i = 0;
    }

    private boolean setLoc(Loc loc) {
        switch (loc.text) {
            case "A":
                loc.x = Data.Ax;
                loc.y = Data.Ay;
                break;
            case "B":
                loc.x = Data.Bx;
                loc.y = Data.By;
                break;
            case "C":
                loc.x = Data.Cx;
                loc.y = Data.Cy;
                break;
            case "X":
                loc.x = Data.Xx;
                loc.y = Data.Xy;
                break;
            default:
                return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Data.map.paintIcon(this, g, 0, 0);
        Data.chara.paintIcon(this, g, curLoc.x, curLoc.y);
        if (isWarning && isOver) {
            Data.warning.paintIcon(this, g, 0, 400);
            isWarning = false;
            isOver = false;
        }
    }

    public void setLoc(String text1, String text2) {
        curLoc.text = text1;
        deLoc.text = text2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && dir_i < dir.length()) {
            switch (dir.charAt(dir_i)) {
                case 'U' -> curLoc.y -= 50;
                case 'D' -> curLoc.y += 50;
                case 'L' -> curLoc.x -= 50;
                case 'R' -> curLoc.x += 50;
            }
            dir_i++;
        } else {
            isStart = false;
            if(isWarning) {
                isOver = true;
            }
        }
        this.repaint();
        timer.start();
    }

    private static class Loc {
        int x;
        int y;
        String text;
    }

}
