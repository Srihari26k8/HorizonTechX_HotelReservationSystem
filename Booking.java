//booking class(stores customer booking details)
public class Booking {
    String customerName;
    int roomNumber;

    //constructor
    Booking(String customerName, int roomNumber){
        this.customerName=customerName;
        this.roomNumber=roomNumber;
    }

    //methods to display booking details
    void displayBooking(){
        System.out.println("Customer Name : " + customerName);
        System.out.println("Room Number   : " + roomNumber);
        System.out.println("-------------------------");
    }
    
}