package com.auth0.samples.kotlinspringboot.dao.impl

import com.auth0.samples.kotlinspringboot.dao.EmployeeDAO
import com.auth0.samples.kotlinspringboot.dao.util.HibernateUtil
import com.auth0.samples.kotlinspringboot.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by SCI on 11/19/2017.
 */
@Repository
class EmployeeDAOImpl : EmployeeDAO {

	@Autowired
	private val hibernateUtil: HibernateUtil? = null

	override fun createEmployee(employee: Employee): Employee {
		val employeeId: Long = hibernateUtil!!.create(employee) as Long
		return getEmployeeById(employeeId)
	}

	override fun updateEmployee(id: Long, employee: Employee): Employee {
		hibernateUtil!!.update(employee)
		return employee
	}

	override fun deleteEmployeeById(id: Long): Boolean {
		hibernateUtil!!.delete(id, Employee::class.java)
		return true
	}

	override fun getEmployeeById(id: Long): Employee {
		return hibernateUtil!!.fetchById(id, Employee::class.java)

	}

	override fun getAllEmployees(): List<Employee> {
		return hibernateUtil!!.fetchAll(Employee::class.java)
	}
}
