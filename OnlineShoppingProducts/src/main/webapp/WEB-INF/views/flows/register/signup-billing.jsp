<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up-Address</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					
					<sf:form class="form-horizontal" method="POST" id="billingForm" modelAttribute="billing">
						<!--Address Line One -->
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne" id="addressLineOne" placeholder="Enter Address Line One" class="form-control" />
									<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Address Line Two -->
						<div class="form-group">
							<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo" id="addressLineTwo" placeholder="Enter Address Line Two" class="form-control" />
									<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- City -->
						<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" id="city" placeholder="Enter city" class="form-control" />
									<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- State -->
						<div class="form-group">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" id="state" placeholder="Enter State" class="form-control" />
									<sf:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Country -->
						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" id="country" placeholder="Enter country" class="form-control" />
									<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Postal Code -->
						<div class="form-group">
							<label class="control-label col-md-4" for="postalCode">Postal Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" id="postalCode" placeholder="Enter postalCode" class="form-control" />
									<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- submit button -->						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
							
							<!-- Submit Button for moving to personal -->
							<button type="submit" class="btn btn-primary" name="_eventId_personal">
							<span class="glyphicon glyphicon-chevron-left"></span>Previous - Personal
							</button>
							<!-- Submit Button for moving back to confirm -->
							<button type="submit" class="btn btn-primary" name="_eventId_confirm">
							Next - Confirm<span class="glyphicon glyphicon-chevron-right"></span>
							</button>
							
							</div>
						</div>

					</sf:form>
				</div>
			</div>

		</div>
	</div>

</div>
<%@include file="../shared/flows-footer.jsp"%>