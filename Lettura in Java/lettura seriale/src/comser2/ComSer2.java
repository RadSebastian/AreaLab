package comser2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import jssc.*;

public class ComSer2 {

    public static void leggiPorta(String fileOutput) throws IOException {
        int i, a;
        BufferedWriter fw = new BufferedWriter(new FileWriter(fileOutput));
        String riga;

        SerialPort serialPort = new SerialPort("COM6");
        try {
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            for (i = 0, a = 0; (i != -1) && (a < 3); a++) {

                String buffer = serialPort.readString();
                if (buffer != null) {
                    if (buffer != "\n") {
                        System.out.print(buffer + "");
                        
                        fw.write(buffer+"");
                    } else {
                        System.out.println("");
                      
                        fw.write("\n");
                    }
                }
            }
        
            fw.close();
            serialPort.closePort();
        } catch (SerialPortException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws IOException {
        leggiPorta("H:\\AreaLab\\Rad_Ricca_Gentile_Scardino\\Lettura in Java\\lettura seriale\\outputJava.odt");
    }

}
