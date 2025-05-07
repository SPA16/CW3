public class StaffHire{
    private int vacancyNum;
    private String designationType;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String appointedBy;
    private String qualification;
    private boolean joined;
    
public StaffHire(int vacancyNum,String designationType, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined){
    this.vacancyNum=vacancyNum;
    this.designationType=designationType;
    this.jobType=jobType;
    this.staffName=staffName;
    this.joiningDate=joiningDate;
    this.qualification=qualification;
    this.appointedBy=appointedBy;
    this.joined=joined;
}

public int getVacancyNum(){
    return vacancyNum;
}

public String getDesignationType(){
    return designationType;
}

public String getJobType(){
    return jobType;
}

public String getStaffName(){
    return staffName;
}
public void setStaffName(String newStaffName){
    this.staffName = newStaffName;
}

public String getJoiningDate(){
    return joiningDate;
}


public void setJoiningDate(String newJoinDate){
    this.joiningDate = newJoinDate;
}



public String getQualification(){
    return qualification;
}
public void setQuali(String newQuali){
    this.qualification = newQuali;
}


public String getAppointedBy(){
    return appointedBy;
}
public void setAppointed(String newAppointedBy){
    this.appointedBy = newAppointedBy;
}


public boolean getJoined(){
    return joined;
}
public void setJoined(boolean newJoined){
    this.joined=newJoined;
}

public String display(){
    String finalDisplay="Vacancy Number: " + vacancyNum +
                        "\n Designation Type: "+ designationType+
                        "\n Job Type: "+ jobType+
                        "\n Staff Name: "+ staffName+
                        "\n Joining Date: "+ joiningDate+
                        "\n Qualification: "+ qualification+ 
                        "\n Appointed By: "+ appointedBy+ 
                        "\n Joined: " + joined;
    return finalDisplay;
}
}


