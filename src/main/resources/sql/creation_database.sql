drop
	table
		if exists uga.Consommation;

drop
	table
		if exists uga.Appareil;

drop
	table
		if exists uga.TypeAppareil;

drop
	table
		if exists uga.Heure;

drop
	table
		if exists uga.Date;

drop
	table
		if exists uga.Maison;

drop
	table
		if exists uga.Quartier;

create
	table
		uga.Quartier(
			id serial primary key not null,
			name varchar(30)
		);

create
	table
		uga.Maison(
			ID serial primary key not null,
			idquartier serial references uga.Quartier(id)
		);

create
	table
		uga.Date(
			id serial primary key not null,
			ddate date not null
		);

create
	table
		uga.Heure(
			id serial primary key not null,
			heure time not null
		);

create
	table
		uga.TypeAppareil(
			id serial primary key not null,
			name varchar(30)
		);

create
	table
		uga.Appareil(
			id serial primary key not null,
			name varchar(30),
			idTypeAppareil serial references uga.TypeAppareil(id),
			idMaison serial references uga.Maison(id)
		);

create
	table
		uga.Consommation(
			idDate serial references uga.Date(id),
			idHeure serial references uga.Heure(id),
			idAppareil serial references uga.Appareil(id),
			etat integer,
			energy_wh integer not null,
			primary key(
				idDate,
				idHeure,
				idAppareil
			)
		);