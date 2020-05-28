/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Fami
 */
public class DonatedTo {
    beneficiary Reciever;
    int Amount;
    
    DonatedTo(beneficiary R,int amount)
    {
        Reciever=R;
        Amount=amount;
    }
    beneficiary getbeneficiary()
    {
        return Reciever;
    }
    int getamount()
    {
        return Amount;
    }
}
