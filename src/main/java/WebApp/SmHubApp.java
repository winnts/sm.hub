package WebApp;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by adyachenko on 29.08.16.
 */
public class SmHubApp extends Application <SmHubAppConfiguration> {
    public static void main(String[] args) throws Exception{
        new SmHubApp().run(args);
    }

    @Override
    public String getName() {
        return "SmHubApp";
    }

    @Override
    public void initialize (Bootstrap<SmHubAppConfiguration> bootstrap){
        bootstrap.addBundle(new AssetsBundle("/webapp", "/app"));
    }

    @Override
    public void run(SmHubAppConfiguration smHubAppConfiguration, Environment environment) {

        final SmHubAppFeeds resource = new SmHubAppFeeds(
                smHubAppConfiguration.getTemplate(),
                smHubAppConfiguration.getDefaultName()
        );
        environment.jersey().register(resource);

    }
}
