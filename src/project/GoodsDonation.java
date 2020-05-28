/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Fami
 */
public class GoodsDonation extends Donation {
    String GoodsDonated;
    int valueReveived;
    GoodsDonation(String Goods,int v)
    {
        Spenton=new ArrayList<>();
        GoodsDonated=Goods;
        valueReveived=v;
    }
    String ShowDetailsforBenef(beneficiary b)
    {
        String s="Donated By: "+DonatedBy.getName()+"\nAmountDonated: "+valueReveived+"\nGoods: "+GoodsDonated+
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
        String s="Donated By: "+DonatedBy.getName()+"\nAmountDonated: "+valueReveived+"\nGoods: "+GoodsDonated+
                "\nDonation Spent: ";
        int Total=valueReveived-RemainingBalance();
             s=s+Total;
        return s;
    }
     void Print()
    {
        System.out.println(GoodsDonated);
    }
     int getFunds()
    {
        return valueReveived;
    }
     int RemainingBalance()
    {
        int Total=0;
        for(DonatedTo d:Spenton)
        {
            Total+=d.getamount();
        }
        Total=valueReveived-Total;
        return Total;
    }
}
