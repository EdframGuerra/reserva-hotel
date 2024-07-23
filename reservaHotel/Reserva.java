package reservaHotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroQuarto, Date chekin, Date checkout) {
        this.numeroQuarto = numeroQuarto;
        this.checkin = chekin;
        this.checkout = checkout;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    // comparação de duas datas em dias
    public long duracao() {
        long diferenca = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public String atualizarReserva(Date checkin, Date checkout){
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            return "As datas da reservas devem ser para datas futuras";
        } if (!checkout.after(checkin)) {
          return "A data do check-out não pode ser maior que a data do check-in";
        }

        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }

    @Override
    public String toString() {
        return "Numero do quarto "+ numeroQuarto+" , chekin: "+dataFormatada.format(checkin)+", checkout: "+ dataFormatada.format(checkout)+", "+duracao()+ " noites";


}
}
