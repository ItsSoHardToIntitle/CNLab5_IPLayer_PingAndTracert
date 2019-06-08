package com.zz.gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import com.zz.cmdprocess.CmdProcess;

/**
 * @author Zhang Zhen
 * @time 2019年6月8日 下午3:38:23
 */
public class Gui {
    private static Gui gui;

    private static JFrame jFrame = new JFrame("lab1_2 --- by ZhangZhen");
    private static JTextField inputField = new JTextField();
    private static JTextArea resArea = new JTextArea(35, 30);

    public Gui() {
        init();
        addControls();
        jFrame.setVisible(true);
    }

    public static Gui getGuiInstance() {
        if (gui == null) {
            gui = new Gui();
        }
        return gui;
    }

    public void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        jFrame.setSize(600, 500);
        jFrame.setResizable(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addControls() {
        Box hBox = Box.createHorizontalBox();
        hBox.add(inputField);
        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String userInput = inputField.getText();
                    CmdProcess.runCommand(userInput);
                }
            }
        });

        Box hBox1 = Box.createHorizontalBox();
        resArea.setEditable(false);
        resArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        resArea.setForeground(Color.BLACK);
        resArea.setBackground(Color.CYAN);

        JScrollPane jScrollPane = new JScrollPane(resArea);
        hBox1.add(jScrollPane);

        Box vBox = Box.createVerticalBox();
        vBox.add(hBox);
        vBox.add(hBox1);

        jFrame.add(vBox);
    }

    public static JTextArea getResArea() {
        return resArea;
    }
}
