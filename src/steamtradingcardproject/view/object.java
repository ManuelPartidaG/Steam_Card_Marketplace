/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;

/**
 *
 * @author Matthew
 */
public class object
{
    String name;
    String id;
    
    public object(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getID() {
        return id;
    }
    public String toString() {
        return name;
    }
}
