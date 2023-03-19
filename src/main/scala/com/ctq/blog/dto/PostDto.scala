package com.ctq.blog.dto

import jakarta.persistence.*
import jakarta.validation.constraints.{NotEmpty, Size}

import java.time.LocalDateTime
import scala.beans.BeanProperty

class PostDto {

  var id: Long = _

  @NotEmpty(message = "title is required")
  @Size(min = 10)
  var title: String = _

  @NotEmpty(message = "description is required")
  @Size(min = 10)
  var description: String = _

  @NotEmpty(message = "content is required")
  @Size(min = 50)
  var content: String = _

  var author: AuthorDto = _

}
