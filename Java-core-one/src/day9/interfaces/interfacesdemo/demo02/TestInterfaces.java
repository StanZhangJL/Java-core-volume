package day9.interfaces.interfacesdemo.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestInterfaces {
    public static void main(String[] args) throws IOException {
        Usbs usbs;
        Pcit pcit;
        pcit = new PcitImpl();
        int pc = pcit.getPc(15);
        System.out.println(pc);

        Path ss1 = Paths.get("ss");
        Path path = FileSystems.getDefault().getPath("logs", "access. log");
        BufferedReader reader = Files. newBufferedReader(path, StandardCharsets. UTF_8);

        //java 11新特性 取代了Paths。get
        Path ss = Path.of("ss");




    }
}
