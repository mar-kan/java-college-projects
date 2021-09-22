class Employee extends Object {

    private String name;
    private String workOn;

    public Employee()
    {
        System.out.println("Employee just created!");
    }


    public void Report(String s)
    {
        System.out.println("Virtual method not implemented.");
    }
};
