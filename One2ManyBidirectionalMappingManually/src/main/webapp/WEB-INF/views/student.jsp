<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page buffer="none" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function insertAjaxData(){
	/* alert('hi'); */
	var fn = $("#firstname").val();
	var ln = $("#lastname").val();
	var section = $("#section").val();
	var universityName = $("#universityName").val();
	var country = $("#country").val();
$.ajax({
    	   type: "post",
    	   url: "insertData",
    	   dataType: "json",  
    	   data:{firstname: fn , lastname: ln , section: section , 
    		   universityName: universityName , country: country },
    	   success: function(response){
    	   		alert(response)
    	  /*  alert('hi');  */
    	    if(response == 1 )
    	    		{
    	    			alert('Inserted Successfully');
    					showAll(); 
    	    	}
    	   },
    	   error: function(){      
    	    alert('Error while request..');
    	   }
    	  });
}
function showAll(){
    $.ajax({
            type:"GET",
            url:"showAll",
            dataType: "json",
            success:function(response)
            { alert('response'+response);
          	  var rows = '';
                $.each( response , function( index, item ) {
                	console.log('item.stuId :: '+item.stuId+' item.firstname :: '+item.firstname+' item.lastname :: '+item.lastname+' item.section :: '+item.section)
        	  	  	//rows += '<tr><td>' + item.stuId + '</td>';
        	  	  	//rows += '<td>' + item.firstname + '</td>';
        	  	  	//rows += '<td>' + item.lastname + '</td>';
        	  	  	//rows += '<td>' + item.section + '</td>';
        	  	  	//rows += '<td>' + item.university.universityName + '</td>';
        	  		//rows += '<td>' + item.university.country + '</td>'; 
        	  	  });
        	  	  $('#tblProducts').html(rows);
            },
            error:function(xmlHttpRequest, textStatus, errorThrown)
            {
                   alert("error");
            }
    });
} 

/* function showAll(){
	alert('hie');
	$.getJSON("showAll", function (data) {
		alert(data);
		var rows = '';
        $.each( data , function( index, item ) {
        	console.log('item.stuId :: '+item.stuId+' item.firstname :: '+item.firstname+' item.lastname :: '+item.lastname+' item.section :: '+item.section)
	  	  	rows += '<tr><td>' + item.stuId + '</td>';
	  	  	rows += '<td>' + item.firstname + '</td>';
	  	  	rows += '<td>' + item.lastname + '</td>';
	  	  	rows += '<td>' + item.section + '</td>';
	  	  	rows += '<td>' + item.university.universityName + '</td>';
	  		rows += '<td>' + item.university.country + '</td>';
	  	  });
	  	  $('#tblProducts').html(rows);
});
} */

</script>  
</head>
<body>
<button type="button"
onclick="showAll();">
showAll</button>
 <table>
  <thead>
  	<tr>
	  <th> Id </th>
	  <th> FirstName </th>
	  <th> LastName </th>
	  <th> Section </th>
	  <th> UniversityName </th>
	  <th> Country </th>
	</tr>
  </thead>
  <tbody id="tblProducts">
  
  </tbody>
</table> 
 <!-- <form action="insertData" method="post"> -->  
	<table>
		 <tr>
			<td>
				<label>FirstName</label>
			</td>
			<td>
				<input id="firstname" type="text" name="firstname" value=""/>
			</td>
		</tr> 
		<tr>
			<td>
				<label>LastName</label>
			</td>
			<td>
				<input id="lastname" type="text" name="lastname" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>Section</label>
			</td>
			<td>
				<input id="section" type="text" name="section" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>UniversityName</label>
			</td>
			<td>
				<input id="universityName" type="text" name="universityName" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>Country</label>
			</td>
			<td>
				<input id="country" type="text" name="country" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="submit" onclick="insertAjaxData();" value="Insert"/>
			</td>
		</tr>
	</table>
 <!-- </form>  -->
</body>
</html>