package com.viewnext.springsecurityssoui.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@EnableOAuth2Sso
@Configuration
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
   	 http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/callback/", "/webjars/**", "/error**")
   			 .permitAll().anyRequest().authenticated();
    }
    
    @Bean
    public TokenStore tokenStore() {
   	 return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
   	 JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
   	 converter.setSigningKey("123");
   	 return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
   	 DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
   	 defaultTokenServices.setTokenStore(tokenStore());
   	 return defaultTokenServices;
    }
    
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
        	OAuth2ProtectedResourceDetails details) {
    	return new OAuth2RestTemplate(details, oauth2ClientContext);
    }


}

