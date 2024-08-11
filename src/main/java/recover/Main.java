package recover;

import UI.App;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        String[] lsblkCmd = {"pkexec","fdisk","-l"};

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(lsblkCmd);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            }
            String[] cmd = {"lsblk"};
            BashExecutor.exec(cmd,"outPuts/cmdOutPut");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Hello world!");

        String command = "sudo java DiskReader.java sdb1 10 512 ";

        String[] Cmd = {"pkexec","java","/home/ked/backups/Frecover/src/main/java/recover/DiskReader.java","sdb1","20","1","512"};

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(Cmd);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

//        try {
//            // Créer un ProcessBuilder pour la commande
//            ProcessBuilder pb = new ProcessBuilder(command);
//            Process process = pb.start();
//
//            // Écrire le mot de passe sudo dans l'entrée standard du processus
//            try (OutputStream os = process.getOutputStream()) {
//                os.write("DAQUIN".getBytes());
//                os.flush();
//            }
//
//            // Lire la sortie standard du processus
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
////                    System.out.println(line);
//                }
//            }
//
//            // Lire la sortie d'erreur du processus
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.err.println(line);
//                }
//            }
//
//            // Attendre la fin du processus
//            int exitCode = process.waitFor();
//            System.out.println("Exited with code: " + exitCode);
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}