package com.ctq.blog.repository

import com.ctq.blog.entity.Author
import org.springframework.data.repository.PagingAndSortingRepository

trait AuthorRepository extends PagingAndSortingRepository[Author, Int] {

  def findByUsername(username: String): Option[Author]

  def findByEmail(email: String): Option[Author]
}
