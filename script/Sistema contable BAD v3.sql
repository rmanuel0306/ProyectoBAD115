alter table BITACORA
   drop constraint FK_BITACORA_RELATIONS_USUARIO;

alter table CUENTA
   drop constraint FK_CUENTA_RELATIONS_ESTADO;

alter table CUENTA
   drop constraint FK_CUENTA_RELATIONS_RUBRO;

alter table DETALLE_ESTADO
   drop constraint FK_DETALLE__RELATIONS_ESTADO;

alter table MOVIMIENTO
   drop constraint FK_MOVIMIEN_RELATIONS_CUENTA;

alter table MUNICIPIO
   drop constraint FK_MUNICIPI_RELATIONS_DEPARTAM;

alter table PERSONA
   drop constraint FK_PERSONA_RELATIONS_MUNICIPI;

alter table TELEFONO
   drop constraint FK_TELEFONO_RELATIONS_PERSONA;

alter table TRANSACCION
   drop constraint FK_TRANSACC_RELATIONS_USUARIO;

alter table TRANSACCION
   drop constraint FK_TRANSACC_RELATIONS_CUENTA;

alter table USUARIO
   drop constraint FK_USUARIO_RELATIONS_PERSONA;

alter table USUARIO
   drop constraint FK_USUARIO_RELATIONS_PRIVILEG;

drop index RELATIONSHIP_6_FK;

drop table BITACORA cascade constraints;

drop index RELATIONSHIP_11_FK;

drop index RELATIONSHIP_9_FK;

drop table CUENTA cascade constraints;

drop table DEPARTAMENTO cascade constraints;

drop index RELATIONSHIP_12_FK;

drop table DETALLE_ESTADO cascade constraints;

drop table ESTADO cascade constraints;

drop index RELATIONSHIP_10_FK;

drop table MOVIMIENTO cascade constraints;

drop index RELATIONSHIP_1_FK;

drop table MUNICIPIO cascade constraints;

drop index RELATIONSHIP_2_FK;

drop table PERSONA cascade constraints;

drop table PRIVILEGIO cascade constraints;

drop table RUBRO cascade constraints;

drop index RELATIONSHIP_3_FK;

drop table TELEFONO cascade constraints;

drop index RELATIONSHIP_8_FK;

drop index RELATIONSHIP_7_FK;

drop table TRANSACCION cascade constraints;

drop index RELATIONSHIP_5_FK;

drop index RELATIONSHIP_4_FK;

drop table USUARIO cascade constraints;

drop table EMPRESA cascade constraints;

DROP SEQUENCE sec_id_bitacora;

DROP SEQUENCE sec_id_cuenta;

DROP SEQUENCE sec_id_departamento;

DROP SEQUENCE sec_id_detalle_estado;

DROP SEQUENCE sec_id_empresa;

DROP SEQUENCE sec_id_estado;

DROP SEQUENCE sec_id_movimiento;

DROP SEQUENCE sec_id_municipio;

DROP SEQUENCE sec_id_persona;

DROP SEQUENCE sec_id_privilegio;

DROP SEQUENCE sec_id_rubro;

DROP SEQUENCE sec_id_telefono;

DROP SEQUENCE sec_id_transaccion;

DROP SEQUENCE sec_id_usuario;

