import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;

public class Room {

    private String type;                  //defines to which type of room the object refers to
    protected ArrayList<Student> students = new ArrayList<Student>();


    public Room(String t)     //initializes room with its type
    {
        System.out.println("A New "+t+" has been created!");
        type = t;
    }

    public void enter(Student student)  //given student enters room
    {
        System.out.println(student.getName()+" enters "+type+" !");
        students.add(student);
    }
    
    public Student exit(int pos)   //student in position pos of vector exits room
    {
        Student student = students.get(pos);
        System.out.println(student.getName()+" exits "+type+" !");
        students.remove(students.get(pos));

        return student; //returns pointer to student that exited
    }
    
    public void print()  //prints room and students in it
    {
        System.out.println("People in "+type+" are: ");

        //prints all students in here
        for (Student student : students)
            student.printNameAndTired();

        System.out.println();
    }

    public Student getStudentAt(int pos)
    {
        return students.get(pos);
    }
    
    public int getStudentCount()
    {
        return students.size();
    }
};
