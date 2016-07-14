<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><s:text name="TitleTab.detailProject"/></title>
		<style type="text/css">
		.blueCell{
			width:12%;
			text-align: center;
			background-color:#C7DFEB;
		}
		td{
			text-align: center;
		}
		th{
			width: 175px;
			text-align: center;
			background-color:#C7DFEB;			
		}
		table{
			border-collapse: collapse;
		}
		
		</style>
	</head>
	
	
	
	<body>
	<div>
		<table style="width: 1400px;">
			<tr>
				<td> <!-- These are going to be just Javascript functions that are going to call actions at the end after doing some tasks -->
					<s:form action="Add_Project" theme="simple" cssStyle=" text-align:left;  padding-top: 35px;">							    		  
		   				<s:submit type="button">Edit Project</s:submit>
		    		</s:form>
		    	</td>
		    	<td>
		    		<s:form action="Add_Project" theme="simple" cssStyle=" text-align:left;  padding-top: 35px;">							    		  
		   				<s:submit type="button">Save Changes</s:submit>
		    		</s:form>
    			</td>
    		</tr>
    	</table>
	</div>
	
	<table border="1"  style="border-collapse: collapse;width:1400px;">
		<tr >
			<td rowspan="3" style="background-color:#C7DFEB; border=1;width: 80%; text-align: center;border:black; "><s:text name="HeaderTitle.detailProject"/>  </td>
			<tr>
				<td style="background-color:#C7DFEB; "><s:text name="prjCreationDate.detailProject"/> </td>
				<td><s:date name="dtoProjectBean.cre_date" format="yyyy/MM/dd"/> </td>
			</tr>
			<tr>
				<td  style="background-color:#C7DFEB; "><s:text name="prjUpdateDate.detailProject"/> </td>
				<td><s:date name="dtoProjectBean.prjUpdateDtime" format="yyyy/MM/dd"/></td>
			</tr>
		
		
		</tr>	
	</table>
	
	<p><s:text name="prjDetails.detailProject"/></p>
	
	<table  border="1"  style="width: 1400px;padding:0px;margin: 0px;border-collapse: collapse;">
		<tr style="padding: 0;">
			<td class="blueCell"><s:text name="prjName.detailProject"/> </td>
			
			<td colspan="9" style="width:8%;text-align: center;margin-right: 0%;margin-left: 0%;padding-right: 0;"> <s:property  value="dtoProjectBean.prjName"/></td>
			
		</tr>
		<tr> 
			<td class="blueCell"><s:text name="prjDivision.detailProject"/></td>
			<td style="width:8%;">  <s:property  value="dtoProjectBean.prjKbnId"/> </td>
			<td class="blueCell" contenteditable="true"><s:text name="prjPriority.detailProject"/></td>
			<td> <s:property  value="dtoProjectBean.prjImportanceId"/></td>
			<td class="blueCell"><s:text name="prjTarget.detailProject"/></td>
			<td> <s:property  value="dtoProjectBean.prjTargetId"/></td>
			<td class="blueCell"><s:text name="prjProfitability.detailProject"/></td>
			<td> <s:property  value="dtoProjectBean.prjProfitabilityId"/></td>
			<td class="blueCell"><s:text name="prjNearShore.detailProject"/></td>
			<td>  <s:property  value="dtoProjectBean.prjNearshoreId"/></td>
		</tr>
		<tr>
			<td class="blueCell"><s:text name="prjStrategy.detailProject"/></td>
			<td><s:property  value="dtoProjectBean.prjStrategicId"/> </td>
			<td class="blueCell"><s:text name="prjCustomer.detailProject"/> </td>
			<td style="text-align: center;" colspan="7" contenteditable="true"> <s:property value="dtoProjectBean.entityMaCustomer.cuatomerName"/> </td>
		</tr>
		<tr>
			<td class="blueCell"> <s:text name="prjEndUser.detailProject"/></td>
			<td colspan="2" style="text-align: center;"> <s:property  value="dtoProjectBean.prjEnduserName"/></td>
			<td class="blueCell"><s:text name="prjWorkingPlace.detailProject"/></td>
			<td colspan="3" style="text-align: center;"> <s:property  value="dtoProjectBean.prjWorkingPlace"/></td>
			<td class="blueCell"><s:text name="prjDeliveryDate.detailProject"/></td>
			<td colspan="2" style="text-align: center;"> <s:date name="dtoProjectBean.prjDeliveryDate" format="yyyy/MM/dd"/></td>
		</tr>
		<tr>
			<td class="blueCell"><s:text name="prjSummary.detailProject"/></td>
			<td colspan="9" style="text-align: center;"> <s:property  value="dtoProjectBean.prjSummary"/></td>
		</tr>		
		<tr>
			<td class="blueCell"><s:text name="prjSecurityReq.detailProject"/></td>
			<td colspan="9" style="text-align: center;"> <s:property  value="dtoProjectBean.securityRequirements"/></td>
		</tr>
		<tr>
			<td class="blueCell"> <s:text name="prjRequirementsNotes.detailProject"/></td>
			<td colspan="9" style="text-align: center;"><s:property  value="dtoProjectBean.prjEtcRequirementes"/> </td>
		</tr>
		<tr>
			<td class="blueCell"><s:text name="prjNotes.detailProject"/></td>
			<td colspan="9" style="text-align: center;"> <s:property  value="dtoProjectBean.prjEtc"/></td>
		</tr>
	
	</table>
	
	<p> <s:text name="secondTabletitle.detailProject"/></p>
	<table border=1 style="table-layout:fixed; width: 1600px; border-collapse:collapse;">
		<tr>
			<th  style="width: 178px;">Engineer Role</th>
			<th  style="width: 181px;">Number of People</th>
			<th >Price</th>
			<th style="width: 375px;">Time Period</th>
			<th >Working Place</th>
			<th>Skill Category</th>
			<th>Skill Name</th>
			<th>Skill level</th>
			<th>Engineer Notes</th>
		</tr>
	</table>
	<table  border=1 style="table-layout:fixed; width: 1600px; border-collapse:collapse;padding: 0;">
		<!-- control de info with jsp code and javascript all the info is in the dto already.. -->
		<%int i=1;boolean j=false;%>
		<tr>
			<td  style="width: 25px;">
				<table style="padding: 0;">	
					<s:iterator  value="dtoProjectBean.entityMaEngineerkbn">
						<tr>
							<td>										
								<%=i%>													
							</td>		<!--MA_engineerKbn engineerkbn_name-->
							<%i++;%>
						</tr>
					</s:iterator>
				</table>
			</td>
			<td style="width: 150px;">
				<table >	
						<s:iterator  value="dtoProjectBean.entityMaEngineerkbn">
							<tr><td>
								<s:property value="engineerkbnName"/>
							</td></tr>
						</s:iterator>
				</table>
			</td>
			<td style="table-layout:fixed; width:1425px;padding:0;">	
				<table  border="1" style="table-layout:fixed; width:1225px;">	
					<s:iterator  value="dtoProjectBean.dtoPrjNeedsEngineer" var="eng">
						<tr>																
							<td  style="width: 100px;">
								<s:property value="prj_needs_engineer_number"/>
							</td>
							<td  style="width: 75px;">
								人
							</td>
							<td  style="width: 145px;">
								<s:property value="prj_needs_engineer_rough_price"/>
							</td>
							<td style="width: 30px;">
								千円
							</td>
							<td style="width: 375px;">
							<div style="width: 375px;">
								<table>
									<tr>
								<!-- 375px total for the dates -->
									
											<td style="width: 70px;"> 							
												<s:date name="prj_needs_priod_from" format="yyyy"/>
											</td>
											<td style="width: 30px;">
												年
											</td>
											<td  style="width: 30px;"> 							
												<s:date name="prj_needs_priod_from" format="MM"/>
											</td>
											<td  style="width: 30px;">
												月
											</td>
											<td  style="width: 55px;">
												~
											</td>
											<td  style="width: 70px;"> 							
												<s:date name="prj_needs_priod_to" format="yyyy"/>
											</td>
											<td  style="width: 30px;">
												年
											</td>
											<td  style="width: 30px;"> 							
												<s:date name="prj_needs_priod_to" format="MM"/>
											</td>
											<td  style="width: 30px;">
												月
											</td>
									</tr>
								</table>
							</div>	
							</td>
							
							<td style="width: 175px;"> 
								<s:property value="prj_needs_engineer_working_place"/> 
							</td>	
							<td style="width: 175px;">	
								<table  border="1">
									<s:iterator  value="dtoProjectBean.entityMaSkillcategory" var="item">
										<tr>																
											<td >	
																					
												<s:iterator  value="item" var="child">												
													<s:property value="#child.categoryName"/> <br>
												</s:iterator>
											</td>
										</tr>
									</s:iterator>
								</table>
							</td>	
							<td style="width: 1175px;">	
								<table  border="1">
								<s:set name="mio" value="%{''+#eng.prj_id+#eng.prj_sub_id+#eng.tz_prj_needs_engineerkbn_id}"/><!--Setting a property in order to make the bellow "if loop" work  -->
								<s:property value="mio"/>
									<s:property value="prj_id"/><s:property value="prj_sub_id"/><s:property value="tz_prj_needs_engineerkbn_id"/><br>
									<s:iterator  value="dtoProjectBean.dtoMaSkillitemList" var="item2">
										<!--<s:property value="%{''+#eng.prj_id+#eng.prj_sub_id+#eng.tz_prj_needs_engineerkbn_id}"/> 	OK-->						
										<!--<s:property value="#eng.prj_sub_id"/><s:property value="#eng.tz_prj_needs_engineerkbn_id"/>OK-->
											<tr>																
												<td >																										
													<s:iterator  value="item2" var="child2">
													<s:property/><!-- debugging purposes -->	
														<s:property value="#child2.skillEngineerId"/><!-- property that I want to compare -->
														
														<s:if test="#mio.equalsIgnoreCase(#child2.skillEngineerId) "><!-- Filter the skills that do not belong to this row or to this engineer -->
															<p>Condition ok, skills for this engineer</p>									
															<s:property value="#child2.skill_name"/><br><!-- the field that I really need -->	
															<s:property value="#child2.skillEngineerId"/>	
														</s:if> 
														<s:else>
															<p>==============Condition false test</p>
														</s:else>										
													</s:iterator>
												</td>
											</tr>
									</s:iterator>
								</table>
							</td>	
							<td style="width: 175px;">	
								<table  border="1">
									<s:iterator  value="dtoProjectBean.dtoMaSkillitemList" var="item2">
										<tr>																
											<td >											
												<s:iterator  value="item2" var="child2">												
													<s:property value="#child2.skillLevel"/><br>												
												</s:iterator>
											</td>
										</tr>
									</s:iterator>
								</table>
							</td>
							<td  style="width: 175px;">	
								<table  border="1">
									<s:iterator  value="dtoProjectBean.dtoPrjNeedsEngineer">
										<tr>																
											<td >
												<s:property value="prj_needs_engineer_etc"/> 
											</td>
										</tr>
									</s:iterator>
								</table>
							</td>										 			
						</tr>
					</s:iterator>
				</table>
			</td>
		</tr>
			
	</table>			
	
	</body>
</html>