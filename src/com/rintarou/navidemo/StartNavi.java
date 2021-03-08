package com.rintarou.navidemo;

import javax.swing.*;
import java.awt.*;

/**
 * 主类，程序入口所在。<br/>
 * 大部分为GUI控件的规划和事件调用。
 */
public class StartNavi {
    public static void main(String[] args) {
        JFrame frame = new JFrame("NaviDemo");
        frame.setLayout(null);
        frame.setBounds(100, 80, 1400, 1039);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        MapPanel mapPanel = new MapPanel();
        mapPanel.setBounds(0, 0, 1000, 1000);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBounds(0, 0, 1400, 1039);

        JLabel label1 = new JLabel("出发地", JLabel.CENTER);
        label1.setFont(new Font("微软雅黑", Font.BOLD, 50));
        label1.setBounds(1000, 0, 400, 100);

        JLabel label2 = new JLabel("目的地", JLabel.CENTER);
        label2.setFont(new Font("微软雅黑", Font.BOLD, 50));
        label2.setBounds(1000, 200, 400, 100);

        JLabel label3 = new JLabel("油耗", JLabel.CENTER);
        label3.setFont(new Font("微软雅黑", Font.BOLD, 50));
        label3.setBounds(1000, 400, 400, 100);

        JLabel label4 = new JLabel("0", JLabel.CENTER);
        label4.setFont(new Font("微软雅黑", Font.BOLD, 50));
        label4.setBounds(1000, 500, 400, 100);


        JTextField text1 = new JTextField();
        text1.setFont(new Font("微软雅黑", Font.BOLD, 50));
        text1.setBounds(1000, 100, 400, 100);


        JTextField text2 = new JTextField();
        text2.setFont(new Font("微软雅黑", Font.BOLD, 50));
        text2.setBounds(1000, 300, 400, 100);

        JButton button = new JButton("Weigh Anchor");
        button.setFont(new Font("微软雅黑", Font.BOLD, 50));
        button.setBounds(1000, 700, 400, 100);
        button.addActionListener(e -> {
            mapPanel.setLoc(text1.getText(), text2.getText());
            label4.setText(Integer.toString(mapPanel.run()));
        });


        panel.setLayout(null);


        frame.add(panel);
        panel.add(button);
        panel.add(text1);
        panel.add(text2);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(mapPanel);
        frame.setVisible(true);


    }
}
