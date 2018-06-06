/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.model;

/**
 *
 * @author aermakov
 */
public class Game {
    public String name;
    public int appid;
    public Game(String name, int appid)
    {
        this.name = name;
        this.appid = appid;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
