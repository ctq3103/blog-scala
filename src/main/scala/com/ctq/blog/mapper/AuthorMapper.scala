package com.ctq.blog.mapper

import com.ctq.blog.dto.{AuthorDto, PostDto}
import com.ctq.blog.entity.{Author, Post}
import com.ctq.blog.mapper.AuthorMapper

import java.util.stream.Collectors

class AuthorMapper 

object AuthorMapper {
  
  def toDto(entity: Author): AuthorDto =
    val author = new AuthorDto
    author.username = entity.username
    author.password = entity.password
    author.email = entity.email
    author.firstName = entity.firstName
    author.lastName = entity.lastName
    author
  
  def toEntity(authorDto: AuthorDto): Author =
    val entity = new Author
    entity.username = authorDto.username
    entity.password = authorDto.password
    entity.email = authorDto.email
    entity.firstName = authorDto.firstName
    entity.lastName = authorDto.lastName
    entity

  def toDtoList(entities: List[Author]): List[AuthorDto] =
    entities.map(toDto(_))
    
 
}
