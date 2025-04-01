<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    body { font-family: Arial, sans-serif;
                    text-align: center; }

                    .container { border: 2px solid black;
                    width: 600px;
                    margin: auto;
                    padding: 10px; }

                    .header { background-color: red;
                    color: white;
                    padding: 5px;
                    font-weight: bold; }

                    .cuadrado_titulo { background-color: #4A90E2;
                    color: white;
                    padding: 5px;
                    margin-top: 10px;
                    font-weight: bold; }

                    table { width: 100%;
                    border-collapse: collapse;
                    margin-top: 10px; }
                    th, td { border: 1px solid black;
                    padding: 5px;
                    text-align: left; }

                    th { background-color: #F3E5AB; }

                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">Streamers</div>
                    <div class="foto-datos">
                    <img src="profile.jpg" width="100" height="100" />
                        <div class="datos">
                            <div class="cuadrado_titulo">Datos personales</div>
                            <div class="datos-info">
                            <p><b>Nombre completo:</b> <xsl:value-of select="streamer/nombre"/></p>
                                <p><b>País: España</b></p>
                                <p><b>Sexo:</b> <xsl:value-of select="streamer/sexo"/></p>
                                <p><b>Apodo: Auromplay</b></p>
                                <p><b>Ranking:</b> <xsl:value-of select="streamer/@ranking"/></p>
                                <p><b>Fecha nacimiento:</b> <xsl:value-of select="streamer/fecha_nacimiento"/></p>
                            </div>
                            </div>
                        </div>
                    <div class="Parte-abajo">
                    <div class="cuadrado_titulo">Plataformas</div>
                    <table>
                        <tr>
                            <th>Nombre</th>
                            <th>Tipo de Contenido</th>
                            <th>Seguidores</th>
                        </tr>

                        <xsl:for-each select="streamer/plataformas/plataforma">
                            <tr>
                                <td><xsl:value-of select="datos/nombre"/></td>
                                <td><xsl:value-of select="datos/tipo_contenido"/></td>
                                <td><xsl:value-of select="seguidores"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>

                    <div class="cuadrado_titulo">Juegos</div>
                    <table>
                        <tr>
                            <th>Nombre</th>
                            <th>Tipos</th>
                            <th>Horas</th>
                        </tr>
                        <xsl:for-each select="streamer/juegos/juego">
                            <tr>
                                <td><xsl:value-of select="nombre"/></td>
                                <td><xsl:value-of select="tipos/tipo"/></td>
                                <td><xsl:value-of select="horas"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
