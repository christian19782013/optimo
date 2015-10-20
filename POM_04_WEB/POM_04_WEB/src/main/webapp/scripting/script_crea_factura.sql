/* Formatted on 22/09/2015 18:17:47 (QP5 v5.252.13127.32867) */
SET DEFINE ~
COLUMN ID FORMAT A25 TRUNC NEW_VALUE V_ID                                                           
COLUMN RUC_CEDULA FORMAT A25 TRUNC NEW_VALUE V_RUC_CEDULA                                           
COLUMN APELLIDOS FORMAT A25 TRUNC NEW_VALUE V_APELLIDOS                                             
COLUMN NOMBRES FORMAT A25 TRUNC NEW_VALUE V_NOMBRES                                                 
COLUMN DIRECCION FORMAT A25 TRUNC NEW_VALUE V_DIRECCION                                             
COLUMN EMAIL FORMAT A25 TRUNC NEW_VALUE V_EMAIL
SELECT *
  FROM IMAGEN_LAB.IMALAB_CLIENTE
 WHERE    RUC_CEDULA LIKE UPPER (UPPER ('%~~v_filtro.'))
       OR APELLIDOS LIKE UPPER ('%~~v_filtro.')
       OR NOMBRES LIKE UPPER ('%~~v_filtro.');