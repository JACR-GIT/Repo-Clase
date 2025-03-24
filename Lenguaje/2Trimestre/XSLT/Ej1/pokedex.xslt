<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/pokedex">
        <html>
            <head>
                <style>
                    body { font-family: Arial, sans-serif; text-align: center; }
                    .contenedor-principal { width: 80%; margin: auto; border: 2px solid black; border-radius: 20px; padding: 20px; }
                    .seccion-cabecera { background-color: red; color: white; padding: 10px; font-size: 20px; border-radius: 10px; margin-bottom: 20px; }
                    .info-pokemon { display: flex; align-items: center; justify-content: space-around; margin-top: 20px; }
                    .info-pokemon img { width: 150px; height: 150px; }
                    .seccion-info { border: 1px solid black; padding: 10px; margin: 10px; border-radius: 10px; display: inline-block; }
                    .titulo-info { background-color: blue; color: white; padding: 5px; border-radius: 5px; margin-bottom: 10px; }
                    .tabla-stats, .tabla-tipo { width: 100%; border-collapse: collapse; }
                    .tabla-stats th, .tabla-stats td, .tabla-tipo th, .tabla-tipo td { border: 1px solid black; padding: 5px; }
                </style>
            </head>
            <body>
                <div class="seccion-cabecera">Pokédex</div>
                <xsl:apply-templates select="pokemon"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="pokemon">
        <div class="contenedor-principal">
            <div class="info-pokemon">
                <div>
                    <h2><xsl:value-of select="@num_pokedex"/> - <xsl:value-of select="@nombre"/></h2>
                    <img>
                        <xsl:attribute name="src">
                            <xsl:value-of select="@url_imagen"/>
                        </xsl:attribute>
                    </img>
                </div>
                <div class="seccion-info">
                    <div class="titulo-info">Datos generales</div>
                    <p><b>Altura:</b> <xsl:value-of select="datos_generales/altura"/> m</p>
                    <p><b>Peso:</b> <xsl:value-of select="datos_generales/peso"/> kg</p>
                    <p><b>Sexo:</b> <xsl:value-of select="datos_generales/sexo"/></p>
                    <p><b>Categoría:</b> <xsl:value-of select="datos_generales/categoria"/></p>
                    <p><b>Habilidad:</b> <xsl:value-of select="datos_generales/habilidad"/></p>
                </div>
                <div class="seccion-info">
                    <div class="titulo-info">Stats Base</div>
                    <table class="tabla-stats">
                        <tr><th>PS</th><td><xsl:value-of select="stats_base/ps"/></td></tr>
                        <tr><th>AT</th><td><xsl:value-of select="stats_base/at"/></td></tr>
                        <tr><th>DEF</th><td><xsl:value-of select="stats_base/def"/></td></tr>
                        <tr><th>S.AT</th><td><xsl:value-of select="stats_base/spat"/></td></tr>
                        <tr><th>S.DEF</th><td><xsl:value-of select="stats_base/spde"/></td></tr>
                        <tr><th>SPD</th><td><xsl:value-of select="stats_base/vel"/></td></tr>
                    </table>
                </div>
            </div>
            <div class="info-pokemon">
                <div class="seccion-info">
                    <div class="titulo-info">Debilidades</div>
                    <table class="tabla-tipo">
                        <xsl:for-each select="tipologia/debilidades/debilidad">
                            <tr>
                                <td><xsl:value-of select="tipo_debilidad"/></td>
                                <td><xsl:value-of select="efectividad"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
                <div class="seccion-info">
                    <div class="titulo-info">Fortalezas</div>
                    <table class="tabla-tipo">
                        <tr><td>AGUA</td><td>x2</td></tr>
                        <tr><td>TIERRA</td><td>x2</td></tr>
                    </table>
                </div>
                <div class="seccion-info">
                    <div class="titulo-info">N. Evoluciones</div>
                    <p><xsl:value-of select="count(evoluciones/evolucion)"/></p>
                </div>
            </div>
        </div>
    </xsl:template>
</xsl:stylesheet>
