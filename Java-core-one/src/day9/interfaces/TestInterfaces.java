package day9.interfaces;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestInterfaces {
    public static void main(String[] args) {
        Usbs usbs;
        Pcit pcit;
        pcit = new PcitImport();
        int pc = pcit.getPc(15);
        System.out.println(pc);

        Path ss1 = Paths.get("ss");

        //java 11新特性 取代了Paths。get
        Path ss = Path.of("ss");




    }
}
