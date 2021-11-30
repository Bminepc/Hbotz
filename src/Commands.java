import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

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
}
