import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Theatre {

    static int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //12 seats in row 1
    static int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};// 16 seats in row 2
    static int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};// 20 seats in row 3

    static ArrayList<Ticket> ticketsList = new ArrayList<>(); // create an array list name as ticketsList

    static void buy_ticket() {
        int Row_Number = 0;
        int Seat_Number = 0;
        while (true) {
            try {
                Scanner RowNum = new Scanner(System.in);
                System.out.println("Input a row number(1-3):");
                Row_Number = RowNum.nextInt();
            } catch (Exception e) {
                System.out.println("invalid input please enter valid input");
            }

            try {
                Scanner SeatNum = new Scanner(System.in);
                System.out.println("Input a seat number:");
                Seat_Number = SeatNum.nextInt();
            } catch (Exception e) {
                System.out.println("invalid input please enter valid input");
            }
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Your Name : ");
            String name = input.next();
            System.out.print("Enter Your Surname : ");
            String surname = input.next();
            System.out.print("Enter Your Email : ");
            String email = input.next();
            System.out.print("input price:");
            int price = input.nextInt();
            Person person = new Person(name, surname, email);//creates a new object called 'person' using 'Person' object.
            if (0 < Row_Number && Row_Number < 4) {
                switch (Row_Number) {
                    case 1: {
                        if (Seat_Number > 0 && Seat_Number < 13 && row1[Seat_Number - 1] == 0) {
                            System.out.println("Seat is available.");
                            row1[Seat_Number - 1] = 1;
                            System.out.println("You have booked seat " + Seat_Number + " in row 1");
                            Ticket ticketObj = new Ticket(Row_Number, Seat_Number, price, person);// create an object name as
                            // ticketObj.
                            ticketsList.add(ticketObj); // add values for the array list.
                        } else {
                            System.out.println("Seat is not available");
                        }
                    }
                    break;
                    case 2: {
                        if (Seat_Number > 0 && Seat_Number < 17 && row2[Seat_Number - 1] == 0) {
                            System.out.println("Seat is available.");
                            row2[Seat_Number - 1] = 1;
                            System.out.println("You have booked seat " + Seat_Number + " in row 2");
                            Ticket ticketObj = new Ticket(Row_Number, Seat_Number, price, person);// create an object name as
                            // ticketObj.
                            ticketsList.add(ticketObj); // add values for the array list.
                        } else {
                            System.out.println("Seat is not available");
                        }
                    }
                    break;
                    case 3: {
                        if (Seat_Number > 0 && Seat_Number < 21 && row3[Seat_Number - 1] == 0) {
                            System.out.println("Seat is available.");
                            row3[Seat_Number - 1] = 1;
                            System.out.println("You have booked seat " + Seat_Number + " in row 3");
                            Ticket ticketObj = new Ticket(Row_Number, Seat_Number, price, person);// create an object name as
                            // ticketObj.
                            ticketsList.add(ticketObj); // add values for the array list.
                        } else {
                            System.out.println("Seat is not available");
                        }
                    }
                    break;
                }
                break;
            } else {
                System.out.println("Invalid row number or seat Number!\n Please try again...");
            }

        }
    }


    static void print_seating_area() {
        System.out.println("      ***********");
        System.out.println("      *  STAGE  *");
        System.out.println("      ***********");

        System.out.print("    ");

        for (int i = 0; i < row1.length; i++) {
            if (i == 6)
                System.out.print("    ");
            if (row1[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.print("    \n");
        System.out.print("  ");

        for (int j = 0; j < row2.length; j++) {
            if (j == 8)
                System.out.print("    ");
            if (row2[j] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.print("  \n");
        System.out.print("");

        for (int k = 0; k < row3.length; k++) {
            if (k == 10)
                System.out.print("    ");
            if (row3[k] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
        }
        System.out.print("\n");
    }

    static void cancel_ticket() {
        int rowNumber = 0;
        int seatNumber = 0;
        while (true) {
            try {
                Scanner rowNum = new Scanner(System.in);
                System.out.println("Enter Row Number(1-3):");
                rowNumber = rowNum.nextInt();
                Scanner seatNum = new Scanner(System.in);
                System.out.println("Enter Seat Number:");
                seatNumber = seatNum.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! please re-enter.");
            }//begins an infinite loop

            if (0 < rowNumber && rowNumber < 4 || seatNumber < 21) {
                switch (rowNumber) {
                    case 1: {
                        if (seatNumber > 0 && seatNumber < 13 && row1[seatNumber - 1] == 1) {
                            row1[seatNumber - 1] = 0;
                            System.out.println("You have successfully canceled the booking of seat " + seatNumber + " in row 1");

                        } else {
                            System.out.println("This seat is already booked!");
                        }
                    }
                    break;
                    case 2: {
                        if (seatNumber > 0 && seatNumber < 17 && row2[seatNumber - 1] == 1) {
                            System.out.println("Seat is ready to cancel");
                            row2[seatNumber - 1] = 0;
                            System.out.println("You have successfully canceled the booking of seat " + seatNumber + " in row 2");
                        } else {
                            System.out.println("This seat is already available!");
                        }
                    }
                    break;
                    case 3: {
                        if (seatNumber > 0 && seatNumber < 21 && row3[seatNumber - 1] == 1) {
                            row1[seatNumber - 1] = 0;
                            System.out.println("You have successfully canceled the booking of seat " + seatNumber + " in row 3");

                        } else {
                            System.out.println("This seat is already available!");
                        }
                    }
                    for (Ticket t : ticketsList) {
                        if (t.getRow() == rowNumber && t.getSeat() == seatNumber) {
                            ticketsList.remove(t);
                        }
                    }
                    break;
                }
                break;
            } else {
                System.out.println("Invalid row number or seat number!");
            }
        }
    }


    static void show_available() {
        System.out.println("Seats available in row 1:");
        int count1 = 1;

        for (int i : row1) {
            if (i == 1) {
                System.out.print(" ");
            } else {
                System.out.print("  " + count1);
            }
            count1++;
        }
        System.out.println("\n");
        int count2 = 1;
        System.out.println("Seats available in row 2:");
        for (int j : row2) {
            if (j == 1) {
                System.out.print(" ");
            } else {
                System.out.print("  " + count2);
            }
            count2++;
        }
        System.out.println("\n");
        int count3 = 1;
        System.out.println("Seats available in row 3:");
        for (int k : row3) {
            if (k == 1) {
                System.out.print(" ");
            } else {
                System.out.print("  " + count3);
            }
            count3++;
        }
        System.out.println("\n");
    }

    public static void save() {
        try {
            FileWriter NewTextFile = new FileWriter("TextFile.txt");
            NewTextFile.write("row 1:");
            int count1 = 1;
            for (int a : row1) {
                if (a == 1) {
                    NewTextFile.write(" ");
                } else {
                    NewTextFile.write(count1 + " ");
                }
                count1++;
            }
            NewTextFile.write(" \n");


            NewTextFile.write("row 2:");
            int count2 = 1;
            for (int b : row2) {
                if (b == 1) {
                    NewTextFile.write(" ");
                } else {
                    NewTextFile.write(count2 + " ");
                }
                count2++;
            }
            NewTextFile.write(" \n");


            NewTextFile.write("row 3:");
            int count3 = 1;
            for (int c : row3) {
                if (c == 1) {
                    NewTextFile.write(" ");
                } else {
                    NewTextFile.write(count3 + " ");
                }
                count3++;

            }
            NewTextFile.write(" \n");

            NewTextFile.close();
            System.out.println("Information was written to the file successfully!");
        } catch (IOException e) {
            System.out.println("An error occured.");
        }
    }
//Java Files
//https://www.w3schools.com/java/java_files_create.asp
//https://www.w3schools.com/java/java_files.asp


    public static void load() {
        try {
            File ReadingFile = new File("TextFile.txt");
            Scanner myReader = new Scanner(ReadingFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {                //https://www.javatpoint.com/filenotfoundexception-in-java
            System.out.println("An error occured. Can't find file.");
        }
    }
    //File reading
    //https://www.w3schools.com/java/java_files_read.asp

    public static ArrayList<Ticket> sort_tickets() {
        ArrayList<Ticket> sortedTickets = ticketsList;
        sortedTickets.sort((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()));
        for (Ticket ticket : sortedTickets) {
            ticket.print();
        }
        return sortedTickets;
    }

    public static void show_tickets_info() {
        double totalPrice = 0.00;

        for (Ticket t : ticketsList) {
            t.print();
            totalPrice = totalPrice + t.getPrice();
        }

        System.out.println("Total Price: " + totalPrice);
    }

    // https://www.geeksforgeeks.org/how-to-sort-an-arraylist-of-objects-by-property-in-java/
    //https://www.geeksforgeeks.org/sorting-in-java/

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("          Welcome to the New Theatre");
                System.out.println("-------------------------------------------------");
                System.out.println("          Please select an option:");
                System.out.println("1) Buy a ticket");
                System.out.println("2) Print seating area");
                System.out.println("3) Cancel ticket");
                System.out.println("4) List available seats");
                System.out.println("5) Save to file");
                System.out.println("6) Load from file");
                System.out.println("7) Print ticket information and total price");
                System.out.println("8) Sort tickets by price");
                System.out.println("0) Quit");
                System.out.println("-------------------------------------------------");

                Scanner input = new Scanner(System.in);
                System.out.print("Enter option:");
                int Option = input.nextInt();
                System.out.println();

                switch (Option) {
                    case 1:
                        buy_ticket();
                        Scanner option_m = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_1 = option_m.next();
                        if (option_1.equals("y")) {
                            continue;
                        } else if (option_1.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 2:
                        print_seating_area();
                        Scanner option_n = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_2 = option_n.next();
                        if (option_2.equals("y")) {
                            continue;
                        } else if (option_2.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 3:
                        cancel_ticket();
                        Scanner option_o = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_3 = option_o.next();
                        if (option_3.equals("y")) {
                            continue;
                        } else if (option_3.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 4:
                        show_available();
                        Scanner option_p = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_4 = option_p.next();
                        if (option_4.equals("y")) {
                            continue;
                        } else if (option_4.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 5:
                        save();
                        Scanner option_q = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_5 = option_q.next();
                        if (option_5.equals("y")) {
                            continue;
                        } else if (option_5.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 6:
                        load();
                        Scanner option_r = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_6 = option_r.next();
                        if (option_6.equals("y")) {
                            continue;
                        } else if (option_6.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 7:
                        show_tickets_info();
                        Scanner option_s = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_7 = option_s.next();
                        if (option_7.equals("y")) {
                            continue;
                        } else if (option_7.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 8:
                        sort_tickets();
                        Scanner option_t = new Scanner(System.in);
                        System.out.print("Do you want to continue with another option press 'y' or press any key or 'q' to exit : ");
                        String option_8 = option_t.next();
                        if (option_8.equals("y")) {
                            continue;
                        } else if (option_8.equals("q")) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                        break;
                    case 0:
                        System.out.println("You are now exiting the program!\nHave a good day!");
                        break;

                }
                break;
            } catch (Exception e) {
                System.out.println("Not A valid input! Please try again");
            }
        }
    }
}
//system.exit:-
//https://stackoverflow.com/questions/52765371/how-do-i-return-to-the-main-method-from-another-method-in-the-same-class-break