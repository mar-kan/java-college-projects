public class Teacher extends Person {


    public Teacher(String n, int fl, int cl, int L)
    {
        super(n, fl, cl, L, "Teacher");
    }

    public void place()   //places teacher in his classroom
    {
        inClass = true;
    }

    public void teach() //teaches for one hour
    {
        tired += Lp;
    }

    public void teacher_out()   //teacher exits classroom
    {
        printAll();
        System.out.println(this.name+" is out!");
        inClass = false;
    }
};