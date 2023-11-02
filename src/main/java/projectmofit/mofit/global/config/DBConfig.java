package projectmofit.mofit.global.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"projectmofit.mofit.domain.user.dao"})
public class DBConfig {
}