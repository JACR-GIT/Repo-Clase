<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Pokedex</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Nombre</th>
                        <th>Numero</th>
                        <th>Tipo</th>
                        <th>Altura</th>
                        <th>Peso</th>
                    </tr>
                    <xsl:for-each select="pokedex/pokemon">
                        <tr>
                            <td><xsl:value-of select="nombre"/></td>
                            <td><xsl:value-of select="numero"/></td>
                            <td><xsl:value-of select="tipo"/></td>
                            <td><xsl:value-of select="altura"/></td>
                            <td><xsl:value-of select="peso"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                <table border="1">
                    <tr>
                        
                    </tr>
                
                </table>
            </body>