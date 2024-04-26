
/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse
{
    //Fields of class Horse
    private char horseSymbol;
    private String horseName;
    private double horseConfidence;
    private int horseDistance;
    private boolean horseFallen;
    
    
      
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.horseConfidence = horseConfidence;
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        horseFallen = true;
        
    }
    
    public double getConfidence()
    {
        return horseConfidence;
    }
    
    public int getDistanceTravelled()
    {
        return horseDistance;   
    }
    
    public String getName()
    {
        return horseName;
    }
    
    public char getSymbol()
    {
        return horseSymbol;
        
    }
    
    public void goBackToStart()
    {
        horseDistance = 0;
        
    }
    
    public boolean hasFallen()
    {
        if(horseFallen == true){
            return true;
        }
        else{
            return false;
        }
        
    }

    public void moveForward()
    {
        horseDistance = horseDistance + 1;
    }

    public void setConfidence(double newConfidence)
    {
        horseConfidence = newConfidence;
        
    }
    
    public void setSymbol(char newSymbol)
    {
        horseSymbol = newSymbol;
        
    }
    
}
