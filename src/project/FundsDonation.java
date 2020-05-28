/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Fami
 */
public class FundsDonation extends Donation {
    int DonatedFunds;
    FundsDonation(int Funds)
    {
            Spenton=new ArrayList<>();
            DonatedFunds=Funds;   
          
    }
    String ShowDetailsforBenef(beneficiary b)
    {
        String s="Donated By: "+DonatedBy.getName()+"\nAmountDonated: "+DonatedFunds+
                "\nDonation Received: ";
        for(DonatedTo d: Spenton)
        {
            if(d.getbeneficiary().equals(b))
            {
                s=s+d.Amount;
            }
        }
        return s;
    }
    String ShowDetailsforDonar()
    {
        String s="Donated By: "+DonatedBy.getName()+"\nAmountDonated: "+DonatedFunds+
                "\nDonation Spent: ";
        int Total=DonatedFunds-RemainingBalance();
             s=s+Total;
        return s;
    }
    void Print()
    {
        System.out.println(DonatedFunds);
    }
    int getFunds()
    {
        return DonatedFunds;
    }
    int RemainingBalance()
    {
        int Total=0;
        for(DonatedTo d:Spenton)
        {
            Total+=d.getamount();
        }
        Total=DonatedFunds-Total;
        return Total;
    }
    
}
