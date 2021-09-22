class PassengerCompartment extends PlaneComponent {

    private String descr;
    private Employee process;
    private boolean ready_check;
    private boolean indoors;


    public PassengerCompartment(boolean inArea)
    {
        descr = "passengers";
        process = null;
        ready_check = false;
        indoors = inArea;
        System.out.println("PassengerCompartment just created!");
    }


    public String getDescr()
    {
        return this.descr;
    }


    public Employee getProcess()
    {
        return this.process;
    }


    public boolean isReadyCheck()
    {
        return this.ready_check;
    }


    public boolean isIndoors()
    {
        return this.indoors;
    }


    public void setReadyCheck(boolean readyCheck)
    {
        this.ready_check = readyCheck;
    }

};
