package day9.interfaces.callbackDemo;

import javax.swing.*;

public class TimerTestt {
    public static void main(String[] args) {

        /**
         * 1.注册回调函数: 使用 Timer 的构造函数，将 TimerPrinter 作为回调函数的实现者传递。
         * 2.触发回调:定时器每隔 1 秒触发一次，自动调用 TimerPrinter 中的 actionPerformed 方法。
         * 这段代码就是回调的具体执行逻辑。
         */
        TimerPrinter printer = new TimerPrinter();
        Timer timer = new Timer(1000, printer);
        timer.start();


        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);


    }
}
