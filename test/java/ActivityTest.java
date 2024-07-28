import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {
    @Test
    void testActivityCreation() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 50, destination);
        assertEquals("Test Activity", activity.getName());
        assertEquals("Test Description", activity.getDescription());
        assertEquals(100.0, activity.getCost());
        assertEquals(50, activity.getCapacity());
        assertEquals(destination, activity.getDestination());
    }

    @Test
    void testAddActivityToDestination() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 50, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
    }
}

class DestinationTest {
    @Test
    void testDestinationCreation() {
        Destination destination = new Destination("Test Destination");
        assertEquals("Test Destination", destination.getName());
    }

    @Test
    void testAddActivityToItinerary() {
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 50, destination);
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
        assertTrue(destination.getActivities().contains(activity));
    }
}

class PassengerTest {
    @Test
    void testPassengerCreation() {
        Passenger passenger = new Passenger("John Doe", 1, "Standard");
        assertEquals("John Doe", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
        assertEquals("Standard", passenger.getPassengerType());
    }

    @Test
    void testAddActivitySignedUpByPassenger() {
        Passenger passenger = new Passenger("John Doe", 1, "Standard");
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Test Description", 100.0, 50, destination);
        passenger.addActivity(activity);
        assertEquals(1, passenger.getActivitiesSignedUp().size());
        assertTrue(passenger.getActivitiesSignedUp().contains(activity));
    }
}

class TravelPackageTest {
    @Test
    void testTravelPackageCreation() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 100);
        assertEquals("Test Package", travelPackage.getName());
        assertEquals(100, travelPackage.getPassengerCapacity());
    }

    @Test
    void testAddDestinationToItinerary() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 100);
        Destination destination = new Destination("Test Destination");
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getItinerary().size());
        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    void testAddPassengerToTravelPackage() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 100);
        Passenger passenger = new Passenger("John Doe", 1, "Standard");
        travelPackage.addPassenger(passenger);
        assertEquals(1, travelPackage.getPassengerList().size());
        assertTrue(travelPackage.getPassengerList().contains(passenger));
    }
}
