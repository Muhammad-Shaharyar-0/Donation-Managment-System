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
public class Donation {
    static int inc=0;
    int id;
    List<DonatedTo> Spenton;
    Donar DonatedBy;
     
     Donation()
     {
         id=inc;
         inc++;
     }
     void Print(){}
     int getID()
     {
         return id;
     }
     int getFunds(){return 0;}
     int RemainingBalance()
     {
         return 0;
     }
     Donar getDonatedBy()
     {
         return DonatedBy;
     }
     DonatedTo Serachbeneficiary(beneficiary B) //Returns The Donation if it was spenton a the beneficiary
     {
         for(DonatedTo d:Spenton)
         {
             if(d.getbeneficiary().equals(B))
                 return d;
         }
         return null;
     }
     void setDonatedBy(Donar D)
     {
         DonatedBy=D;
     }
     void Addspenton(beneficiary b,int amount)
     {
         DonatedTo d=new DonatedTo(b,amount);
         Spenton.add(d);
     }
     int getFundsSpent()
     {
        int Total=0;
        for(DonatedTo d:Spenton)
        {
            Total+=d.getamount();
        }
        return Total;
     }
    String ShowDetailsforBenef(beneficiary b)
    {
        
        return null;
    }
    String ShowDetailsforDonar()
    {
       
        return null;
    }
}
