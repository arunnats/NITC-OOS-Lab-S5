public class Q6 {
    public static void main(String[] args) {
        TicketBooking regularBooking = new TicketBooking();
        VIPBooking vipBooking = new VIPBooking();
        System.out.println("=== Regular Ticket Booking ===");
        regularBooking.bookTicket();
        double regularFee = regularBooking.calculateBookingFees(200.0);
        System.out.println("Regular booking fee: $" + regularFee);
        System.out.println();
        System.out.println("=== VIP Ticket Booking ===");
        vipBooking.bookTicket();
        double vipFee = vipBooking.calculateBookingFees(200.0);
        System.out.println("VIP booking fee: $" + vipFee);
    }
}

class TicketBooking{
    public void bookTicket(){
        System.out.println("Booking Regular Ticket..");
    }

    public double calculateBookingFees(double price){
        return price + (10.0*price)/100;
    }
}

class VIPBooking{
    public void bookTicket(){
        System.out.println("Booking VIP ticket with additional perks..");
    }

    public double calculateBookingFees(double price){
        return price + (5.0*price)/100;
    }
}
