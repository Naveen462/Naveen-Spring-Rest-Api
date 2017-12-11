package com.auth0.samples.kotlinspringboot.persistence

import com.auth0.samples.kotlinspringboot.model.EmployeeDTO
import com.marklogic.client.pojo.PojoRepository

/**
 * Created by SCI on 11/17/2017.
 */

interface CustomerRepository: PojoRepository<EmployeeDTO, Long>
