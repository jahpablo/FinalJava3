create table artista(id_artista integer primary key auto_increment, 
    nombre varchar(250),
    id_cancion integer, 
    id_album integer);

create table cancion(id_cancion integer primary key auto_increment, 
    nombre varchar(250),
    id_artista integer, 
    id_album integer, 
    constraint foreign key (id_artista) references artista(id_artista),
    constraint foreign key (id_album) references album(id_album));

create table album(id_album integer primary key auto_increment, 
    nombre varchar(250), 
    id_artista integer, 
    constraint foreign key (id_artista) references artista(id_artista));


