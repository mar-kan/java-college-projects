public class Stair extends Room {


    public Stair()
    {
        super("Stair");
    }

    public int getStudentPosForFloor(int floor_num)     //returns position of a student that wants to go to given floor_num
    {
        for (int i=0; i<students.size(); i++)
        {
            if (students.get(i).getFloor_num() == floor_num)
                return i;
        }
        return -1;  //returns -1 if there are none left for this floor
    }
};