package mongodb.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories(basePackages = "repository.order")
public class DerivedMongoConfig extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "db";
    }

    @Autowired
    private Environment env;
    @Override
    public Mongo mongo() throws Exception {
        MongoCredential credential = MongoCredential.createCredential(
                env.getProperty("mongo.username"),
                "db",
                env.getProperty("mongo.password").toCharArray());
        return new MongoClient(
                new ServerAddress("localhost",37017),
                Arrays.asList(credential));
//        return new MongoClient();
    }
}
