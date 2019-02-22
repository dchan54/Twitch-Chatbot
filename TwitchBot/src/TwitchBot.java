import org.jibble.pircbot.*;
public class TwitchBot extends PircBot // Object extending the PircBot library
{
    long timeStart = 0;
    long timeNow = 0;
    public TwitchBot()
    {
        this.setName("DLSBot");
        this.isConnected();      
    }
    
    @Override
    protected void onJoin(String channel, String sender, String login, String hostname) // Does this when it joins the channel
    {
        sendMessage(channel, "Hello Friends!");
        timeStart = System.currentTimeMillis(); // Records the time in milliseconds when bot joins
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) 
    // If anyone types these messages, the following will be printed.
    {
        if(message.equalsIgnoreCase("!rules"))
        {
            sendMessage(channel, "1. No hate speech");
            sendMessage(channel, "2. No harassing or threatening others");
            sendMessage(channel, "3. No links or advertisements");
            sendMessage(channel, "4. Do not post anyone's private information");
        }
        else if(message.equalsIgnoreCase("!steamgroup"))
        {
            sendMessage(channel, Config.steamGroup); // Links URL in config
        }
        else if(message.equalsIgnoreCase("!botinfo"))
        {
            sendMessage(channel, "This bot was made by myself using the Pircbot Java IRC Bot");
        }
        
        else if(message.equalsIgnoreCase("!sensitivity"))
        {
            sendMessage(channel, "1000 DPI and 1.6 Sensitivity.");
        }
        
        else if(message.equalsIgnoreCase("!resolution"))
        {
            sendMessage(channel, "1920x1080, 16:9, Lowest settings");
        }
        
        else if(message.equalsIgnoreCase("!viewmodel"))
        {
            sendMessage(channel, Config.csConfig); // Links URL in Config
        }
        else if(message.equalsIgnoreCase("!crosshair"))
        {
            sendMessage(channel, Config.csConfig);
        }
        else if(message.equalsIgnoreCase("!config"))
        {
            sendMessage(channel, Config.csConfig);
        }
        
        else if(message.equalsIgnoreCase("!game"))
        {
            sendMessage(channel, "The current game is " + Config.currentGame);
        }
        
        else if(message.equalsIgnoreCase("!schedule"))
        {
            sendMessage(channel, "Currently I don't have a proper schedule. I usually stream late at night though");
        }
        
        else if(message.equalsIgnoreCase("!about"))
        {
            sendMessage(channel, "Just some college student playing games");
        }
        
        else if(message.equalsIgnoreCase("!donate"))
        {
            sendMessage(channel, "I currently don't have a donation set-up yet, but feel free to drop a follow!");
        }
        
        else if(message.equalsIgnoreCase("!keyboard"))
        {
            sendMessage(channel, "Das Keyboard Model S Ultimate");
        }
        
        else if(message.equalsIgnoreCase("!uptime"))
        {
            timeNow = System.currentTimeMillis(); // Records the time in milliseconds when command is given
            printUpTime(timeStart, timeNow, channel); // Calls printUpTime
        }
    }
    public void printUpTime(long streamStart, long streamNow, String channel) // Method that prints how long the bot has been running
    {
        long upTime = timeNow - timeStart; // Difference between the time
        int hours = (int) ((upTime / (1000 * 60 * 60)) % 24); // Converting milliseconds to hours, minutes and seconds.
        int minutes = (int) ((upTime / (1000 * 60)) % 60);
        int seconds = (int) (upTime / 1000) % 60;
        
        sendMessage(channel, hours + " hour(s), " + minutes + " minute(s), and " + seconds + " second(s)");
    }

}
