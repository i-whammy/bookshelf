package com.iwhammy

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.iwhammy")
		.start()
}

