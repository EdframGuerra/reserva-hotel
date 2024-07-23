package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import reservaHotel.Reserva;

public class programa {
    public static void main(String[] args) throws ParseException {
        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Quarto numero: ");
        int numeroQuarto = leitor.nextInt();

        System.out.print("Data do check-in: ");
        Date checkin = dataFormatada.parse(leitor.next());

        System.out.print("Data do check-out: ");
        Date checkout = dataFormatada.parse(leitor.next());

        if (!checkout.after(checkin)) {
            System.err.println("A data do check-out não pode ser maior que a data do check-in");
        } else {
            Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
            System.err.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Entre com os dados da atualização da reserva: ");
            System.out.print("Data do check-in: ");
            checkin = dataFormatada.parse(leitor.next());

            System.out.print("Data do check-out: ");
            checkout = dataFormatada.parse(leitor.next());

            String erro = reserva.atualizarReserva(checkin, checkout);

            if(erro!=null){
                System.out.println("Erro na reserva: "+erro);
            }
            else{
                System.err.println("Reserva: " + reserva);
            }
            

            leitor.close();
        }

    }
}
