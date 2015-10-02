package grails.plugin.hibernatestats

import org.hibernate.SessionFactory
import org.hibernate.stat.Statistics
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.InitializingBean

/**
 * Based on example from https://hibernate.atlassian.net/browse/HHH-6190
 *
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class HibernateStatisticsFactoryBean implements FactoryBean<Statistics>, InitializingBean {

	SessionFactory sessionFactory

	final Class<Statistics> objectType = Statistics

	final boolean singleton = true

	Statistics getObject() { sessionFactory.statistics }

	void afterPropertiesSet() {
		sessionFactory.statistics.statisticsEnabled = false
	}
}
