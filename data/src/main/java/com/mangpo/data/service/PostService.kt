package com.mangpo.data.service

import com.mangpo.data.model.base.BaseResDTO
import com.mangpo.data.model.createPost.CreatePostReqDTO
import com.mangpo.data.model.createPost.CreatePostResDTO
import com.mangpo.data.model.getPosts.GetPostsResDTO
import com.mangpo.data.model.updatePost.UpdatePostReqDTO
import com.mangpo.data.model.updatePost.UpdatePostResDTO
import retrofit2.http.*

interface PostService {
    @GET("/api/posts?size=20")
    suspend fun getPosts(@Query("userId") userId: Int, @Query("page") page: Int, @Query("sort") sort: String, @Query("createdDate") createdDate: String?, @Query("star") star: Int?, @Query("category") category: String?): BaseResDTO<GetPostsResDTO?>

    @POST("/api/posts")
    suspend fun createPost(@Body createPostReqDTO: CreatePostReqDTO): BaseResDTO<CreatePostResDTO?>

    @PATCH("/api/posts/{postId}")
    suspend fun updatePost(@Body updatePostReqDTO: UpdatePostReqDTO, @Path("postId") postId: Int): BaseResDTO<UpdatePostResDTO?>

    @DELETE("/api/posts/{postId}")
    suspend fun deletePost(@Path("postId") postId: Int): BaseResDTO<Nothing>
}