package FinalProject_2023;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {
    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    private static String token;
    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resourses.properties");
        prop.load(configFile);

        apiKey =  prop.getProperty("apiKey");
        baseUrl= prop.getProperty("base_url");
        token=prop.getProperty("token");
    }

    public static String getApiKey() {

        return apiKey;
    }

    public static String getBaseUrl() {

        return baseUrl;
    }
    public static String getToken() {

        return token;
    }

}
