package com.auth0.samples.kotlinspringboot.service.impl

import com.auth0.samples.kotlinspringboot.dao.EmployeeDAO
import com.auth0.samples.kotlinspringboot.entity.Employee
import com.auth0.samples.kotlinspringboot.model.EmployeeDTO
import com.auth0.samples.kotlinspringboot.service.EmployeeService
import org.springframework.stereotype.Service


/**
 * Created by SCI on 11/19/2017.
 */
@Service
@org.springframework.transaction.annotation.Transactional
class EmployeeServiceImpl(val employeeDAO: EmployeeDAO): EmployeeService {
	fun convertToEntity(employeeDTO: EmployeeDTO):Employee{
	return Employee(employeeDTO.id,employeeDTO.firstName,employeeDTO.lastName)
			}

	fun convertToDTO(employee: Employee):EmployeeDTO{
		return EmployeeDTO(employee.id,employee.firstName,employee.lastName)
	}
	override fun createEmployee(employeeDTO: EmployeeDTO): EmployeeDTO {
		var employee = employeeDAO.createEmployee(convertToEntity(employeeDTO))
		return convertToDTO(employee)
	}

	override fun updateEmployee(id: Long, employeeDTO: EmployeeDTO): EmployeeDTO {
		val updatedEmployee = employeeDAO.updateEmployee(id, convertToEntity(employeeDTO))
		return convertToDTO(updatedEmployee)
	}

	override fun deleteEmployeeById(id: Long): Boolean {
		return employeeDAO.deleteEmployeeById(id)
			}

	override fun getEmployeeById(id: Long): EmployeeDTO {

		val getEmployee = 	employeeDAO.getEmployeeById(id)
		return convertToDTO(getEmployee)
	}

	override fun getAllEmployees(): List<EmployeeDTO> {
		val employees = employeeDAO.getAllEmployees()
		val employeeDTOs =ArrayList<EmployeeDTO>()
		for (i in employees.indices) {
			employeeDTOs.add(convertToDTO(employees[i]))
		}
      return employeeDTOs
	}
}
