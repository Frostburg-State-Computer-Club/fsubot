package app;

import components.listeners.corecommands.GeneralCommandHandler;
import components.listeners.weatherapi.WeatherAPI;
import config.TokenLoader;
import components.listeners.*;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = new TokenLoader().getToken();
        builder.setToken(token);
        builder.addEventListeners(
            new GeneralCommandHandler(),
            new RollHandler(),
            new SteveKHandler(),
            new SwallowHandler(),
            new PigLatinListener(),
            new PizzaHandler(),
            new MostHandler(),
            new WeatherHandler(),
            new WeatherAPI()
        );
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
