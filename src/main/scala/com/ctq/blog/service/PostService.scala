package com.ctq.blog.service

import com.ctq.blog.dto.{PostDto, PostsResponse}
import com.ctq.blog.entity.Post
import com.ctq.blog.exception.NotFoundException
import com.ctq.blog.mapper.PostMapper
import com.ctq.blog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.stereotype.Service

import scala.collection.JavaConverters.*
import scala.collection.immutable.List

@Service
class PostService @Autowired()(val postRepository: PostRepository) {

  def getAll(pageable: Pageable): PostsResponse = {
    val posts = postRepository.findAll(pageable)
    val content: List[PostDto] = PostMapper.toDtoList(posts.getContent().asScala.toList)

    val postsResponse = new PostsResponse

    postsResponse.content = content
    postsResponse.pageNo = posts.getNumber
    postsResponse.pageSize = posts.getSize
    postsResponse.totalElements = posts.getTotalElements
    postsResponse.totalPages = posts.getTotalPages
    postsResponse.isLast = posts.isLast

    postsResponse
  }

  def getById(id: Long): PostDto =
    PostMapper.toDto(Option(postRepository.findById(id)).getOrElse(throw NotFoundException(s"Post with ID $id not found")))

  def create(postDto: PostDto): PostDto =
    PostMapper.toDto(postRepository.save(PostMapper.toEntity(postDto)))

  def update(id: Long, postDto: PostDto): PostDto =
    val post = getById(id)
    post.title = postDto.title
    post.description = postDto.description
    post.content = postDto.content
    PostMapper.toDto(postRepository.save(PostMapper.toEntity(post)))

  def delete(id: Long): PostDto =
    val post = postRepository.findById(id)
    val deletedPost = PostMapper.toDto(post)
    postRepository.delete(post)
    deletedPost

}
