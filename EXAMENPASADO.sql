/*Jose Antonio Campos Rueda*/

Select (APELLIDO1||' '||APELLIDO2||' ,'||nombre) as "NOMBRE JACR", trunc((sysdate-fecha_nacimiento)/365.25,0)||' años' as "Edad"
from personas;

Select TIPO as "TIPO PRR", count(id)
from asignatura
group by Tipo
having count(id)>15;

select  DISTINCT p.id,p.nombre, p.apellido1, p.apellido2,c.año_inicio, c.año_fin
from curso_escolar c join alumno_se_matricula_asignatura a 
        on c.id=a.id_curso_escolar
    join personas p on a.id_alumno=p.id
where c.año_inicio=2022 and c.año_fin=2023
ORDER BY 2,3,1; 

Select nombre, apellido1, apellido2, nif,tipo
from personas
where nif like '%G'
order by 5,2;

Select (APELLIDO1||' '||APELLIDO2||' ,'||nombre) as "NOMBRE JACR", dirección, fecha_nacimiento
from personas
where tipo = 'alumno' and TO_CHAR(FECHA_NACIMIENTO, 'mm') IN (1,2,3)
order by apellido1,apellido2;

Select a.nombre, g.nombre
from asignatura a join grado g on g.id = a.id_grado
WHERE g.nombre like '%Informática%';

SELECT a.NOMBRE "Asignaturas", a.TIPO "Tipo"
FROM ASIGNATURA  a JOIN PROFESOR ON a.ID_PROFESOR = PROFESOR.ID_PROFESOR
                                    JOIN PERSONAS pe ON pe.ID = PROFESOR.ID_PROFESOR
WHERE pe.NOMBRE = 'Zoe' and pe.APELLIDO1 = 'Ramírez' and pe.APELLIDO2 = 'Gea'
            and a.TIPO = 'básica'; 