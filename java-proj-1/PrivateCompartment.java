class PrivateCompartment extends PlaneComponent {

    private String descr;
    private Employee process;

    public PrivateCompartment()
    {
        System.out.println("PrivateCompartment just created!");
    }


    public boolean Ready_check()
    {
        System.out.println("Virtual method not implemented.");
        return false;
    }


    public String getDescr()
    {
        return this.descr;
    }


    public Employee getProcess()
    {
        return this.process;
    }

};
