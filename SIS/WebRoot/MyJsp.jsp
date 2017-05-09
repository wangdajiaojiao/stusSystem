<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/page.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/page.js"></script>
</head>
<body>
<!--currentpage="1" numbercount="100"-->
    <ul class="page" maxshowpageitem="5" pagelistcount="10"  id="page"></ul>
</body>
</html>
<script type="text/javascript">
    function tt(dd){
        //alert(dd);
    }
    var GG = {
        "kk":function(mm){
           // alert(mm);
        }
    }
    $("#page").initPage(71,1,GG.kk);
</script>
