package java_interface.application;

import java_interface.model.entities.CarRental;
import java_interface.model.entities.Vehicle;
import java_interface.model.services.BrazilTaxServices;
import java_interface.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
       Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();

        System.out.print("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);

        System.out.print("Retorno (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);

        CarRental cr = new CarRental(start,finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por hora: ");
        double priceHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, priceHour, new BrazilTaxServices());

        rentalService.processInvoice(cr);

        System.out.println("FATURA: ");
        System.out.println("Pagamento básico: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f",cr.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));



        sc.close();
    }


}
