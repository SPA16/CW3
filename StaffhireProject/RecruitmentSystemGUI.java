import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RecruitmentSystemGUI implements ActionListener{
    private JFrame frame;
    private JTextField vacancyTextF;
    private JTextField designationTextF;
    private JTextField staffNameTextF;
    private JTextField joiningDateTextF;
    private JTextField qualificationTextF;
    private JTextField appointedByTextF;
    private JTextField displayNumTextF;
    private JCheckBox joinedCheck;
    private JButton newStaffButton;
    private JButton displayButton;
    private JRadioButton fullTimeButton;
    private JRadioButton partTimeButton; 
    private JButton terminateButton;
    private ArrayList<StaffHire> staffList = new ArrayList<>();
    public RecruitmentSystemGUI(){
        makeFrame();
    }
    
    private void makeFrame()
    {
        frame= new JFrame("Recruitment System");
        makeMenuBar(frame);
        Container contentPane= frame.getContentPane();
        contentPane.setLayout(new GridLayout(0,2,10, 10));
        
        
        
        guiMain(contentPane);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
    
    public void guiMain(Container contentPane){
        JLabel vacancyLabel= new JLabel ("Vacancy Number: ");
        vacancyTextF=new JTextField(15);
        contentPane.add(vacancyLabel);
        contentPane.add(vacancyTextF);
        
        JLabel designationLabel= new JLabel ("Designation Type: ");
        designationTextF=new JTextField(15);
        contentPane.add(designationLabel);
        contentPane.add(designationTextF);
        
        JLabel staffNameLabel= new JLabel ("Staff Name: ");
        staffNameTextF=new JTextField(15);
        contentPane.add(staffNameLabel);
        contentPane.add(staffNameTextF);
        
        JLabel joiningDateLabel= new JLabel ("Joining Date: ");
        joiningDateTextF=new JTextField(15);
        contentPane.add(joiningDateLabel);
        contentPane.add(joiningDateTextF);
        
        JLabel qualificationLabel= new JLabel ("Qualification: ");
        qualificationTextF=new JTextField(15);
        contentPane.add(qualificationLabel);
        contentPane.add(qualificationTextF);
        
        JLabel appointedByLabel= new JLabel ("Appointed By: ");
        appointedByTextF=new JTextField(15);
        contentPane.add(appointedByLabel);
        contentPane.add(appointedByTextF);
        
        joinedCheck= new JCheckBox();
        JLabel joinedLabel= new JLabel ("Joined?");;
        contentPane.add(joinedLabel);
        contentPane.add(joinedCheck);
        
        newStaffButton= new JButton("Add");
        newStaffButton.addActionListener(this);
        contentPane.add(newStaffButton);
        
        terminateButton = new JButton("Terminate");
        terminateButton.addActionListener(this);
        contentPane.add(terminateButton);
        
        ButtonGroup jobTypeGroup = new ButtonGroup();
        fullTimeButton = new JRadioButton("Full-Time");
        partTimeButton = new JRadioButton("Part-Time");
        jobTypeGroup.add(fullTimeButton);
        jobTypeGroup.add(partTimeButton);

        contentPane.add(fullTimeButton);
        contentPane.add(partTimeButton);
        
        JLabel displayLabel = new JLabel ("Display Number: ");
        displayNumTextF=new JTextField(15);
        contentPane.add(displayLabel);
        contentPane.add(displayNumTextF);
        
        displayButton= new JButton("Display Staff");
        displayButton.addActionListener(this);
        contentPane.add(displayButton);
    } 
    
        
    
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        fileMenu.add(openItem);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);
    }
    
    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();
    if(command.equals("Open")){
        open();
    }
    else if(command.equals("Quit")){
        quit();}
    else if(command.equals("Add")){
        eventAddButton();}
    else if(command.equals("Terminate")){
        eventTerminateButton();
    }
    else if(command.equals("Display Staff")){
        eventDisplayButton();
    }
    }
    
    
   private void eventAddButton() {
  
    String vacancyNumberText = vacancyTextF.getText();
    String designation = designationTextF.getText();
    String staffName = staffNameTextF.getText();
    String joiningDate = joiningDateTextF.getText();
    String qualification = qualificationTextF.getText();
    String appointedBy = appointedByTextF.getText();
    boolean joined = joinedCheck.isSelected();
    
    
    int vacancyNumber = 0;
    try {vacancyNumber = Integer.parseInt(vacancyNumberText);}
    catch (NumberFormatException e) {
        showError("Error: Vacancy number must be a valid number. Please retry.");
        return;
    }

    
    if (!joined) {
        showError("Error: The staff must be marked as 'Joined'. Please retry.");
        return;
    }

    
    if (vacancyNumberText.isEmpty() || designation.isEmpty() || staffName.isEmpty() || joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty()) {
        showError("Error: All fields must be filled. Please retry.");
        return;
    }

    StaffHire newStaff = null;

    
    if (fullTimeButton.isSelected()) {
        String salaryText = JOptionPane.showInputDialog(frame, "Enter the salary:");
        double salary = 0;
        String jobType= "Full-Time";
        try {salary = Double.parseDouble(salaryText);}
        catch (NumberFormatException e) {showError("Error: Invalid salary amount. Please retry.");
            return;
        }
        String weeklyFracHoursText = JOptionPane.showInputDialog(frame, "Enter the weekly hours:");
        int weeklyFractionalHours= 0;
        try {weeklyFractionalHours = Integer.parseInt(weeklyFracHoursText);}
        catch (NumberFormatException e) {showError("Error: Invalid weekly hours input. Please retry.");
            return;
        }

        newStaff = new fullTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyFractionalHours);

    } 
    
    
    else if (partTimeButton.isSelected()) {
        String hourlyRateText = JOptionPane.showInputDialog(frame, "Enter the hourly rate:");
        double hourlyRate = 0;
        String jobType= "Part-Time";
        try {hourlyRate = Double.parseDouble(hourlyRateText);}
        catch (NumberFormatException e) {showError("Error: Invalid hourly rate. Please retry.");
            return;
        }
        String workingHourText = JOptionPane.showInputDialog(frame, "Enter the working hours: " );
        int workingHour=0;
        try {int workingHourCheck = Integer.parseInt(workingHourText);} 
        catch (NumberFormatException e) {showError("Error: Invalid hourly rate. Please retry.");
            return;
        }
        
        String shifts = JOptionPane.showInputDialog(frame, "What hours are you working? 1 for morning, 2 for afternoon, 3 for evening" );
        try {int shiftCheck = Integer.parseInt(shifts);}
        catch (NumberFormatException e) {showError("Error: Invalid working hour.");
            return;
        }
        
        if(shifts=="1"){
            shifts="Morning";
        }
        else if (shifts=="2"){
            shifts="Afternoon";
        }
        else if(shifts=="3"){
            shifts="Evening";
        }
        boolean terminationStatus = false;
        
        newStaff = new partTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined, workingHour,hourlyRate, shifts, terminationStatus);
    } 
   
    else {
        showError("Error: Please select a job type Full-Time or Part-Time.");
        return;
    }

    
    addStaff(newStaff);
}

