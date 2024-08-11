package recover;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DiskReader {

    public static void main(String[] args){
// arg1 =partition , arg2 = nombre de blocs a lire , arg3 = start blocs , arg4 = size bloc
        
        FileInputStream sdb1;
        byte[] line;
        int i=0, start = Integer.parseInt(args[2]);
        String disk = args[0];
        int nb = Integer.parseInt(args[1]), size = Integer.parseInt(args[3]);
        String[] arr = new String[size];
        try {
            i=start;
            sdb1 = new FileInputStream(new File("/dev/"+disk));
            while (i<nb+start){
                System.out.println("Bloque "+i);
                line = sdb1.readNBytes(size);
                for (int j = 0; j < line.length; j++) {
                    arr[j] = String.format("%02x", line[j]);
                }
                System.out.println(Arrays.toString(arr));
                i++;
            }

            sdb1.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
