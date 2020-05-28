/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Zero
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class dbConnectivity 
{
    Connection con;
    Statement stmt;
    int count;
    dbConnectivity() //cons
    {
        try
        {
             String s = "jdbc:mysql://localhost:3306/system";
             con=DriverManager.getConnection(s,"root","1963szrs");
             stmt = con.createStatement(); 
             count=0;
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void CreateProject(String name,String Desc,String projectManager,int goal)
    {
        try
        {
           stmt.executeUpdate("INSERT INTO `system`.`project`\n" +"(`Name`,\n" 
                    +"`Description`,\n" +"`Goal`,`ProjectManger`)\n" 
                    +"VALUES\n" +"('"+name+"','"+Desc+"',"+goal+",'"+projectManager+"');");
         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    int AllocateTeam(String Pname,String TeamLead,String M1,String M2){
        try
        {
          
            stmt.executeUpdate("INSERT INTO `system`.`team`(`Project`,`Member1`,`TeamLead`,`Member2`)VALUES "
                    + "('"+Pname+"','"+TeamLead+"','"+M1+"','" +M2+"');");
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
    int AddMember(String V,int membercount,String pname){
         try
        {
            
            int m=membercount-1;
           
            System.out.println(membercount);
             if(membercount==count)
             {
             stmt.executeUpdate("ALTER TABLE team\n" +
                            "ADD COLUMN Member"+m+" VARCHAR(15);");
             }
              stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`Member"+m+"` = \""+V+"\" \n" +"WHERE `Project` = \""+pname+"\";");
              
              stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 0 \n" +"WHERE `Name` = \""+V+"\";");


           //  ResultSet rs=stmt.executeQuery();
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }
    void ChangeMember(String v1,int membernumber,String v2,String pname){
        try
        {
           
             stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`Member"+membernumber+"` = \""+v2+"\" \n" +"WHERE `Project` = \""+pname+"\";");
             stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 1 \n" +"WHERE `Name` = \""+v1+"\";");
             stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 0 \n" +"WHERE `Name` = \""+v2+"\";");
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void ChangeTeamLead(String v1,int membernumber,String v2,String pname){
        try
        {
              stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`TeamLead` = \""+v2+"\" \n" +"WHERE `Project` = \""+pname+"\";");
                 stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 1 \n" +"WHERE `Name` = \""+v1+"\";");
                 stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 0 \n" +"WHERE `Name` = \""+v2+"\";");
         
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void RemoveMember(String V1,String V2,int membernumber,int lastMember ,String pname){
        try
        {
                  stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`Member"+membernumber+"` = \"-\" \n" +"WHERE `Project` = \""+pname+"\";");
                  stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 1 \n" +"WHERE `Name` = \""+V1+"\";");
                  stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`Member"+membernumber+"` = \""+V2+"\" \n" +"WHERE `Project` = \""+pname+"\";");
                  stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`Member"+lastMember+"` = \"-\" \n" +"WHERE `Project` = \""+pname+"\";");
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void RemoveTeamLead(String V1,String V2,int membernumber,int lastMember ,String pname){
        try
        {
                 stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`TeamLead` = \"-\" \n" +"WHERE `Project` = "+pname+";");
                 stmt.executeUpdate("UPDATE `system`.`voluntess`\n" +"SET\n" +"`Available` = 1 \n" +"WHERE `Name` = \""+V1+"\";");
                 stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`TeamLead` = \""+V2+"\" \n" +"WHERE `Project` = "+pname+";");
                 stmt.executeUpdate("UPDATE `system`.`team`\n" +"SET\n" +"`Member"+lastMember+"` = \"-\" \n" +"WHERE `Project` = "+pname+";");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void AddDonar(int id, String name, int qun, int price){
        try
        {
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void AddDonation(int id, String name, int qun, int price){
        try
        {
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void AddBeneficiery(int id, String name, int qun, int price){
        try
        {
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void GiveDonation(int id, String name, int qun, int price){
        try
        {
             
             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    void getProjects(Organization O)
    {
         try
        {
             ResultSet rs=stmt.executeQuery("select * from Project");
             while(rs.next())
             {   
                   O.PopulateProjects(rs.getString(1),rs.getString(2),rs.getString(4),rs.getInt(3));
                 
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void getVolunteers(List <Volunteer> volunteers)
    {
          try
        {
             ResultSet rs=stmt.executeQuery("select * from Voluntess");
             while(rs.next())
             {   
                   Volunteer v =new Volunteer(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getBoolean(4));
                   volunteers.add(v);
                 
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void getTeams(Organization O)
    {
          try
        {   
                
             ResultSet rs=stmt.executeQuery("SELECT count(*) AS team FROM information_schema.columns\n" +
                            "     WHERE table_name ='team'");
              while(rs.next())
             {   
                    count = rs.getInt(1);
                 
             }
             rs=stmt.executeQuery("select * from team");
             
             while(rs.next())
             {      List<String> s=new ArrayList();
                    for(int i=0;i<count;i++)
                    {
                       
                        if(rs.getString(i+1).equals("-"))
                        {
                        }
                        else
                        {
                            s.add(rs.getString(i+1));
                        }
                    }
                         O.PopulateTeams(s);
                
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void getDonars(Organization O)
    {
          try
        {   
                int count=0;
             ResultSet rs=stmt.executeQuery("SELECT count(*) AS team FROM information_schema.columns\n" +
                            "     WHERE table_name ='team'");
              while(rs.next())
             {   
                    count = rs.getInt(1);
                 
             }
             rs=stmt.executeQuery("select * from team");
             while(rs.next())
             {      List<String> s=new ArrayList();
                    for(int i=0;i<count;i++)
                    {
                       
                        s.add(rs.getString(i+1));
                    }
                  
                //   O.AllocateTeam(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                   //O.getTeams(s);
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
     void getbeneficiaries(Organization O)
    {
          try
        {   
                int count=0;
             ResultSet rs=stmt.executeQuery("SELECT count(*) AS team FROM information_schema.columns\n" +
                            "     WHERE table_name ='team'");
              while(rs.next())
             {   
                    count = rs.getInt(1);
                 
             }
             rs=stmt.executeQuery("select * from team");
             while(rs.next())
             {      List<String> s=new ArrayList();
                    for(int i=0;i<count;i++)
                    {
                       
                        s.add(rs.getString(i+1));
                    }
                  
                //   O.AllocateTeam(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                 //  O.getTeams(s);
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
      void getFundsDonations(Organization O)
    {
          try
        {   
                int count=0;
             ResultSet rs=stmt.executeQuery("SELECT count(*) AS team FROM information_schema.columns\n" +
                            "     WHERE table_name ='team'");
              while(rs.next())
             {   
                    count = rs.getInt(1);
                 
             }
             rs=stmt.executeQuery("select * from team");
             while(rs.next())
             {      List<String> s=new ArrayList();
                    for(int i=0;i<count;i++)
                    {
                       
                        s.add(rs.getString(i+1));
                    }
                  
                //   O.AllocateTeam(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                  // O.getTeams(s);
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
       void getGoodsDonations(Organization O)
    {
          try
        {   
                int count=0;
             ResultSet rs=stmt.executeQuery("SELECT count(*) AS team FROM information_schema.columns\n" +
                            "     WHERE table_name ='team'");
              while(rs.next())
             {   
                    count = rs.getInt(1);
                 
             }
             rs=stmt.executeQuery("select * from team");
             while(rs.next())
             {      List<String> s=new ArrayList();
                    for(int i=0;i<count;i++)
                    {
                       
                        s.add(rs.getString(i+1));
                    }
                  
                //   O.AllocateTeam(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                 //  O.getTeams(s);
             }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

