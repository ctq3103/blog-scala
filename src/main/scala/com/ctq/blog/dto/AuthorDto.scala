package com.ctq.blog.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.{Column, Id}
import jakarta.validation.constraints.{Email, NotNull, Size}

import java.time.{LocalDate, LocalDateTime}
import scala.beans.BeanProperty

class AuthorDto {

  @NotNull
  @Size(min = 2, max = 255)
  @BeanProperty
  var username: String = _

  @NotNull
  @Size(min = 8, max = 255)
  @BeanProperty
  @JsonIgnore
  var password: String = _

  @NotNull
  @Size(min = 2, max = 255)
  @BeanProperty
  var firstName: String = _

  @NotNull
  @Size(min = 2, max = 255)
  @BeanProperty
  var lastName: String = _

  @NotNull
  @Email
  @BeanProperty
  var email: String = _

}
