public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("before removing");
        for (Note i: manager.get_previous_notes_from_file("notes.txt")){
            System.out.println(i.getTopic());
        }
        System.out.println("after_removing");
        // removing the second note
        manager.remove(2);
        for (Note i: manager.get_previous_notes_from_file("notes.txt")){
            System.out.println(i.getTopic());
        }
        // the third and second note has been removed

    }
}