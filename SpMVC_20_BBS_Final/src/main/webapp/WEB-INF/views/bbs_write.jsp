<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {

		$("button.del").click(function(){
			
			let id = $(this).attr("data-id")
			
			document.location.href = "${rootPath}/delete?id=" + id 
			
			alert(id+"를 삭제하겠습니다.")
		})
		
	
		
		var toolbar = [
			['style',['bold','italic','underline'] ],
			['fontsize',['fontsize']],
			['font Style',['fontname']],
			['color',['color']],
			['para',['ul','ol','paragraph']],
			['height',['height']],
			['table',['table']],
			['insert',['link','hr','picture']],
			['view',['fullscreen','codeview']]
			
		]
	
		$("#b_content").summernote({
			lang:'ko-KR',
			placeholder:'본문을 입력하세요',
			width:'100%',
			toolbar:toolbar,
			height:'200px',
			disableDragAndDrop : false,
			callbacks : {
				onImageUpload : function(files, editor, isEdite){
					for(let i = files.length - 1; i >= 0; i--){
						// 파일을 1개씩 업로드할 함수
						upFile(files[i],this) // this = editor
					}
				}
			}
		}) // end summer
		
		// ajax를 이용해서 파일을 서버로 업로드 수행하고
		// 실제 저장된 파일 이름을 받아서
		// summernote에 기록된 내용중 img src=""을 변경
		function upFile(file,editor){
			
			var formData = new FormData()
			// 'upFile'은 컨트롤러에서 받아오는 정보
			formData.append('upFile',file)
			$.ajax({

				url : "${rootPath}/image_up",
				type : "POST",
				data : formData,
				contentType : false,
				processData : false,
				encType : "multipart/form-data",
				success:function(result){
					alert(result)
					result = "${rootPath}/files/" + result
					$(editor).summernote('editor.insertImage',result)
				},
				error:function(){
					alert("서버통신 오류")
				}
				
			})
		}
		
		$("#b_content").summernote()
			
	})
</script>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section class="container-fluid">
		<fieldset>
			<form method="POST">
				<div class="form-group mt-3">
					<input name="b_writer" class="form-control" value="${BBS.b_writer}" placeholder="작성자">
				</div>

				<div class="form-group">
					<input name="b_subject" class="form-control" value="${BBS.b_subject}" placeholder="제목">
				</div>

				<div class="form-group">
					<textarea rows="5" cols="30" class="form-control"  id="b_content" name="b_content">${BBS.b_content}</textarea>
				</div>
				
				<div class="form-group d-flex justify-content-end">
					<button class="btn btn-secondary mr-2">저장</button>
					<button type="button" class="btn btn-secondary">목록으로</button>
				</div>
			</form>
		</fieldset>
	</section>
</body>
</html>