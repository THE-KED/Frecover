package recover;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BashExecutor {

    private static File file;

    public static void exec(String[] commande,String outPutFile) throws IOException {
        System.out.println("exec");
        if(outPutFile(outPutFile)){
            String line;
            try(FileWriter of = new FileWriter(file)){
                System.out.println("Try to write in file");
                Runtime runtime = Runtime.getRuntime();
                BufferedReader reader = new BufferedReader(new InputStreamReader(runtime.exec(commande).getInputStream()));
                while ((line = reader.readLine())!=null){
                    System.out.println(line);
                    of.write(line);
                }
                of.close();
            }catch (IOException ioException){
                System.err.println(ioException.getMessage());
            }
            System.out.println("exec");
        }
    }

    public static boolean outPutFile(String outPutFile) throws IOException {
        file = new File("src/main/java/recover/indentification/"+outPutFile);
        try {
            System.out.println("Try to creat file");
            return file.createNewFile();
        }catch (IOException ioException){
            System.out.println("fail to creat file");
        }
        System.out.println(file.getAbsolutePath());
        return false;
    }
}
