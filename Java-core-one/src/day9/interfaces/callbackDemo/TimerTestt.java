package day9.interfaces.callbackDemo;

import javax.swing.*;

public class TimerTestt {
    public static void main(String[] args) {
        TimerPrinter printer = new TimerPrinter();
        Timer timer = new Timer(10000, printer);
        timer.start();


        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);


    }
}
