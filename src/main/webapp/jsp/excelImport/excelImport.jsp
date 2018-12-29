<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../common/common.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>农行信息导入</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${ss }/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ss }/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="${ss }/css/matrix-style.css" />
    <link rel="stylesheet" href="${ss }/css/matrix-media.css" />
    <link rel="stylesheet" href="${ss }/css/metroStyle.css" type="text/css">
    <link href="${ss }/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    <meta name="_csrf" content="${_csrf.token}"/><meta name="_csrf_header" content="${_csrf.headerName}"/>

</head>

<body>

<!--Header-part-->
<div id="header">
    <h1><a href="dashboard.html">Matrix Admin</a></h1>
</div>
<!--close-Header-part-->

<!--top-Header-menu-->
<%@include file="../common/top.jsp"%>
<%@include file="../common/menu.jsp"%>

<div id="content">
    <div id="content-header">
        <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tables</a> </div>
        <h5>农行信息导入</h5>
    </div>
    <div class="container-fluid">
        <hr>
        <div class="row-fluid">
            <div class="span12">
                <div class="widget-box">
                    <form class="form-inline">
                        <div class="form-group"  enctype="multipart/form-data">
                            <input type="file" id="filepathagr">
                            <button type="button" onclick="uploadAgr()">上传</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>






<!--Footer-part-->
<div class="row-fluid">
    <div id="footer" class="span12"> 2017 &copy; yqj <a href="http://themedesigner.in/">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->
<script src="${ss }/js/jquery-1.11.2.min.js"></script>
<script src="${ss }/js/bootstrap.min.js"></script>
<script src="${ss }/js/jquery.dataTables.min.js"></script>
<script src="${ss }/js/layer.js"></script>
<script type="text/javascript" src="${ss }/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ss }/js/jquery.ztree.excheck.js"></script>

<script type="text/javascript">
    function uploadAgr(){
        var path=$('#filepathagr').val();
        $.ajax({
            cache: true,
            type: "POST",
            url:'${ss}/excelImport/uploadAgricul.do',
            data:{path:path},
            async: false,
            dataType:"json",
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            success: function(data) {
                alert("111");
                alert(data);
                if(data=="success"){
                    alert("保存成功!");
                }else{
                    alert('获取信息失败');
                }
            }
        });
    }
</script>

</body>
</html>
