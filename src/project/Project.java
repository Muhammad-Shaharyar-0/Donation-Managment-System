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
public class Project {
    
    String Name;
    String Discription;
    Volunteer ProjectManager;
    int Goal;    //Required Budget
    List<Donar> Donars;
    List <beneficiary> beneficiaries;
    List <beneficiary> Applicants;
    List <Volunteer> Team;
    Volunteer TeamLead;
    List <Donation> Donations;
    List <Pledge> Pledges;
    
    Project(String name,String disc,Volunteer manager,int g)
    {
        Name=name;
        Discription=disc;
        manager.setAvailability(false);
        ProjectManager=manager;
        Goal=g;
        Donars=new ArrayList<Donar>();
        beneficiaries=new ArrayList<beneficiary>();
        Team=new ArrayList<Volunteer>();
        Donations=new ArrayList<Donation>();
        Pledges=new ArrayList<Pledge>();
        Applicants=new ArrayList<beneficiary>();
    }
    String getName()
    {
        return Name;
    }
    Volunteer getProjectManger()
    {
        return ProjectManager;
    }
    void AddApplicant(beneficiary B)
    {
        Applicants.add(B);
    }
    List<Donar> getDonars()
    {
        return Donars;
    }
    void SelectApplicant(String Bname)
    {
        for(beneficiary b: Applicants)
        {
            if(b.getName().equals(Bname))
            {
                beneficiaries.add(b);
                Applicants.remove(b);
                break;
            }
        }
    }
    beneficiary getApplicant(String Bname)
    {
        for(beneficiary b: Applicants)
        {
            if(b.getName().equals(Bname))
            {
              return b;
            }
        }
        return null;
    }
    beneficiary getBeneficiary (String Bname)
    {
        for(beneficiary b: beneficiaries)
        {
            if(b.getName().equals(Bname))
            {
              return b;
            }
        }
        return null;
    }
    int getRemainingBalance()
    {
       int Balance=0;
       for(Donation d: Donations)
       {
            Balance+=d.RemainingBalance();
       }
       return Balance;
    }
    String GiveDonation(String Bname,int amount)
    {
        if(getRemainingBalance()<amount)
        {
             String s="Amount exceeds Remaining Balance Donation Cancelled";
             return s;
        }
        else
        {
            beneficiary b=getBeneficiary(Bname);
            b.AddProject(this);
            int total=0;
            for(Donation d: Donations)
            {
                 total+=d.RemainingBalance();
                 if(total<amount)
                 {
                     d.Addspenton(b,d.RemainingBalance());
                     b.AddDonation(d);
                 }
                 else if(total==amount)
                 {
                     d.Addspenton(b,d.RemainingBalance());
                     b.AddDonation(d);
                     break;
                 }
                 else
                 {
                     total=total-amount;
                     d.Addspenton(b,total);
                     b.AddDonation(d);
                     break;
                 }
            }
             String s="Donation Given";
             return s;
        }
       
    }
    List<beneficiary> getApplicants()
    {
        return Applicants;
    }
    List<beneficiary> getbeneficiaries()
    {
        return beneficiaries;
    }
    void Print()
    {
        System.out.println(Name);
        System.out.println(Discription);
        System.out.println(ProjectManager.getName());
        System.out.println(Goal);
        for(Donar d:Donars)
        {
            d.Print();
        }
    }
    String ShowDetails()
    {
        String s="Name: "+Name+"\nDiscription: "+Discription+"\nProjectManager: "+ProjectManager.getName()+"\nGoal: "+Goal+
                "\nRemainingBalance: "+this.getRemainingBalance();
       return s;
    }
    void PrintTeam()
    {
        for(Volunteer v: Team)
        {
            v.Print();
        }
    }
    List<Volunteer> getTeam()
    {
     
        return Team;
   
    }
    void FundsCollection()
    {
        
    }
    void AddTeamLead(Volunteer V){
        
        Team.add(V);
        TeamLead=V;
        V.setAvailability(false);
    }
    void SetTeamLead(Volunteer V){
        
    }
    void RemoveTeamLead(Volunteer V){
        
    }
    void AddMember(Volunteer V){
           Team.add(V);
           V.setAvailability(false);
    }

    void ChangeMember(Volunteer V1,Volunteer V2){
         Team.remove(V2);
        V2.setAvailability(true);
        Team.add(V1);
        V1.setAvailability(false);
    }
    void RemoveMember(Volunteer V){
       
        Team.remove(V);
        V.setAvailability(true);
        
    }
    Volunteer getTeamLead()
    {
        return TeamLead;
    }
    void AddDonar(Donar D)
    {
        
        Donars.add(D);
    }
    void AddDonarwithSearch(Donar D)
    {
        if(!Donars.contains(D))
            Donars.add(D);
    }
    void Collection(Donation D)
    {
        Donations.add(D);
    }
    void FundsDisbursement(){
        
    }
    
    void GoodsCollection(){
        
    }
    
    void GoodsDisbursement(){
        
    }
    
    void MakePledge(){
        
    }
    
    List<Donation> GetAllDonationsMadeByDonar(Donar d)
    {
        List<Donation> temp=new ArrayList<>();
        for(Donation D:Donations)
        {
           if(D.getDonatedBy().equals(d))
             temp.add(D);
        }
        return temp;
    }
    List<Donation> GetAllDonationsMadeGivenToBeneficery(beneficiary B)
    {
        List<Donation> temp=new ArrayList<>();
        for(Donation D:Donations)
        {
            if(D.Serachbeneficiary(B).equals(B))
                    temp.add(D);
        }
        return temp;
    }
    void GetAllPledgesMadeByDonar(Donar d)
    {
        
    }
    
    void ConductInterview(List <Volunteer> Assesors, beneficiary b)
    {
        
    }
   
    
    
}
