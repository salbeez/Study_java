<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<style type="text/css">
			#paging{text-align:center;}
			a.paging-item,a.paging-side{margin:0 .25em;}
			a.paging-item.selected{font-weight:bold;}
		</style>
<title>Insert title here</title>
</head>
<body>

<div id="paging"></div>
		<p>
			<button type="button" class="paging-function" value="1">Change page to 8</button>
			<button type="button" class="paging-function" value="2">Change max page to 101</button>
			<button type="button" class="paging-function" value="3">Destroy and create paging with another options</button>
		</p>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/1.12.0/jquery.min.js"></script>
		<script type="text/javascript" src="./jquery.paging.js"></script>
		<script type="text/javascript">
			$('#paging').paging({
				current:5,max:45,
				onclick:function(e,page){
					alert('going to page '+page);
				}
			});
			$('.paging-function').on('click', function(){
				switch(this.value){
					case '1':
						$('#paging').paging({current:8});
						break;
					case '2':
						$('#paging').paging({max:101});
						break;
					case '3':
						$('#paging').paging('destroy');
						setTimeout(function(){
							$('#paging').paging({current:2,max:50});
						},1000);
						break;
				}
				return false;
			});
		</script>
</body>
</html>