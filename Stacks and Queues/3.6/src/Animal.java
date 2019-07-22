/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Portatil
 */
public class Animal {
    
    private String type;
    
    private long timeArrival;

    public Animal(String type, long timeArrival) {
        this.type = type;
        this.timeArrival = timeArrival;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(long timeArrival) {
        this.timeArrival = timeArrival;
    }
    
    
    
}
