package com.zz.cmdprocess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.zz.gui.Gui;

/**
 * @author Zhang Zhen
 * @time 2019年6月8日 下午3:38:01
 */
public class CmdProcess {
    private static Runtime runtime = Runtime.getRuntime();
    private static Process process;
    private static BufferedReader bufferedReader;
    private static InputStreamReader inputStreamReader;

    private static final String CMD_COMMAND = "cmd /c ";

    public static void runCommand(String userInput) {
        try {
            process = runtime.exec(CMD_COMMAND + userInput);
            inputStreamReader = new InputStreamReader(process.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);

            Gui.getResArea().setText("");
            
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                Gui.getResArea().append(string + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
