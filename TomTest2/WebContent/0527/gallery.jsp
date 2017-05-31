<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<title>Insert title here</title>
<style>
div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 180px;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}
</style>

</head>
<body>

	<div class="gallery">
		<a target="_blank" href="img_fjords.jpg"> <img
			src="img_fjords.jpg" alt="Trolltunga Norway" width="300" height="200"></a>
		<div class="desc">Add a description of the image here</div>
	</div>

	<div class="gallery">
		<a target="_blank" href="img_forest.jpg"> <img
			src="img_forest.jpg" alt="Forest" width="600" height="400"></a>
		<div class="desc">Add a description of the image here</div>
	</div>

	<div class="gallery">
		<a target="_blank" href="img_lights.jpg"> <img
			src="img_lights.jpg" alt="Northern Lights" width="600" height="400"></a>
		<div class="desc">Add a description of the image here</div>
	</div>

	<div class="gallery">
		<a target="_blank" href="img_mountains.jpg"> <img
			src="img_mountains.jpg" alt="Mountains" width="600" height="400"></a>
		<div class="desc">Add a description of the image here</div>
	</div>


</body>
</html>