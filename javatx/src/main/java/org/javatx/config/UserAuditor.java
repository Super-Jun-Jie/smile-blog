package org.javatx.config;

import org.javatx.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Configuration
public class UserAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        User user = new User();
        if (StringUtils.isEmpty(user)){
            return Optional.ofNullable("系统");
        }else {
            return Optional.ofNullable(user.getUsername());
        }
    }
}