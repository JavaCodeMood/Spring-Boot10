package com.spring;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

/**集成分页插件
 * * 1).@SpringBootApplication标注启动配置入口，run()方法会创建一个Spring应用上下文(Application
 * Context)。 * SpringBoot通过启动内嵌的Servlet容器（默认tomcat）用来处理Http请求。 *
 * 2).@RestController是特殊的Controller，他的返回值直接作为Http Response的Body部分返回给浏览器 *
 * 3).Spring WebMvc框架会将Servlet容器里收到的Http请求根据路径分发到对应的@Controller下进行处理。
 */
@SpringBootApplication
//@EnableAspectJAutoProxy
@EnableAutoConfiguration
@ComponentScan
// 指定扫描的mapper接口所在的包
@MapperScan("com.spring.mapper")
// 启动注解事务管理
@EnableTransactionManagement
public class SpringBoot12Application {
	private static final String TYPE_ALIASES_PACKAGE = "com.spring.model";
	private static final String MAPPER_LOCATION = "classpath:/mybatis/*.xml";

	@Bean 
	@Autowired 
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception { 
		final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); 
		sqlSessionFactoryBean.setDataSource(dataSource); 
		// 分页插件 
		PageHelper pageHelper = new PageHelper(); 
		Properties properties = new Properties(); 
		properties.setProperty("reasonable", "true"); 
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check"); 
		properties.setProperty("params", "count=countSql"); 
		pageHelper.setProperties(properties); 
		//添加插件 
		sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper}); 
		//mybatis.typeAliasesPackage：指定domain类的基包，即指定其在*Mapper.xml文件中可以使用简名来代替全类名（看后边的UserMapper.xml介绍） 
		sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE); 
		/* mybatis.mapperLocations：指定*Mapper.xml的位置 如果不加会报
		 * org.apache.ibatis.binding.BindingException: 
		 * Invalid bound statement (not found): 
		 * com.blog.mapper.MessageMapper.findMessageInfo异常 
		 * 因为找不到*Mapper.xml，也就无法映射mapper中的接口方法。 */ 
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION)); 
		return sqlSessionFactoryBean.getObject(); 
	 }
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot12Application.class, args);
	}
}
