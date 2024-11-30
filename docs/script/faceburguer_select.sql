select nome_usuario, mensagem from usuario
inner join mensagem
on FK_ID_USUARIO = id_usuario
order by id_mensagem desc;