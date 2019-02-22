/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Derrick
 */
public class Config 
{
    public static String currentGame = "Counter-Strike: Global Offensive";
    
    public static String csConfig = "https://pastebin.com/iJqtFYMM"; // Links to use in twitch messages
    
    public static String steamGroup = "http://steamcommunity.com/groups/dlsslynx";
    
    public static void main(String[] args) throws Exception // Define the bot here
    {
        String channel = "#dlsslynx"; // Name of channel to join
        
        TwitchBot bot = new TwitchBot(); // Creating a new bot
        bot.setVerbose(true); // Shows debugging output
        // Server name, port and authentication password
        bot.connect("irc.chat.twitch.tv", 6667, "oauth:do1ey5ithqd60nbtz42npavf27gql8"); // Connects it to the IRC server
        bot.joinChannel(channel); // Joins the channel
        bot.getName(); // Gets the nickname of the bot from twitch.tv
    }
    
}

