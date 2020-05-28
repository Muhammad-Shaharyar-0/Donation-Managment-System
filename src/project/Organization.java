/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.*;
/**
 *
 * @author Fami
 */
public class Organization {
   final List <Volunteer> volunteers=new ArrayList<Volunteer>();
   final List <Donar> Donars=new ArrayList<Donar>();
   final List<Project> Projects=new ArrayList<Project>();
   final List<beneficiary> beneficiaries=new ArrayList<beneficiary>();
   Volunteer Administrator;
   dbConnectivity db;
    
    Organization()
    {
       
        db=new dbConnectivity();
        db.getVolunteers(volunteers);
        db.getProjects(this);
        db.getTeams(this);
       // db.getDonars(this);
       // db.getbeneficiaries(this);
    }
    void createProject(String name,String Desc,String projectManager,int goal)//
    {
        for(Volunteer v :volunteers )
        {
            if(v.getName().equals(projectManager))
            {
                Project p=new Project(name,Desc,v,goal);
                Projects.add(p);
                db.CreateProject(name,Desc,projectManager,goal);
                
            }
        }
    
    }
    void PopulateProjects(String name,String Desc,String projectManager,int goal)//
    {
        for(Volunteer v :volunteers )
        {
            if(v.getName().equals(projectManager))
            {
                Project p=new Project(name,Desc,v,goal);
                Projects.add(p);
                
            }
        }
    }
     void PopulateTeams(List<String> T)//
    {
                              System.out.println("sad");
                for(Project p :Projects )
                {
                     if(p.getName().equals(T.get(0)))
                    {
                          System.out.println(Projects.size());
                            p.AddTeamLead(getVolunteer(T.get(1)));
                           for(int i=2;i<T.size();i++)
                            p.AddMember(getVolunteer(T.get(i)));
                     }
                }
            
    }
    void PopulateDonars(String name,String Desc,String projectManager,int goal)//
    {
        for(Volunteer v :volunteers )
        {
            if(v.getName().equals(projectManager))
            {
                Project p=new Project(name,Desc,v,goal);
                Projects.add(p);
                
            }
        }
    }
    void Populatebeneficiaries(String name,String Desc,String projectManager,int goal)//
    {
        for(Volunteer v :volunteers )
        {
            if(v.getName().equals(projectManager))
            {
                Project p=new Project(name,Desc,v,goal);
                Projects.add(p);
                
            }
        }
    }
    List<Project> getProjects()
    {
        return Projects;
    }
    List<Volunteer>  getVolunteers()
    {
       return volunteers;
       
    }
    Volunteer  getVolunteer(String name)
    {
           
       for(Volunteer v:volunteers )
       {
           if(v.getName().equals(name))
           {
               
               return v;
           }
       }
       return null;
    }
    List<Volunteer> getTeamofProject(String Name)
    {
         for(Project p :Projects )
        {
               if(p.getName().equals(Name))
                {
                        return p.getTeam();
                }
                     
            
        }
         return null;
    }
    void AllocateTeam(String ProjectName,String TeamLead,String Member1,String Member2)//
    {
        
        Volunteer Temp1 = null;
        Volunteer Temp2=null;
        Volunteer Temp3=null;
        int flag=0;
        for(Volunteer v :volunteers )
        {
            if(v.getName().equals(TeamLead))
            {
                    Temp1=v;
                    flag++;
            }
            else if(v.getName().equals(Member1))
            {
                Temp2=v;
                flag++;
            }
            else if(v.getName().equals(Member2))
            {
                Temp3=v;
                flag++;
            }
            if(flag==3)
            {
                for(Project p :Projects )
                {
                     if(p.getName().equals(ProjectName))
                    {
                       
                        p.AddTeamLead(Temp1);
                        p.AddMember(Temp2);
                        p.AddMember(Temp3);
                        p.PrintTeam();
                        db.AllocateTeam(ProjectName, TeamLead, Member1, Member2);
                        break;
                     }
                     
            
                }
               
                break;
            }
        }
        
    }
   
