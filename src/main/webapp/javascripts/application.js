function buscarComentarios(idDoPost){
	$.ajax({
		type : "GET",
		datType: "json",
		url : "/comentarios",
		data : {
			'post.id' : idDoPost
		}
	}).done(function(msg) {
		console.log("Data Saved: " + msg);
	});
	
}

$(document).ready(function() {	
	$('#novoComentario').click(function(event) {
		$.ajax({
			type : "POST",
			url : "/comentarios",
			data : {
				'comentario.conteudo' : 'John',
			}
		}).done(function(msg) {
			console.log("Data Saved: " + msg);
		});
	});
	buscarComentarios(1);
});