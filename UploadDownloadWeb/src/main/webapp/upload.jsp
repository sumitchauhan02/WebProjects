<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>

<body style = "text-align: center; font-weight:bold">

   
        <form name ="uploadForm" method="post" action="uploadFile" enctype="multipart/form-data">
            First Name: <input type="text" name="firstName" title ="firstName"><br/><br/>
            Last Name: <input type="text" name="lastName" title ="lastName"><br/><br/>
            Select file to upload: <input type="file" name="uploadFile" />
            
            <br/><br/>
            <input type="submit" value="Upload" />
        </form>
    
   
</body>
</html>