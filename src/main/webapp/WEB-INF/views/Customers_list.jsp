<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-UTF-8">
		<title>List of Customers</title>
		<style type="text/css">
			
			table{
				width:100%;
			}
			table, th, td {
					
					border-collapse: collapse;
			    	border: 1px solid black;
			    	text-align: center;
			    	
			}
			th{
				border-collapse: collapse;
				background-color:#C7DFEB;
				height: 80px;
				font-weight: bolder;
				border: 1px solid black;
			}
			.buttons{
				
				height:12%;
				padding: 1% 5% 0% 1%;
				
				font-size: large;
				size: 15%;
			}
		</style>
	
	</head>
	<table>
		<tr>
			<td style="width: 8%;vertical-align: bottom;font-size: large;">
				<s:form action="Add_customer" theme="simple" cssClass="buttons">							    		  
			   			<s:submit  theme="simple" type="button">Add Customer</s:submit>
			    </s:form>
			</td>
			<td style="width: 25%; text-align:left;vertical-align: bottom;">
			    <s:form action="MainMenu" theme="simple" cssClass="buttons">							    		  
			   				<s:submit type="button">Back</s:submit>
			    </s:form>
			</td>
		</tr>
	</table>
	<body>
		<table>		
			<tr>
				<th>
					Row No 
				</th>
				<th>
					Code 
				</th>
				<th>
					Name of the Company
				</th>
				<th>
					Display Name
				</th>
				<th>
					Telephone
				</th>
				<th>
					Contact's Name
				</th>				
			</tr>
			<%int i=1;%>
			<s:iterator  value="customerList">	
				<tr>
					<td>
						<%=i%>
						
					</td>
					<td>
						<s:property value="customerCode" />
					</td>
					<td>
						<s:property value="cuatomerName" />
					</td>
					<td>
						<s:property value="customerDspName" />
					</td>
					<td>
						<s:property value="customerTel" />
					</td>
					<td>
						<s:property value="customerTantoName" />
					</td>
				</tr>
				<%i++; %>
			</s:iterator>
		</table>
	
	</body>
</html>