/*==============================================================*/
/* Table: EMPRESA                                               */
/*==============================================================*/
create table EMPRESA 
(
   ID_EMPRESA				INTEGER not null,	
   ENOMBRE				VARCHAR2(50),
   EDIRECCION				VARCHAR2(100),
   TELEFONO				NUMBER(8,0),
   constraint PK_EMPRESA primary key (ENOMBRE)
);

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA 
(
   ID_BITACORA          INTEGER              not null,
   ID_USUARIO           INTEGER,
   FECHA_INGRESO        DATE,
   constraint PK_BITACORA primary key (ID_BITACORA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_6_FK on BITACORA (
   ID_USUARIO ASC
);

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA 
(
   ID_CUENTA            INTEGER              not null,
   ID_ESTADO            INTEGER,
   ID_RUBRO             INTEGER,
   NOMBRE_CUENTA        VARCHAR2(100),
   CUENTA_MAYOR         INTEGER,
   constraint PK_CUENTA primary key (ID_CUENTA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_9_FK on CUENTA (
   ID_RUBRO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_11_FK on CUENTA (
   ID_ESTADO ASC
);

/*==============================================================*/
/* Table: DEPARTAMENTO                                          */
/*==============================================================*/
create table DEPARTAMENTO 
(
   ID_DEPARTAMENTO      INTEGER              not null,
   NOMBRE_DEPTO         VARCHAR2(30),
   constraint PK_DEPARTAMENTO primary key (ID_DEPARTAMENTO)
);

/*==============================================================*/
/* Table: DETALLE_ESTADO                                        */
/*==============================================================*/
create table DETALLE_ESTADO 
(
   ID_DETALLE_ESTADO    INTEGER              not null,
   ID_ESTADO            INTEGER,
   FECHA_INICIO         DATE,
   FECHA_FIN            DATE,
   SALDO_TOTAL          NUMBER(18,2),
   RUTA_DOCUMENTO       VARCHAR2(150),
   constraint PK_DETALLE_ESTADO primary key (ID_DETALLE_ESTADO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_12_FK on DETALLE_ESTADO (
   ID_ESTADO ASC
);

/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table ESTADO 
(
   ID_ESTADO            INTEGER              not null,
   NOMBRE_ESTADO        VARCHAR2(50),
   DISPONIBILIDAD       SMALLINT,
   constraint PK_ESTADO primary key (ID_ESTADO)
);

/*==============================================================*/
/* Table: MOVIMIENTO                                            */
/*==============================================================*/
create table MOVIMIENTO 
(
   ID_MOVIMIENTO        INTEGER              not null,
   ID_CUENTA            INTEGER,
   MES					INTEGER,
   YEAR					INTEGER,
   DEBE                 NUMBER(18,2),
   HABER                NUMBER(18,2),
   CONCEPTO				VARCHAR2(3),
   constraint PK_MOVIMIENTO primary key (ID_MOVIMIENTO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on MOVIMIENTO (
   ID_CUENTA ASC
);

/*==============================================================*/
/* Table: MUNICIPIO                                             */
/*==============================================================*/
create table MUNICIPIO 
(
   ID_MUNIC             INTEGER              not null,
   ID_DEPARTAMENTO      INTEGER,
   NOMBRE_MUNIC         VARCHAR2(30),
   constraint PK_MUNICIPIO primary key (ID_MUNIC)
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_1_FK on MUNICIPIO (
   ID_DEPARTAMENTO ASC
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA 
(
   ID_PERSONA           INTEGER              not null,
   ID_MUNIC             INTEGER,
   PRIMER_NOMBRE        VARCHAR2(25),
   SEGUNDO_NOMBRE       VARCHAR2(25),
   PRIMER_APELLIDO      VARCHAR2(25),
   SEGUNDO_APELLIDO     VARCHAR2(25),
   CARGO		VARCHAR2(25),
   SEXO                 VARCHAR2(1),
   FECHA_NAC            DATE,
   DUI                  VARCHAR2(9),
   E_MAIL               VARCHAR2(30),
   DIRECCION            VARCHAR2(100),
   constraint PK_PERSONA primary key (ID_PERSONA)
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_2_FK on PERSONA (
   ID_MUNIC ASC
);

/*==============================================================*/
/* Table: PRIVILEGIO                                            */
/*==============================================================*/
create table PRIVILEGIO 
(
   ID_PRIVILEGIO        SMALLINT             not null,
   NOMBRE_PRIVILEGIO    VARCHAR2(20),
   DESCRIPCION          VARCHAR2(100),
   constraint PK_PRIVILEGIO primary key (ID_PRIVILEGIO)
);

/*==============================================================*/
/* Table: RUBRO                                                 */
/*==============================================================*/
create table RUBRO 
(
   ID_RUBRO             INTEGER              not null,
   NOMBRE_RUBRO         VARCHAR2(100),
   TIPO_RUBRO           VARCHAR2(30),
   constraint PK_RUBRO primary key (ID_RUBRO)
);

/*==============================================================*/
/* Table: TELEFONO                                              */
/*==============================================================*/
create table TELEFONO 
(
   ID_TELEFONO          INTEGER              not null,
   ID_PERSONA           INTEGER,
   TELEFONO_FIJO        NUMBER(8,0),
   TELEFONO_MOVIL       NUMBER(8,0),
   TELEFONO_AUXILIAR    NUMBER(8,0),
   constraint PK_TELEFONO primary key (ID_TELEFONO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_3_FK on TELEFONO (
   ID_PERSONA ASC
);

/*==============================================================*/
/* Table: TRANSACCION                                           */
/*==============================================================*/
create table TRANSACCION 
(
   ID_TRANSACCION       INTEGER              not null,
   ID_USUARIO           INTEGER,
   ID_CUENTA            INTEGER,
   ID_RELATIVO          INTEGER, 
   COMPORTAMIENTO       VARCHAR2(2), 
   FECHA                DATE,
   CONCEPTO		VARCHAR2(3), 
   SALDO                NUMBER(18,2),
   constraint PK_TRANSACCION primary key (ID_TRANSACCION)
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on TRANSACCION (
   ID_USUARIO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_8_FK on TRANSACCION (
   ID_CUENTA ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   ID_USUARIO           INTEGER              not null,
   ID_PRIVILEGIO        SMALLINT,
   ID_PERSONA           INTEGER,
   NOMBRE_USUARIO       VARCHAR2(10),
   CLAVE                VARCHAR2(12),
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_4_FK on USUARIO (
   ID_PERSONA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_5_FK on USUARIO (
   ID_PRIVILEGIO ASC
);

alter table BITACORA
   add constraint FK_BITACORA_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO);

alter table CUENTA
   add constraint FK_CUENTA_RELATIONS_ESTADO foreign key (ID_ESTADO)
      references ESTADO (ID_ESTADO);

alter table CUENTA
   add constraint FK_CUENTA_RELATIONS_RUBRO foreign key (ID_RUBRO)
      references RUBRO (ID_RUBRO);

alter table DETALLE_ESTADO
   add constraint FK_DETALLE__RELATIONS_ESTADO foreign key (ID_ESTADO)
      references ESTADO (ID_ESTADO);

alter table MOVIMIENTO
   add constraint FK_MOVIMIEN_RELATIONS_CUENTA foreign key (ID_CUENTA)
      references CUENTA (ID_CUENTA);

alter table MUNICIPIO
   add constraint FK_MUNICIPI_RELATIONS_DEPARTAM foreign key (ID_DEPARTAMENTO)
      references DEPARTAMENTO (ID_DEPARTAMENTO);

alter table PERSONA
   add constraint FK_PERSONA_RELATIONS_MUNICIPI foreign key (ID_MUNIC)
      references MUNICIPIO (ID_MUNIC);

alter table TELEFONO
   add constraint FK_TELEFONO_RELATIONS_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA);

alter table TRANSACCION
   add constraint FK_TRANSACC_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO);

alter table TRANSACCION
   add constraint FK_TRANSACC_RELATIONS_CUENTA foreign key (ID_CUENTA)
      references CUENTA (ID_CUENTA);

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA);

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_PRIVILEG foreign key (ID_PRIVILEGIO)
      references PRIVILEGIO (ID_PRIVILEGIO);


-- SECUENCIAS

CREATE SEQUENCE sec_id_bitacora START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_departamento START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_detalle_estado START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_empresa START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_movimiento START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_municipio START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_persona START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_privilegio START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_telefono START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_transaccion START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE sec_id_usuario START WITH 1 INCREMENT BY 1;


-- TRIGGERS
CREATE OR REPLACE TRIGGER trig_increment_id_bitacora
BEFORE INSERT ON BITACORA
FOR EACH ROW
BEGIN
SELECT sec_id_bitacora.NEXTVAL INTO :NEW.ID_BITACORA FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_departamento
BEFORE INSERT ON DEPARTAMENTO
FOR EACH ROW
BEGIN
SELECT sec_id_departamento.NEXTVAL INTO :NEW.ID_DEPARTAMENTO FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_incre_id_detalle_estado
BEFORE INSERT ON DETALLE_ESTADO
FOR EACH ROW
BEGIN
SELECT sec_id_detalle_estado.NEXTVAL INTO :NEW.ID_DETALLE_ESTADO FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_empresa
BEFORE INSERT ON EMPRESA
FOR EACH ROW
BEGIN
SELECT sec_id_empresa.NEXTVAL INTO :NEW.ID_EMPRESA FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_movimiento
BEFORE INSERT ON MOVIMIENTO
FOR EACH ROW
BEGIN
SELECT sec_id_movimiento.NEXTVAL INTO :NEW.ID_MOVIMIENTO FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_municipio
BEFORE INSERT ON MUNICIPIO
FOR EACH ROW
BEGIN
SELECT sec_id_municipio.NEXTVAL INTO :NEW.ID_MUNIC FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_persona
BEFORE INSERT ON PERSONA
FOR EACH ROW
BEGIN
SELECT sec_id_persona.NEXTVAL INTO :NEW.ID_PERSONA FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_privilegio
BEFORE INSERT ON PRIVILEGIO
FOR EACH ROW
BEGIN
SELECT sec_id_privilegio.NEXTVAL INTO :NEW.ID_PRIVILEGIO FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_telefono
BEFORE INSERT ON TELEFONO
FOR EACH ROW
BEGIN
SELECT sec_id_telefono.NEXTVAL INTO :NEW.ID_TELEFONO FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_transaccion
BEFORE INSERT ON TRANSACCION
FOR EACH ROW
BEGIN
SELECT sec_id_transaccion.NEXTVAL INTO :NEW.ID_TRANSACCION FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER trig_increment_id_usuario
BEFORE INSERT ON USUARIO
FOR EACH ROW
BEGIN
SELECT sec_id_usuario.NEXTVAL INTO :NEW.ID_USUARIO FROM DUAL;
END;
/



INSERT INTO estado (ID_ESTADO, NOMBRE_ESTADO, DISPONIBILIDAD) VALUES
(1, 'BALANCE DE COMPROBACION', 0);
INSERT INTO estado (ID_ESTADO, NOMBRE_ESTADO, DISPONIBILIDAD) VALUES
(2, 'BALANCE DE COMPROBACION AJUSTADO', 0);
INSERT INTO estado (ID_ESTADO, NOMBRE_ESTADO, DISPONIBILIDAD) VALUES
(3, 'ESTADO FINANCIERO DE RESULTADOS', 0);
INSERT INTO estado (ID_ESTADO, NOMBRE_ESTADO, DISPONIBILIDAD) VALUES
(4, 'ESTADO FINANCIERO DE CAPITAL', 0);
INSERT INTO estado (ID_ESTADO, NOMBRE_ESTADO, DISPONIBILIDAD) VALUES
(5, 'BALANCE GENERAL', 0);

INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(11, 'ACTIVO CORRIENTE', 'ACTIVO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(12, 'ACTIVO NO CORRIENTE', 'ACTIVO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(21, 'PATRIMONIO Y RESERVAS', 'PATRIMONIO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(22, 'EXCENTES POR APLICAR', 'PATRIMONIO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(23, 'PATRIMONIO RESTRINGIDO', 'PATRIMONIO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(24, 'PATRIMONIO NO DISTRIBUIBLE', 'PATRIMONIO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(31, 'PASIVO CORRIENTE', 'PASIVO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(32, 'PASIVO NO CORRIENTE', 'PASIVO');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(41, 'COSTOS DE OPERACION DE INTERMEDIACION', 'COSTOS Y GASTOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(42, 'COSTOS DE OTRAS OPERACIONES', 'COSTOS Y GASTOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(43, 'GASTOS OPERACIONABLES', 'COSTOS Y GASTOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(44, 'GASTOS NO OPERACIONALES', 'COSTOS Y GASTOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(51, 'INGRESOS DE OPERACIONES DE INTERMEDIACION', 'INGRESOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(52, 'INGRESOS OPERACIONES', 'INGRESOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(53, 'INGRESOS NO OPERACIONALES', 'INGRESOS');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(61, 'CUENTA LIQUIDADA', 'CUENTAS DE CIERRE');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(71, 'DERECHOS Y OBLIGACIONES FINANCIERAS', 'CUENTAS DE ORDEN');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(73, 'DERECHOS Y OBLIGACIONES FINANCIERAS POR CONTRA', 'CUENTAS DE ORDEN');
INSERT INTO rubro (ID_RUBRO, NOMBRE_RUBRO, TIPO_RUBRO) VALUES
(74, 'DOCUMENTOS EN CAJA DE SEGURIDAD POR CONTRA', 'CUENTAS DE ORDEN');



INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1101, 11, 5, 'Caja_general',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1102, 11, 5, 'Depositos_en_bancos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1103, 11, 5, 'Linea_de_prestamo',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1104, 11, 5, 'Provición_para_incobrabilidad_de_prestamos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1105, 11, 5, 'Intereses_por_cobrar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1106, 11, 5, 'Comisiones_por_cobrar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1107, 11, 5, 'Saldos_por_cobrar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1108, 11, 5, 'Documentos_por_cobrar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1109, 11, 5, 'Credito_fiscal',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1110, 11, 5, 'Seguros_y_fianzas',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1111, 11, 5, 'Gastos_de_organización',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1112, 11, 5, 'Intereses_pagados_por_anticipados',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1113, 11, 5, 'Mantenimiento_y_Equipo',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1114, 11, 5, 'Material_papeleria_y_utiles',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1115, 11, 5, 'Insumos_administrativos_y_de_oficinas',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1116, 11, 5, 'Inventarios_de_Mercaderia',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1117, 11, 5, 'Alquileres',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1118, 11, 5, 'Enseres_Administrativos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1119, 11, 5, 'Amortizacion_Acumulada',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1120, 11, 5, 'Agotamiento_de_recursos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1121, 11, 5, 'Publicidad_y_propagandas',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1201, 12, 5, 'Terrenos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1202, 12, 5, 'Construccion_en_proceso',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1203, 12, 5, 'Bienes_no_depreciables',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1204, 12, 5, 'Muebles_y_Enceres',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1205, 12, 5, 'Mobiliario_y_Equipo_de_oficina',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1206, 12, 5, 'Edificaciones',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1207, 12, 5, 'Vehiculos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1208, 12, 5, 'Depreciacion_de_edificaciones',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1209, 12, 5, 'Depreciacion_de_equipo_y_mobiliario',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(1210, 12, 5, 'Depreciacion_de_vehiculos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2101, 21, 4, 'Capital_social',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2102, 21, 4, 'Reserva_Legal',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2201, 22, 4, 'Resultado_de_ejercicio_anterior',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2202, 22, 4, 'Resultado_del_ejercicio_corriente',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2301, 23, 4, 'Excendetes_no_distribuibles',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2302, 23, 4, 'Revaluaciones',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2401, 24, 4, 'Donaciones',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(2402, 24, 4, 'Donaciones_de_particulares',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3101, 31, 5, 'Depositos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3102, 31, 5, 'Prestamos_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3103, 31, 5, 'Intereses_sobre_prestamos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3104, 31, 5, 'Intereses_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3105, 31, 5, 'Intereses_sobre_depositos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3106, 31, 5, 'Intereses_sobre_documentos_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3107, 31, 5, 'Comisiones_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3108, 31, 5, 'Saldos_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3109, 31, 5, 'Impuestos_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3110, 31, 5, 'Debito_fiscal',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3111, 31, 5, 'Retenciones_a_empleados',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3112, 31, 5, 'Gastos_diversos_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3113, 31, 5, 'Documentos_por_pagar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3201, 32, 5, 'Prestamos_por_pagar_a_largo_plazo',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(3202, 32, 5, 'Recuperacion_de_prestamos_por_aplicar',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4101, 41, 3, 'Prestamos_obtenidos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4201, 42, 3, 'Costos_por_servicios_tecnicos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4202, 42, 3, 'Costos_por_servicios_basicos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4301, 43, 3, 'Gastos_por_administracion_y_vigilancia',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4302, 43, 3, 'Gastos_por_salarios',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4303, 43, 4, 'Gastos_del_personal',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4304, 43, 3, 'Consumo_de_materiales',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4305, 43, 3, 'Combustible_y_lubricantes',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4306, 43, 3, 'Reparacion_y_mantenimiento_de_maquinaria',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4307, 43, 3, 'Gastos_diversos_de_mobiliario_y_equipo_de_oficina',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4308, 43, 3, 'Gastos_por_servicios_basicos_sobre_operaciones',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4309, 43, 3, 'Gastos_por_alquileres',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4310, 43, 3, 'Gastos_por_Depreciaciones',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4311, 43, 3, 'Gastos_por_Intereses',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4312, 43, 3, 'Gastos_por_seguro_y_fianzas',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4313, 43, 3, 'Gastos_por_Agotamiento_de_recursos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4314, 43, 3, 'Gastos_por_retenciones_de_salarios_a_empleados',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4315, 43, 3, 'Gastos_por_intereses_varios',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4316, 43, 3, 'Gastos_por_cuentas_incobrables',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4317, 43, 3, 'Costos_por_ventas_de_mercaderia',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4318, 43, 3, 'Gastos_por_publicidad_y_propaganda',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4319, 43, 3, 'Gastos_por_armortizacion',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(4401, 44, 3, 'Gastos_por_ejercicio_anteriores',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(5101, 51, 3, 'Ingresos_sobre_prestamos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(5102, 51, 3, 'Ingreso_sobre_compra',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(5201, 52, 3, 'Ingresos_por_venta',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(5301, 53, 3, 'Bonificaciones_sobre_compra',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(6101, 61, 5, 'Excendetes',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(7101, 71, 5, 'Disponibilidad_por_creditos_obtenidos',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(7102, 71, 5, 'Exigibilidad_por_creditos_otorgados',0);
INSERT INTO cuenta (ID_CUENTA, ID_RUBRO, ID_ESTADO, NOMBRE_CUENTA, CUENTA_MAYOR) VALUES
(7103, 71, 5, 'Titulos valores y otros documentos',0);

