package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:conf/${env}.properties"})
public interface Configuration extends Config {

    @Key("url.base")
    String urlBase();

}
