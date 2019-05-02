SELECT count(*) FROM studentai;

SELECT s.vardas, s.pavarde, p.pazymys FROM studentai AS s
JOIN pazymiai AS p ON p.studentas_id = s.id
WHERE data = '2018-08-12';
    
SELECT s.vardas, s.pavarde, CAST(AVG(p.pazymys) AS DECIMAL(10,2)) AS Vidurkis FROM pazymiai AS p
JOIN studentai AS s ON p.studentas_id = s.id
GROUP BY s.id;

SELECT s.vardas, s.pavarde, CAST(AVG(p.pazymys) AS DECIMAL(10,2)) AS vidurkis FROM pazymiai AS p
JOIN studentai AS s ON p.studentas_id = s.id
GROUP BY s.id
HAVING AVG(p.pazymys) > 9;

SELECT s.el_paštas FROM studentai AS s
JOIN pazymiai AS p ON p.studentas_id = s.id
GROUP BY s.id
HAVING count(p.pazymys) <= 1;