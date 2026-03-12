import java.util.*;

class RitualEntry {

    String date;
    String week;
    String bestMoment;
    String challenge;
    String learning;
    String gratitude;
    String improvement;
    String futureMessage;
    int mood;

    RitualEntry(String date,String week,String bestMoment,String challenge,
                String learning,String gratitude,String improvement,
                String futureMessage,int mood){

        this.date=date;
        this.week=week;
        this.bestMoment=bestMoment;
        this.challenge=challenge;
        this.learning=learning;
        this.gratitude=gratitude;
        this.improvement=improvement;
        this.futureMessage=futureMessage;
        this.mood=mood;
    }
}

class VentEntry {

    String date;
    String message;
    int mood;

    VentEntry(String date,String message,int mood){

        this.date=date;
        this.message=message;
        this.mood=mood;
    }
}

public class Unmute {

    static Scanner sc=new Scanner(System.in);

    static ArrayList<RitualEntry> rituals=new ArrayList<>();
    static ArrayList<VentEntry> vents=new ArrayList<>();

    // CO4 IMPLEMENTATION (HashMap for fast lookup using date)
    static HashMap<String,RitualEntry> ritualMap=new HashMap<>();


    public static void main(String[] args){

        while(true){

            System.out.println("\n===== INNER SPACE =====");
            System.out.println("1. Weekly Ritual");
            System.out.println("2. Vent");
            System.out.println("3. View Sealed Ritual Entries");
            System.out.println("4. View Vent Entries");
            System.out.println("5. Search Ritual by Mood");
            System.out.println("6. Sort Rituals by Mood");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    weeklyRitual();
                    break;

                case 2:
                    vent();
                    break;

                case 3:
                    viewRituals();
                    break;

                case 4:
                    viewVents();
                    break;

                case 5:
                    searchRitual();
                    break;

                case 6:
                    sortRituals();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }


    static void weeklyRitual(){

        System.out.println("\n--- Weekly Ritual ---");

        System.out.print("How was your overall week? ");
        String week=sc.nextLine();

        System.out.print("Best moment of your week: ");
        String best=sc.nextLine();

        System.out.print("What challenged you the most? ");
        String challenge=sc.nextLine();

        System.out.print("Did you learn something new? ");
        String learning=sc.nextLine();

        System.out.print("What are you grateful for? ");
        String gratitude=sc.nextLine();

        System.out.print("What would you improve next week? ");
        String improve=sc.nextLine();

        System.out.print("Rate your mood (1-10): ");
        int mood=sc.nextInt();
        sc.nextLine();

        System.out.print("Message to your future self: ");
        String future=sc.nextLine();

        String date=new Date().toString();

        RitualEntry entry = new RitualEntry(date,week,best,challenge,learning,
                gratitude,improve,future,mood);

        rituals.add(entry);

        // CO4: storing entry in HashMap using date as key
        ritualMap.put(date,entry);

        System.out.println("Week sealed successfully!");
    }


    static void vent(){

        System.out.println("\n--- Vent Space ---");

        System.out.print("Write whatever you feel: ");
        String msg=sc.nextLine();

        System.out.print("Mood (1-10): ");
        int mood=sc.nextInt();
        sc.nextLine();

        String date=new Date().toString();

        vents.add(new VentEntry(date,msg,mood));

        System.out.println("Vent saved.");
    }


    static void viewRituals(){

        if(rituals.size()==0){
            System.out.println("No ritual entries yet.");
            return;
        }

        for(int i=0;i<rituals.size();i++){

            RitualEntry r=rituals.get(i);

            System.out.println("\nEntry "+(i+1));
            System.out.println("Date: "+r.date);
            System.out.println("Mood: "+r.mood);
            System.out.println("Week Reflection: "+r.week);
            System.out.println("Best Moment: "+r.bestMoment);
            System.out.println("Challenge: "+r.challenge);
            System.out.println("Learning: "+r.learning);
            System.out.println("Gratitude: "+r.gratitude);
            System.out.println("Improvement: "+r.improvement);
            System.out.println("Future Message: "+r.futureMessage);
        }
    }


    static void viewVents(){

        if(vents.size()==0){
            System.out.println("No vent entries yet.");
            return;
        }

        for(int i=0;i<vents.size();i++){

            VentEntry v=vents.get(i);

            System.out.println("\nVent "+(i+1));
            System.out.println("Date: "+v.date);
            System.out.println("Mood: "+v.mood);
            System.out.println("Message: "+v.message);
        }
    }


    static void searchRitual(){

        System.out.print("Enter mood to search: ");
        int target=sc.nextInt();

        boolean found=false;

        for(RitualEntry r:rituals){

            if(r.mood==target){

                System.out.println("\nEntry Found:");
                System.out.println("Date: "+r.date);
                System.out.println("Mood: "+r.mood);
                System.out.println("Best Moment: "+r.bestMoment);

                found=true;
            }
        }

        if(!found)
            System.out.println("No entry with that mood.");
    }


    static void sortRituals(){

        for(int i=0;i<rituals.size()-1;i++){

            for(int j=0;j<rituals.size()-i-1;j++){

                if(rituals.get(j).mood > rituals.get(j+1).mood){

                    RitualEntry temp=rituals.get(j);
                    rituals.set(j,rituals.get(j+1));
                    rituals.set(j+1,temp);
                }
            }
        }

        System.out.println("Ritual entries sorted by mood.");
    }

}