private void eventTerminateButton() {
    String displayNumText = displayNumTextF.getText();
    int displayNum = -1;
    try {displayNum = Integer.parseInt(displayNumText);
        if (displayNum < 0 || displayNum >= staffList.size()) {
            showError("Error: Display number is out of range.");
            return;
        }
    } catch (NumberFormatException e) {
        showError("Error: Display number must be a valid integer.");
        return;
    }

    StaffHire staffToTerminate = staffList.get(displayNum);
    
    if (staffToTerminate instanceof partTimeStaffHire) {
        partTimeStaffHire partTimeStaff = (partTimeStaffHire) staffToTerminate;
        partTimeStaff.terminate();
        JOptionPane.showMessageDialog(frame, "Part-time staff terminated.");
    } else {
        JOptionPane.showMessageDialog(frame, "Cannot terminate full-time staff.");
    }
}

private void eventDisplayButton(){
    String displayNumText=displayNumTextF.getText();
    int displayNum= -1;
    try {displayNum = Integer.parseInt(displayNumText);
        if (displayNum < 0 || displayNum >= staffList.size()) {
            showError("Error: Display number is out of range.");
            return;
        }
    } catch (NumberFormatException e) {
        showError("Error: Display number must be a valid integer.");
        return;
    }
StaffHire staff = staffList.get(displayNum);
    StringBuilder sb = new StringBuilder();

    sb.append("Display Number: ").append(displayNum).append("\n")
      .append("Vacancy Number: ").append(staff.getVacancyNum()).append("\n")
      .append("Designation: ").append(staff.getDesignationType()).append("\n")
      .append("Job Type: ").append(staff.getJobType()).append("\n");

    if (staff instanceof partTimeStaffHire) {
        partTimeStaffHire pt = (partTimeStaffHire) staff;
        sb.append("Wages Per Hour: £").append(pt.getWagesPerHour()).append("\n")
          .append("Working Hours: ").append(pt.getWorkingHour()).append("\n")
          .append("Shifts: ").append(pt.getShifts()).append("\n")
          .append("Terminated: ").append(pt.getTerminationStatus()).append("\n");
    } else if (staff instanceof fullTimeStaffHire) {
        fullTimeStaffHire ft = (fullTimeStaffHire) staff;
        sb.append("Salary: £").append(ft.getSalary()).append("\n")
          .append("Weekly Hours: ").append(ft.getWeeklyFractHours()).append("\n");
    }

    JOptionPane.showMessageDialog(frame, sb.toString(), "Staff Details", JOptionPane.INFORMATION_MESSAGE);
}

private void showError(String message) {
    JOptionPane.showMessageDialog(frame, message, "Invalid Input", JOptionPane.ERROR_MESSAGE);
}
     
     public void addStaff(StaffHire staff) {
        staffList.add(staff);
    }
    
   
    public void open(){
        System.out.println("Unable to print file");
    }
    public void quit(){
        System.out.println("Thank you for using this program");
        System.exit(0);
    }
}

