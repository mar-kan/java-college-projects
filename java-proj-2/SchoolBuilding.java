public class SchoolBuilding extends Room {

    private Floor[] floors = new Floor[3];   //array of 3 floors of school
    private Yard yard = new Yard();
    private Stair stair = new Stair();


    public SchoolBuilding(int cClass)                          //constructor of school building
    {                                                          //initializes 3 floors
        super("SchoolBuilding");

        System.out.println("A New School has been created!");
        for (int i = 0; i < 3; i++)
            floors[i] = new Floor(i + 1, cClass);  //i+1 represents floor num
    }

    public void enter(Student student)    //student enters school building
    {
        System.out.println(student.getName()+" enters building!");
        yard.enter(student);
    }
    public void print()       //prints school building as requested
    {
        System.out.println("School life consists of:");

        for (int i = 0; i < 3; i++)
            floors[i].print();
    }
    
    public void operate() //operates school for one hour
    {
        for (int i = 0; i < 3; i++)
            floors[i].operate();
    }

    //getters
    public Yard getYard() 
    {
        return yard;
    }

    public Stair getStair() 
    {
        return stair;
    }

    public Floor getFloorByNum(int num)    //returns floor with floor num = num
    {
        for (int i = 0; i < 3; i++)
        {
            if (floors[i].getFloorNum() == num)
                return floors[i];
        }
        return null;
    }
};