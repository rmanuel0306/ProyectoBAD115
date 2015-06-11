-- PROCEDIMIENTOS MODULO PERSONA

create or replace procedure savePerson (idmunic PERSONA.ID_MUNIC%TYPE,priNombre PERSONA.PRIMER_NOMBRE%TYPE,segNombre PERSONA.SEGUNDO_NOMBRE%TYPE,
priApellido PERSONA.PRIMER_APELLIDO%TYPE,segApellido PERSONA.SEGUNDO_APELLIDO%TYPE,carg PERSONA.CARGO%TYPE,v_sexo PERSONA.SEXO%TYPE,
fechNac PERSONA.FECHA_NAC%TYPE,v_dui PERSONA.DUI%TYPE,v_email PERSONA.E_MAIL%TYPE,direc PERSONA.DIRECCION%TYPE)
IS
BEGIN
INSERT INTO PERSONA(ID_MUNIC,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,CARGO,SEXO,FECHA_NAC,DUI,E_MAIL,DIRECCION) VALUES 
(idmunic,priNombre,segNombre,priApellido,segApellido,carg,v_sexo,fechNac,v_dui,v_email,direc);
COMMIT;
END savePerson;

/

create or replace procedure deletePerson(idper PERSONA.ID_PERSONA%TYPE)
IS
BEGIN
DELETE FROM PERSONA WHERE ID_PERSONA = idper;
COMMIT;
END deletePerson;

/

-- PROCEDIMIENTOS MODULO USUARIO

create or replace PROCEDURE PROC_USUARIO 
(
  OPERACION IN NUMBER 
, VID_USUARIO IN NUMBER 
, VID_PRIVILEGIO IN NUMBER 
, VID_PERSONA IN NUMBER 
, VNOMBRE_USUARIO IN VARCHAR2 
, VCLAVE IN VARCHAR2 
) AS 
sid_usuario number(38,0); 
sid_privilegio number(38,0); 
sid_persona number(38,0); 
snombre_usuario VARCHAR2(5); 
sclave VARCHAR2(12); 
BEGIN
  --------operacion 1 crear usuario
 if operacion=1 then 
   insert into usuario(id_usuario,id_persona,nombre_usuario,clave) values(VID_USUARIO,VID_PERSONA,VNOMBRE_USUARIO,VCLAVE);
  end if;
  -------operacion 2 consultar usuario
 if operacion=2 then  
   select id_usuario,id_persona,nombre_usuario,clave into sid_usuario,sid_persona,snombre_usuario,sclave from usuario where id_usuario=VID_USUARIO;
   DBMS_OUTPUT.PUT_LINE(sid_usuario||' '||sid_persona||' '||snombre_usuario||' '||sclave); 
  end if;
  -------operacion 3 actualizar usuario
 if operacion=3 then  
   update usuario set id_persona=VID_PERSONA,nombre_usuario=VNOMBRE_USUARIO,clave=VCLAVE where id_usuario=VID_USUARIO;
  end if;
   -------operacion 4 eliminar usuario
  if operacion=4 then  
   delete from usuario where id_usuario=VID_USUARIO;
  end if;
  -------operacion 5 validar que exista persona
  -------operacion 6 validar que exista usuario
  COMMIT;
END PROC_USUARIO;

/

-- PROCEDIMIENTOS MODULO XXXXXXX