import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.*;

public class Manager {
    private ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> getNotes() {
        return notes;
    }
    public void add_note(String topic, String text){
        if (check_for_repetitive_topic(topic))
            return;
        Note note = new Note(topic,return_current_date(),text);
        //getting the previous notes from the "notes.txt" file
        if (get_previous_notes_from_file("notes.txt") != null){
            notes = get_previous_notes_from_file("notes.txt");
        }
        notes.add(note);
        //Writing the new arraylist of notes into the "notes.txt" file
        write_into_file("notes.txt");
        //printing a message
        System.out.println("A new note has been added");
    }
    public void remove(int index){}
    public void Notes_show(int index){}
    public void export(int index){}

    private boolean check_for_repetitive_topic(String topic){
        //checking if the topic s repetitive or not
        for (Note i: notes){
            if (i.getTopic().equals(topic)){
                System.out.println("repetitive topic!");
                System.out.println("Please try again with a different topic");
                return true;
            }
        }
        return false;
    }
    private String return_current_date(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    private ArrayList<Note> get_previous_notes_from_file(String fileName){
        File file = new File(fileName);
        ArrayList<Note> noteArrayList = new ArrayList<>();
        if (file.length() > 0){
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object o;
                if ((o = ois.readObject()) != null){
                    noteArrayList = (ArrayList<Note>) o;
                }
                fis.close();
                ois.close();
                return noteArrayList;
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return null;
    }
    private void write_into_file(String fileName){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.notes);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
