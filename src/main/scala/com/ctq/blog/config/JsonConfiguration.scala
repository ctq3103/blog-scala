package com.ctq.blog.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class JsonConfiguration {

  @Bean
  def myJsonMapper: ObjectMapper = {
    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper
  }
}
