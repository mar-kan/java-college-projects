class SecurityEmployee extends Employee {

    private String name;
    private boolean workOn;


    public SecurityEmployee(String n)
    {
        name = n;
        workOn = false;        //no work

        System.out.println("Security Employee just created!");
    }


    public void Report(String area)
    {
        System.out.println(area +" is OK");
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

