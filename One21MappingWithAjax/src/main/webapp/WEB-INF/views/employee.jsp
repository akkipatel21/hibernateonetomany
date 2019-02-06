<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<title>Insert title here</title>
 <script type="text/javascript">
 function hidedata(){
	 
 }
function insertAjaxData(){
	
	/* $('#table2').show(); */
	var fn = $("#fname").val();
	var ln = $("#lname").val();
	var sal = $("#salary").val();
	var state = $("#state").val();
	var city = $("#city").val();
$.ajax({
    	   type: "post",
    	   url: "insertData",
    	   dataType: "json",  
    	   data:{fname: fn,lname: ln , salary: sal , state: state, city: city},
    	   success: function(response){
    	/*    alert(response)
    	   alert('hi');  */
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
	/* $('#table2').hide();
	$('#table1').show(); */
    $.ajax({
            type:"GET",
            url:"showAll",
            dataType: "json",
            success:function(respose)
            { alert('respose');
          	  var rows = '';
                $.each( response , function( index, item ) {
        	  	  	rows += '<tr><td>' + item.id + '</td>';
        	  	  	rows += '<td>' + item.fname + '</td>';
        	  	  rows += '<td>' + item.lname + '</td>';
        	  	  	rows += '<td>' + item.salary + '</td>';
        	  	  	rows += '<td>' + item.address.state + '</td>';
        	  	  rows += '<td>' + item.address.city + '</td>';
        	  	  });
        	  	  $('#tblProducts').html(rows);
            },
            error:function(xmlHttpRequest, textStatus, errorThrown)
            {
                   alert("error");
            }
    });
}

</script> 
</head>
<body>
 <table id="table1" ><!--style="display: none;"  -->
  <thead>
  	<tr>
	  <th> Id </th>
	  <th> PersonName </th>
	  <th> Salary </th>
	  <th> Department </th>
	</tr>
  </thead>
  <tbody id="tblProducts">
  
  </tbody>
  </table>
 <!-- <form action="addEmp" method="post"> -->  
	<table id="table2">
		 <tr>
			<td>
				<label>Fname</label>
			</td>
			<td>
				<input id="fname" type="text" name="fname" value=""/>
			</td>
		</tr> 
		<tr>
			<td>
				<label>Lname</label>
			</td>
			<td>
				<input id="lname" type="text" name="lname" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>salary</label>
			</td>
			<td>
				<input id="salary" type="text" name="salary" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>State</label>
			</td>
			<td>
				<input id="state" type="text" name="state" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>City</label>
			</td>
			<td>
				<input id="city" type="text" name="city" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="submit" on onclick="insertAjaxData();" value="Insert"/>
			</td>
		</tr>
	</table>
 <!-- </form>  -->
</body>
</html>