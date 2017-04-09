<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<html>

<%@ include file="../../common/jstl.jsp"%>

<script type="text/javascript">

var roleChosen;

//表单验证
$(function(){
	
	
	$('#editForm').validator({
		fields : {
			name : '角色名称:required;length[~50]'
		},
		valid : function(form){
			var laodIdx = layer.load();
			
			$('#editForm').ajaxSubmit({
				data : {
				},
				traditional : true,
				success : function(result){
					layer.close(laodIdx);
					if(result.success){
						layer.alert('保存成功', function(){
							window.location.reload();
						});
					}else{
						layer.alert(result.msg);
					}
				}
			});
		}
	});
	
});


</script>

<head>
</head>

<body>

	
	<div id="addForm" class="mgt40">
		<form action="${ctx }/xcUserModel/ajax/save" id="editForm" method="post">
		<input type="hidden" name="id" value="${user.id }"/>
		<div class="">
			<div class="J_formTable l_form_table">
				<table class="not_hightlight">
					<tr>
						<td class="l_title w200"><b class="cRed">*</b> 账号</td>
                         <td>
                             <div class="J_toolsBar fl">
                                 <div class="t_text w200 ml10">
                                     <label>
                                     	<c:choose>
                                     		<c:when test="${not empty user }">
                                     			<input type="text" name="username" data-rule="账号:required;" value="${user.username }" readonly="readonly"/>
                                     		</c:when>
                                     		<c:otherwise>
                                     			<input type="text" name="username" data-rule="账号:required;username;remote[${ctx }/user/ajax/validator/username]" value="" />
                                     		</c:otherwise>
                                     	</c:choose>
                                     </label>
                                 </div>
                             </div>
                         </td>
                     </tr>
					 
					 <tr>
						<td class="l_title "> 手机号码</td>
                         <td>
                             <div class="J_toolsBar fl">
                                 <div class="t_text w200 ml10">
                                     <label>
                                     	<input type="text" name="mobile" data-rule="手机号码:mobile;" value="${user.mobile }" />
                                     </label>
                                 </div>
                             </div>
                         </td>
                     </tr>
					 
                     
				</table>
			</div>
		</div>
		</form>
	</div>

</body>
</html>