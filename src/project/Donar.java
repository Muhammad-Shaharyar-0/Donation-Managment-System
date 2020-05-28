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
public class Donar {
    String Name;
    List<Project> ProjectsDonatedTo;
    List<Donation> DonationsMade;
    Donar(String name,Project p,Donation D)
    {
        Name=name;
        ProjectsDonatedTo=new ArrayList<>();
        DonationsMade=new ArrayList<>();
        ProjectsDonatedTo.add(p);
        DonationsMade.add(D);
    }
    void AddDonation(Donation D)
    {
        DonationsMade.add(D);
    }
    List<Project> getProjects()
    {
        return ProjectsDonatedTo;
    }
    List<Donation> getDonations()
    {
        return DonationsMade;
    }
    void DetailAbouAllDonations()
    {
        //Print();
      //  ComputeDonationTotal();
        ComputeProjactTotal("Project");
    }
    int ComputeDonationTotal()
    {
        int Total=0;
        for(Donation d:DonationsMade)
         {
             Total+=d.getFunds();
         }
        return Total;
    }
     int ComputeProjactTotal(String Name)
    {
        int Total=0;
        for(Project p:ProjectsDonatedTo)
         {
             if(p.getName().equals(Name))
             {
                for(Donation d:p.GetAllDonationsMadeByDonar(this))
                {
                    Total+=d.getFunds();
                }
             }
         }
        return Total;
    }
    Project getProject(String name)
    {
        for(Project p:ProjectsDonatedTo)
        {
            if(p.getName().equals(name));
            {
                return p;
            }
            
        }
        return null;
    }
    void Print()
    {
          System.out.println(Name);
         for(Donation d:DonationsMade)
         {
             d.Print();
         }
    }
    String getName()
    {
        return Name;
    }
    Donation getDonation(int id)
    {
        for(Donation d:DonationsMade)
        {
            if(d.getID()==id)
                return d;
        }
        return null;
    }
    
}
