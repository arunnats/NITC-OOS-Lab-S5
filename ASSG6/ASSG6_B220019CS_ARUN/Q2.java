public class Q2 {
    public static void main(String[] args) {
        BookingApp B= new BookingApp();

        B.bookTransport(5782387, "CFG", "DUB");
        B.bookTransport(212435, "First AC");
        B.bookTransport("Coonoor", "Calicut");
        B.bookTransport("Kohlapur", "Nashik", 4);
    }
}

class BookingApp {
    public void bookTransport(int flightNumber, String depCity, String arrCity) {
        System.out.println("You have booked Flight number " + flightNumber + " from " + depCity + " to " + arrCity + ".");
    }

    public void bookTransport(int trainNumber, String trainClass) {
        System.out.println("You have booked Train number " + trainNumber + " of " + trainClass + " class." );

    }

    public void bookTransport(String pickup, String dropoff) {
        System.out.println("You have booked Cab from " + pickup + " to " + dropoff + "." );
    }

    public void bookTransport(String pickup, String dropoff, int passengers) {
        if (passengers > 0) {
            System.out.println("You have booked a Cab from " + pickup + " to " + dropoff + " for " + passengers + " passengers.");
        } else {
            System.out.println("Number of passengers must be greater than zero.");
        }
    }
}