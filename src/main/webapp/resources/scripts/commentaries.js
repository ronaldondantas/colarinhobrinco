var commentForm = document.querySelector("#add-commentary-form");

commentForm.addEventListener("submit", function(event) {
	
	event.preventDefault();
	
	var ajaxLoader = document.querySelector("#ajaxloader");
	
	var comment = createComment();
	
	var xhr = new XMLHttpRequest();
	
	xhr.open("POST", "http://localhost:8080/colarinhobranco/comment/save");
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.addEventListener("load", function() {
		
		ajaxLoader.classList.add("invisible");
		
		if (xhr.status == 200) {
			addCommentInPage(comment);
			document.querySelector("#add-commentary-form").reset();
		}
		
	});
	
	ajaxLoader.classList.remove("invisible");
	
	xhr.send(objectToParams(comment));
	
});

function createComment() {
	
	var form = document.querySelector("#add-commentary-form");
	
	var comment = {
		newsId: form.newsId.value,
		author: form.author.value,
		content: form.content.value
	}
	
	return comment;
	
}

function objectToParams(obj) {
	
	var params = "";
	
	Object.keys(obj).forEach(function(key, index) {
		params += key + "=" + obj[key] + "&";
	});
	
	return encodeURI(params.slice(params.length * -1, -1));
	
}

function addCommentInPage(comment) {
	
	var authorH2 = document.createElement("h2");
	authorH2.textContent = comment.author;
	
	var contentP = document.createElement("p");
	contentP.textContent = comment.content;
	
	var commentDiv = document.createElement("div");
	commentDiv.appendChild(authorH2);
	commentDiv.appendChild(contentP);
	commentDiv.classList.add("comment");
	
	var commentsDiv = document.querySelector("#news-commentaries");
	commentsDiv.insertBefore(commentDiv, commentsDiv.childNodes[0]);
	
}