    void AddVolunteers()
    {
        
    }
    void AddDonar(String Pname,String Dname,Donation d)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
                Donar D=new Donar(Dname,p,d);
                Donars.add(D);
                d.setDonatedBy(D);
                p.AddDonar(D);
                p.Collection(d);
                db.AddDonar(Dname,p.getName(),d.getID());
             }            
        }
    }
     List<Donar> getDonars()
    {
        return Donars;
    }
    void AddDonation(String Pname,String Dname,Donation d)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
                for(Donar D :Donars )
                {
                    if(D.getName().equals(Dname))
                    {
                        System.out.println(D.DonationsMade.size());
                        d.setDonatedBy(D);
                        p.AddDonarwithSearch(D);
                        p.Collection(d);
                        D.AddDonation(d);
                    }            
                }
               
            }            
        }
    }
    void PrintDetailsofaDonar(String Dname)
    {
        for(Donar d:Donars)
        {
            if(d.getName().equals(Dname))
            {
                d.DetailAbouAllDonations();
            }
        }
    }
    void PrintDetailsofaBeneficieries(String Bname)
    {
        for(beneficiary b:beneficiaries)
        {
            if(b.getName().equals(Bname))
            {
                b.PrintDetailsofaBeneficieries();
            }
        }
    }
    void AddBeneficiery(String Pname,String Bname,String Bphone,String Baddress,int income)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
               beneficiary b=new beneficiary(Bname,Bphone,Baddress,income);
               p.AddApplicant(b);
            }            
        }
    }
    List<beneficiary> getApplicants(String Pname)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
              
               return p.getApplicants();
            }            
        }
        return null;
    }
    List<beneficiary> getbeneficiaries(String Pname)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
              
               return p.getbeneficiaries();
            }            
        }
        return null;
    }
    void SelectApplicant(String Pname,String Bname)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
               
               p.SelectApplicant(Bname);
               beneficiaries.add(p.getApplicant(Bname));
            }            
        }
    }
    String GiveDonation(String Pname,String Bname,int amount)  //Also Check balance
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
              return p.GiveDonation(Bname,amount);
            }            
        }
        return null;
    }
    void TransferVolunteerFromProject(String Pname,String Vname1,String Vname2)//
    {
        int flag=0;
         for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
                for(Volunteer v :volunteers )
                {
                    if(v.getName().equals(Vname2))
                    {
                        if(p.getTeamLead().getName().equals(Vname1))
                        {
                            p.SetTeamLead(v);
                        }
                         p.AddMember(v);
                          flag++;
                    }
                    if(v.getName().equals(Vname1))
                    {
                         p.RemoveMember(v);
                             flag++;

                    }
                    if(flag==2)
                    {
                        db.ChangeMember(Vname1,p.getTeam().indexOf(v), Vname2, Pname);
                        break;
                    }
                }  
                break;
            }
         }
    }
   
    void RemovingVolunteerFromProject(String Pname,String Vname)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
                for(Volunteer v :volunteers )
                {
                    if(v.getName().equals(Vname))
                    {                    
                         if(p.getTeamLead()==v)
                         {
                             db.RemoveTeamLead(Vname,p.getTeam().get(p.getTeam().size()-1).getName(), p.getTeam().indexOf(v), p.getTeam().size()-1, Pname);
                             p.SetTeamLead(p.getTeam().get(p.getTeam().size()-1));
                             p.RemoveMember(v);
                         }
                         else
                         {
                             db.RemoveMember(Vname,p.getTeam().get(p.getTeam().size()-1).getName(), p.getTeam().indexOf(v), p.getTeam().size()-1, Pname);
                               p.SetTeamLead(p.getTeam().get(p.getTeam().size()-1));
                             p.RemoveMember(v);
                         }
                         
                        
                        
                         break;
                    }
                }
                        
                break;
            }
      
         }
    }
    
    void AssigningVolunteerToAProject(String Pname,String Vname)//
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(Pname))
            {
                for(Volunteer v :volunteers )
                {
                    if(v.getName().equals(Vname))
                    {
                         p.AddMember(v);
                         db.AddMember(Vname,p.getTeam().size(),Pname);
                         break;
                    }
                }
                        
                break;
            }
      
         }
    }
    
    Donar SearchDonar(String name)
    {
        for(Donar d :Donars )
        {
            if(d.getName().equals(name))
                return d;
         
        }
        return null;
    }
    beneficiary Searchbeneficiary(String name)
    {
        for(beneficiary b :beneficiaries )
        {
            if(b.getName().equals(name))
                return b;
         
        }
        return null;
    }
    Project SearchProjectByName(String name)
    {
        for(Project p :Projects )
        {
            if(p.getName().equals(name))
                return p;
         
        }
        return null;
    }
     void SearchProjectByManager(String name)
    {
        for(Project p :Projects )
        {
            if(p.getProjectManger().getName().equals(name))
            {

                p.Print();
            }
           
        }
    }
     /*
         void CheckingAvailabilityOfVolunteers()
    {
        
    } 
   void DeleteProject()
    {
        
    }
    
    void RemoveVolunteer()
    {
        
    }
    
    void RemoveDonar()
    {
        
    }
    
    void RemoveBeneficiary()
    {
        
    }
    
    void GetFundsSpentByDonar()//Total and Project Voice
    {
        
    }
    
    void GetAllPledgesMadeByDonar()//Total and Project Voice
    {
        
        
    }
    void GetBeneficiresofaProject()//
    {
        
    }
    void GetFundsDonatedToBenefiery()//Total and Project Voice
    {
        
    }
    void GetDonarsofaProject()//
    {
        
    }
    void GetAllFundsAllocation()
    {
        
    }*/
};

