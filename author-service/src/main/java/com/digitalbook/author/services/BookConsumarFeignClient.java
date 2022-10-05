package com.digitalbook.author.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import feign.Headers;

@FeignClient(name = "BOOK-SERVICE")
public interface BookConsumarFeignClient {

	@PostMapping(value = "/api/v1/digitalbook/{authorID}/book/",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Headers("Content-Type: multipart/form-data")
	public ResponseEntity<String> saveBook(@PathVariable Long authorID, @RequestParam String tittle,
			@RequestParam String category, @RequestParam float price, @RequestParam String authorName,
			@RequestParam String publisher, @RequestParam String publisherDate, @RequestParam boolean active,
			@RequestParam String content, @RequestParam("image") MultipartFile image);

	@PutMapping("/api/v1/digitalbook/{authorId}/book/{bookId}")
	@Headers("Content-Type: multipart/form-data")
	public ResponseEntity<String> updateBook(@PathVariable Long authorId,

			@PathVariable Long bookId, @RequestParam String tittle, @RequestParam String category,
			@RequestParam float price, @RequestParam String authorName, @RequestParam String publisher,
			@RequestParam String publisherDate, @RequestParam boolean active, @RequestParam String content,
			@RequestParam("image") MultipartFile image);
}
