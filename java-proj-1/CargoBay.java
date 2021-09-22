class CargoBay extends PrivateCompartment {

    private String descr;
    private Employee process;
    private boolean ready_check;
    private EquipmentCompartment equip;

    public CargoBay()
    {
        this.descr = "this is cargo bay";
        this.process = null;
        this.ready_check = false;
        this.equip = new EquipmentCompartment();

       System.out.println("Cargo Bay just created!");
    }


    //getters

    public String getDescr()
    {
        return this.descr;
    }


    public EquipmentCompartment getEquip()
    {
        return this.equip;
    }


    public boolean isReadyCheck()
    {
        return this.ready_check;
    }


    public void setReadyCheck(boolean readyCheck)
    {
        this.ready_check = readyCheck;
    }


    public Employee getProcess()
    {
        return this.process;
    }
};
