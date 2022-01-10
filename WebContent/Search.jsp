<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Microdogle</title>
		<style type="text/css">
			.border-style {
				border-radius: 75px/90px;
			}
			
			#padding {
				padding: 0px 0px 0px 15px;
			}
		</style>
	</head>
	
	<body style='background-color: #FFFFBB'>
		<form action='${requestUri}' method='get'>
			<div>
				<input type='text' class="border-style" id="padding"
					style='font-size: 120%; position: absolute; left: 50%; top: 48%; margin-top: -47px; margin-left: -400px; width: 800px; height: 45px'
					name='keyword' placeholder='請輸入關鍵字' onfocus="placeholder= '' "
					onblur="placeholder='請輸入關鍵字'" />
			</div>
			<div>
				<input type='image' src="images/loupe-2.png"
					style='position: absolute; width: 37px; height: 37px; left: 50%; top: 50%; margin-top: -55px; margin-left: 368px' />
			</div>
			<div>
				<img src="images/bone.png"
					style='position: absolute; width: 350px; height: 250px; left: 50%; top: 40%; margin-top: 100px; margin-left: -175px'>
			</div>
			<div>
				<img src="images/Microdogle.png"
					style='position: absolute; width: 1200px; height: 300px; left: 50%; top: 40%; margin-top: -300px; margin-left: -580px'>
			</div>
		</form>
	</body>
</html>