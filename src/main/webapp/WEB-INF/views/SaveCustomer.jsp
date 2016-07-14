<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/jquery.validate.js"></script>
<title>Add Customer</title>

	<style type="text/css">
			
			
			table {
					width:100%;
					border-collapse: collapse;
			    	border: 1px solid black;
			    	
			}
			th{
				border-collapse: collapse;
				background-color:#C7DFEB;
				height: 80px;
				font-weight: bolder;
				border: 1px solid black;
				width: 35%;
			}
			
			td{
				width:12%;
			}
			.cell{
				width:65%; 
			}
			.text1{
				padding: 2% 2%;
				height: 100%;
				width:100%;
				text-align: center;
				font-size: large;
			}
			.text2{
				padding: 2% 2%;
				height: 75%;
				width:100%;
				text-align: center;
				font-size: large;
			}
			
		</style>
		<script type="text/javascript">
		$.validator.setDefaults({
			submitHandler: function() {
				alert("submitted!");
			}
		});

		$().ready(function() {

			// validate the comment form when it is submitted
			$("#SaveCustomerrrrrrr").validate();

			
			$("#sssSaveCustomer").validate({
				rules: {
					ccode: "required",
					cname: "required",
				},
				messages: {
					ccode: "Please enter your firstname",
					cname: "Please enter your lastname",
				}
			});
			
				// validate signup form on keyup and submit
				$("#signupFormrrrr").validate({
					rules: {
						firstname: "required",
						lastname: "required",
						username: {
							required: true,
							minlength: 2
						},
						password: {
							required: true,
							minlength: 5
						},
						confirm_password: {
							required: true,
							minlength: 5,
							equalTo: "#password"
						},
						email: {
							required: true,
							email: true
						},
						topic: {
							required: "#newsletter:checked",
							minlength: 2
						},
						agree: "required"
					},
					messages: {
						firstname: "Please enter your firstname",
						lastname: "Please enter your lastname",
						username: {
							required: "Please enter a username",
							minlength: "Your username must consist of at least 2 characters"
						},
						password: {
							required: "Please provide a password",
							minlength: "Your password must be at least 5 characters long"
						},
						confirm_password: {
							required: "Please provide a password",
							minlength: "Your password must be at least 5 characters long",
							equalTo: "Please enter the same password as above"
						},
						email: "Please enter a valid email address",
						agree: "Please accept our policy"
					}
				});
		});
		
			function btnSave(){
					var see=document.getElementById("SaveCustomer");
					//if(confirm("Are you sure you want to save?"))
					if(confirm('<s:text name="confirmJS.fillFormCustomer"/>'))
						document.getElementById("SaveCustomer").submit();					
					else
						alert('<s:text name="cancelConfirmJS.fillFormCustomer"/>');
					//return false;
				}
			//alert("ey!");

		</script>
		
</head>
<body>
	
	<table>
			<tr>
				<td>
					<s:form  action="Customer_list" theme="simple" cssStyle=" text-align:left;  padding-top: 35px;">							    		  
				   				<s:submit  cssStyle="" type="button" value="Back to List"/>
				    </s:form>
					
				</td>
				<td>
			    	<!--<s:form action="#"  theme="simple" cssStyle=" text-align:left;  padding-top: 35px;">-->						    		  
			   			<s:submit  onclick="btnSave();" value="Save customer"/>
			   		 <!--</s:form>--> <!-- If I use the complete form tag the action property give me problems redirecting actions -->
				</td>
			</tr>
		</table>
		<div>  </div>
		
		<!-- 
		<p style="color:red;">
		<s:iterator var="msg" value="#session.errorMessages" >
		      ${msg} <br>
		</s:iterator>
		</p>
		<s:set scope="session" var="errorMessages" value="%{null}" /><%--flush errors--%>
		 -->
		
		<table>
		<s:form id="SaveCustomer" name="frmSaveAction" action="SaveCustomer">
			<tr>
				<th>
					<s:text name="companyCode.fillFormCustomer"/>
				</th>				
				<td colspan="5" class="cell">
					
					<s:textfield id="ccode" name="compCode" key="compCode" cssClass="text1" theme="simple"> </s:textfield>
				</td>
				<td></td><td></td><td></td><td></td>
			</tr>	
			<tr>
				<th>
					Company's name
				</th>
				<td colspan="5" class="cell">
					
					<s:textfield id="cname" name="compName" cssClass="text1" theme="simple"> </s:textfield>
				</td>
				<td></td><td></td><td></td><td></td>
			</tr>	
			<tr>
				<th>
					Company's display name
				</th>
				<td  colspan="5" class="cell">
					<s:textfield name="compDspName" cssClass="text1" theme="simple"> </s:textfield>
				</td>
				<td></td><td></td><td></td><td></td>
			</tr>	
			<tr>
				<th> Telephone	</th>
				<td colspan="1" width="12%" style="padding-left: 1%;"> <s:textfield name="tel1" cssClass="text2" theme="simple"/></td>
				<td colspan="1" style="text-align: center;font-size: large;" width="5%"> --- </td>
				<td colspan="1" width="12%"><s:textfield name="tel2" cssClass="text2" theme="simple"/></td>
				<td colspan="1" style="text-align: center;font-size: large;" width="5%"> --- </td>
				<td colspan="1" width="12%"><s:textfield name="tel3" cssClass="text2" theme="simple"/></td>
			</tr>
			<tr>
				<th> Fax </th>
				<td  colspan="1" width="12%" style="padding-left: 1%;"> <s:textfield name="fax1" cssClass="text2" theme="simple"/></td>
				<td  colspan="1" style="text-align: center;font-size: large;" width="5%"> --- </td>
				<td  colspan="1" width="12%"><s:textfield name="fax2" cssClass="text2" theme="simple"/> </td>
				<td  colspan="1" style="text-align: center;font-size: large;" width="5%"> --- </td>
				<td  colspan="1" width="12%"><s:textfield name="fax3" cssClass="text2" theme="simple"/></td>
			</tr>
			<tr>
				<th>
					Contact person
				</th>
				<td colspan="5" class="cell">
					<s:textfield name="contactName" cssClass="text1" theme="simple"> </s:textfield>
				</td>
				<td></td><td></td><td></td><td></td>
			</tr>	
			<tr>
				<th>
					Email address
				</th>
				<td colspan="5" class="cell">
					<s:textfield name="email" cssClass="text1" theme="simple"> </s:textfield>
				</td>
				<td></td><td></td><td></td><td></td>
			</tr>				
		</s:form>	
		</table>
		
</body>
</html>