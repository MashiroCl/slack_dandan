/**
 * @author mashirocl@gmail.com
 * @since 2022/01/05 17:52
 */
import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.bolt.socket_mode.SocketModeApp;
import com.slack.api.model.event.AppMentionEvent;


public class MyApp {
    public static void main(String[] args) throws Exception {
        String botToken = System.getenv("SLACK_BOT_TOKEN");
        App app = new App(AppConfig.builder().singleTeamBotToken(botToken).build());
        app.event(AppMentionEvent.class, (req, ctx) -> {
            ctx.say("とかげですよ〜〜〜〜");
            return ctx.ack();
        });
        String appToken = System.getenv("SLACK_APP_TOKEN");
        System.out.println(appToken);
        SocketModeApp socketModeApp = new SocketModeApp(appToken, app);
        socketModeApp.start();
    }
}
