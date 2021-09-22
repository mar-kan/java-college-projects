public class Class extends Room {

    private int max_capacity;
    private int class_num;
    private String type;                            //junior or senior class
    private Teacher teacher = null;


    public Class(String t, int max_capacity, int class_num)   //initializes max capacity, class num, null array of <capacity> studentArray
    {
        super("Class");

        System.out.println("A New Class has been created with number: "+class_num);
        this.max_capacity = max_capacity;
        this.class_num = class_num;
        this.type = t;
    }


    public void enter(Student student)  //given student enters class
    {
        if (this.isFull())
            return;

        System.out.println(student.getName()+" enters Class !");
        student.setInClass(true);
        students.add(student);
    }

    public Student exit(int pos)   //student in position pos of arrayList exits classroom
    {
        Student student = students.get(pos);

        System.out.println(student.getName()+" starts exiting!");
        System.out.println(student.getName()+" exits "+type+" !");
        students.remove(students.get(pos));

        return student; //returns pointer to student that exited
    }

    public void print()  //prints class as requested
    {
        System.out.println("People in class "+class_num+" are: ");

        //prints all studentArray in here
        for (Student student : students)
            student.printNameAndTired();

        //prints teacher
        if (teacher.inClass)
        {
            System.out.println("The teacher is:");
            teacher.printNameAndTired();
        }
        System.out.println();
    }

    public void operate()   //teacher teaches and all studentArray attend class for 1 hour
    {
        teacher.teach();
        for (Student student : students)
            student.attend();
    }

    public Boolean isFull()    //returns if class is full
    {
        return max_capacity < students.size();
    }

    //getters and setters
    public void setTeacher(Teacher teach)
    {
        teacher = teach;
    }

    public int getClassNum()
    {
        return class_num;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }
};