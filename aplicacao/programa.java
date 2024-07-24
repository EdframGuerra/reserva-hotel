package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Excecao.DominioException;
import entidades.Reserva;

public class programa {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Quarto numero: ");
            int numeroQuarto = leitor.nextInt();
            System.out.print("Data do check-in: ");
            Date checkin = dataFormatada.parse(leitor.next());
            System.out.print("Data do check-out: ");
            Date checkout = dataFormatada.parse(leitor.next());

            Reserva reserva = new Reserva(numeroQuarto, checkin, checkout);
            System.err.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com os dados da atualização da reserva: ");
            System.out.print("Data do check-in: ");
            checkin = dataFormatada.parse(leitor.next());
            System.out.print("Data do check-out: ");
            checkout = dataFormatada.parse(leitor.next());

            reserva.atualizarReserva(checkin, checkout);
            System.err.println("Reserva: " + reserva);
        } 
        catch (ParseException e) {
            System.err.println("Data invalida");
        } 
        catch (DominioException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}

        leitor.close();
    }
}