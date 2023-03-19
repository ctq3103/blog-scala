package com.ctq.blog.repository

import com.ctq.blog.entity.Post
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository


@Repository
trait PostRepository extends PagingAndSortingRepository[Post, java.lang.Long] {

  //def findAll(pageable: Pageable): Page[Post]

  def findById(id: Long): Post

  def save(post: Post): Post

  def delete(post: Post): Post

  @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', ?1, '%'))")
  def findAll(keyword: String, pageable: Pageable): Page[Post]

  @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', ?1, '%'))")
  def findAll(keyword: String): Post

  @Query("SELECT p FROM Post p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', ?1, '%')) " + "OR LOWER(p.description) LIKE LOWER(CONCAT('%', ?1, '%')) " + "OR LOWER(p.author) LIKE LOWER(CONCAT('%', ?1, '%'))")
  def searchByKeyword(keyword: String): Option[Post]

  def findByTitleContainingIgnoreCase(title: String): List[Post]

  @Query("SELECT p FROM Post p WHERE p.author.username = ?1 OR p.author.email = ?1")
  def findByAuthor(author: String): Post

}
