<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

	<!-- <link rel="stylesheet" type="text/css" href="css/management.css"> OK-->
<style type="text/css">

	
	
	
	table{
			width:100%;
	}
	table, th, td {
			
			border-collapse: collapse;
	    	border: 1px solid black;
	    	
	}
	th{
		border-collapse: collapse;
		background-color:#C7DFEB;
		height: 80px;
		font-weight: bolder;
		border: 1px solid black;
	}
	
	
	title{font-size: larger;}
	
	tr td{background: white;}
	tr:nth-child(odd) td{background: #DCD3D3;}
	td{height: 40px;text-align: center;}
	
	.normal {
		background-color: white;
		text-align: left;
	 	border: 0;
	}
		
		
</style>			
	<title><s:text name="TitleTab.listprojects"/></title>
	
</head>
	<body>
		<div>
		
		<a href="<s:url action='Add_Project'>
					<s:param name='projectId'>22</s:param>			
				</s:url>">
			This is a test link
		</a>
		
		
		<table class="normal" >
		<tr class="normal" ><td style="background-color: white; width:20%; padding-top: 15px; border: 0;">
			<s:text name="Title.listprojects"/>
			</td>
			<td style="background-color: white; margin-left: 0;  border: 0;">
			<s:form action="Add_Project" theme="simple" cssStyle=" text-align:left;  padding-top: 35px;">							    		  
   				<s:submit type="button"><s:text name="Button.listprojects"/></s:submit>
    		</s:form>
    	</td></tr>
    	</table>
    	</div>
		
		<table style="border: 2px solid black;">	
			<tr>
				<th> <s:text name="countRow.0listprojects.m"/></th>
				<th> <s:text name="upd_dtime.1listprojects.m"/></th>
				<th> <s:text name="prj_target_id.2listprojects.m"/></th>
				<th> <s:text name="prj_profitability_id.3listprojects"/></th>
				<th> <s:text name="prj_nearshore_id.4listprojects"/></th>
				<th> <s:text name="prj_strategic_id.5listprojects"/></th>
				<th> <s:text name="prj_customer_name.6listprojects"/></th>
				<th> <s:text name="prj_enduser_name.7listprojects"/></th>
				<th> <s:text name="prj_name.8listprojects"/></th>
				<th> <s:text name="prj_summary.9listprojects"/></th>
				<th><s:text name="prj_skill_name.10listprojects"/></th>
				
				<th colspan="2"> 
					 <s:text name="prj_eng_role.11Alistprojects"/> , 
					 <s:text name="prj_eng_number.11Blistprojects"/> 
				</th>
				
				<th colspan="2"> 
					  <s:text name="prj_eng_unit_price.12Alistprojects"/>
					  <s:text name="prj_eng_time_period.12Blistprojects"/> 
					
				</th>
				
				<th> <s:text name="prj_working_place.13listprojects"/></th>
				<th> <s:text name="prj_etc.14listprojects"/></th>				
			</tr>
			<%int i=1;boolean j=false;%>
			<s:iterator  value="dtoProjecList">	
					
					<tr>	
						<td>				
						<a href="<s:url action='ViewOrModify_Project'>
							<s:param name='projectId'><s:property value="prId"/></s:param>			
							</s:url>">
							<%=i%>
						</a>
							
						</td>		
						<%i++;j=(i % 2==0);%>	
						<td> 
							<!--<s:property value="cre_date"/>-->
							<s:date name="cre_date" format="dd/M"/>
						</td>				
						<td> 
							<s:property value="prjTargetId"/> 
						</td>								
						<td>	
							  <s:property value="prjProfitabilityId"/>
						</td>  				
						<td>	      
							<s:property value="prjNearshoreId"/>
						</td>				
						<td>
							  <s:property value="prjStrategicId"/>
						</td>		
						<td>
							  <s:property value="prj_maCustomerId"/>
						</td>						
						<td>
							  <s:property value="prjEnduserName"/>
						</td>				
						<td>
							  <s:property value="prjName"/>
						</td>				
						<td>
							  <s:property value="prjSummary"/>
						</td>									
						<td>																
							<s:iterator  value="dtoMaSkillitemList" var="item">
								<s:iterator  value="item" var="child">
									<!-- <p>This is the child</p>  -->
									<!--<s:property /> -->
									<!--<p>This is the property</p>  -->
									<s:property value="#child.skill_name"/>	<br>
								</s:iterator>
																									
									<!--<p>This is the object</p> 
									<!--<s:property /> -->
							</s:iterator>															
						</td>						
							<td>																																																		
								<s:iterator  value="entityMaEngineerkbn">								
									<s:property value="engineerkbnName"/>												
								</s:iterator>							
							</td>	
							<td>									
								<s:iterator  value="dtoPrjNeedsEngineer">																
									<s:property value="prj_needs_engineer_number"/>						
								</s:iterator>																				 
							</td>						
							<td>
								<s:iterator  value="dtoPrjNeedsEngineer">
									<s:property value="prj_needs_engineer_rough_price"/>							
								</s:iterator>
							</td> 						 						 
							 <td >
							 	<table>						 	
							 	<s:iterator  value="dtoPrjNeedsEngineer">
									<!--<s:property value="prj_needs_priod_from"/> -->
								<tr><td style="background-color: inherit;">	<s:date name="prj_needs_priod_from" format="yyyy/M"/>						
									<!--<s:property value="prj_needs_priod_to"/>-->
									 <!-- conditional display of a second parameter field -->
									<s:if test="((!prj_needs_priod_to.equals('')))">
									 	~ <s:date name="prj_needs_priod_to" format="yyyy/M"/> </td></tr>
									</s:if> 
									<s:else>
										~ <s:text name="null"/></td></tr>
									</s:else>
								</s:iterator>							
								</table>
							 </td>
										
						<td>
							  <s:property value="prjWorkingPlace"/>
						</td>				
						<td>
							  <s:property value="prjEtc"/>
						</td>					
					</tr> 
				
			</s:iterator>	
		</table>							
	</body>
</html>