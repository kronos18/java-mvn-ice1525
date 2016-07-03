select 	sum( conso_totale ),a.last_date,a.last_heure,a.idmaison,a.id_date from (select distinct(max( uga.date.ddate )) as last_date, max( extract( hour from uga.heure.heure ) ) as last_heure, sum( energy_wh ) as conso_totale, uga.appareil.idmaison,uga.date.id as id_date from uga.Consommation join uga.appareil on (uga.appareil.id = uga.consommation.idappareil) join uga.maison on (uga.maison.id = uga.appareil.idmaison) join uga.date on (uga.date.id = uga.consommation.iddate	) join uga.heure on (uga.heure.id = uga.consommation.idheure ) where uga.appareil.idmaison = ? and uga.date.ddate in( select distinct( max( uga.date.ddate ) ) as last_date from uga.Consommation join uga.appareil on (uga.appareil.id = uga.consommation.idappareil ) left outer join uga.maison on ( uga.maison.id = uga.appareil.idmaison ) left outer join uga.date on ( uga.date.id = uga.consommation.iddate ) left outer join uga.heure on ( uga.heure.id = uga.consommation.idheure ) where uga.appareil.idmaison = ? ) group by uga.appareil.idmaison, uga.date.id order by last_heure desc)  A group by a.last_date, a.idmaison,a.last_heure,a.id_dateorder by a.last_heure desc limit 1

select
	sum( conso_totale ) as conso_totale,
	a.last_date,
	a.last_heure,
	a.idmaison,
	a.id_date
from
	(
		select
			distinct(
				max( uga.date.ddate )
			) as last_date,
			max( extract( hour from uga.heure.heure ) ) as last_heure,
			energy_wh as conso_totale,
			uga.appareil.idmaison,
			uga.date.id as id_date
		from
			uga.Consommation join uga.appareil on
			(
				uga.appareil.id = uga.consommation.idappareil
			) join uga.maison on
			(
				uga.maison.id = uga.appareil.idmaison
			) join uga.date on
			(
				uga.date.id = uga.consommation.iddate
			) join uga.heure on
			(
				uga.heure.id = uga.consommation.idheure
			)
		where
			uga.appareil.idmaison = 900
			and uga.date.ddate in(
				select
					distinct(
						max( uga.date.ddate )
					) as last_date
				from
					uga.Consommation join uga.appareil on
					(
						uga.appareil.id = uga.consommation.idappareil
					) left outer join uga.maison on
					(
						uga.maison.id = uga.appareil.idmaison
					) left outer join uga.date on
					(
						uga.date.id = uga.consommation.iddate
					) left outer join uga.heure on
					(
						uga.heure.id = uga.consommation.idheure
					)
				where
					uga.appareil.idmaison = 900
			)
		group by
			uga.appareil.idmaison,
			uga.date.id,
			uga.consommation.energy_wh
		order by
			last_heure desc
	) A
group by
	a.last_date,
	a.idmaison,
	a.last_heure,
	a.id_date
	order by last_heure desc limit 1;