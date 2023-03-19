package com.ctq.blog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BlogApplication {}

object BlogApplication {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[BlogApplication], args: _*)
  }
}
