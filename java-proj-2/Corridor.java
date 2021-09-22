public class Corridor extends Room {

    public Corridor()
    {
        super("Corridor");
    }

    public int getStudentPosFromClass(int class_num)      //returns position of a student that wants to go to given class_num
    {
        for (int i=0; i<students.size(); i++)
        {
            if (students.get(i).getClass_num() == class_num)
                return i;
        }
        return -1;  //returns -1 if there are none left for this class
    }
};
