package tr.com.rest.example.restuserservice.config;

import java.io.IOException;
import java.util.Properties;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated() // Diğer tüm istekler için kimlik doğrulama
            .and()
            .httpBasic(); // HTTP Basic Authentication kullan
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        Properties users;
        try {
            // Production ortamında kullanici bilgilerinin 'users.properties' ile belirtilmesi gerekecek
            String configFiles = System.getProperty("spring.config.location");
            if (configFiles != null) { // Konfigürasyon dosyası verilmişse
                String usersFile = Stream.of(configFiles.split("[,]"))
                        .filter(f -> f.contains("users.properties")).findFirst().get();
                FileSystemResource resource = new FileSystemResource(usersFile);
                users = PropertiesLoaderUtils.loadProperties(resource);
            } else {
                // Test ortamında manuel kullanıcı ekleniyor
                users = new Properties();
                users.put("test", "{noop}test,ROLE_USER,enabled"); // test kullanıcısı, noop ile şifresiz
            }
            return new InMemoryUserDetailsManager(users); // InMemoryUserDetailsManager kullanarak kullanıcıyı ekle
        } catch (IOException e) {
            return null; // Hata oluşursa null döndür
        }
    }

}
