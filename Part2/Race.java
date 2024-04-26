import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.lang.Math;




/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McFarewell
 * @version 1.0
 */
public class Race
{
    private int raceLength;
    private ArrayList<Horse> horses;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance, ArrayList<Horse> horses)
    {
        // initialise instance variables
        raceLength = distance;
        this.horses = horses;
        
    }
    
    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRaceGUI()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        
        //reset all the lanes (all horses not fallen and back to 0). 
        for (Horse h : horses)
        {
            if (h!=null) {
                h.goBackToStart();

            }
        }
                      
        while (!finished)
        {

            //move each horse
            if(!(horses.isEmpty())){

                for(Horse h : horses)
                {
                    moveHorse(h);
                }
            }




            //print the race positions
            printRace();
            
            //if all horses have fallen or one has won
            for (Horse h : horses)
            {
                if(h!=null){
                    if (raceWonBy(h))
                    {
                        //System.out.println("And the winner is " + h.getName());
                        finished = true;
                        break;
                    }

                }
            }

            boolean allFallen = true;
            for(Horse h : horses)
            {
                if(h!=null && !h.hasFallen() && !raceWonBy(h)){
                        allFallen = false;
                        break;
    
                }
            
            }
            finished = allFallen;
        
            //if ( raceWonBy(lane1Horse) || raceWonBy(lane2Horse) || raceWonBy(lane3Horse) )
            //{
                //finished = true;
            //}
           
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}

            //if(!finished && lane1Horse.hasFallen() && lane2Horse.hasFallen() && lane3Horse.hasFallen()){
                //if(lane1Horse.hasFallen() && lane2Horse.hasFallen() && lane3Horse.hasFallen()){
                    //System.out.println("No winner");
                    //finished = true;
                    
  
                //}
            //}

            //print the winner
    
            for(Horse h : horses)
            {
                if(raceWonBy(h))
                {
                    System.out.println("And the winner is " + h.getName());
                    System.exit(0);
                    

                }
                else if(allFallen){
                    System.out.println("No winner");
                    System.exit(0);
                }
            }

            // if(raceWonBy(lane1Horse))
            // {
            //     System.out.println("And the winner is " + lane1Horse.getName());
            // }
            // else if(raceWonBy(lane2Horse))
            // {
            //     System.out.println("And the winner is " + lane2Horse.getName());
            // }
            // else if(raceWonBy(lane3Horse))
            // {
            //     System.out.println("And the winner is " + lane3Horse.getName());
            // }
        }


        





    }
    
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }
            
            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence 
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1*theHorse.getConfidence()*theHorse.getConfidence()))
            {
                theHorse.fall();
            }
        }
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse)
    {

        if (theHorse.getDistanceTravelled() == raceLength)
        {
            return true;

        }
        else
        {
            return false;
        }
    }
    
    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print("\033c");  //clear the terminal window
        
        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();

        //print each lane

        for(Horse h : horses)
        {
            printLane(h);
        }
        
        
        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();    
    }
    //Make method wiht for loop to add values in arraylist into printLane method

    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        //print a | for the beginning of the lane
        System.out.print('|');
        
        //print the spaces before the horse
        multiplePrint(' ',spacesBefore);
        
        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen())
        {
            System.out.print('\u0078');
        }
        else if(raceWonBy(theHorse)){
            System.out.print(theHorse.getSymbol());
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }
        
        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);
        
        //print the | for the end of the track
        System.out.print('|');
            if(raceWonBy(theHorse)){
                System.out.print(theHorse.getName() + " (Current confidence" + theHorse.getConfidence()+")" );

                
            }
            if(theHorse.hasFallen()){
                System.out.print(theHorse.getName() + " (Current confidence" + theHorse.getConfidence()+")" );
            }
            System.out.println();
 


            
  

        
    }
        
    
    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
