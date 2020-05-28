/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fami
 */
public class beneficiary{
    String Name;
    String Phone;
    String Address;
    int Income;
    List<Project> ProjectsDonatedBy;
    List<Donation> DonationsRecieved;
    beneficiary(String name,String Contact,String address,int income)
    {
        Name=name;
        Phone=Contact;
        Address=address;
        Income=income;
        ProjectsDonatedBy=new ArrayList<>();
        DonationsRecieved=new ArrayList<>();
    }
    void AddProject(Project p)
    {
        ProjectsDonatedBy.add(p);
    }
    void AddDonation(Donation d)
    {
        DonationsRecieved.add(d);
    }
    String getName()
    {
        return Name;
    }
    Donation getDonation(int id)
    {
        for(Donation d:DonationsRecieved)
        {
            if(d.getID()==id)
                return d;
        }
        return null;
    }
   void PrintDetailsofaBeneficieries()
    {
       Print();
        ComputeDonationTotal();
        ComputeProjactTotal("Project");
    }
    int ComputeDonationTotal()
    {
        int Total=0;
        for(Donation d:DonationsRecieved)
         {
             Total+=d.getFundsSpent();
         }
         return Total;
    }
    int ComputeProjactTotal(String Name)
    {
        int Total=0;
        for(Project p:ProjectsDonatedBy)
         {
             if(p.getName().equals(Name))
             {
                for(Donation d:p.GetAllDonationsMadeGivenToBeneficery(this))
                {
                    Total+=d.getFunds();
                }
             }
         }
        return Total;
    }
    void Print()
    {
          System.out.println(Name);
          for(Donation d:DonationsRecieved)
          {
               d.Print();
          }
    }
    List<Project> getProjects()
    {
        return ProjectsDonatedBy;
    }
    List<Donation> getDonations()
    {
        return DonationsRecieved;
    }
    Project getProject(String name)
    {
        for(Project p:ProjectsDonatedBy)
        {
            if(p.getName().equals(name));
            {
                return p;
            }
            
        }
        return null;
    }
    
}
