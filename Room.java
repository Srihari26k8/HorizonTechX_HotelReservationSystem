public class Room {
    //room class (stores room details)
    int roomNumber;
    String category;
    boolean isAvailable;

    //Constractor
    Room(int roomNumber,String category){
        this.roomNumber=roomNumber;
        this.category=category;
        this.isAvailable=true;         //availablity of room
    }
    //method to display room details
    void displayRoom(){
        System.out.println("Room Number : " + roomNumber);
        System.out.println("Category    : " + category);
        System.out.println("Available   : " + (isAvailable ? "Yes" : "No"));
        System.out.println("-------------------------");
    }

}
