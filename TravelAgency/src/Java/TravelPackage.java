package src.Java;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}

class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}

class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private String passengerType; // Standard, Gold, Premium
    private List<Activity> activitiesSignedUp;

    public Passenger(String name, int passengerNumber, String passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.activitiesSignedUp = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public List<Activity> getActivitiesSignedUp() {
        return activitiesSignedUp;
    }

    public void setActivitiesSignedUp(List<Activity> activitiesSignedUp) {
        this.activitiesSignedUp = activitiesSignedUp;
    }

    public void addActivitySignedUp(Activity activity) {
        activitiesSignedUp.add(activity);
    }
}

class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengerList;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengerList = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(List<Destination> itinerary) {
        this.itinerary = itinerary;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengerList.size());
        for (Passenger passenger : passengerList) {
            System.out.println("Name: " + passenger.getName() + ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger.getPassengerType().equals("Standard") || passenger.getPassengerType().equals("Gold")) {
            System.out.println("Balance: " + passenger.getBalance());
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : passenger.getActivitiesSignedUp()) {
            System.out.println("Activity: " + activity.getName() + ", Destination: " + activity.getDestination().getName() + ", Price: " + activity.getCost());
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription());
            }
        }
    }

}

class TravelPackageGUI extends JFrame {
    private JTextArea textArea;

    public TravelPackageGUI() {
        setTitle("Travel Package Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void displayItinerary(TravelPackage travelPackage) {
        textArea.setText("Travel Package: " + travelPackage.getName() + "\n");
        for (Destination destination : travelPackage.getItinerary()) {
            textArea.append("Destination: " + destination.getName() + "\n");
            for (Activity activity : destination.getActivities()) {
                textArea.append("Activity: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity() + ", Description: " + activity.getDescription() + "\n");
            }
        }
    }

    public void displayPassengerList(TravelPackage travelPackage) {
        textArea.setText("Passenger List for Travel Package: " + travelPackage.getName() + "\n");
        textArea.append("Passenger Capacity: " + travelPackage.getPassengerCapacity() + "\n");
        textArea.append("Number of Passengers Enrolled: " + travelPackage.getPassengerList().size() + "\n");
        for (Passenger passenger : travelPackage.getPassengerList()) {
            textArea.append("Name: " + passenger.getName() + ", Passenger Number: " + passenger.getPassengerNumber() + "\n");
        }
    }

    // passenger details and available activities can be added similarly

    public static void main(String [] args) {
        TravelPackageGUI gui = new TravelPackageGUI();
        TravelPackage travelPackage = new TravelPackage("Package 1", 100);
        // Add destinations, passengers, and activities to the travel package


        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50.0, 20, destination1);

        destination1.addActivity(activity1);
        travelPackage.addDestination(destination1);

//        Passenger passenger1 = new Passenger("John Doe", "Standard");
//        travelPackage.addPassenger(passenger1);

        gui.displayItinerary(travelPackage);
        gui.displayPassengerList(travelPackage);
    }

}
