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
public class Volunteer {
    String Name;
    int Age;
    String Cnic;
    Boolean Available;
    
    Volunteer(String name,int age,String cnic,Boolean A)
    {
        Name=name;
        Age=age;
        Cnic=cnic;
        Available=A;
    }
    String getName()
    {
        return Name;
    }
    void setAvailability(Boolean a)
    {
        Available=a;
    }
    Boolean getAvailability()
    {
        return Available;
    }
    void Print()
    {
        System.out.println(Name);
        System.out.println(Age);
        System.out.println(Cnic);
        
    }
}
