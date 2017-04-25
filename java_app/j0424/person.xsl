<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">	
	<xsl:template match="/persons">	 
	   <table border='1' cellpading='5' bgcolor='yellow'>
	     <tr>
	        <th>이름</th>
	        <th>나이</th>
	        <th>직업</th>
	     </tr>
	     <xsl:apply-templates/><!-- 자식태그에 대한 템플릿 호출 -->
	   </table>		 
	</xsl:template>
	<xsl:template match="person">
	   <tr>
	     <xsl:apply-templates/><!-- 자식태그에 대한 템플릿 호출 -->
	   </tr>	
	</xsl:template>
	
	<xsl:template match="name">
	   <td><xsl:value-of select="."/></td>	
	</xsl:template>
	<xsl:template match="age">
	   <td><xsl:value-of select="."/></td>		
	</xsl:template>
	<xsl:template match="job">
	   <td><xsl:value-of select="."/></td>		
	</xsl:template>
	
	
</xsl:stylesheet>