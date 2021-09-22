public class Floor extends Room {

    private int floor_num;

    private JuniorClass[] juniorClasses = new JuniorClass[3]; //array of 3 junior classes of floor
    private SeniorClass[] seniorClasses = new SeniorClass[3]; //array of 3 senior classes of floor
    private Corridor corridor = new Corridor();

    public Floor(int num, int cClass)  //initializes floor <num> with new empty corridor and 6 classes
    {
        super("Floor");

        System.out.println("A New Floor has been created with number: "+num);
        floor_num = num;

        for (int i=0; i<3; i++)
        {
            int class_num = floor_num*10 + i+1;   //class num is a 2-digit num. 1st one represents floor and 2nd class

            //creates 3 junior and 3 senior classes
            juniorClasses[i] = new JuniorClass(cClass, class_num); //classes 1to3
            seniorClasses[i] = new SeniorClass(cClass, class_num+3); //classes 4to6
        }
    }


    public void enter(Student student)  //given student enters floor, overrides room's enter
    {
        System.out.println(student.getName()+" enters floor!");
        corridor.enter(student);   //enters corridor
    }

    public void print() //prints floor, overrides room's print
    {
        System.out.println("Floor number "+floor_num+" contains:");
        corridor.print();

        for (int i=0; i<3; i++)
        {
            juniorClasses[i].print();
            seniorClasses[i].print();
        }
    }

    public void operate()   //operates floor's classrooms
    {
        for (int i=0; i<3; i++)
        {
            juniorClasses[i].operate();
            seniorClasses[i].operate();
        }
    }

    public Class getClassByNum(int num)   //returns class with number = num
    {
        for (int i=0; i<3; i++)
        {
            if (juniorClasses[i].getClassNum() == num)
                return juniorClasses[i];
            if (seniorClasses[i].getClassNum() == num)
                return seniorClasses[i];
        }
        return null;
    }
    
    public Corridor getCorridor() 
    {
        return corridor;
    }
    
    public int getFloorNum()
    {
        return floor_num;
    }
};