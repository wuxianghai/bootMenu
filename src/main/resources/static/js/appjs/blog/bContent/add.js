$().ready(function() {
getType()
$('#memberId').val($.cookie("memberId"))
	$('.summernote').summernote({
		height : '220px',
		lang : 'zh-CN',
		callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
	});
	validateRule();
});


$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var content_sn = $("#content_sn").summernote('code');
	$("#content").val(content_sn);
	$.ajax({
		cache : true,
		type : "get",
		url : "/system/webMenu/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(r) {
			if (r.code == 0) {
				// window.location.href="/blog";
                location.href = 'http://localhost/blog';
			} else {
				parent.layer.alert(r.msg)
			}
		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			title : "required",
			categories : "required",
			content : "required"
		},
		messages : {
			title : "请填写菜谱标题",
			author : "请填写菜谱类别",
			content : "请填写菜谱内容"
		}
	});
}
function getType() {
           $.ajax({
				type : "get",
				url : "/common/dict/list?type=" + "menu_type",
				error : function(request) {
					parent.layer.alert("Connection error");
				},
				success : function(r) {
				console.log(r)
					if (r.total > 0) {
						var select = "";
						$.each(r.rows, function(i,item){
							if(item.value != 99){
								select = select + "<option value='" + item.value + "'>" + item.name + "</option>"
							}
						})
						$('#categories').html(select);
					} else {
						parent.layer.alert(r.msg)
					}
				}
			});
        }

function returnList() {
	alert(333)
	var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
	parent.layer.close(index);
}