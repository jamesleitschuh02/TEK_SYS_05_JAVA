console.log("connected!");

function upload(id, noteTitle, noteContent) {
	
	let updateBtn = document.getElementById('update-btn');
	updateBtn.dataset.id = id;
	
	let deleteBtn = document.getElementById('delete-btn');
	deleteBtn.dataset.id = id;
	
//	let listId = document.getElementById(id);
//	listId.className = "list-group-item active";
	
	let title = document.getElementById('note-title');
	title.value = noteTitle;
	
	let text = document.getElementById('note-text');
	text.value = noteContent;
};

function update() {
	
	let title = document.getElementById('note-title');
	let titleValue = title.value;
	
	let text = document.getElementById('note-text');
	let textValue = text.value;
	
	let updateBtn = document.getElementById('update-btn');
	let id = updateBtn.dataset.id;
	
	window.location.replace("http://localhost:8080/notes/update/" + id + "/" + titleValue + "/" + textValue);
}

function deleteNote() {
	
	let deleteBtn = document.getElementById('delete-btn');
	let id = deleteBtn.dataset.id;
	
	window.location.replace("http://localhost:8080/notes/delete/" + id);
}