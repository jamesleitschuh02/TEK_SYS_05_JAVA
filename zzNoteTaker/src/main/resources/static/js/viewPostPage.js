console.log("connected!");

function comment(id) {
	console.log("function comment works");
	
	let postComment = document.getElementById('post-comment');
	
	console.log(postComment.value);
	console.log("POST ID IS:",id);
	let comment = postComment.value;
	postComment.value = "";
	
	window.location.replace("http://localhost:8080/responses/addComment/" + id + "/" + comment);
}

document.getElementById('test').addEventListener('click', event => {
	event.preventDefault();
	console.log("test function");
});