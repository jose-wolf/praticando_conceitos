package arquivos.exercicio.application;

import arquivos.exercicio.entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File sourceFile = new File(strPath);
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "\\out").mkdir();

        String targetFileStr = sourceFolderStr + "\\out\\sumary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
            String itemCsv = br.readLine();
            while(itemCsv != null){

                String[] fields= itemCsv.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                int quantity = Integer.parseInt(fields[2]);

                Product product = new Product(name,price,quantity);
                list.add(product);

                itemCsv = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){

                for (Product item: list){
                    bw.write(item.getName() + "," + String.format("%.2f",item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + " Created");

            }catch (IOException e){
                System.out.println("Error: " +  e.getMessage());
            }

        }catch (IOException e){
            System.out.println("Error: " +  e.getMessage());
        }

        sc.close();

    }

}
