  public class Q8 {
  public static void main(String[] args) {
    EventManager manager = new EventManager();
    Event concert = new Concert("Summer Music Festival", 100, "The Jazz Band");
    Event play = new TheaterPlay("Shakespeare's Hamlet", 50, "John Doe");
    Event sports = new SportsGame("City Derby", 200, "Team A vs Team B");
    manager.addEvent(concert); manager.addEvent(play);
    manager.addEvent(sports);
    manager.bookEventTickets("Summer Music Festival", 10);
    manager.cancelEventTickets("Shakespeare's Hamlet", 5); 
    manager.displayAllEvents();
    }
}

interface Event {
  String getEventName();
  int getAvailableTickets();
  boolean bookTickets(int numberOfTickets);
  boolean cancelTickets(int numberOfTickets);
}

class Concert implements Event {
  private String eventName;
  private int totalTickets;
  private String performer;
  private int bookedTickets;

  public Concert(String eventName, int totalTickets, String performer) {
      this.eventName = eventName;
      this.totalTickets = totalTickets;
      this.performer = performer;
      this.bookedTickets = 0;
  }

  @Override
  public String getEventName() {
      return eventName;
  }

  @Override
  public int getAvailableTickets() {
      return totalTickets - bookedTickets;
  }

  @Override
  public boolean bookTickets(int numberOfTickets) {
      if (getAvailableTickets() >= numberOfTickets) {
          bookedTickets += numberOfTickets;
          System.out.println(numberOfTickets + " tickets booked successfully for " + eventName);
          return true;
      } else {
          System.out.println("Failed to book tickets for " + eventName + ". Not enough tickets available.");
          return false;
      }
  }

  @Override
  public boolean cancelTickets(int numberOfTickets) {
      if (bookedTickets >= numberOfTickets) {
          bookedTickets -= numberOfTickets;
          System.out.println(numberOfTickets + " tickets cancelled successfully for " + eventName);
          return true;
      } else {
          System.out.println("Failed to cancel tickets for " + eventName + ". Not enough tickets booked.");
          return false;
      }
  }

  public String getPerformer() {
      return performer;
  }

  @Override
  public String toString() {
      return "Concert: " + eventName + " | Performer: " + performer + " | Available Tickets: " + getAvailableTickets();
  }
}

class TheaterPlay implements Event {
  private String eventName;
  private int totalTickets;
  private String director;
  private int bookedTickets;

  public TheaterPlay(String eventName, int totalTickets, String director) {
      this.eventName = eventName;
      this.totalTickets = totalTickets;
      this.director = director;
      this.bookedTickets = 0;
  }

  @Override
  public String getEventName() {
      return eventName;
  }

  @Override
  public int getAvailableTickets() {
      return totalTickets - bookedTickets;
  }

  @Override
  public boolean bookTickets(int numberOfTickets) {
      if (getAvailableTickets() >= numberOfTickets) {
          bookedTickets += numberOfTickets;
          System.out.println(numberOfTickets + " tickets booked successfully for " + eventName);
          return true;
      } else {
          System.out.println("Failed to book tickets for " + eventName + ". Not enough tickets available.");
          return false;
      }
  }

  @Override
  public boolean cancelTickets(int numberOfTickets) {
      if (bookedTickets >= numberOfTickets) {
          bookedTickets -= numberOfTickets;
          System.out.println(numberOfTickets + " tickets cancelled successfully for " + eventName);
          return true;
      } else {
          System.out.println("Failed to cancel tickets for " + eventName + ". Not enough tickets booked.");
          return false;
      }
  }

  public String getDirector() {
      return director;
  }

  @Override
  public String toString() {
      return "Theater Play: " + eventName + " | Director: " + director + " | Available Tickets: " + getAvailableTickets();
  }
}

class SportsGame implements Event {
  private String eventName;
  private int totalTickets;
  private String teamNames;
  private int bookedTickets;

  public SportsGame(String eventName, int totalTickets, String teamNames) {
      this.eventName = eventName;
      this.totalTickets = totalTickets;
      this.teamNames = teamNames;
      this.bookedTickets = 0;
  }

  @Override
  public String getEventName() {
      return eventName;
  }

  @Override
  public int getAvailableTickets() {
      return totalTickets - bookedTickets;
  }

  @Override
  public boolean bookTickets(int numberOfTickets) {
      if (getAvailableTickets() >= numberOfTickets) {
          bookedTickets += numberOfTickets;
          System.out.println(numberOfTickets + " tickets booked successfully for " + eventName);
          return true;
      } else {
          System.out.println("Failed to book tickets for " + eventName + ". Not enough tickets available.");
          return false;
      }
  }

  @Override
  public boolean cancelTickets(int numberOfTickets) {
      if (bookedTickets >= numberOfTickets) {
          bookedTickets -= numberOfTickets;
          System.out.println(numberOfTickets + " tickets cancelled successfully for " + eventName);
          return true;
      } else {
          System.out.println("Failed to cancel tickets for " + eventName + ". Not enough tickets booked.");
          return false;
      }
  }

  public String getTeamNames() {
      return teamNames;
  }

  @Override
  public String toString() {
      return "Sports Game: " + eventName + " | Teams: " + teamNames + " | Available Tickets: " + getAvailableTickets();
  }
}

class EventManager {
  private java.util.List<Event> events = new java.util.ArrayList<>();

  public void addEvent(Event event) {
      events.add(event);
  }

  public boolean bookEventTickets(String eventName, int numberOfTickets) {
      for (Event event : events) {
          if (event.getEventName().equalsIgnoreCase(eventName)) {
              return event.bookTickets(numberOfTickets);
          }
      }
      System.out.println("Event " + eventName + " not found.");
      return false;
  }

  public boolean cancelEventTickets(String eventName, int numberOfTickets) {
      for (Event event : events) {
          if (event.getEventName().equalsIgnoreCase(eventName)) {
              return event.cancelTickets(numberOfTickets);
          }
      }
      System.out.println("Event " + eventName + " not found.");
      return false;
  }

  public void displayAllEvents() {
      for (Event event : events) {
          System.out.println(event);
      }
  }
}