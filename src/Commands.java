import groovy.console.ui.Console;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberUpdateEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Commands extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        super.onReady(event);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("Message Recieved!");
        String args = event.getMessage().getContentRaw();
        if (args.equals("!infohbotz") && 911769123065831467L == Long.parseLong(event.getChannel().getId())) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Hey there. Botbut").queue();
            // message.guild.channels.find("name", "general").setName("Testing");
            System.out.println(event.getMember());
            System.out.println(event.getChannel().getId());
            //System.out.println(event.getGuild().getTextChannelById("913688104416722964").getName());
            //System.out.println(event.getGuild().getTextChannelById("913688104416722964").getManager().getChannel());
            System.out.println(event.getGuild().getMemberCache().size());
            System.out.println(event.getGuild().getMemberCount());
            System.out.println(event.getGuild().getId());

            //event.getGuild().getTextChannelById("913688104416722964").getManager().setName("Test").queue();

            //913688104416722964L
            //event.getGuild().getTextChannelById(event.getChannel().getId()).getManager().setName("Nutzer_im_DC: " + event.getGuild().getMemberCount()).queue();

        }else if(args.equals("stophbotz") && 911769123065831467L == Long.parseLong(event.getChannel().getId())) { //Chanel auf dem Main 911769123065831467 Chanel auf dem Test 907049183586955277
            Main.brunner = false;
            System.out.println("Stoping Bot in next Cycle!");
        }
        System.out.println("-------------------");
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        //super.onGuildMemberRemove(event);
        System.out.println("Leave");
        event.getGuild().getVoiceChannelById(911756528913113100L).getManager().setName("Member Count: " + event.getGuild().getMemberCount()).queue();
    }

    @Override
    public void onGuildMemberUpdate(@NotNull GuildMemberUpdateEvent event) {
        super.onGuildMemberUpdate(event);
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
        System.out.println("Join");
        event.getGuild().getVoiceChannelById(911756528913113100L).getManager().setName("Member Count: " + event.getGuild().getMemberCount()).queue();
    }
}
