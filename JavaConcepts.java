/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Osama Sajid Khan
 */

package abstractclasses;

abstract class Metals
{
   
    String Color;
    String Name;
    int Quality;
    final int MaximumRating=10;
    final int MinimumRating=5;
    public static int NumofAcceptedMinerals=0;
    public static int NumofRejectedMinerals=0;
  
    
    
    
    
    public Metals(String color, String name, int quality)
    {
        this.Color = "";
        System.out.println("Mineral Constructor Called");
        this.Color=color;
        this.Name=name;
        this.Quality=quality;
    }
    abstract double volume();
    
       
    public String getName()
    {
        return Name;
    }
    
    public String getColor()
    {
        return Color;
    }
    
    public int getQuality()
    {
        return Quality;
    }
    
    public static int GetAccepted()
    {
        return NumofAcceptedMinerals;
    }
    
     public static int GetRejected()
    {
        return NumofRejectedMinerals;
    }
    
    public boolean IsAccepted()
    {
        
        boolean check=false;
        
        if(Quality<MinimumRating)
        {
            System.out.println("Mineral of Poor Quality");
            NumofRejectedMinerals++;
            
        }
        
        else if(Quality==MaximumRating)
        {
            System.out.println("Mineral of Excellent Quality");
            check=true;
            NumofAcceptedMinerals++;
        }
        
        else if(Quality>=MinimumRating)
        {
            System.out.println("Mineral of Good Quality");
            check=true;
            NumofAcceptedMinerals++;
        }
        
        return check;
    }
}

   

class Bars extends Metals
{
    double Length;
    double Width;
    double Height;
    
    
    public Bars( String color,String name, int quality, double length, double width, double height) 
    {
        // calling Metals constructor 
        super(color,name,quality); 
        System.out.println("Bars constructor called"); 
        this.Length = length;
        this.Width = width;
        this.Height = height;
    } 
    

    @Override
    double volume() 
    { 
        return Length * Width * Height; 
    } 
   
    
    class Display 
    { 
      public void DisplayLength() { 
         
        System.out.println("The Length of the Bar is: "); 
        System.out.println(Length); 
      } 
      
      public void DisplayWidth() { 
         
        System.out.println("The Width of the Bar is: "); 
        System.out.println(Width); 
      } 
      
       public void DisplayHeight() { 
         
        System.out.println("The Height of the Bar is: "); 
        System.out.println(Height); 
      } 
    }
      
      
      
}

class Ores extends Metals
{
    double InitialVolumeofWater;
    double FinalVolumeofWater;
   
    
    public Ores(String color,String name, int quality, double initialvolumeofwater, double finalvolumeofwater) 
    {
        // calling Metals constructor 
        super(color,name,quality); 
        System.out.println("Bars constructor called"); 
        this.InitialVolumeofWater = initialvolumeofwater;
        this.FinalVolumeofWater = finalvolumeofwater;
    } 
    

    @Override
    double volume() 
    { 
        return FinalVolumeofWater - InitialVolumeofWater; 
    } 
    
}


class MyException extends Exception 
{ 
    // default constructor 
    MyException() {    } 
  
    // parametrized constructor 
    MyException(String str) { super(str); } 
} 

public class AbstractClasses 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        try
        {
            Metals M1 = new Bars("Green","Emerald",10,5,5,7);
            Metals M2 = new Bars("Yellow","Quartz",5,3,3,3);
            Metals M3 = new Ores("Red","Ruby",3,10,15);
            Metals M4 = new Ores("Black","Coal",7,10,12);
            
            
            M1.IsAccepted();
            M2.IsAccepted();
            M3.IsAccepted();
            M4.IsAccepted();
            
            System.out.println("The color of"+ M1.getName() + "is:" + M1.getColor());
            System.out.println("The color of"+ M2.getName() + "is:" + M2.getColor()); 
            System.out.println("The color of"+ M3.getName() + "is:" + M3.getColor()); 
            System.out.println("The color of"+ M4.getName() + "is:" + M4.getColor());
            
            System.out.println("The quality of"+ M1.getName() + "is:" + M1.getQuality());
            System.out.println("The quality of"+ M2.getName() + "is:" + M2.getQuality()); 
            System.out.println("The quality of"+ M3.getName() + "is:" + M3.getQuality()); 
            System.out.println("The quality of"+ M4.getName() + "is:" + M4.getQuality()); 
            
            System.out.println("The volume of"+ M1.getName() + "is:" + M1.volume());
            System.out.println("The volume of"+ M2.getName() + "is:" + M2.volume()); 
            System.out.println("The volume of"+ M3.getName() + "is:" + M3.volume()); 
            System.out.println("The volume of"+ M4.getName() + "is:" + M4.volume());
            
            System.out.println("The Total Number of Accepted Minerals:"+ Metals.GetAccepted()); 
            System.out.println("The Total Number of Rejected Minerals:"+ Metals.GetRejected()); 
            
            Bars.Display dis = new Bars("Blue","Sapphire",9,15,6,7).new Display();
            dis.DisplayHeight();
            dis.DisplayLength();
            dis.DisplayWidth();
            
            
            if (M1.volume() < 0 || M2.volume() < 0 || M3.volume() < 0 || M4.volume() < 0) 
                { 
                    MyException me = new MyException("Volume is less than 0"); 
                    throw me; 
                } 
        } 
        
        catch(ArithmeticException e) 
        { 
            System.out.println ("Can't divide a number by 0"); 
        } 
        
        catch(NullPointerException e) 
        { 
            System.out.println("NullPointerException.."); 
        } 
        
        catch(MyException e) 
        { 
            e.printStackTrace(); 
        } 
    }
}

