package colarinhobranco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="news_seq", sequenceName="news_id_seq", allocationSize=1)
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="news_seq")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="headline_content")
	private String headlineContent;
	
	@Column(name="headline_image")
	private String headlineImage;
	
	@Column(name="content")
	private String content;
	
	public News() { }
	
	public News(String title, Date date, String headlineContent, String headlineImage, String content) {
		
		super();
		this.title = title;
		this.date = date;
		this.headlineContent = headlineContent;
		this.headlineImage = headlineImage;
		this.content = content;
		
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getTitle() { return title; }

	public void setTitle(String title) { this.title = title; }

	public Date getDate() { return date; }

	public void setDate(Date date) { this.date = date; }

	public String getHeadlineContent() { return headlineContent; }

	public void setHeadlineContent(String headlineContent) { this.headlineContent = headlineContent; }

	public String getHeadlineImage() { return headlineImage; }

	public void setHeadlineImage(String headlineImage) { this.headlineImage = headlineImage; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	@Override
	public String toString() {
		
		return "News [id=" + id + ", title=" + title + ", date=" + date + ", headlineContent="
				+ headlineContent + ", headlineImage=" + headlineImage + ", content=" + content + "]";
		
	}

}