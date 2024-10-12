package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Zoo {
    private static int no_visitor=0;
    private static double revenue=0;
    private static ArrayList<Animal> animals=new ArrayList<>();
    private static ArrayList<Visitor> visitors= new ArrayList<>();
    private static ArrayList<Attraction> attractions= new ArrayList<>();
    private static ArrayList<Discount> discountlist= new ArrayList<>();
    private static ArrayList<SpecialDeal> deallist= new ArrayList<>();
    private static ArrayList<Feedback> feedbacklist= new ArrayList<>();
    public Zoo() {
    }
    public static void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public static void adddeal(SpecialDeal abc){
        deallist.add(abc);
    }
    public static void addDiscount(Discount animal) {
        discountlist.add(animal);
    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }
    protected static ArrayList<SpecialDeal> getspecialDeals() {
        return deallist;
    }

    protected static ArrayList<Feedback> getfeedbacklist() {
        return feedbacklist;
    }

    public static void enterAsAdmin(admin abc) {
        admin head =null;
        System.out.println("Enter Admin Username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter Admin Password: ");
        String password = scanner.nextLine();
        if (username.equals(abc.getusr()) && password.equals(abc.getpass())) {
            System.out.println("LOGINED SUCCESFULLY");
            while (true){
                head=abc;
                System.out.println("Admin Menu:");
                System.out.println("1. Manage Attractions");
                System.out.println("2. Manage Animals");
                System.out.println("3. Schedule Events");
                System.out.println("4. Set Discounts");
                System.out.println("5. Set Special Deal");
                System.out.println("6. View Visitor Stats");
                System.out.println("7. View Feedback");
                System.out.println("8. Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
                if(choice==8){
                    System.out.println("exited successfully");
                    break;
                }
                switch (choice) {
                    case 1:
                        head.getManageAttractionsMenuChoice();
                        break;
                    case 2:
                        head.getManageAnimals();
                        break;
                    case 3:
                        head.askToChangeAttractionStatus();
                        break;
                    case 4:
                        // Set discounts.
                        head.setdiscount();
                        break;
                    case 5:
                        // Set special deal.
                        head.setdeal();
                        break;
                    case 6:
                        // View visitor stats.
                        head.ststistic();
                        break;
                    case 7:
                        // View feedback.
                        head.viewfeedback();
                        break;

                    default:
                        System.out.println("Invalid choice try again.");
                }}}
        else {
            System.out.println("Invalid username or password.");
        }
    }
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public static ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public static void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public static ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public static ArrayList<Discount> getDiscount() {
        return discountlist;
    }

    public static ArrayList<Attraction> getEligibleAttractions() {
        ArrayList<Attraction> abcc =new ArrayList<>();
        for(Attraction obj:attractions){
            if(obj.get_status().equals("OPEN")) {
                abcc.add(obj);
            }
        }
        return abcc ;
    }
    public void viewdiscount(){
        int i=1;
        for (Discount obj:discountlist){
            System.out.println(Integer.toString(i)+". "+obj.getDiscountCode());
            i++;
        }
    }
    public void viewdeals(){
        int i=1;
        for (SpecialDeal obj:deallist){
            System.out.println(Integer.toString(i)+". "+obj.getName()+" (" +obj.getDescription()+")");
            i++;
        }
    }
    public void enterAsVisitor() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3.EXIT");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice==3){
                break;
            }
            switch (choice) {
                case 1:
                    Scanner scannerr = new Scanner(System.in);
                    System.out.println("Enter your IDno: ");
                    int id = scannerr.nextInt();
                    System.out.println("Enter your name: ");
                    Scanner scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    System.out.println("Enter your age: ");
                    int age = scannerr.nextInt();
                    System.out.println("Enter your phone number: ");
                    Scanner abc =new Scanner(System.in);
                    String phoneNumber = abc.nextLine();
                    System.out.println("Enter your balance: ");
                    double balance = scannerr.nextDouble();

                    System.out.println("Enter your email address: ");
                    String emailAddress = scan.nextLine();

// Prompt the user for their password.
                    System.out.println("Enter a password: ");
                    String password = scan.nextLine();

                    Visitor visitor = new Visitor(id, name, age, phoneNumber, balance, emailAddress, password);
                    System.out.println("registered succcesfully");
                    Zoo.visitorinc();
                    break;
                case 2:
                    Scanner sca =new  Scanner(System.in);

                    System.out.println("Enter your email address: ");
                    String email = sca.nextLine();

                    System.out.println("Enter your password: ");
                    String ppassword = sca.nextLine();
                    Visitor men = null;
                    for (Visitor visitorr : visitors) {
                        if (visitorr.getEmail().equals(email) && visitorr.getPassword().equals(ppassword)) {
                            men = visitorr;
                        }
                    }
                    if (men == null) {
                        System.out.println("please register first");
                    } else {
                        System.out.println("login successfully");
                        while (true) {
                            Scanner scanneer = new Scanner(System.in);
                            System.out.println("Visitor Menu:");
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Leave Feedback");
                            System.out.println("9.Balance");
                            System.out.println("10. Log Out");
                            System.out.println("Enter your choice: ");
                            int choicee = scanneer.nextInt();
                            if (choicee == 10) {

                                break;
                            }
                            switch (choicee) {
                                case 1:
                                    men.ExploreZoo();
                                    break;
                                case 2:
                                    men.buyMembership();
                                    break;
                                case 3:
                                    men.buyTicket();
                                    break;
                                case 4:
                                    // View discounts.
                                    men.viewdiscount();
                                    break;
                                case 5:
                                    men.viewdeals();
                                    break;
                                case 6:
                                    // Visit animals.
                                    men.visitAnimal();
                                    break;
                                case 7:
                                    // Visit attractions.
                                    men.visitAttraction();
                                    break;
                                case 8:
                                    // Leave feedback.
                                    men.leaveFeedback();
                                    break;
                                case 9:
                                    // Leave feedback.
                                    System.out.println(men.getBalance());
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                        }
                    }

                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static int getNo_visitor() {
        return no_visitor;
    }

    public static void visitorinc() {
        Zoo.no_visitor +=1;

    }

    public static double    getRevenue() {
        return revenue;
    }

    public static void setRevenue(double revenue) {
        Zoo.revenue += revenue;
    }
}
class Feedback{
    private String feedback;

    public void setFeedback(String xxx){
        this.feedback=xxx;
    }
    public String getFeedback(){
        return feedback;
    }
}
class SpecialDeal {

    private String name;
    private String description;
    private int tickets;
    private int discount;

    public SpecialDeal(String name, String description, int tickets, int discount) {
        this.name = name;
        this.description = description;
        this.tickets = tickets;
        this.discount = discount;
        Zoo.adddeal(this);
    }
    public double applydeal(double price){
        return price-price*discount/100;

    }

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

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

class Attraction extends Zoo {
    private int id;
    private String name;
    private double price;
    private int visited =0;
    private int ticket_user=0;
    private String status ="OPEN";

    public Attraction(int id, String name, String status, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status=status;
        Zoo.addAttraction(this);

    }
    public int getvisited(){
        return visited;
    }
    public int getId() {
        return id;
    }

    public void setId(int newid) {
        this.id= newid;
    }


    public String getName() {
        return name;
    }
    public void setName(String newname) {
        this.name = newname;}

    public void setPrice(int price) {
        this.price = price;
    }


    public double getPrice() {
        return price;
    }

    public void set_status(String newstatus){
        this.status=newstatus;
    }
    public String get_status(){
        return this.status;
    }

    public void ticketuserINC(){
        this.ticket_user=ticket_user++;
    }
    public void visitorsINC(){
        this.visited=this.visited+1;
    }
}



class Animal extends Zoo {
    private int id;
    private String name;
    private String description;
    private String animalType;
    private String sound;

    public Animal(int id, String name,String animalType,String description,String sound) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.sound=sound;
        this.description=description;
        Zoo.addAnimal(this);

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void settype(String newname){
        this.animalType=newname;
    }
    public void setDescription(String newname){
        this.description=newname;
    }
    public void setname(String newname){
        this.name=newname;
    }
    public void setSound(String newname){
        this.sound=newname;
    }
    public String gettype() {
        return this.animalType;
    }

    public void feed(){
        System.out.println(this.sound);
    }
    public void read(){
        System.out.println(this.description);
    }
}

class Visitor extends Zoo{

    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private double balance;
    private String email;
    private String password;
    private int experienceLevel;
    private ArrayList<Ticket> tickets;

    // ... other methods ...

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    Visitor(int id, String name, int age, String phoneNumber, double balance, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.email = email;
        this.password = password;
        this.experienceLevel = -1;
        Zoo.getVisitors().add(this);
        tickets=new ArrayList<>();
    }

    public Visitor() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public int getExperienceLevel() {
        return experienceLevel;
    }
    public void setExperienceLevel(int abc) {
        experienceLevel=abc;
    }


    public  void leaveFeedback() {
        System.out.println("please enter feedbackin max 200words");
        Scanner feedbackk =new Scanner(System.in);

        Feedback feedback =new Feedback();
        String feed =feedbackk.nextLine();
        feedback.setFeedback(feed);
        Zoo.getfeedbacklist().add(feedback);
        System.out.println("Thank you for your feedback!");
    }
    public void ExploreZoo() {
        while(true){
            System.out.println("Explore the Zoo:");
            System.out.println( "1. View Attractions \n2. View Animals\n3. Back");
            Scanner inputt =new Scanner(System.in);
            int usrinput= inputt.nextInt();
            if(usrinput==1){
                int i=1;
                for (Attraction obj : Zoo.getAttractions()) {
                    System.out.println(Integer.toString(i)+" "+obj.getName());
                    i++;  }

            }
            else if(usrinput==2){
                int i=1;
                for (Animal obj : Zoo.getAnimals()) {
                    System.out.println(Integer.toString(i)+" "+obj.getName());
                    i++;  }
                ;

            }
            else if(usrinput==3){
                break;
            }
            else{
                System.out.println("InVALID INPUT TRY AGAIN");
            }
        }




    }
    public void visitAttraction() {
        int experienceLevel = this.experienceLevel;
        int i = 1;
        for (Attraction obj :  Zoo.getAttractions()) {
            if(obj.get_status().equals("OPEN")){
                System.out.println(Integer.toString(i) + " " + obj.getName() + "($"+obj.getPrice()+')');
                i++;
            }}
        System.out.println("choose the attraction too visit:");
        Scanner scanner = new Scanner(System.in);
        int attractionIndex = scanner.nextInt();
        Attraction chosenAttraction =  Zoo.getAttractions().get(attractionIndex - 1);
        if (experienceLevel == 1) {
            System.out.println("Welcome to the " + chosenAttraction.getName() + " attraction!");
            chosenAttraction.visitorsINC();
        } else {
            for (Ticket tick : tickets) {
                if (tick.number() > 0) {
                    if (tick.getId() == chosenAttraction.getId()) {
                        tick.numberdec();
                        System.out.println("Welcome to the " + chosenAttraction.getName() + " attraction!");
                        chosenAttraction.visitorsINC();
                        return;
                    }
                }
            }
            System.out.println("please purchase ticket first");


        }
    }

    public void buyMembership() {
        if(this.experienceLevel==-1|| this.experienceLevel==0){
            System.out.println("Please select a membership to purchase:");
            System.out.println("1. Premium (50rs)");
            System.out.println("2. Basic (20rs)");
            Scanner scanner = new Scanner(System.in);
            int membershipIndex = scanner.nextInt();
            System.out.println("would like to apply discount");
            System.out.println("1.YES");
            System.out.println("2.NO");
            int response =scanner.nextInt();

            if (response==1) {
                System.out.println("Please select a discount:");
                int iii = 0;
                for (Discount discount : Zoo.getDiscount()) {
                    System.out.println(Integer.toString(iii) + ". " + discount.getDiscountCode());
                    iii++;
                }
                int discountIndex = scanner.nextInt();
                switch (membershipIndex) {
                    case 1 -> {
                        double price = Zoo.getDiscount().get(discountIndex).applyDiscount(50);
                        if (this.getBalance() >= price) {
                            this.setExperienceLevel(1);
                            this.balance -= price;
                            System.out.println("You have successfully purchased a PREMIUM membership!");
                            Zoo.setRevenue(price);
                        } else {
                            System.out.println("insufficient balance");
                        }
                    }
                    case 2 -> {
                        double pricee = Zoo.getDiscount().get(discountIndex).applyDiscount(20);
                        if (this.getBalance() >= pricee) {
                            this.setExperienceLevel(0);
                            this.balance -= pricee;
                            Zoo.setRevenue(pricee);
                            System.out.println("You have successfully purchased a BASIC membership!");
                        } else {
                            System.out.println("insufficient balance");

                        }
                    }
                    default -> {
                        System.out.println("Invalid membership selection.");

                    }
                }
            }
            else{
                switch (membershipIndex) {
                    case 1 -> {
                        if (this.getBalance() >= 50) {
                            this.setExperienceLevel(1);
                            this.balance -= 50;
                            Zoo.setRevenue(50);
                            System.out.println("You have successfully purchased a PREMIUM membership!");
                        } else {
                            System.out.println("insufficient balance");
                        }
                    }
                    case 2 -> {
                        if (this.getBalance() >= 20) {
                            this.setExperienceLevel(0);
                            this.balance -= 20;
                            Zoo.setRevenue(20);
                            System.out.println("You have successfully purchased a BASIC membership!");
                        } else {
                            System.out.println("insufficient balance");

                        }
                    }
                    default -> {
                        System.out.println("Invalid membership selection.");
                        return;
                    }
                }
            }}
        else{
            System.out.println("you have already purchased premium  memmbership");
        }

    }

    public void visitAnimal() {
        System.out.println("Please select an animal to visit:");
        int i = 1;
        for (Animal animal : Zoo.getAnimals()) {
            System.out.println(Integer.toString(i) + ". " + animal.getName());
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int animalIndex = scanner.nextInt();
        Animal chosenAnimal = Zoo.getAnimals().get(animalIndex-1);

        System.out.println("Would you like to feed the animal or read about the animal? (Enter feed or read)");
        Scanner scannerr = new Scanner(System.in);
        String response = scannerr.nextLine();

        // If the visitor chooses to feed the animal, play the animal's sound effect.
        if (response.equalsIgnoreCase("feed")) {
            chosenAnimal.feed();
            System.out.println("feed succesfully");
        }

        if (response.equalsIgnoreCase("read")) {
            chosenAnimal.read();
            System.out.println("read successfully");
        }
    }

    public void buyTicket() {
        if(this.experienceLevel==1){
            System.out.println("YOU ARE  PREMIUM MEMBER NO NEED TO BUY TICKETS");
        }
        else{
            ArrayList<Attraction> eligibleAttractions = Zoo.getEligibleAttractions();
            System.out.println("Please select an attraction to purchase a ticket for:");
            int i = 0;
            for (Attraction attraction : eligibleAttractions) {
                System.out.println(Integer.toString(i) + ". " + attraction.getName());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            int attractionIndex = scanner.nextInt();
            Attraction chosenAttraction = eligibleAttractions.get(attractionIndex);

            System.out.println("How many tickets would you like to purchase?");
            int numberOfTickets = scanner.nextInt();
            SpecialDeal applicableSpecialDeal = null;
            for (SpecialDeal specialDeal : Zoo.getspecialDeals()) {
                if (specialDeal.getTickets() <= numberOfTickets) {
                    applicableSpecialDeal = specialDeal;
                    break;
                }
            }
            Ticket ticket = new Ticket(chosenAttraction,numberOfTickets);
            if (applicableSpecialDeal != null) {
                System.out.println("There is a special deal available for the attraction you have selected:");
                System.out.println(applicableSpecialDeal.getName() + ": " + applicableSpecialDeal.getDescription());
                System.out.println("Would you like to apply this special deal? (Enter yes or no)");
                Scanner abcc = new Scanner(System.in);
                String response = abcc.nextLine();
                double ticketPrice = chosenAttraction.getPrice() * numberOfTickets;

                if (response.equalsIgnoreCase("yes")) {
                    ticketPrice = applicableSpecialDeal.applydeal(ticketPrice);
                    ticket.setPrice(ticketPrice);
                    System.out.println("DEAL APPLIED SUCCESSFULLY");}
                else if (response.equalsIgnoreCase("no")){
                    ticket.setPrice(ticketPrice);

                }
                System.out.println("now ticket price is"+ticket.getPrice());}
            System.out.println("Would you like to apply a discount? (Enter yes or no)");
            Scanner sccanner = new Scanner(System.in);
            String response = sccanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                // Display a list of all available discounts.
                System.out.println("Please select a discount:");
                int iii = 0;
                for (Discount discount : Zoo.getDiscount()) {
                    System.out.println(Integer.toString(iii) + ". " + discount.getDiscountCode());
                    iii++;
                }
                int discountIndex = scanner.nextInt();

                ticket.setPrice(Zoo.getDiscount().get(discountIndex).applyDiscount(ticket.getPrice()));
                System.out.println("TOTAL Ticket price after discount is "+ ticket.getPrice());
            }

            if (balance >= ticket.getPrice()) {
                balance -= ticket.getPrice();
                tickets.add(ticket);
                Zoo.setRevenue(ticket.getPrice());
            } else {
                System.out.println("Insufficient balance. Please top up your balance to purchase the ticket.");
                return;
            }
            System.out.println("ticket purchased succesfully");
        }
    }
}
class Discount extends Zoo{
    private String discountCode;
    private double discountPercentage;
    Discount(String discountCode, double discountPercentage) {
        super();
        this.discountCode = discountCode;
        this.discountPercentage = discountPercentage;
        Zoo.addDiscount(this);
    }
    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }



    public double applyDiscount(double amount) {
        return amount - (amount * discountPercentage) / 100;
    }
}
class Ticket {
    private int id;
    private String attractionName;
    private double price;
    private int numbers = 0;
    public Ticket(Attraction attraction, int no) {
        this.id = attraction.getId();
        this.attractionName = attraction.getName();
        this.price = attraction.getPrice();
        this.numbers = no;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttraction() {
        return attractionName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int number() {
        return numbers;
    }

    public void numberinc() {
        numbers++;
    }

    public void numberdec() {
        numbers--;
    }


}class admin extends Zoo{
    private final String usr="admin";
    private final String password="admin123";
    public String getusr(){
        return usr;
    }
    public String getpass(){
        return password;
    }
    public void getManageAnimals() {
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Manage Animals Menu:");
            System.out.println("1. Add Animal");
            System.out.println("2. Update Animal Details");
            System.out.println("3. Remove Animal");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            if(choice==4){
                break;
            }
            switch (choice) {
                case 1:

                    // Prompt the user to enter the animal ID.
                    System.out.println("Enter the animal ID: ");

                    // Read the animal ID.
                    int animalId = scanner.nextInt();

                    // Prompt the user to enter the animal name.
                    System.out.println("Enter the animal name: ");
                    Scanner nnn =new Scanner(System.in);
                    // Read the animal name.
                    String animalName = nnn.nextLine();

                    // Prompt the user to enter the animal type.
                    System.out.println("Enter the animal type: ");

                    // Read the animal type.
                    String animalType = nnn.nextLine();

                    // Prompt the user to enter the animal description.
                    System.out.println("Enter the animal description: ");

                    // Read the animal description.
                    String animalDescription = nnn.nextLine();

                    // Prompt the user to enter the animal sound.
                    System.out.println("Enter the animal sound: ");

                    // Read the animal sound.
                    String animalSound = nnn.nextLine();

                    // Create a new Animal object with the user-provided input.
                    Animal animal = new Animal(animalId, animalName, animalType, animalDescription, animalSound);
                    System.out.println("animal added successfully");

                    break;
                case 2:// Display the list of animals to the user.
                    System.out.println("List of Animals:");
                    int a=1;
                    for (Animal animall : Zoo.getAnimals()) {
                        System.out.println(Integer.toString(a)+ ". " + animall.getName());
                        a++;
                    }


                    System.out.println("Enter the ID of the animal whose details you want to modify: ");
                    int index = scanner.nextInt();
                    Animal choosenanimal = Zoo.getAnimals().get(index-1);
                    while(true){
                        System.out.println("What do you want to modify?");
                        System.out.println("1. Name");
                        System.out.println("2. Type");
                        System.out.println("3. Description");
                        System.out.println("4. Sound");
                        System.out.println("5. BACK");
                        System.out.println("Enter your choice: ");
                        int chooice = scanner.nextInt();
                        Scanner newscan= new Scanner(System.in);
                        if (chooice==5){
                            break;
                        }
                        switch (chooice) {

                            case 1:
                                System.out.println("enter name");
                                String abc = newscan.nextLine();
                                choosenanimal.setname(abc);

                                System.out.println("NAME  MODIFIED SUCCESSFULLY");
                                break;
                            case 2:

                                System.out.println("enter type");
                                String abcc = newscan.nextLine();
                                choosenanimal.settype(abcc);
                                System.out.println("TYPE  MODIFIED SUCCESSFULLY");
                                break;
                            case 3:
                                System.out.println("enter description");
                                String abcd = newscan.nextLine();
                                choosenanimal.setDescription(abcd);
                                System.out.println("DESCRIPTION  MODIFIED SUCCESSFULLY");
                                break;
                            case 4:
                                System.out.println("enter sound");
                                String abdc = newscan.nextLine();
                                choosenanimal.setSound(abdc);
                                System.out.println("SOUND MODIFIED SUCCESSFULLY");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }}
                    break;
                case 3: System.out.println("List of Animals:");
                    int aa=1;
                    for (Animal animall : Zoo.getAnimals()) {
                        System.out.println(Integer.toString(aa)+ ". " + animall.getName());
                        aa++;
                    }

                    // Prompt the user to choose an animal.
                    System.out.println("Enter the ID of the animal whose you want to remove ");

                    // Read the user's choice.
                    int indexx = scanner.nextInt();

                    // Get the animal that the user wants to modify.
                    Animal choosenanimall = Zoo.getAnimals().get(indexx-1);

                    Zoo.getAnimals().remove(choosenanimall);


                    break;
                default:
                    System.out.println("Invalid choice.");
            }


        }}

    public void getManageAttractionsMenuChoice() {

        while(true){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Manage Attractions Menu:");
            System.out.println("1. Add Attraction");
            System.out.println("2. View Attractions");
            System.out.println("3. Modify Attraction");
            System.out.println("4. Remove Attraction");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            if(choice==5){
                break;
            }
            switch (choice) {
                case 1:
                    // Add Attractio
                    scanner.nextLine();
                    System.out.print("Enter Attraction ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Attraction Name: ");
                    Scanner cc= new Scanner(System.in);
                    String name = cc.nextLine();
                    System.out.print("Enter Attraction Price: ");
                    int price= scanner.nextInt();
                    Attraction a= new Attraction(id,name,"OPEN",price);
                    System.out.println("Attraction added successfully.");

                    break;
                case 2:
                    // View Attractions
                    int i=1;
                    System.out.println("List of Attractions:");
                    for (Attraction attraction : Zoo.getAttractions()) {
                        System.out.println(Integer.toString(i)+". "+attraction.getName());
                        i++;}
                    break;
                case 3:
                    if(!Zoo.getAttractions().isEmpty()) {
                        int ii = 1;
                        System.out.println("List of Attractions choose which u want to modify:");
                        for (Attraction attraction : Zoo.getAttractions()) {
                            System.out.println(Integer.toString(ii) + ". " + attraction.getName());
                            ii++;
                        }
                        int index = scanner.nextInt();
                        System.out.println("ATTRACTION CHOOSED SUCCESFULLY");

                        Attraction chosenatraction = Zoo.getAttractions().get(index - 1);
                        while (true) {
                            System.out.println("What do you want to modify?");
                            System.out.println("1. Name");
                            System.out.println("2. Price");
                            System.out.println("3. BACK");
                            System.out.println("Enter your choice: ");
                            int cchoice = scanner.nextInt();
                            if (cchoice == 3) {
                                break;

                            }
                            switch (cchoice) {
                                case 1:
                                    System.out.print("ENTER NAME");
                                    Scanner abbb=new Scanner(System.in);
                                    String nnn = abbb.nextLine();
                                    chosenatraction.setName(nnn);
                                    break;
                                case 2:
                                    System.out.print("ENTER PRICE");
                                    int nnnm = scanner.nextInt();
                                    chosenatraction.setPrice(nnnm);
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }
                            System.out.println("attraction modified successfully");
                        }

                    }else{
                        System.out.println("NO ATTRACTION TO MODIFY PLEASE ADD FIRST");
                    }
                    break;
                case 4:
                    // Remove Attraction
                    int iii=1;
                    System.out.println("List of Attractions choose which u want to modify:");
                    for (Attraction attraction : Zoo.getAttractions()) {
                        System.out.println(Integer.toString(iii)+". "+attraction.getName());
                        iii++;}
                    int indexx = scanner.nextInt();
                    Zoo.getAttractions().remove(indexx-1);
                    System.out.println("ATTRACTION removed SUCCESFULLY");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }}
    }
    public void setdeal(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            // Display the menu options to the user.
            System.out.println("What do you want to do?");
            System.out.println("1. Add Deal");
            System.out.println("2. Remove Deal");
            System.out.println("3.EXIT");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            if(choice==1){

                System.out.println("Enter the special deal name: ");
                Scanner abc =new Scanner(System.in);
                // Read the special deal name.
                String name = abc.nextLine();

                // Prompt the user to enter the special deal description.
                System.out.println("Enter the special deal description: ");

                // Read the special deal description.
                String description = abc.nextLine();

                // Prompt the user to enter the number of tickets available for the special deal.
                System.out.println("Enter the number of tickets available for the special deal: ");

                // Read the number of tickets available for the special deal.
                int tickets = scanner.nextInt();

                // Prompt the user to enter the discount for the special deal.
                System.out.println("Enter the discount percentage for the special deal: ");

                // Read the discount for the special deal.
                int discount = scanner.nextInt();
                SpecialDeal specialDeal = new SpecialDeal(name, description, tickets, discount);
            }
            else if (choice==2){
                ArrayList<SpecialDeal> specialDeals = Zoo.getspecialDeals();
                if(!specialDeals.isEmpty()){
                    int i=1;
                    System.out.println("List of Special Deals:");
                    for (SpecialDeal specialDeal : specialDeals) {
                        System.out.println(Integer.toString(i)+ ". " + specialDeal.getName());
                        i++;
                    }
                    System.out.println("Enter the ID of the special deal you want  remove: ");
                    int choicce = scanner.nextInt();
                    Zoo.getspecialDeals().remove(choicce-1);
                    System.out.println("DEAL REMOVED SUCCESSFULLY");
                }
                else{
                    System.out.println("NO DEAL TO REMOVE");}
            }
            else if(choice==3){
                break;
            }
            else{
                System.out.println("INvalid input");
            }
        }
    }
    public void setdiscount(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("What do you want to do?");
            System.out.println("1. Add Discount");
            System.out.println("2. Remove Discount");
            System.out.println("3.EXIT");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            if(choice==1){
                System.out.println("Enter the discount name: ");
                Scanner abd =new Scanner(System.in);
                // Read the special deal name.
                String name = abd.nextLine();
                System.out.println("Enter the discount percentage ");
                double discount = scanner.nextDouble();
                Discount newdiscount =new Discount(name,discount);
            }
            else if (choice==2){
                ArrayList<Discount> specialDeals = Zoo.getDiscount();
                if(!Zoo.getDiscount().isEmpty()){
                    int i=1;
                    // Display the list of special deals to the user.
                    System.out.println("List of Discount:");
                    for (Discount specialDeal : specialDeals) {
                        System.out.println(Integer.toString(i)+ ". " + specialDeal.getDiscountCode());
                        i++;
                    }
                    System.out.println("Enter the ID of the discount you want  remove: ");

                    // Read the user's choice.
                    int choicce = scanner.nextInt();
                    Zoo.getDiscount().remove(choicce-1);
                    System.out.println("Discount REMOVED SUCCESSFULLY");
                }else{
                    System.out.println("NO discounts to remove");
                }}
            else if(choice==3){
                break;
            }
            else{
                System.out.println("INVALID INPUT");
            }

        }

    }

    public void viewfeedback(){
        System.out.println("FEEDBACK ARE FOLLOWING");
        int i=0;
        for(Feedback obj:Zoo.getfeedbacklist()){
            System.out.println(Integer.toString(i)+". "+obj.getFeedback());
            i++;
        }
        System.out.println("-------------------end ----------------------");
    }
    public void ststistic(){
        Attraction maximumVisitedAttraction = null;
        int maximumNumberOfVisits = 0;
        for (Attraction attraction : Zoo.getAttractions()) {
            int numberOfVisits = attraction.getvisited();
            if (numberOfVisits > maximumNumberOfVisits) {
                maximumVisitedAttraction = attraction;
                maximumNumberOfVisits = numberOfVisits;
            }
        }
        System.out.println("Visitor Statistics:");
        System.out.println("Total Visitors: " + Zoo.getNo_visitor());
        System.out.println("Total Revenue: $" + Zoo.getRevenue());

        assert maximumVisitedAttraction != null;
        System.out.println("Most Popular Attraction: " + maximumVisitedAttraction.getName());

    }
    public void askToChangeAttractionStatus() {
        int i=1;
        for (Attraction attraction : Zoo.getAttractions()) {
            System.out.println(Integer.toString(i)+". "+attraction.getName());
            i++;
        }
        System.out.println("Enter the ID of the attraction you want to change the status of: ");
        Scanner scanner = new Scanner(System.in);
        int attractionId = scanner.nextInt();
        attractionId--;
        System.out.println("PLEASE SELECT: ");
        System.out.println("1.OPEN");
        System.out.println("2.CLOSE");
        int newStatus = scanner.nextInt();
        if(newStatus==1){
            Zoo.getAttractions().get(attractionId).set_status("OPEN");
            System.out.println("CHANGED SUCCESSFULLY");
        }
        else if (newStatus==2){
            Zoo.getAttractions().get(attractionId).set_status("CLOSED");
            System.out.println("CHANGED SUCCESSFULLY");
        }
        else {
            System.out.println("invalid input");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Zoo zoo =new Zoo();
        SpecialDeal deal =new SpecialDeal("DIWALI10","buy three 3 and get 10 %off",3,10);
        Animal lion = new Animal(12,"lion","mammal","kill smoothly","roar");
        Animal dog = new Animal(123,"dog","mammal","bites hardly","bark");
        Attraction gg =new Attraction(1,"GODZILLA","OPEN",40);
        Discount d1 = new Discount("MINOR10",10);
        Discount d2 = new Discount("SENIOR20",20);
        while(true) {
            System.out.println("Welcome to ZOOtopia!");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. EXIT");
            System.out.println("Enter your choice: ");
            admin ADMIN = new admin();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 4) {
                break;
            }
            switch (choice) {
                case 1:
                    Zoo.enterAsAdmin(ADMIN);
                    break;
                case 2:
                    zoo.enterAsVisitor();
                    break;
                case 3:
                    zoo.viewdeals();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }
}