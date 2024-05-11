import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Manager manager = new Manager();
        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        int counter = 0; // it counts the nu,ner of exports to create a different file every time and prevent overwriting files

        System.out.println("1. add");
        System.out.println("2. remove");
        System.out.println("3. notes");
        System.out.println("4. export");
        System.out.println("5. exit");
        String command = in.next();
        while (!command.equals("5")){
            if (command.equals("1")){
                String topic;
                String note;
                System.out.print("write your topic : ");
                topic = in1.nextLine();
                System.out.print("write your note : ");
                note = in1.nextLine();
                manager.add_note(topic, note);
            }
            else if (command.equals("2")){
                manager.show_list_of_notes_from_file();
                System.out.print("enter the index: ");
                int index = in.nextInt();
                manager.remove(index);
            }
            else if (command.equals("3")){
                manager.show_list_of_notes_from_file();
                System.out.print("enter the index : ");
                int index = in.nextInt();
                manager.show_Notes(index);
            }
            else if (command.equals("4")){
                manager.show_list_of_notes_from_file();
                System.out.print("enter the index : ");
                int index = in.nextInt();
                manager.export(index, counter);
                counter ++;
            }
            else
                System.out.println("invalid input. please try again");
            System.out.println("1. add");
            System.out.println("2. remove");
            System.out.println("3. notes");
            System.out.println("4. export");
            System.out.println("5. exit");
            command = in1.nextLine();
        }
        System.exit(0);
        manager.add_note("test1", "this is just a test 1");
        manager.add_note("test2", "this is just a test 2");
        manager.add_note("test3", "this is just a test 3");

        for (Note i: manager.get_previous_notes_from_file("notes.txt")){
            System.out.println(i.getTopic());
        }
        System.out.println("after_removing");
        // removing the second note
        manager.remove(1);
        for (Note i: manager.get_previous_notes_from_file("notes.txt")){
            System.out.println(i.getTopic());
        }
        // the third and second note has been removed
    }
}