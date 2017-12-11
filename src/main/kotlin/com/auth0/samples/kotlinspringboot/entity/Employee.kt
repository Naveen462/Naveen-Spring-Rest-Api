package com.auth0.samples.kotlinspringboot.entity

import java.io.Serializable
import javax.persistence.*

/**
 * Created by SCI on 11/19/2017.
 */

//object
@Entity
@Table(name = "employee",  schema = "naveen")
data class Employee(
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		var id: Long = 0,
		@Column(name = "first_name")
		var firstName: String = "",
		@Column()
		var lastName: String = ""
):Serializable
