public class Person {

    protected String name;
    protected int floor_num, class_num;
    protected Boolean inClass = false;
    protected int tired = 0;      //tiredness points
    protected int Lp;         //tiredness increases by Ls points
    protected String type;    //defines type of person this object refers to


    public Person(String n, int fl, int cl, int L, String t)   //creates person and prints all his info
    {
        name = n;
        floor_num = fl;
        class_num = fl * 10 + cl;
        Lp = L;
        type = t;

        System.out.println("A New "+type+" has been created!");
        printAll();
    }

    public void printNameAndTired()   //prints person's name
    {
        System.out.println(name+"' "+tired);
    }

    public void printAll()    //prints all person's info
    {
        System.out.println("Name: "+name);
        System.out.println("Floor number: "+floor_num);
        System.out.println("Class number: "+class_num);

        if (inClass)
            System.out.println("Inside classroom");
        else
            System.out.println("Outside of classroom");

        System.out.println("Tired points: "+tired);
        System.out.println();
    }

    //getters and setters
    public Boolean getInClass()
    {
        return inClass;
    }

    public int getFloor_num()
    {
        return floor_num;
    }

    public int getClass_num()
    {
        return class_num;
    }

    public String getName()
    {
        return name;
    }

    public void setInClass(Boolean inClass)
    {
        this.inClass = inClass;
    }
};