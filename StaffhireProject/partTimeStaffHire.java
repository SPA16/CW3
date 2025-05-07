public class partTimeStaffHire extends StaffHire{
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminationStatus;
    public partTimeStaffHire(
    int vacancyNum,
    String designationType,
    String jobType,
    String staffName,
    String joiningDate,
    String qualification,
    String appointedBy,
    boolean joined,
    int workingHour,
    double wagesPerHour,
    String shifts,
    boolean terminationStatus){
        super(vacancyNum, designationType, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour=workingHour;
        this.wagesPerHour=wagesPerHour;
        this.shifts=shifts;
        this.terminationStatus=false;
    }
    
    public int getWorkingHour(){
        return workingHour;
    }
    
    public double getWagesPerHour(){
        return wagesPerHour;
    }
    
    public String getShifts(){
        return shifts;
    }
    public boolean setShifts(String newShift){
        if (getJoined()==true){
            this.shifts=newShift;
            return true;
        }
        else{
        return false;}
    }
    public void terminate() {
        this.terminationStatus = true;  
        setJoined(false);
    }
    public boolean getTerminationStatus(){
        return terminationStatus;
    }
    public boolean setTerminationStatus(boolean newTerminationStatus){
        if(newTerminationStatus==false){
            return false;
        }
        else{
            setStaffName("");
            setJoiningDate("");
            setQuali("");
            setAppointed("");
            terminationStatus=true;
            setJoined(false);
            return true;
            
        }
    }
     @Override
     public String display(){
        String partTimeDisplay= super.display();
        partTimeDisplay= partTimeDisplay + "\n Working hours: " + workingHour + "\n Hourly wages: " + wagesPerHour + "\n Shift: " + shifts + "\n Terminated?: " + terminationStatus + "\n Income Per Day: " + (wagesPerHour*workingHour);
        return partTimeDisplay;
}
}