public class Main
{
    public static void main(String[] args)
    {
        Plane airplane = new Plane("this is the plane", "Boeing", 200);

        SecurityEmployee sec = new SecurityEmployee("George");
        MaintenanceEmployee maint = new MaintenanceEmployee("Peter");
        CleaningEmployee clean = new CleaningEmployee("Joe");
        System.out.println();

        boolean ok;
        ok = airplane.SecurityCheck(sec);
        ok = ok && airplane.MaintenanceCheck(maint);
        ok = ok && airplane.CleaningCheck(clean);
        System.out.println();

        if (airplane.Ready() && ok)
            System.out.println ("Plane ready to take off!");
    else
        System.out.println("Plane not ready");
    }
}
