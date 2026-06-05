//main class
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        //ArrayList (to store room details)
        ArrayList<Room> rooms=new ArrayList<>();

        //ArrayList (to booking details)
        ArrayList<Booking> bookings=new ArrayList<>();

        //Adding sample rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Standard"));
        rooms.add(new Room(105, "Deluxe"));

        //infinite loop for menu
        while(true){
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");

            System.out.println("1. View Room");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();
            switch(choice){
                //view all rooms
                case 1:
                    System.out.println("\n--- Room Details ---");

                    for (Room room :rooms){
                        room.displayRoom();
                    }
                    break;

                    //Book a room
                    case 2:
                        System.out.print("Enter Room Number to Book: ");
                        int roomNumber =sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String name=sc.nextLine();

                        boolean found=false;
                        for(Room room:rooms){
                            // check if room exists
                            if(room.roomNumber == roomNumber){
                                found=true;

                                //check availability
                                if(room.isAvailable){
                                    room.isAvailable=false;

                                    //add booking
                                    bookings.add(new Booking(name, roomNumber));

                                    System.out.println("Room Booked Successfully!");
                                    System.out.println("Payment Successful!");
                                }else{
                                    System.out.println("Room Already Booked!");
                                }
                            }
                        }
                        //if room number is invalid
                        if(!found){
                            System.out.println("Room Not Found!");
                        }
                        break;
                    //cancel booking
                    case 3:
                        System.out.print("Enter Room NUmber to cancel booking: ");
                        int cancelRoom=sc.nextInt();
                        boolean cancelled=false;

                        for(Room room:rooms){
                            if(room.roomNumber==cancelRoom){
                                //check if room is booked
                                if(!room.isAvailable){
                                    room.isAvailable=true;
                                    cancelled=true;

                                    //remove booking details
                                    for(int i=0;i<bookings.size();i++){
                                        if (bookings.get(i).roomNumber==cancelRoom){
                                            bookings.remove(i);
                                            break;
                                        }
                                    }
                                    System.out.println("Booking cancelled Successfully!");
                                }else{
                                    System.out.println("Room is already available!");
                                }
                            }
                        }
                        if(!cancelled){
                            System.out.println("Booking Not Found!");
                        }
                        break;
                    //view all bookings
                    case 4:
                        System.out.println("\n--- Booking Details ---");
                        if(bookings.isEmpty()){
                            System.out.println("No Bookings Available!");
                        }else{
                            for(Booking booking:bookings){
                                booking.displayBooking();
                            }
                        }
                        break;

                    //Exit program
                    case 5:
                        System.out.println("ThankYou!");
                        System.exit(0);

                    //invalid choice
                    default:
                        System.out.println("Invalid Choice!");
            }
        }

    }
}