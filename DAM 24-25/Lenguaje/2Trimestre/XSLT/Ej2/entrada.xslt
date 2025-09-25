<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    * {
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                    }
                    
                    body {
                        font-family: Arial, Helvetica, sans-serif;
                        width: 70%;
                        margin: 0 auto;
                    }
                    
                    #result_output {
                        width: 100%;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        gap: 1rem;
                    }
                    
                    .ticket {
                        width: 100%;
                        max-width: 500px;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        gap: 1rem;
                    }

                    .ticket div {
                        width: 100%;
                    }

                    .encabezado-ticket {
                        display: flex;
                        flex-direction: row;
                        align-items: center;
                        justify-content: space-between;
                        flex-wrap: nowrap;
                        border: 1px solid black;
                        padding: 0.5rem;
                        font-size: small;
                    }

                    .encabezado-ticket div {
                        display: flex;
                        flex-direction: row;
                        align-items: center;
                        justify-content: flex-start;
                        gap: 0.5rem;
                    }

                    .cuerpo-ticket {
                        width: 100%;
                        display: flex;
                        flex-direction: row;
                        align-items: flex-start;
                        justify-content: center;
                        gap: 0.5rem;
                    }

                    .cuerpo-ticket div {
                        flex: 1;
                    }

                    .imagen-evento, .imagen-barra {
                        width: 100%;
                    }

                    .div-datos-evento {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: space-between;
                    }

                    th {
                        background-color: #7eb1e6;
                        padding: 5px;
                        border: 1px solid black;
                    }

                    td {
                        padding: 5px;
                        text-align: right;
                        width: 50%;
                        border: 1px solid black;
                    }
                    
                </style>
            </head>
            <body>
                <xsl:for-each select="entrada/evento">
                    <div class="ticket">
                        <div class="encabezado-ticket">
                            <div>
                                <b>Ticket para el evento: </b>
                                <p><xsl:value-of select="datos/nombre" /></p>
                            </div>
                            <div>
                                <b>Código: </b>
                                <p><xsl:value-of select="codigo" /></p>
                            </div>
                        </div>
                        <div class="cuerpo-ticket">
                            <div class="div-imagen-ticket">
                                <img class="imagen-evento" alt="Imagen del evento">
                                    <xsl:attribute name="src">
                                        <xsl:value-of select="@url_imagen_evento" />
                                    </xsl:attribute>
                                </img>
                            </div>
                            <div class="div-datos-evento">
                                <table>
                                    <tr>
                                        <th colspan="2">Datos del evento</th>
                                    </tr>
                                    <tr>
                                        <td><b>Fecha</b></td>
                                        <td><xsl:value-of select="datos/fecha" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Lugar</b></td>
                                        <td><xsl:value-of select="datos/lugar" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Ciudad</b></td>
                                        <td><xsl:value-of select="datos/ciudad" /></td>
                                    </tr>
                                    <tr>
                                        <td><b>Precio</b></td>
                                        <td><xsl:value-of select="datos/precio" /></td>
                                    </tr>
                                </table>
                                <img class="imagen-barra" alt="Imagen del evento">
                                    <xsl:attribute name="src">
                                        <xsl:value-of select="@url_imagen_barra" />
                                    </xsl:attribute>
                                </img>
                            </div>
                        </div>
                    </div>
                </xsl:for-each>
            </body>
        </html>    
    </xsl:template>
</xsl:stylesheet>
