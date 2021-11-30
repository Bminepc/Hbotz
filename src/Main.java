import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

//Version 1.0
//Date: 26.11.2021

public class Main {
    public static JDA jda;
    public static String prefix = "!";
    public static Boolean brunner = true;
    public static LocalTime t;

    public static void main(String[] args) throws InterruptedException {
        try {
            jda = JDABuilder.createDefault("OTEzODU4MjAyODg4NzI0NTUx.YaEmxg.5LnjK5UxSoqBlgnmT188xZqV-9U").build();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Probably no Bot available!");
        }
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.listening("HBz"));
        // jda.getGuildChannelById("HBz Mod-Team Discord");
        jda.addEventListener(new Commands());

        TimeUnit.SECONDS.sleep(5);
        while (brunner == true) {
            t = LocalTime.now();
            System.out.println("Starting work! - " + t);
            System.out.println(jda.getGuildById(911597065505738772L).getMemberCount());
            jda.getGuildById(911597065505738772L).getVoiceChannelById(911756528913113100L).getManager().setName("Member Count: " + jda.getGuildById(911597065505738772L).getMemberCount()).queue();
            System.out.println("Done for now! - " + t);
            TimeUnit.MINUTES.sleep(10);
            // jda.getGuildById(907049183142350909L).getTextChannelById(913851816834392135L).getManager().setName("Test:
            // ").queue();
        }
        System.out.println("Bot stoped");
        jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        return;
    }
}
