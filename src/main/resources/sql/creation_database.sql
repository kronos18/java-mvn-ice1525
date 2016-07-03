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
			id bigint primary key not null,
			name varchar(30)
		);

create
	table
		uga.Maison(
			ID bigint primary key not null,
			idquartier bigint references uga.Quartier(id)
		);

create
	table
		uga.Date(
			id BIGSERIAL primary key not null,
			ddate date not null
		);

create
	table
		uga.Heure(
			id BIGSERIAL primary key not null,
			heure time not null
		);

create
	table
		uga.TypeAppareil(
			id BIGSERIAL primary key not null,
			name varchar(30)
		);

create
	table
		uga.Appareil(
			id bigint primary key not null,
			name varchar(60),
			idTypeAppareil bigint references uga.TypeAppareil(id),
			idMaison bigint references uga.Maison(id)
		);

create
	table
		uga.Consommation(
			idDate bigint references uga.Date(id),
			idHeure bigint references uga.Heure(id),
			idAppareil bigint references uga.Appareil(id),
			etat integer,
			energy_wh integer not null,
			primary key(
				idDate,
				idHeure,
				idAppareil
			)
		);

truncate
	table
		uga.appareil cascade;

truncate
	table
		uga.consommation cascade;

truncate
	table
		uga.date cascade;

truncate
	table
		uga.heure cascade;

truncate
	table
		uga.maison cascade;

truncate
	table
		uga.quartier cascade;

truncate
	table
		uga.typeappareil cascade;
