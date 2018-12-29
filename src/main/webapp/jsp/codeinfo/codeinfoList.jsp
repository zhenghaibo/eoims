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
    
    <title>字典管理</title>
    
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
	    <h1>Tables</h1>
	  </div>
	  <div class="container-fluid">
	    <hr>
	    <div class="row-fluid">
	      <div class="span12">
	        
	        <div class="widget-box">
	          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
	            <h5>字典列表</h5>
	          </div>
	          	<form class="form-inline">
	          		<security:authorize buttonUrl="/resources/addResources.do">
			          <button type="button" id="btn_search" onclick="$('#resourcesForm')[0].reset(); $('#resourcesModal').modal();" class="btn btn-info" style="float: right; margin-right: 1;">新增</button>
					</security:authorize>
				</form>
	            <table class="table table-bordered data-table" id="datatable" >
	              <thead>
	              	<tr>
	                  <th>ID</th>
	                  <th>类别</th>
	                  <th>字典码</th>
	                  <th>字典名</th>
	                  <th>序号</th>
	                  <th>状态</th>
                   	  <th>操作</th>
	                </tr>
	              </thead>
	            </table>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
	
	<%--弹框--%>
			<div class="modal fade bs-example-modal-sm"  id="selectResources" tabindex="-1" role="dialog" aria-labelledby="selectRoleLabel">
			  <div class="modal-dialog modal-sm" role="document" style="height: 600px; "  >
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="selectRoleLabel">分配权限</h4>
			      </div>
			      <div class="modal-body">
			        <form id="boxRoleForm" >
			          <ul id="treeDemo" class="ztree"></ul>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" onclick="saveRoleResources();" class="btn btn-primary">Save</button>
			      </div>
			    </div>
			  </div>
			</div>
			<%----/弹框--%>
			
			
		<!--添加弹框-->
				<div class="modal fade" id="codeinfoModal" tabindex="-1" role="dialog" aria-labelledby="addcodeLabel">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="addcodeLabel">添加/修改字典</h4>
				      </div>
				      <div class="modal-body">
				        <form id="codeinfoForm">
							<div class="form-group" style="display:none">
								<label for="id" class="control-label">id:</label>
								<input type="text" class="form-control" name="id" id="id" />
							</div>
				          <div class="form-group">
				            <label for="catetory" class="control-label">类别:</label>
				            <input type="text" class="form-control" name="catetory" id="catetory" placeholder="请输入类别"/>
				          </div>
				          <div class="form-group">
				            <label for="code" class="control-label">字典码:</label>
				            <input type="text" class="form-control" name="code" id="code" placeholder="请输入字典码"/>
				          </div>
				          <div class="form-group">
				            <label for="name" class="control-label">字典名:</label>
				            <input type="text" class="form-control" id="name" name="name"  placeholder="请输入字典名">
				          </div>
				          <div class="form-group">
				            <label for="ordernum" class="control-label">序号:</label>
				            <input type="text" class="form-control" id="ordernum" name="ordernum"  placeholder="请输入序号">
				          </div>
				          <div class="form-group">
				            <label for="status" class="control-label">状态:</label>
				            <select class="form-control" name="status" id="status" >
							  <option value="1">启用</option>
							  <option value="2">停用</option>
							</select>
				          </div>
				          <div class="form-group">
				            <label for="remark" class="control-label">备注:</label>
				            <input type="textarea" class="form-control" id="remark" name="remark" >
				          </div>
				        </form>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        <button type="button" onclick="addCodeinfo();" class="btn btn-primary">Save</button>
				      </div>
				    </div>
				  </div>
				</div>
			<!--/添加弹框-->
	
	
	
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
	//_csrf参数设置
  	var header = $("meta[name='_csrf_header']").attr("content");  
     var token = $("meta[name='_csrf']").attr("content");  
     var table;
     $(document).ready(function() {
		table = $('#datatable').DataTable( {
				"dom": '<"top"i>rt<"bottom"flp><"clear">',
			  	 "searching" : false,
			  	"bJQueryUI": true,
				"sPaginationType": "full_numbers",
			  	"serverSide": true,//开启服务器模式，使用服务器端处理配置datatable
			  	"processing": true,//开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
			  	
			  	"ajax": '${ss}/resources/codeinfoList.do',
			  	"columns": [
		            { "data": "id" },
		            { "data": "catetory" },
		            { "data": "code" },
		            { "data": "name" },
		            { "data": "ordernum" },
		            { "data": "status" },
		            {data: null}
		        ],
			columnDefs:[{
                targets: 7,
                render: function (data, type, row, meta) {
                    return '<p><security:authorize buttonUrl='/codeinfo/delCodeinfo.do'><a type="button" class="btn btn-danger  btn-default" href="javascrip:;" onclick=delById(' + row.id + ') >删除</a></security:authorize>'+
                    '<security:authorize buttonUrl='/codeinfo/editCodeinfo.do'><a type="button" class="btn btn-success btn-default" href="javascrip:;" onclick=editCodeinfo(' + row.id + ') >修改</a></security:authorize></p>';
                }
            },
                { "orderable": false, "targets": 0 },
                { "orderable": false, "targets": 1 },
                { "orderable": false, "targets": 2 },
                { "orderable": false, "targets": 3 },
                { "orderable": false, "targets": 4 },
                {	 
                	"orderable": false,
                    "render": function(data, type, row) {
                        if(data==1){
                        	return "启用";
                        }else if(data==2){
                        	return "停用";
                        }else{
                        	return "其他";
                        }
                    },
                    "targets": 5
                }
            ],
                
		    } );
			
			
			
	} );
	
	function search(){
		table.ajax.reload();
	}
	
	//添加
	function addCodeinfo() {
		var name = $("#name").val();
		var resKey= $("#resKey").val();
		var parentId = $("#parentId").val();
		var resUrl = $("#resUrl").val();
		var sort = $("#sort").val();
		
		if(name == "" || name == undefined || name == null){
			return layer.msg('资源名称不能为空', function(){
				//关闭后的操作
			});
		}
		if(resKey == "" || resKey == undefined || resKey == null){
			return layer.msg('资源key不能为空', function(){
				//关闭后的操作
			});
		}
		if(parentId == "" || parentId == undefined || parentId == null){
			return layer.msg('父资源id不能为空', function(){
				//关闭后的操作
			});
		}
		if(resUrl == "" || resUrl == undefined || resUrl == null){
			return layer.msg('资源链接不能为空', function(){
				//关闭后的操作
			});
		}
		if(sort == "" || sort == undefined || sort == null){
			return layer.msg('资源排序不能为空', function(){
				//关闭后的操作
			});
		}

		$.ajax({
			cache: true,
			type: "POST",
			url:'${ss}/codeinfo/addCodeinfo.do',
			data:$('#codeinfoForm').serialize(),// 你的formid
			async: false,
			dataType:"json",
			beforeSend: function(xhr){  
                xhr.setRequestHeader(header, token);  
            },
		    success: function(data) {
		    	if(data=="success"){
					layer.msg('保存成功');
					table.ajax.reload();
					 $('#resourcesModal').modal('hide');
				}else{
					layer.msg('保存失败');
					 $('#resourcesModal').modal('hide');
				}
		    }
		});
	}
   function editResources(id){
       $.ajax({
           cache: true,
           type: "POST",
           url:'${ss}/resources/getById.do',
           data:{id:id},
           async: false,
           dataType:"json",
           beforeSend: function(xhr){
               xhr.setRequestHeader(header, token);
           },
           success: function(data) {
               if(data.success==true){
                   $('#id').val(data.data[0].id);
                   $('#name').val(data.data[0].name);
                   $('#resKey').val(data.data[0].resKey);
                   $('#parentId').val(data.data[0].parentId);
                   $('#resUrl').val(data.data[0].resUrl);
                   $('#type').val(data.data[0].type);
                   $('#sort').val(data.data[0].sort);
                   $('#resourcesModal').modal('show');
               }else{
                   layer.msg('获取信息失败');
               }
           }
	   });
   }
	function delById(id) {
		layer.confirm('您确定要删除该资源吗？', {
			  btn: ['确认','取消'] //按钮
			}, function(){
				$.ajax({
					cache: true,
					type: "POST",
					url:'${ss}/resources/delResources.do',
					data:{id:id},
					async: false,
					dataType:"json",
					beforeSend: function(xhr){  
		                xhr.setRequestHeader(header, token);  
		            },
				    success: function(data) {
				    	if(data=="success"){
							layer.msg('删除成功');
							table.ajax.reload();
						}else{
							layer.msg('删除失败');
						}
				    }
				});
			});
		
	}
	
	</script>

  </body>
</html>
