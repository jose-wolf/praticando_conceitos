package arquivos;

import java.io.File;
import java.util.Scanner;

public class AulaTresDeArquivos {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("Folders: "); // Lendo pasta
        for(File folder : folders){
            System.out.println(folder);
        }

        Thread.sleep(2000);

        File[] files = path.listFiles(File::isFile);
        System.out.println("Files: "); // Lendo arquivos
        for(File file : files){
            System.out.println(file);
        }

        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created sucessfully: " + success);

        sc.close();

    }

}
