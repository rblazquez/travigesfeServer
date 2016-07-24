package com.blacarapps.travivel.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blacarapps.travivel.domain.entity.Attachment;

public interface AttachmentRepository extends PagingAndSortingRepository<Attachment, Long> {

}

