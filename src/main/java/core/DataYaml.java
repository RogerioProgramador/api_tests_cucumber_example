package core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Log4j2
public class DataYaml{

    private static File getYamlDataFile(String fileName){
        log.info(String.format("Recuperando o caminho do arquivo %s.yml da massa de dados do ambiente %s"
                ,fileName,System.getProperty("env")));
        return new File("./src/test/resources/data/" + System.getProperty("env") + "/"+fileName+".yml");
    }

    @SneakyThrows
    public static LinkedHashMap<String,String> getMapYamlValues(String fileName, String titulo){

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        Map<String , Object> maps;
        try {
            maps = (LinkedHashMap<String, Object>) mapper.readValue(getYamlDataFile(fileName), Map.class);
            log.info(String.format("Retornando objeto HashMap com a massa de dados do arquivo %s.yml com titulo %s",fileName,titulo));
            return  (LinkedHashMap<String, String>) maps.get(titulo);
        } catch (IOException e) {
            log.error(String.format("Erro ao tentar ler o arquivo de massa %s.yaml - stackTrace: %s",fileName,e));
            return new LinkedHashMap<String, String>();
        }
    }

}
