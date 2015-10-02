package com.piragua.hibernate.stat

import groovy.util.logging.Slf4j

@Slf4j
class HibernateStatsController {

	def sessionFactory

	static defaultAction = 'stats'

	def turnOff() {
		sessionFactory.statistics.statisticsEnabled = false
		redirect action: 'stats'
	}

	def turnOn() {
		sessionFactory.statistics.statisticsEnabled = true
		flash.message = 'Hibernate statistics have been enabled'
		redirect action: 'stats'
	}

	def clear() {
		sessionFactory.statistics.clear()
		flash.message = 'Hibernate statistics have been cleared'
		redirect action: 'stats'
	}

	def stats() {
		log.info '{}', sessionFactory.statistics
		[statistics: sessionFactory.statistics]
	}
}
