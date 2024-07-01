/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe.part2.java;
import javax.swing.JOptionPane;
import java.util.ArrayList;
        
/**
 *
 * @author RC_Student_lab
 */
public class Part_3 {
    private static int taskNumber = 0;//Intialize task number
    private static final ArrayList<Task> tasks = new ArrayList<>();//List to staore tasks
    
    //Test data for tasks
    static {
        tasks.add(new Task("Create login","Create a login feature","Mike Smith",5,createTaskID("Create login","Mike Smith"),"To Do"));
        tasks.add(new Task("Create Add Features","Add new features to the system","Edward Harrison",8,createTaskID("Create Add features","Edward Harrison"),"Doing"));
        tasks.add(new Task("Create reports","Generate system reports","Samantha Paulson",2, createTaskID("Create reports","Samantha Paulson"),"Done"));
        tasks.add(new Task("Add Arrays", "Integrate array handling", "Glenda Oberholzer",11,createTaskID("Add Arrays","Glenda Oberholzer"),"To Do" ));
        taskNumber = tasks.size();// Update task number
    }
    public static void main(String[]args){
        while(true){
            String[] options ={"Add Task","View All Tasks","Search Task","Search by Developer","Delete Task","Display report","Exit"};String choice = (String)JOptionPane.showInputDialog(null,"Choose an option:","Task Manager",JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            switch (choice){
                case "Add Task":
                    addTask();
                    break;
                case "View All Tasks":
                    viewAllTasks();
                    break;
                case "Search Task":
                    searchTask();
                    break;
                case "Search by Developer":
                    searchByDeveloper();
                    break;
                case "Delete Task":
                    deleteTask();
                    break;
                case "Exit":
                    System.exit(0);// Exit the program    
            }
        }
    }
        // Method to add a new task
        public static void addTask(){
            String taskName = JOptionPane.showInputDialog("Enter the task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter the task description(max 50 characters):");
            
            if (!checkTaskDescription(taskDescription)){
               JOptionPane.showMessageDialog(null,"Please enter a task description of less than 50 characters");
               return;
            }
            String developerDetails = JOptionPane.showInputDialog("Enter the developer's first and last name");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours:"));
            String taskID = createTaskID(taskName, developerDetails);
            String[] statusOptions = {"To Do","Done","Doing"};
            String taskStatus = (String)JOptionPane.showInputDialog(null, "Select the task status:","Task Status",JOptionPane.QUESTION_MESSAGE,null,statusOptions, statusOptions[0]);
            Task task = new Task(taskName, taskDescription,developerDetails, taskDuration, taskID,taskStatus);
            tasks.add(task);
            taskNumber++;
            
            JOptionPane.showMessageDialog(null,"Tasks sucessfully captured");
        }
        // Method to view all tasks
        public static void viewAllTasks(){
            StringBuilder allTaskDetails = new StringBuilder();
            for (Task task : tasks){
                allTaskDetails.append(task.printTaskDetails()).append("\n\n");
            }
            
            JOptionPane.showMessageDialog(null,allTaskDetails.toString());
            }
        //Method to check if the task description is valid
        public static boolean checkTaskDescription(String description){
            return description.length()<=50; 
        }
        // Method to create task ID
        public static String createTaskID(String taskName, String developerDetails){
            String[] developerNameParts = developerDetails.split("");
            String developerLastName = developerNameParts[developerNameParts.length -1];
            return (taskName.substring(0,2)+":"+taskNumber +":"+ developerLastName.substring(developerLastName.length()-3)).toUpperCase();
            
        }
        //Method to search for a task by task name
        public static void searchTask(){
            String taskName = JOptionPane.showInputDialog("Enter the task name to search:");
            for (Task task: tasks){
             if (task.taskName.equalsIgnoreCase(taskName)){
                        JOptionPane.showMessageDialog(null,"Task Name:" + task.taskName + "\nDeveloper:"+ task.developerDetails + "\nTask status:"+ task.taskStatus);
                        return;
                    }   
                }
            JOptionPane.showMessageDialog(null,"Task not found");
            }
        //Mehtod to search for tasks by developer
        public static void searchByDeveloper(){
            String developer= JOptionPane.showInputDialog("Enter the developer's name to search:");
            StringBuilder result = new StringBuilder();
            for(Task task : tasks){
                if(task.developerDetails.equalsIgnoreCase(developer)){
                    result.append("Task Name:").append(task.taskName).append("\nTask Status:").append(task.taskStatus).append("\n\n");
                }
            }
            if (result.length()>0){
                JOptionPane.showMessageDialog(null, result.toString());
            }else{
                JOptionPane.showMessageDialog(null,"No tasks found for this developer");
        }
        
    }
        //Method to delete a task by task name
        public static void deleteTask(){
            String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");
            for (Task task:tasks){
                if(task.taskName.equalsIgnoreCase(taskName)){
                    tasks.remove(task);
                    JOptionPane.showMessageDialog(null,"Task deleted seccessfully");
                    return;
                }
            }
            JOptionPane.showMessageDialog(null,"Task not found"); 
        }
        //Task class to store task details
        static class Task{
            private String taskName;
            private final String taskDescription;
            private String developerDetails;
            private final int taskDuration;
            private final String taskID;
            private String taskStatus;
            
            public Task(String taskName, String taskDescription,String developerDetails, int taskDuration,String taskID, String taskStatus){
                this.taskName = taskName;
                this.taskDescription = taskDescription;
                this.developerDetails= developerDetails;
                this.taskDuration= taskDuration;
                this.taskID= taskID;
                this.taskStatus = taskStatus;
            }
            
            //Method to print task details
            public String printTaskDetails(){
                return "Task Name:"+ taskName +"\nTask Number:"+ taskNumber+"\nTask Description:"+ taskDescription+"\nDeveloper Details:"+ developerDetails+"\nTask Duration:"+taskDuration+ "hours\nTaskID:"+ taskID+"\nTask Status:"+taskStatus;
              }       
                        
            }
                    
    
}
