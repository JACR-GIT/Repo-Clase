<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8"/>
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Piratas</title>
                <style>
                    table { border-collapse: collapse; width: 50%; margin: 20px; }
                    th, td { border: 1px solid black; padding: 8px; text-align: left; }
                    th { background-color: #f2f2f2; }
                </style>
            </head>
            <body>
                <h1>Piratas</h1>
                <xsl:apply-templates select="piratas/pirata"/>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="pirata">
        <h2>Actor</h2>
        <p>
            <strong>Nombre completo:</strong> <xsl:value-of select="datos_actor/nombre"/> <xsl:value-of select="datos_actor/apellidos"/><br/>
            <strong>Sexo:</strong> <xsl:value-of select="datos_actor/sexo"/><br/>
            <strong>Fecha nacimiento:</strong> <xsl:value-of select="datos_actor/nacimiento"/>
        </p>
        <img src="{@url}" alt="Imagen del pirata" width="100"/>
        
        <h2>Películas</h2>
        <table>
            <tr>
                <th>Título</th>
                <th>Saga</th>
                <th>Tipo</th>
                <th>Barco</th>
            </tr>
            <xsl:for-each select="peliculas/pelicula">
                <tr>
                    <td><xsl:value-of select="titulo"/></td>
                    <td><xsl:value-of select="saga"/></td>
                    <td><xsl:value-of select="roles/rol/tipo_rol"/></td>
                    <td><xsl:value-of select="roles/rol/barco"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>