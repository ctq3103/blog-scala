package com.ctq.blog.controller

import com.ctq.blog.dto.{PostDto, PostsResponse}
import com.ctq.blog.exception.BadRequestException
import com.ctq.blog.repository.PostRepository
import com.ctq.blog.service.PostService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestBody, RequestMapping, RequestMethod, ResponseStatus, RestController}

@RestController
class PostController @Autowired()(val postService: PostService, val postRepository: PostRepository) {

  @RequestMapping(value = Array("/posts"), method = Array(RequestMethod.GET))
  @ResponseStatus(HttpStatus.OK)
  def getPosts(pageable: Pageable): PostsResponse = postService.getAll(pageable)

  @RequestMapping(value = Array("/posts/{id}"), method = Array(RequestMethod.GET))
  @ResponseStatus(HttpStatus.OK)
  def getPostById(@PathVariable id: Long): PostDto = postService.getById(id)

  @RequestMapping(value = Array("/posts"), method = Array(RequestMethod.POST))
  @ResponseStatus(HttpStatus.CREATED)
  def createPost(@Valid @RequestBody postDto: PostDto, bindingResult: BindingResult): PostDto = {
    if (bindingResult.hasErrors) throw BadRequestException(bindingResult.getFieldError.getDefaultMessage)
    postService.create(postDto)
  }

  @RequestMapping(value = Array("/posts/{id}"), method = Array(RequestMethod.PUT))
  @ResponseStatus(HttpStatus.OK)
  def updatePost(@PathVariable id: Long, @Valid @RequestBody postDto: PostDto, bindingResult: BindingResult): PostDto = {
    if (bindingResult.hasErrors) throw BadRequestException(bindingResult.getFieldError.getDefaultMessage)
    postService.update(id, postDto)
  }

  @RequestMapping(value = Array("/posts/{id}"), method = Array(RequestMethod.DELETE))
  @ResponseStatus(HttpStatus.OK)
  def deletePost(@PathVariable id: Long): PostDto = postService.delete(id)
}
