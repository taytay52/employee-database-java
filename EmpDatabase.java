import java.util.*;
import java.io.*;

class EmpDatabase
{
   public static void main(String[] args) throws FileNotFoundException
   {
      FileOutputStream fl = new FileOutputStream("Employee_Record.txt", true); //To open 'Employee_Record.txt' file. 'true' means you will be able to append new data in the file
      PrintStream pr = new PrintStream(fl); //To write data into the file
      Scanner sc = new Scanner(System.in); //To read from the console
      char ans = ' ';
      
      try
      {
         //Adding record
         for(int i = 0; i < 3; i++)
         {  
            //Read data from console
            System.out.print("Enter the name of the employee: ");
            String name = sc.nextLine();
            System.out.print("Enter the age of the emplyee: ");
            int age = sc.nextInt();
            System.out.print("Enter the monthly salary of the emplyee: ");
            double sal = sc.nextDouble();   
            pr.append(name + " " + age + " " + sal + "\n"); //Add record at the end of the last record of 'Employee_Record.txt'
            pr.flush();
            System.out.println("Record added successfully");
            sc.nextLine();
         }
         fl.close();
      
         //Modifying records multiple times
         do
         {
            fl = new FileOutputStream("temp.txt", true); //To open 'temp.txt' file for writing the content of 'Employee_Record.txt'.
            pr = new PrintStream(fl);
            Scanner scf = new Scanner(new File("Employee_Record.txt")); //To open 'Employee_Record.txt' file for reading the records
         
            System.out.print("Enter the name of the employee to modify the record: ");
            String tempName = sc.nextLine();
            while(scf.hasNextLine()) //To read all records of 'Employee_Record.txt' line by line
            {
               String oldRec = scf.nextLine(); //Reading the current record of 'Employee_Record.txt'
               String[] data = oldRec.split(" "); //Storing employee name in data[0], age in data[1], and monthly salary in data[2]
               String modfRec = " ";
               if(data[0].compareTo(tempName) != 0) //If employee name does not match, append the record to 'temp.txt' file
               {
                  pr.println(oldRec);
                  pr.flush();
               }
               else //Otherwise, modify the monthly salary and append the modified record to 'temp.txt' file  
               {
                  System.out.print("Enter the new monthly salary of " + data[0] + ": ");
                  data[2] = sc.nextLine();
                  modfRec = data[0] + " " + data[1] + " " + data[2];
                  pr.println(modfRec);
                  pr.flush();
                  System.out.println("Record modified successfully");
               }
            }
            scf.close();
            File of = new File("Employee_Record.txt");
            of.delete(); //Delete old 'Employee_Record.txt' from the folder
            fl.close();
            File nf = new File("temp.txt"); 
            nf.renameTo(of); //Rename the 'temp.txt' file to 'Employee_Record.txt'

            System.out.print("Do you want to modify more record?(Y/N): ");
            ans = sc.nextLine().charAt(0);
            //sc.nextLine();
         }while(ans == 'y' || ans == 'Y');
      }
      catch(Exception ex){}   
   }
}