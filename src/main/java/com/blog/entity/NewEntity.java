package com.blog.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "new")
public class NewEntity extends BaseEntity {
	
	@Column(name = "title")
	private String title;
	
	@Transient
	private String thumbnail;
	
	
	@Column(name = "thumbnail", columnDefinition = "MEDIUMBLOB")
	private Blob thumbnail_Blob;
	
	@Column(name = "shortdescription", columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Blob getThumbnail_Blob() {
		return thumbnail_Blob;
	}

	public void setThumbnail_Blob(Blob thumbnail_Blob) {
		this.thumbnail_Blob = thumbnail_Blob;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
}
