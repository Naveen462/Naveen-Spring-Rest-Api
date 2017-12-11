package com.auth0.samples.kotlinspringboot.dao.util

/**
 * Created by SCI on 11/20/2017.
 */

import org.hibernate.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate4.HibernateTransactionManager
import org.springframework.orm.hibernate4.LocalSessionFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource

/**
 * @author Ranga_Reddy1
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = *arrayOf("classpath:application.properties"))
class HibernateConfiguration {


//    @Autowired
//    private val environment: Environment? = null

	init {
		println("HibernateConfiguration()")
//		println("driver class "+environment!!.getRequiredProperty("jdbc.driverClass"))
	}

	//    @Bean
//    fun dataSource(): DataSource {
//        val dataSource = DriverManagerDataSource()
//        dataSource.setDriverClassName(environment!!.getRequiredProperty("jdbc.driverClass"))
//        dataSource.url = environment!!.getRequiredProperty("jdbc.url")
//        dataSource.username = environment!!.getRequiredProperty("jdbc.username")
//        dataSource.password = environment!!.getRequiredProperty("jdbc.password")
//        return dataSource
//    }
	@Bean
	fun dataSource(): DataSource {
		val dataSource = DriverManagerDataSource()
		dataSource.setDriverClassName("com.mysql.jdbc.Driver")
		dataSource.url = "jdbc:mysql:///naveen"
		dataSource.username = "naveen"
		dataSource.password = "password@123"
		println("data source")
		return dataSource
	}

//    private fun hibernateProperties(): Properties {
//        val properties = Properties()
//        properties.put("hibernate.dialect", environment!!.getRequiredProperty("hibernate.dialect"))
//        properties.put("hibernate.show_sql", environment!!.getRequiredProperty("hibernate.show_sql"))
//        properties.put("hibernate.format_sql", environment!!.getRequiredProperty("hibernate.format_sql"))
//        properties.put("hibernate.hbm2ddl.auto", environment!!.getRequiredProperty("hibernate.hbm2ddl.auto"))
//        return properties
//    }

	private fun hibernateProperties(): Properties {
		val properties = Properties()
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
		properties.put("hibernate.show_sql", "true")
		properties.put("hibernate.format_sql", "true")
		properties.put("hibernate.hbm2ddl.auto", "create")
		println("hibernate properties")
		return properties
	}

	@Bean
	fun sessionFactory(): LocalSessionFactoryBean {
		val sessionFactory = LocalSessionFactoryBean()
		sessionFactory.setDataSource(dataSource())
		sessionFactory.setPackagesToScan(*arrayOf("com.auth0.samples.kotlinspringboot.entity"))
		sessionFactory.hibernateProperties = hibernateProperties()
		println("session factory")
		return sessionFactory
	}

	@Bean
	fun transactionManager(sessionFactory: SessionFactory): HibernateTransactionManager {
		val txManager = HibernateTransactionManager()
		txManager.sessionFactory = sessionFactory
		println("transaction manger")
		return txManager
	}
}

