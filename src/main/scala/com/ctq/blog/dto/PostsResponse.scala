package com.ctq.blog.dto

import com.ctq.blog.entity.Post
import org.springframework.stereotype.Component

import scala.beans.BeanProperty

class PostsResponse {

  var content: List[PostDto] = _
  var pageNo: Int = _
  var pageSize: Int = _
  var totalElements: Long = _
  var totalPages = 0
  var isLast = false
}
