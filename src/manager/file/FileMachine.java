package manager.file;

import java.io.*;

public class FileMachine {
    public String read(String fileName) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String readString="";
        while(true) {
            String line = br.readLine();
            if (line==null) break;
            readString += line;
        }
        br.close();
        return readString;
    }
    public String write(String fileName, String data) throws Exception{
        PrintWriter pw = new PrintWriter(fileName);
        pw.println(data);
        pw.close();
        return "write complete.";
    }
    public String append(String fileName, String data) throws Exception{
        PrintWriter pw2 = new PrintWriter(new FileWriter(fileName, true));
        pw2.println(data);
        pw2.close();
        return "append complete.";
    }
}