public class Student extends Person {

    public Student(String n, int fl, int cl, int L, String t)
    {
        super(n, fl, cl, L, t);
    }

    public void StudentInit(String n, int fl, int cl, int L)   //creates student outside of classroom and not tired
    {
        //initializes person
    }

    public void attend()        //attends class for one hour
    {
        tired += Lp;
    }
};