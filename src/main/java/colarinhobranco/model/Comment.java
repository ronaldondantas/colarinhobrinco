package colarinhobranco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="comment_seq", sequenceName="comment_id_seq", allocationSize=1)
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")
	private Integer id;
	
	@Column(name="author")
	private String author;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private News news;
	
	public Comment() { }
	
	public Comment(String author, String content) {
		
		super();
		this.author = author;
		this.content = content;
		
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) { this.author = author; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }
	
	public News getNews() { return news; }

	public void setNews(News news) { this.news = news; }

	@Override
	public String toString() {
		return "Comment [id=" + id + ", author=" + author + ", content=" + content + "]";
	}	
	
}