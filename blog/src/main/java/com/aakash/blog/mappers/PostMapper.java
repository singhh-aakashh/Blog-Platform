package com.aakash.blog.mappers;

import com.aakash.blog.domain.CreatePostRequest;
import com.aakash.blog.domain.UpdatePostRequest;
import com.aakash.blog.domain.dtos.CreatePostRequestDto;
import com.aakash.blog.domain.dtos.PostDto;
import com.aakash.blog.domain.dtos.UpdatePostRequestDto;
import com.aakash.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostDto toDto(Post post);


    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);

}
