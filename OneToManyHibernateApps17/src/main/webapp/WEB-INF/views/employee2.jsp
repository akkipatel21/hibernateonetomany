<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="default/style.min.css" />
</head>
<body>
<div id="jstree1">
	<ul>
		<li id="1" title="0"><span onclick="alert( $(this).html() );" class="content">Root node 1</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
		<ul>
			<li id="4" title="1">node 1.1
			<ul>
				<li id="111" title="4">ode 1.1.1</li>
				<li id="112" title="4">ode 1.1.2</li>
			</ul>
			</li>
			<li id="5" title="1">node 1.2</li>
			<li id="6" title="1">node 1.3</li>
		</ul>
		</li>
		<li id="2" title="0">Root node 2
		<ul>
			<li id="7" title="2">node 2.1</li>
			<li id="8" title="2">node 2.2</li>
			<li id="9" title="2">node 2.3</li>
		</ul>
		</li>
		<li id="3" title="0">Root node 3
		<ul>
			<li id="10" title="3">node 2.1</li>
			<li id="11" title="3">node 2.2</li>
			<li id="12" title="3">node 2.3</li>
		</ul>
		</li>
	</ul>
</div>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/jstree.min.js"></script>

<script src="/resources/js/jquery.jstree_old.js"></script>

<script>
var oldParent = 0;
var newParent = 0;
var newPos = 0;
var idNode = 0;
$(function(){
	$('#jstree1')
		.jstree({
			'core' : {
				'check_callback' : true
			},
			'force_text' : true,
			'plugins' : [ 'dnd','ui','themes' /*'html_data',  ,'wholerow' ,'state' ,'ui','html_data','checkbox' */]
		})
		.on('move_node.jstree',function(e,data){
			idNode = data.node.id;
			oldParent = $('#'+data.node.id).attr("title");
			newParent = data.node.parent;
			newPos = data.position;
			alert( 'id:'+idNode+'---oldParent:'+oldParent+'---newParent:'+newParent+'---newPos:'+newPos+'---Condition:'+(newParent==oldParent || newParent=='#'));
			
			if(newParent==oldParent || newParent=='#'){
				$.get('?operation=move_node', {
					'id':idNode,'current_position':data.node.position,'position':data.position,'parent':data.node.parent
					})
					.error(function () { alert('in error'); data.instance.refresh(); })
					.success(function () {
						alert('in sucess::::'+data.node.text);
						//data.instance.refresh();
				});
			}else{
				alert('Not Move id:'+data.node.id);
				data.instance.refresh();
			}
		})
		.bind('loaded.jstree',function(e,data){
			$(this).jstree('open_all');
		});
});
</script>
</body>
</html>

<!-- 
<div id="jstree2">
	<ul>
		<li class="1">
		<span onclick="alert( $(this).html() );" class="content">Root node 1</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
		<ul>
			<li class="4">
			<span onclick="alert( $(this).html() );" class="content">node 1.1</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
			<ul>
				<li class="7"><span onclick="alert( $(this).html() );" class="content">ode 1.1.1</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
				</li>
				<li class="8"><span onclick="alert( $(this).html() );" class="content">ode 1.1.2</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
				</li>
			</ul>
			</li>
			<li class="5"><span onclick="alert( $(this).html() );" class="content">node 1.2</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
			</li>
			<li class="6"><span onclick="alert( $(this).html() );" class="content">node 1.3</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
			</li>
		</ul>
		</li>
		<li class="2"><span onclick="alert( $(this).html() );" class="content">Root node 2</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
		</li>
		<li class="3"><span onclick="alert( $(this).html() );" class="content">Root node 3</span><span class="actions"><a href="/open">open</a><a href="/delete">delete</a></span>
		</li>
	</ul>
</div> -->