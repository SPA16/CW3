
public class fullTimeStaffHire extends StaffHire{
    private double salary;
    private int weeklyFractionalHours;
    public fullTimeStaffHire(
    int vacancyNum,
    String designationType,
    String jobType,
    String staffName,
    String joiningDate,
    String qualification,
    String appointedBy,
    boolean joined,
    double salary,
    int weeklyFractionalHours){
        super(vacancyNum, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary=salary;
        this.weeklyFractionalHours=weeklyFractionalHours;
    }
    public double getSalary(){
    return salary;
    }
    public boolean setSalary(double newSalary){
        if (getJoined()==true){
            this.salary=newSalary;
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getWeeklyFractHours(){
        return weeklyFractionalHours;
    }
    public void setWeeklyFractHours(int newWeeklyFractHours){
        this.weeklyFractionalHours= newWeeklyFractHours;
    }
    @Override
    public String display(){
        String fullTimeDisplay= super.display();
        fullTimeDisplay= fullTimeDisplay + "\n Salary: " + salary + "\n Weekly Fractional Hours: " + weeklyFractionalHours;
        return fullTimeDisplay;
}
}