package grails.plugin.hibernatestats

import grails.plugins.Plugin

class HibernateStatsGrailsPlugin extends Plugin {

	def grailsVersion = '3.0.0 > *'
	def author = 'Mike Hugo'
	def authorEmail = 'mike@piragua.com'
	def title = 'Enables Hibernate Statistics capture and exposes an MBean'
	def description = 'Enables capturing of Hibernate Statistics and provides a Controller and View to view stats'
	def documentation = 'https://grails.org/plugin/hibernate-stats'
	def license = 'APACHE'
	def issueManagement = [url: 'https://github.com/mjhugo/hibernatestats/issues']
	def scm = [url: 'https://github.com/mjhugo/hibernatestats']
	def loadAfter = ['hibernate', 'hibernate4']
	def profiles = ['web']

	Closure doWithSpring() {{ ->
		hibernateStats(HibernateStatisticsFactoryBean) {
			sessionFactory = ref('sessionFactory')
		}
	}}
}
