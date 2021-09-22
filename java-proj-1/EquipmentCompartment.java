class EquipmentCompartment extends Object {

    private String descr;
    private Employee process;
    private boolean ready_check;


    public EquipmentCompartment()
    {
        descr = "this is an equipment compartment";
        process = null;
        ready_check = false;
        System.out.println("Equipment Compartment just created!");
    }


    public String getDescr()
    {
        return  this.descr;
    }


    public Employee getProcess()
    {
        return this.process;
    }


    public boolean isReadyCheck()
    {
        return this.ready_check;
    }


    void setReadyCheck(boolean readyCheck)
    {
        ready_check=readyCheck;
    }

};

