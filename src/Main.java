import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.InterfacedEventManager;
import net.dv8tion.jda.api.requests.GatewayIntent;

//Version 2.0
//Date: 26.11.2021

public class Main {
    public static JDA jda;
    //public static String prefix = "!"; //No longer used
    public static Boolean bRunner = true;
    //public static LocalTime t; //No longer used

    private static Boolean botOffSaid = false;

    public static void main(String[] args) throws InterruptedException {
        try {
            String token = new GetMyToken().GetMyTokenBack();
            JDABuilder b = JDABuilder.createDefault(token);
            b.enableIntents(GatewayIntent.GUILD_MEMBERS);
            jda = b.build();
            jda.setEventManager(new InterfacedEventManager());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Probably no Bot available!");
        }
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.listening("HBz"));
        // jda.getGuildChannelById("HBz Mod-Team Discord");
        jda.addEventListener(new Commands());

        TimerTask timerTask = new TimerTask() {
            public void run() {
                System.out.println("Timer");
                Guild server = jda.getGuildById(911597065505738772L);
                List<GuildChannel> l = server.getChannels();
                server.loadMembers();
                List<Member> m = server.getMembers();
                System.out.println(m.size());
                System.out.println(server.getName());
                System.out.println(server.getMemberCount());

                //New
                try {
                    Member musicbot = server.getMemberById(676156711958216725L);
                    musicbot.getVoiceState();
                    botOffSaid = false;
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println("None detected!");
                    if (!botOffSaid){
                        jda.getGuildById(911597065505738772L).getTextChannelById(911769123065831467L).sendMessage("Der Musikbot ist offline! <@&911597830924292116>").queue();
                        botOffSaid = true;
                    }
                    //jda.getGuildById(911597065505738772L).getTextChannelById(911769123065831467L).sendMessage("&stream 912090816883859489 ilovebass").queue();
                }
                //New

                //System.out.println(jda.getGuildById(911597065505738772L).getMemberById(682980754447400970L).getNickname());
                //System.out.println(jda.getGuildById(911597065505738772L).getMemberCount());
                jda.getGuildById(911597065505738772L).getVoiceChannelById(911756528913113100L).getManager().setName("Member Count: " + jda.getGuildById(911597065505738772L).getMemberCount()).queue();
            }
        };
        Timer timer = new Timer();
        //600000
        timer.schedule(timerTask,3000, (long) (600000));
        while (bRunner){

        }
        System.out.println("Bot stopped");
        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        System.exit(1);

        //TimeUnit.SECONDS.sleep(5);
        /*while (brunner) {
            t = LocalTime.now();
            System.out.println("Starting work! - " + t);
            System.out.println(jda.getGuildById(911597065505738772L).getMemberCount());
            jda.getGuildById(911597065505738772L).getVoiceChannelById(911756528913113100L).getManager().setName("Member Count: " + jda.getGuildById(911597065505738772L).getMemberCount()).queue();
            System.out.println("Done for now! - " + t);
            TimeUnit.MINUTES.sleep(10);
            // jda.getGuildById(907049183142350909L).getTextChannelById(913851816834392135L).getManager().setName("Test:
            // ").queue();
        }
        System.out.println("Bot stopped");
        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        return;

         */
    }
}
