package day10.lamada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class Greeter{
    public void greet(ActionEvent event){
        System.out.println("hello, the time is"
                + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }

//    @Override
//    public void actionPerformed(ActionEvent event) {
//        System.out.println("hello, the time is"
//                + Instant.ofEpochMilli(event.getWhen()));
//        Toolkit.getDefaultToolkit().beep();
//    }
}

class RepeGreeter extends Greeter{
    public void greet(ActionEvent event){
        Timer timer = new Timer(1000, super::greet);
        timer.start();

    }

    public static void main(String[] args) {
        RepeGreeter repeGreeter = new RepeGreeter();
        ActionEvent command = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "command");
        repeGreeter.greet(command);


    }
}