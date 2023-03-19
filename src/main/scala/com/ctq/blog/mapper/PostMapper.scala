package com.ctq.blog.mapper

import com.ctq.blog.dto.PostDto
import com.ctq.blog.entity.Post
import com.ctq.blog.mapper.AuthorMapper

class PostMapper

object PostMapper {

  def toDto(entity: Post): PostDto =
    val post = new PostDto
    post.id = entity.id
    post.title = entity.title
    post.content = entity.content
    post.description = entity.description
    post.author = AuthorMapper.toDto(entity.author)
    post

  def toEntity(postDto: PostDto): Post =
    val entity = new Post
    entity.id = postDto.id
    entity.content = postDto.content
    entity.description = postDto.description
    entity.title = postDto.title
    entity.author = AuthorMapper.toEntity(postDto.author)
    entity

  def toDtoList(entities: List[Post]): List[PostDto] =
    entities.map(toDto(_))

}
