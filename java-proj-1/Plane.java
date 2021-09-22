import java.util.*;
import java.util.Random;


class Plane extends Object{

    private String descr;
    private String title;
    private int capacity;
    private Employee process = new Employee();            //create employee and cargo bay
    private CargoBay cargo = new CargoBay();
    private EquipmentCompartment[] equips = new EquipmentCompartment[3];
    int n;
    LinkedList<PassengerCompartment> spaces = new LinkedList<PassengerCompartment>();             //create linked list of Passenger Compartments


    public Plane(String d, String t, int c)
    {
        int i;

        this.descr = d;
        this.title = t;
        this.capacity = c;
        this.process = null;          //no employees working yet

        //creates rest of plane's compartments

        for (i=0; i<3; i++)
        {
            this.equips[i] = new EquipmentCompartment();
        }

        this.n = CalculatePassengerSpaces(capacity);
        for (i=0; i<n; i++)                                     //fill list with airplane's Passenger Compartments
        {
            PassengerCompartment temp = new PassengerCompartment(false);
            this.spaces.add(temp);
        }
        System.out.println("Plane just created!");
    }


    public boolean Ready()                             //checks if all plane's spaces are ready
    {
        if (!this.cargo.isReadyCheck())
            return false;

        int i;

        for (i=0; i<3; i++)
        {
            if (this.equips[i] == null)
                return false;

            if (!this.equips[i].isReadyCheck())
                return false;
        }

        for (i=0; i<this.spaces.size(); i++)
        {
            if (!this.spaces.get(i).isReadyCheck())
                return false;
        }

        return true;
    }


    public boolean SecurityCheck(SecurityEmployee emp) //puts security employee to work in all spaces
    {
        boolean ready = true;

        if (emp.getWorkOn())
        {
            System.out.println("Employee already working");
            return false;
        }

        System.out.println("Security Employee working:");
        this.process = emp;

        if (!this.cargo.isReadyCheck())
        {
            emp.setWorkOn(true);
            System.out.println("Checking Cargo Bay");
            emp.Report("Cargo Bay");

            System.out.println("Checking Cargo Bay's Equipment Compartment");
            emp.Report("Cargo Bay's Equipment Compartment");

            this.cargo.setReadyCheck(true);
            emp.setWorkOn(false);

            ready = ready && this.cargo.isReadyCheck();
        }

        int i;
        for (i=0; i<3; i++)
        {
            if (this.equips[i] == null)
                return false;

            if (!this.equips[i].isReadyCheck())
            {
                emp.setWorkOn(true);
                System.out.println("Checking Equipment Compartment");
                emp.Report("Equipment Compartment");
                this.equips[i].setReadyCheck(true);
                emp.setWorkOn(false);

                ready = ready && this.equips[i].isReadyCheck();
            }
        }

        for (i=0; i<this.spaces.size(); i++)
        {
            if (!this.spaces.get(i).isReadyCheck())
            {
                emp.setWorkOn(true);
                System.out.println("Checking Passenger Compartment");
                emp.Report("Passenger Compartment");

                if (this.spaces.get(i).isIndoors())
                {
                    System.out.println("Checking Passenger Compartment's indoor area");
                    emp.Report("Passenger Compartment's indoor area");
                }

                this.spaces.get(i).setReadyCheck(true);
                emp.setWorkOn(false);
            }

            ready = ready && this.cargo.isReadyCheck();
        }

        this.process = null;
        return ready;
    }


    public boolean MaintenanceCheck(MaintenanceEmployee emp) //puts maintenance employee to work in all spaces
    {
        this.cargo.setReadyCheck(false);                    //back to false because they have become true from security check
        this.equips[0].setReadyCheck(false);
        this.equips[1].setReadyCheck(false);
        this.equips[2].setReadyCheck(false);

        if (emp.getWorkOn())
        {
            System.out.println("Employee already working");
            return false;
        }

        System.out.println("Maintenance Employee working:");
        this.process = emp;

        if (!this.cargo.isReadyCheck())
        {
            emp.setWorkOn(true);
            System.out.println("Checking Cargo Bay");
            emp.Report("Cargo Bay");

            System.out.println("Checking Cargo Bay's Equipment Compartment");
            emp.Report("Cargo Bay's Equipment Compartment");

            this.cargo.setReadyCheck(true);
            emp.setWorkOn(false);
        }

        int i;
        for (i=0; i<3; i++)
        {
            if (!this.equips[i].isReadyCheck())
            {
                emp.setWorkOn(true);
                System.out.println("Checking Equipment Compartment");
                emp.Report("Equipment Compartment");
                this.equips[i].setReadyCheck(true);
                emp.setWorkOn(false);
            }
        }

        this.process = null;
        return this.cargo.isReadyCheck() && this.equips[0].isReadyCheck() && this.equips[1].isReadyCheck() && this.equips[2].isReadyCheck();
    }


    public boolean CleaningCheck(CleaningEmployee emp)     //puts cleaning employee to work in all spaces
    {
        boolean ready = true;
        this.cargo.setReadyCheck(false);

        if (emp.getWorkOn())
        {
            System.out.println("Employee already working");
            return false;
        }

        System.out.println("Cleaning Employee working:");
        this.process = emp;

        if (!this.cargo.isReadyCheck())
        {
            emp.setWorkOn(true);
            System.out.println("Checking Cargo Bay");
            emp.Report("Cargo Bay");

            System.out.println("Checking Cargo Bay's Equipment Compartment");
            emp.Report("Cargo Bay's Equipment Compartment");

            this.cargo.setReadyCheck(true);
            emp.setWorkOn(false);

            ready = ready && this.cargo.isReadyCheck();
        }

        int i;
        for (i=0; i<this.spaces.size(); i++)
        {
            if (!this.spaces.get(i).isReadyCheck())
            {
                emp.setWorkOn(true);
                System.out.println("Checking Passenger Compartment");
                emp.Report("Passenger Compartment");

                if (this.spaces.get(i).isIndoors())
                {
                    System.out.println("Checking Passenger Compartment's indoor area");
                    emp.Report("Passenger Compartment's indoor area");
                }

                this.spaces.get(i).setReadyCheck(true);
                emp.setWorkOn(false);
            }

            ready = ready && this.cargo.isReadyCheck();
        }

        this.process = null;
        return ready;
    }


    int CalculatePassengerSpaces(int cap)
    {
        Random rand = new Random();
        return (rand.nextInt(5) + 1) * cap / 100;                  //random number depending on capacity
    }


    //getters

    public String getDescr()
    {
        return this.descr;
    }

    public String getTitle()
    {
        return this.title;
    }


    public int getCapacity()
    {
        return this.capacity;
    }


    Employee getProcess()
    {
        return this.process;
    }


    CargoBay getCargo()
    {
        return this.cargo;
    }


    EquipmentCompartment getEquips(int index)
    {
        return this.equips[index];
    }


    int getN()
    {
        return this.n;
    }

};
