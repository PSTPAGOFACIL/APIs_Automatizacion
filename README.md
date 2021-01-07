<img src="https://drive.google.com/uc?id=1hJSrL1jW94zsIrxLUG90cbfytQCI7Nnw" width="256">

# PagoFácil

## Herramientas utilizadas:
- **IDE:** Eclipse.
- **Lenguaje:** Java.
- **Versión JDK:** 1.8.0_261.
- **Frameworks:** Selenium, Serenity.
- **Patrón de diseño:** Screenplay con PageObject Model.
- **Gestor de dependencias:** Maven y ejecución. 

**Java 8 u261 JDK**
- https://javadl.oracle.com/webapps/download/GetFile/1.8.0_261-b12/a4634525489241b9a9e1aa73d9e118e6/windows-i586/jdk-8u261-windows-x64.exe

**Java 8 u261 JRE**
- https://javadl.oracle.com/webapps/download/GetFile/1.8.0_261-b12/a4634525489241b9a9e1aa73d9e118e6/windows-i586/jre-8u261-windows-x64.exe

## Ejecución por Maven

Colocarse en el directorio del proyecto desde la consola

### Ejemplos de comandos de ejecución.

**Ejecutar un test:**

mvn -Dtest=\NombreDeLaClase#NombreDelTest* test -DskipTests=false

**Ejecutar Más de un test:**

mvn -Dtest=\NombreDeLaClase#NombreDelTest*+NombreDelOtroTest* test -DskipTests=false

**Ejecutar todos los test de las clases de un paquete en especifico.**

mvn -Dtest="com.Arbusta.PagoFacil.features.Facturación.**" test -DskipTests=false

**Ejecutar todos los test del proyecto.**

mvn -Dtest="com.Arbusta.PagoFacil.features.**" test -DskipTests=false

**Generar el reporte actualizado después de la ejecución.**

mvn serenity:aggregate

Los reportes se guardan por default en \target\site\serenity (Abrir index.html)

## Test por paquete.

### Paquete: com.Arbusta.PagoFacil.features.Facturación
**Clase:** Facturacion_de_Un_Servicio

**Listado de Test:**

Facturar_cargar_factura_correctamente_test *(Incluye las validaciones de estado y descarga de XML y PDF)*
Facturación_Mas_de_un_producto_montos_coinciden_test

**Clase:** Facturacion_de_Un_Servicio_Casos_invalidos

**Listado de Test:**

* Descarga_de_PDF_desactivada_en_detalles_de_transacciones_no_completadas_test
* Descarga_de_XML_desactivada_en_detalles_de_transacciones_no_completadas_test
* Facturación_añadir_producto_Cantidad_vacío_test
* Facturación_añadir_producto_Descripcion_vacío_test
* Facturación_añadir_producto_Nombre_vacío_test
* Facturación_añadir_producto_Precio_vacío_test
* Facturación_desactivada_en_detalles_de_transacciones_Anulada_test
* Facturación_desactivada_en_detalles_de_transacciones_fallidas_test
* Facturación_desactivada_en_detalles_de_transacciones_pendientes_test
* Facturación_desactivada_en_transacciones_Anuladas_test
* Facturación_desactivada_en_transacciones_fallidas_test
* Facturación_desactivada_en_transacciones_Pendientes_test
* Facturación_Mas_de_un_producto_montos_no_coinciden_test
* Facturacion_Monto_de_productos_no_coinciden_test
* Facturar_cargar_factura_CANTIDAD_invalido_test
* Facturar_cargar_f actura_Codigo_de_sucursal_invalido_test
* Facturar_cargar_factura_Codigo_de_sucursal_vacío_test
* Facturar_cargar_factura_Comuna_contraparte_invalido
* Facturar_cargar_factura_Comuna_contraparte_vacío_test
* Facturar_cargar_factura_Dirección_contraparte_invalido
* Facturar_cargar_factura_Dirección_contraparte_vacío_test
* Facturar_cargar_factura_Fecha_de_Vencimiento_invalido_test
* Facturar_cargar_factura_Fecha_de_Vencimiento_vacío_test
* Facturar_cargar_factura_Fecha_desde_invalida_test
* Facturar_cargar_factura_Fecha_desde_vacío_test
* Facturar_cargar_factura_Fecha_hasta_invalido_test
* Facturar_cargar_factura_Fecha_hasta_vacío_test
* Facturar_cargar_factura_Fecha_invalido_test
* Facturar_cargar_factura_Fecha_vacío_test
* Facturar_cargar_factura_Folio_invalido
* Facturar_cargar_factura_Folio_vacío_test
* Facturar_cargar_factura_PRECIO_invalido_test
* Facturar_cargar_factura_Razon_Social_contraparte_invalido
* Facturar_cargar_factura_Razon_Social_contraparte_vacío_test
* Facturar_cargar_factura_RUT_Contraparte_invalido_test
* Facturar_cargar_factura_RUT_Contraparte_vacío_test
* Facturar_cargar_factura_Tipo_de_factura_invalido
* Facturar_cargar_factura_Tipo_de_factura_vacío_test
* Facturar_desactivado_sin_configurar_Nubox_test


### Paquete: com.Arbusta.PagoFacil.features.IntegraciónNubox
**Clase:** ConfiguraciónDeNubox

**Listado de Test:**

* Configurar_Nubox_contrasena_Incorrecta
* Configurar_Nubox_correctamente
* Configurar_Nubox_correctamente_Y_Cancelar
* Configurar_Nubox_correctamente_Y_Cerrar
* Configurar_Nubox_Mensaje_de_Pass_Vacio
* Configurar_Nubox_Mensaje_de_Rut_Vacio
* Configurar_Nubox_Mensaje_de_Usuario_Vacio
* Configurar_Nubox_RUT_Incorrecto
* Configurar_Nubox_usuario_Incorrecto

### Paquete: com.Arbusta.PagoFacil.features.Servicios
**Clase:** Crear_Un_Servicio

**Listado de Test:**
* creación_de_Servicios_Nombre_Vacío
* creación_de_Servicios_Plan_Vacío
* creación_de_Servicios_test
* creación_de_Servicios_Tipo_Vacío
* creación_de_Servicios_URL_Vacío
* ver_Servicio_Detalles_del_servicio
* ver_Servicio_por_Default

**Clase:** Transacciones

**Listado de Test:**
* crear_transaccion
* crear_transaccion_Mensaje_receptor_vacio

**Clase:** Ver_Mas.java

*(Busqueda de transacciones)*

**Listado de Test:**

* filtrar_por_Actualizado
* filtrar_por_Actualizado_incorrecto
* filtrar_por_Email
* filtrar_por_Email_incorrecto
* filtrar_por_Estado_Anulada
* filtrar_por_Estado_Completada
* filtrar_por_Estado_Fallida
* filtrar_por_Estado_Pendiente
* filtrar_por_Monto
* filtrar_por_Monto_incorrecto
* filtrar_por_order_id_Tienda
* filtrar_por_order_id_Tienda_incorrecto
* ingresa_Al_Servicio
* link_Completar
* link_Completar_Mas_Info
* link_Recibo
* link_Recibo_Mas_Info

### Paquete: com.Arbusta.PagoFacil.features.Login
**Clase:** login

**Listado de Test:**
* Iniciar_sesion
* Iniciar_sesion_campos_vacios
* Iniciar_sesion_datos_erroneos



|   |   |
| :------------ | :------------ |
|  <img src="https://drive.google.com/uc?id=1IBhvGh8oqxGyik2ZyUlSkEa6s2FsQXN9" width="128"> | **Automatizado por el equipo de Arbusta.**  |
