//package com.auth0.samples.kotlinspringboot
//
//import com.auth0.samples.kotlinspringboot.model.EmployeeDTO
//import com.auth0.samples.kotlinspringboot.persistence.CustomerRepository
//import org.springframework.web.bind.annotation.*
//
///**
// * Created by SCI on 11/17/2017.
// */
//
//@RestController
//@RequestMapping("/customers")
//class CustomerController(){
//	val repository : CustomerRepository?= null
//
//	@GetMapping
//	fun findAll() = repository.readAll(1)
//
//	@PostMapping
//	fun addCustomer(@RequestBody employeeDTO: EmployeeDTO) = repository.write(employeeDTO)
//
//	@PutMapping("/{id}")
//	fun updateCustomer(@PathVariable id: Long, @RequestBody employeeDTO: EmployeeDTO)
//	{
//		assert(employeeDTO.id.equals(id))
//		repository.write(employeeDTO)
//	}
//
//	@DeleteMapping("/{id}")
//	fun removeCustomer(@PathVariable id :Long) = repository.delete(id)
//
//	@GetMapping("/{id}")
//	fun getById(@PathVariable id: Long)
//			= repository.search(id)
//
//}
