import java.util.Random;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Main{
    public static String generateRandomName() //returns a random string
    {
        //string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //random string builder
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        int length = 10;

        for(int i=0; i<length; i++)
        {
            // gets random character from string
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }


    public static int getRandomIntInRage(int a, int b)  //returns random integer in [a,b]
    {
        Random rand = new Random();
        return rand.ints(a, (b + 1)).findFirst().getAsInt();
    }
    
    
    public static void main(String[] args)  //main
    {
        if (args.length < 5)
        {
            System.out.println("Too few arguments ("+args.length+")");
            exit(-1);
        }

        //stores program arguments
        int cClass = parseInt(args[0]);
        int Lj = parseInt(args[1]);
        int Ls = parseInt(args[2]);
        int Lt = parseInt(args[3]);
        int N = parseInt(args[4]);


        /** creating school **/
        SchoolBuilding school = new SchoolBuilding(cClass);

        /** creating students **/
        int student_count = cClass * 20;
        Student[] outStudents = new Student[student_count];             //array that contains all students that are outside the school
        for (int i=0; i<student_count; i++)
        {
            if (i < student_count / 2)
                outStudents[i] = new SeniorStudent(generateRandomName(), getRandomIntInRage(1,3), getRandomIntInRage(4, 6), Ls);   //creates new senior student with random name and random floor and class numbers (senior classes have numbers that end with [4,6])
            else
                outStudents[i] = new JuniorStudent(generateRandomName(), getRandomIntInRage(1,3), getRandomIntInRage(1,3), Lj);   //creates new junior student with random name and random floor and class numbers (junior classes have numbers that end with [1,3]
        }

        /** creating teachers **/
        int teach_count=0;
        Teacher[] teachers = new Teacher[18];    //array that contains all teachers (their number is equal to num of classrooms)
        for (int i=0; i<3; i++)     //in each floor
        {
            for (int j=0; j<6; j++) //and each classroom
            {
                teachers[teach_count] = new Teacher(generateRandomName(), i+1, j+1, Lt); //adds one teacher with random name
                school.getFloorByNum(i+1).getClassByNum((i+1)*10+j+1).setTeacher(teachers[teach_count++]);    //sets him as him classroom's teacher
            }
        }

        /** all students enter the schoolyard in random order **/
        while (student_count>0)    //while there are students outside
        {
            //a random student enters school
            int pos= getRandomIntInRage(0,student_count-1);
            school.enter(outStudents[pos]);

            //removes student from array
            if (student_count - 1 - pos >= 0)            //fixes rest of array so there are no gaps
                System.arraycopy(outStudents, pos + 1, outStudents, pos, student_count - 1 - pos);

            student_count--;  //decreases number of students outside
        }

        /** all students exit schoolyard and enter stairs in random order **/
        while (school.getYard().getStudentCount()>0)  //while there are people in yard
        {
            //gets random student position
            int pos = getRandomIntInRage(0, school.getYard().getStudentCount()-1);
            //exits schoolyard and enters stairs
            school.getStair().enter(school.getYard().exit(pos));
        }

        //for every floor fills corridor until stairs have students or there are no more students for this floor
        for (int floor=0; floor<3; floor++)
        {
            /** all students that go on each floor exit stairs and enter each floor's corridor **/
            while (school.getStair().getStudentCount()>0)  //while there are students in stairs
            {
                //gets position of a student that goes to this floor
                int pos = school.getStair().getStudentPosForFloor(floor+1);
                if (pos < 0)
                    break;  //no more students for this floor

                //exits stairs and enters floor (its corridor)
                school.getFloorByNum(floor+1).enter(school.getStair().exit(pos));
            }

            for (int classe=0; classe<6; classe++)
            {
                /** students exit corridors and enter their classes until they are full **/
                while (school.getFloorByNum(floor+1).getCorridor().getStudentCount() > 0 && !school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).isFull())  //while there is room in classroom and people in floor corridor
                {
                    //gets position of a student that goes to this classroom
                    int pos = school.getFloorByNum(floor+1).getCorridor().getStudentPosFromClass((floor+1)*10+classe+1);
                    if (pos < 0)
                        break;  //no more students for this floor

                    //checks if classroom is full
                    if (school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).isFull())
                    break;

                    //exits corridor and enters classroom
                    school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).enter(school.getFloorByNum(floor+1).getCorridor().exit(pos));
                }
            }
        }

        /**all teachers are placed in their classrooms **/
        for (int i=0; i<teach_count; i++)
            teachers[i].place();   //places teacher

        /**operating school**/
        for (int i=0; i<N; i++)
            school.operate();

        /** printing school **/
        school.print();

        /** emptying building **/
        //reverse of students entering the building
        for (int floor=0; floor<3; floor++)
        {
            for (int classe=0; classe<6; classe++)
            {
                /** all students exit their class and enter back to the corridor **/
                while (school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).getStudentCount() > 0)  //while there are people in classroom
                {
                    //gets random student from classroom
                    int pos = getRandomIntInRage(0, school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).getStudentCount()-1);

                    //exits classroom and enters corridor
                    school.getFloorByNum(floor+1).getCorridor().enter(school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).exit(pos));
                }
                //once for every classroom, its teacher exits
                school.getFloorByNum(floor+1).getClassByNum((floor+1)*10+classe+1).getTeacher().teacher_out();
            }
            /** all students exit their floor's corridor and enter back to stairs **/
            while (school.getFloorByNum(floor+1).getCorridor().getStudentCount() > 0)  //while there are students in corridor
            {
                //gets position of a student that goes to this floor
                int pos = getRandomIntInRage(0, school.getFloorByNum(floor+1).getCorridor().getStudentCount()-1);
                if (pos < 0)
                    break;  //no more students for this floor

                //exits floor's corridor and enters stairs
                school.getStair().enter(school.getFloorByNum(floor+1).getCorridor().exit(pos));
            }


        }
        /** all students exit stairs and enter back to schoolyard in random order **/
        while (school.getStair().getStudentCount() > 0)  //while there are people in yard
        {
            //gets random student position
            int pos = getRandomIntInRage(0, school.getStair().getStudentCount()-1);
            //exits schoolyard and enters stairs
            school.getYard().enter(school.getStair().exit(pos));
        }
        /** all students exit the schoolyard in random order **/
        while (school.getYard().getStudentCount() > 0)    //while there are students outside
        {
            //a random student enters school
            int pos= getRandomIntInRage(0,school.getYard().getStudentCount()-1);
            school.getYard().exit(pos);
        }

        /** prints empty school **/
        System.out.println();
        school.print();
        exit(0);
    }
}