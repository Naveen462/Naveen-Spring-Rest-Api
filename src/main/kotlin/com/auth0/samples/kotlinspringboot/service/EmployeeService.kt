package com.auth0.samples.kotlinspringboot.service

import com.auth0.samples.kotlinspringboot.model.EmployeeDTO

/**
 * Created by SCI on 11/19/2017.
 */
interface EmployeeService {

	fun createEmployee(employeeDTO: EmployeeDTO): EmployeeDTO
	fun updateEmployee(id: Long, employeeDTO: EmployeeDTO): EmployeeDTO
	fun deleteEmployeeById(id :Long):Boolean
	fun getEmployeeById(id: Long): EmployeeDTO
	fun getAllEmployees(): List<EmployeeDTO>


}
