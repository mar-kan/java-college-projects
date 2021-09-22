class MaintenanceEmployee extends Employee{
    
    private String name;
    private boolean workOn;

    
    public MaintenanceEmployee(String n)
    {
        this.name = n;
        this.workOn = false;        //no work

        System.out.println("Maintenance Employee just created!");
    }
    
    
    public void Report(String compartment)
    {
        if (this.workOn)
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
