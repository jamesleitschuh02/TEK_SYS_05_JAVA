console.log("connected!");

function comment(id) {
	let postComment = document.getElementById('post-comment');
	let comment = postComment.value;
	postComment.value = "";
	
	window.location.replace("http://localhost:8080/comment/addComment/" + id + "/" + comment);
}