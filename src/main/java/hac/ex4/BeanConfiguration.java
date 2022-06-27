package hac.ex4;

import hac.ex4.beans.Cart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * create some beans witn various scopes using QUALIFIERS (method names)
 */
@Configuration
public class BeanConfiguration {
    /**
     *
     * @return new Cart
     */
    @Bean(name="namedFile")
    public Cart namedFile() {
        return new Cart();
    }

    /**
     * session Scope Bean
     * @return Cart
     */
    @Bean
    @SessionScope
    public Cart sessionScopeBean () {
        return new Cart();
    }
}
