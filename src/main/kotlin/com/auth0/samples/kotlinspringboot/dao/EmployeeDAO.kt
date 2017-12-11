package com.auth0.samples.kotlinspringboot.dao

import com.auth0.samples.kotlinspringboot.entity.Employee

/**
 * Created by SCI on 11/19/2017.
 */
interface EmployeeDAO {
	fun createEmployee(employee: Employee): Employee
	fun updateEmployee(id: Long, employee: Employee): Employee
	fun deleteEmployeeById(id :Long):Boolean
	fun getEmployeeById(id: Long): Employee
	fun getAllEmployees(): List<Employee>
}
