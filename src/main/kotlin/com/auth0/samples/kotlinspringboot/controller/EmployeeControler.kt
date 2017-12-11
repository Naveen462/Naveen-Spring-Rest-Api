package com.auth0.samples.kotlinspringboot.controller

import com.auth0.samples.kotlinspringboot.model.EmployeeDTO
import com.auth0.samples.kotlinspringboot.service.EmployeeService
import org.springframework.web.bind.annotation.*

/**
 * Created by SCI on 11/19/2017.
 */

@RestController
@RequestMapping("/employees")
class EmployeeControler(val employeeService:EmployeeService) {



	@PostMapping("/createEmployee")
	fun createEmployee(@RequestBody employeeDTO: EmployeeDTO)
	{
		employeeService.createEmployee(employeeDTO)
	}


	@PutMapping("/updateEmployee/{id}")
	fun updateEmployee(@PathVariable id: Long, @RequestBody employeeDTO: EmployeeDTO)
	{
		assert(employeeDTO.id.equals(id))
		employeeService.updateEmployee(id, employeeDTO)
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	fun deleteEmployeeById(@PathVariable id :Long) = employeeService.deleteEmployeeById(id)

	@GetMapping("/getEmployeeById/{id}")
	fun getEmployeeById(@PathVariable id: Long)
			= employeeService.getEmployeeById(id)

	@GetMapping("/getAllEmployees")
	fun getAllEmployees():List<EmployeeDTO>{
	 return employeeService.getAllEmployees()
	}






}
