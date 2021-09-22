class CleaningEmployee extends Employee {

    private String name;
    private boolean workOn;

    public CleaningEmployee(String n)
    {
        this.name = n;
        this.workOn = false;        //no work

        System.out.println("Cleaning Employee just created!");
    }


    public void Report(String compartment)
    {
        System.out.println(compartment +" is OK");
    }


    public String getName()
    {
        return this.name;
    }


    public boolean getWorkOn()
    {
        return this.workOn;
    }


    public void setWorkOn(boolean w)
    {
        this.workOn = w;
    }
       
};
