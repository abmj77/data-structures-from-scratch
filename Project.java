package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class project{
    
    private Node head;  
    public class Node {
        int ID_Number = 7;
        double Work_hours, Employee_Salary;
        String Employee_Name, First_Day_Work, Phone_Number, Employee_Address; 

        public Node next;
        public Node head;

        public Node(int ID,String Name,String First_Day,
                    String Phone,String Address,
                    double Work_hours,double Salary){

            this.ID_Number = ID;
            this.Employee_Name = Name;
            this.First_Day_Work = First_Day;
            this.Phone_Number = Phone;
            this.Employee_Address = Address;
            this.Work_hours = Work_hours;
            this.Employee_Salary = Salary;
            this.next = null;
        }
    }
   
    
    public void writeEmployeeInfo() throws IOException {
        File file = new File("Employee_File.txt");
        FileWriter writer = new FileWriter(file);
        Node temp = head;
        
        while(temp != null){
            writer.write(temp.ID_Number +" "+ temp.Employee_Name +" "+ temp.First_Day_Work
            +" "+ temp.Phone_Number +" "+ temp.Employee_Address +" "+ temp.Work_hours +" "+
            temp.Employee_Salary+"\n");
            temp = temp.next;
        }
        writer.close();
    }
   
    public void readEmployeeInfo() throws FileNotFoundException {
        File file = new File("Employee_File.txt");
        if(file.exists()){
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                int ID_Number = scanner.nextInt();
                String Phone_Number = scanner.next();
                String Employee_Name = scanner.next();
                String First_Day_Work = scanner.next();
                String Employee_Address = scanner.next();
                double Work_hours = scanner.nextDouble();
                double Employee_Salary = scanner.nextDouble();
                Create_Record(ID_Number, Employee_Name, First_Day_Work, 
                               Phone_Number, Employee_Address, Work_hours, 
                               Employee_Salary);
            }
            scanner.close();
        }
    }
    
    public void Create_Record(int ID_Number,String Employee_Name,
                               String First_Day_Work,String Phone_Number,
                               String Employee_Address,double Work_hours,
                               double Employee_Salary){
      
        System.out.println("\n---------------------");
        Node node = new Node(ID_Number,Employee_Name,First_Day_Work,
                                 Phone_Number,Employee_Address,Work_hours,
                                 Employee_Salary);
        if(head == null){
            head = node;
            return;
        }
        else {
            Node temp = head;
            while (temp.next != null && node.ID_Number > temp.next.ID_Number  ){
               temp = temp.next;
            }
            
            if(head == temp){
                node.next=head;
                head = node;
                
            }else {
                node.next = temp.next;
                temp.next = node;
            } 
        }
    }
    
    boolean Check_Record(int ID_Number){
        Node temp = head;
        if(head == null)
           return false;
       
        while(temp != null && head != null){
            if(temp.ID_Number == ID_Number)
                return true;
            temp = temp.next;
        }
        return false;
   }
   
    public Node Search_Record(int ID_Number){
        Node temp = head;
        while (temp != null){
            if(temp.ID_Number == ID_Number){
                break;
            }
            else {
                temp = temp.next;
            }
        }
        return temp;
   }
   
    public int Delete_Record(int ID_Number){
        Node temp = head;
        Node previos = null;
        
        if (temp != null && temp.ID_Number == ID_Number){
            head = temp.next; 
            return 1;
        }
        while (temp != null && temp.ID_Number != ID_Number){
            previos = temp;
            temp = temp.next;
        }
        if(temp == null){
            return 0;
        }
        previos.next = temp.next;
        return 1;
   }
    
     public void Show_Record(){
        Node temp = head;
        while(temp != null){
            System.out.println("\nEmployee Information:\n"
                               + "- ID: " + temp.ID_Number + "\n- Name: "
                               +temp.Employee_Name + "\n- First day of work: "
                               +temp.First_Day_Work + "\n- Phone number: "
                               +temp.Phone_Number + "\n- Address: "
                               +temp.Employee_Address + "\n- Work hours: "
                               +temp.Work_hours + "\n- Salary: "
                               +temp.Employee_Salary +"\n\n--------------------------");
            temp = temp.next;
        }
     }
     
     public void Update_Salary(int ID_Number){
        Node temp = Search_Record(ID_Number);
        if(temp != null){
            if(temp.Work_hours > 32){
                double extraHours = temp.Work_hours - 32;
                double bouns = extraHours * 2;
                temp.Employee_Salary +=(temp.Employee_Salary * bouns / 100);
                System.out.println("The salary for emplyee with ID '" + ID_Number + "' has updated.");
            }
            else{
                System.out.println("This employee with ID '"+ ID_Number +"' does not have a bonus");
            }
        }
        else{
            System.out.println("Employee with ID '" + ID_Number + "' doesn't Exist");
        }
      
        
     }
     
     public void Update_Employee(int ID_Number){
        if(!Check_Record(ID_Number)){
            System.out.println("Employee not found");
        }
        else{
            Node temp = head;
            while(temp != null){
                if(temp.ID_Number == ID_Number){
                    break;
                }
                temp = temp.next;
                }
                         
            Scanner scan = new Scanner(System.in);
            int select; 
            int again;
            String Employee_Name, First_Day_Work, Phone_Number, Employee_Address;
            double Work_hours, Employee_Salary;

            do{
                System.out.println("\nSelect the option that you want to update : ");
                System.out.println("1 - Employee name ");
                System.out.println("2 - First day of work ");
                System.out.println("3 - Phone number ");
                System.out.println("4 - Address ");
                System.out.println("5 - Work hours ");
                System.out.println("6 - Salary ");
                select = scan.nextInt();
                scan.nextLine();
                switch(select){
                    case 1: 
                        System.out.print("Enter the new name: ");  
                        Employee_Name = scan.nextLine();
                        temp.Employee_Name = Employee_Name;
                        break;

                    case 2:
                        System.out.print("Enter the new first day of work: ");  
                        First_Day_Work = scan.nextLine();
                        temp.First_Day_Work = First_Day_Work;
                        break;

                    case 3:
                        System.out.print("Enter the new phone number: ");  
                        Phone_Number = scan.nextLine();
                        temp.Phone_Number = Phone_Number;
                        break;

                    case 4:
                        System.out.print("Enter new address: ");  
                        Employee_Address = scan.nextLine();
                        temp.Employee_Address = Employee_Address;
                        break;

                    case 5:
                        System.out.print("Enter the new work hours: ");  
                        Work_hours = scan.nextDouble();
                        temp.Work_hours = Work_hours;
                        break;

                    case 6:
                        System.out.print("Enter the new salary: ");  
                        Employee_Salary = scan.nextDouble();
                        temp.Employee_Salary = Employee_Salary;
                        Update_Salary(ID_Number);
                        break;

                    default : 
                        System.out.println("Wrong choice!!");

                     }
                System.out.print("\n"
                		+ "if you want to update another data press 1 otherwise press any other number: ");
                again=scan.nextInt();
                
            }while(again==1);     
           
        }    System.out.println("\n--------------------------");
    }
     
     
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int ID_Number;
        int select;
        String Employee_Name, First_Day_Work, Phone_Number, Employee_Address;
        double Work_hours, Employee_Salary;
        boolean flag = true;

        project employee = new project();
        employee.readEmployeeInfo();
        while(flag){
            System.out.println("1 - Insert employee record\n" +
                               "2 - Delete employee record\n" +
                               "3 - Update employee record\n" +
                               "4 - Show details of an employee\n" +
                               "5 - Search an employee\n" +
                               "6 - Update the salary of an employee\n"+
                               "7 - Exit\n");
              System.out.print("Select your choice: ");
              select = scan.nextInt();
              System.out.println("");
              switch(select){
                 case 1:
                    do{
                        System.out.print("Enter employee ID (Just 7 numbers): ");  
                        ID_Number = scan.nextInt();
                        }while(String.valueOf(ID_Number).length()<7 || String.valueOf(ID_Number).length()>7);
                        scan.nextLine();
                        
                    if(employee.Check_Record(ID_Number)){
                      System.out.println("Employee with ID " +ID_Number+ " already exist ");
                    }else{
                        System.out.print("Enter employee Name: ");  
                        Employee_Name = scan.nextLine();

                        System.out.print("Enter First day of work (dd/mm/yyyy): ");  
                        First_Day_Work = scan.nextLine();

                        do{
                        System.out.print("Enter Phone number: ");  
                        Phone_Number = scan.nextLine();
                        }while(Phone_Number.length() != 10);

                        System.out.print("Enter Address: ");  
                        Employee_Address = scan.nextLine();

                        do{
                            System.out.print("Enter Work hours (It must be more than 32 hours): ");  
                            Work_hours = scan.nextDouble();
                        }while(Work_hours < 32);
                        
                        System.out.print("Enter Salary: ");  
                        Employee_Salary = scan.nextDouble();
                        
                        employee.Create_Record(ID_Number, Employee_Name, First_Day_Work, 
                                                Phone_Number, Employee_Address, Work_hours, 
                                                Employee_Salary);
                    }
                    break;
                    
                  case 2: 
                      System.out.print("Enter the employee ID to delete it: ");
                      ID_Number = scan.nextInt();
                      if(employee.Delete_Record(ID_Number) == 1){
                          System.out.println("Emplyee with ID " +ID_Number+ " has been deleted"
                          		+ "\n\n---------------------");

                      }else{
                          System.out.println("There is no employee with ID "+ID_Number+"\n---------------------");
                      }
                      break;
                      
                  case 3:
                       System.out.print("Enter employee ID to update it: ");
                       ID_Number = scan.nextInt();
                       employee.Update_Employee(ID_Number);
                       break;
                      
                  case 4:
                      employee.Show_Record();
                      break;
                      
                  case 5:
                      System.out.print("Enter employee ID to search about it :");
                      ID_Number = scan.nextInt();
                      Node temp = employee.Search_Record(ID_Number);
                      if(temp != null){
                           System.out.println("Employee Information :\n- ID: "
                                              +ID_Number+"\n- Name: "
                                              +temp.Employee_Name +"\n- First day of work: "
                                              +temp.First_Day_Work +"\n- Phone number: "
                                              +temp.Phone_Number+"\n- Address :"
                                              +temp.Employee_Address+"\n- Work hours: "
                                              +temp.Work_hours +"\n- Salary: "
                                              +temp.Employee_Salary +"\n\n--------------------------");
                      }else{
                           System.out.println("employee with ID ("+ID_Number+") not registered\n"
                        		  +"\n--------------------------");
                      }
                      break;
                      
                  case 6:
                      System.out.print("Enter employee ID to update salary: ");
                      ID_Number = scan.nextInt();
                      employee.Update_Salary(ID_Number);
                      System.out.println("\n--------------------------");
                      break;
                      
                  case 7:
                      employee.writeEmployeeInfo();
                      flag = false;
                      break;
                      
                  default:
                      System.out.print("Wrong choice");
            }
        }
    }
}