package com.ctq.blog.entity

import jakarta.persistence.{Column, Entity, Id, Table}
import jakarta.validation.constraints.{Email, NotNull, Size}

import java.time.{LocalDate, LocalDateTime}
import scala.beans.BeanProperty

@Entity
@Table(name = "authors")
class Author {

  @Id
  @Column(name = "username")
  @BeanProperty
  var username: String = _

  @Column(name = "password")
  @BeanProperty
  var password: String = _

  @Column(name = "first_name")
  @BeanProperty
  var firstName: String = _

  @Column(name = "last_name")
  @BeanProperty
  var lastName: String = _

  @Column(name = "email")
  @BeanProperty
  var email: String = _
}
