package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/default.properties",
        "classpath:config/${env}.properties"
})
public interface AppConfig extends Config {

    @Key("base_url")
    @DefaultValue("https://www.demoblaze.com")
    String baseUrl();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

}
