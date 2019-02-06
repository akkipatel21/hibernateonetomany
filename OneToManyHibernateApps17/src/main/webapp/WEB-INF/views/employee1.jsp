<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="default/style.min.css" />
</head>
<body>
<div id="jstree2"></div>
<div id="jstree1">
	<ul>
		<li><a href="http://www.google.com">Root node 1</a> <a href="#edit" onclick="alert('1.1');">edit</a> delete
		<ul>
			<li><a href="#1.1" onclick="alert('1.1');">node 1.1</a>  edit delete
			<ul>
				<li><a href="#1.1.1">ode 1.1.1</a>  edit delete</li>
				<li><a href="#1.1.2">ode 1.1.2</a>  edit delete</li>
			</ul>
			</li>
			<li><a href="#1.2">node 1.2</a>  edit delete</li>
			<li><a href="#1.3">node 1.3</a>  edit delete</li>
		</ul>
		</li>
		<li><a href="#2">Root node 2</a>  edit delete</li>
		<li><a href="#3">Root node 3</a>  edit delete</li>
	</ul>
</div>

<script src="./js/jquery.min.js"></script>
<script src="./js/jstree.min.js"></script>
<script>
var current_p_id = '';
var Parent = 0;
var newParent = 0;
var Pos = 0;
var newPos = 0;

$(function(){
	/* $(window).resize(function () {
		var h = Math.max($(window).height() - 0, 420);
		$('#container, #data, #tree, #data .content').height(h).filter('.default').css('lineHeight', h + 'px');
	}).resize(); */
	
	$('#jstree2')
		.jstree({
			'core' : {
				'data' : {
					'url' : 'root.json',
					"dataType" : "json",
					'data' : function (node) {
						return { 'id' : node.id };
					}
				},
				'check_callback' : true
			},
			'force_text' : true,
			'plugins' : ['html_data','state', 'dnd' ,'wholerow' /*,'checkbox' */]
		})
		.on('move_node.jstree',function(e,data){
			current_p_id = data.node.icon;
		    alert('par.'+data.node.icon+'---new par.'+data.node.parent+' Condition : '+ (data.node.parent==data.node.icon || data.node.parent=='#'));
			
			if(data.node.parent==data.node.icon || data.node.parent=='#'){
				alert('current_id-'+data.node.id+ ' current_p_id-'+current_p_id+' moved_parent_id-'+data.node.parent+' position-'+data.position);
				
				$.get('?operation=move_node', {
					'id':data.node.id,'current_position':data.node.position,'position':data.position,'parent':data.node.parent
					})
					.error(function () { alert('in error'); data.instance.refresh(); })
					.success(function () {
						alert('in sucess::::'+data.node.text);
						//data.instance.refresh();
				});
			}else{
				alert('Not For Move id-'+data.node.id);
				data.instance.refresh();
			}
		});
});
//$('#tree').jstree("deselect_all");
//alert('id-'+data.node.id+'  pid::'+data.pid +'  pos:'+ data.position+'  par:'+data.node.parent);
//'id':data.node.id,'current_position':data.node.position,'position':data.position,'parent':data.node.parent,'text':data.node.text;
</script>
</body>
</html>