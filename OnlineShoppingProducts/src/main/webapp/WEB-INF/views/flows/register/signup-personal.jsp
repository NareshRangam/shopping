<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Sign Up-Personal</h4>
				</div>
				<div class="panel-body">
					<!-- form elements -->
					
					<sf:form class="form-horizontal" method="POST" id="registerForm" modelAttribute="user">
						<!-- First Name -->
						<div class="form-group">
							<label class="control-label col-md-4" >First Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="firstName" id="firstName" placeholder="First Name" class="form-control" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Last Name -->
						<div class="form-group">
							<label class="control-label col-md-4" >Last Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="lastName" id="lastName" placeholder="Last Name" class="form-control" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Email -->
						<div class="form-group">
							<label class="control-label col-md-4" >Email</label>
							<div class="col-md-8">
								<sf:input type="text" path="email" id="email" placeholder="Naresh@gmail.com" class="form-control" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<!-- Contact Number -->
						<div class="form-group">
							<label class="control-label col-md-4" >Contact Number</label>
							<div class="col-md-8">
								<sf:input type="text" path="contactNumber" id="contactNumber" placeholder="8867236723" class="form-control" />
								<sf:errors path="contactNumber" cssClass="help-block" element="em" />
							</div>
						</div>

					<!-- Password -->
						<div class="form-group">
							<label class="control-label col-md-4" >Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="password" id="password" placeholder="Password" class="form-control" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Confirm Password -->
						<div class="form-group">
							<label class="control-label col-md-4" >Confirm Password</label>
							<div class="col-md-8">
								<sf:input type="password" path="confirmPassword" id="confirmPassword" placeholder="Re-Enter Password" class="form-control" />
								<sf:errors path="confirmPassword" cssClass="help-block" element="em" />
							</div>
						</div>
						
						<!-- Radio Button using bootstrap class of radio inline -->
						<div class="form-group">
						<label class="control-label col-md-4">Select Role</label>
						<div class="col-md-8">
						<label class="radio-inline">
						<sf:radiobutton path="role" value="USER" checked="checked"/>User
						<sf:errors path="role" cssClass="help-block" element="em" />
						</label>
						<label class="radio-inline">
						<sf:radiobutton path="role" value="SUPPLIER"/>Supplier
						<sf:errors path="role" cssClass="help-block" element="em" />
						</label>
						<label class="radio-inline">
						<sf:radiobutton path="role" value="ADMIN"/>Admin
						<sf:errors path="role" cssClass="help-block" element="em" />
						</label>
						</div>
						</div>

						<!-- Submit Button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
							<button type="submit" class="btn btn-primary" name="_eventId_billing">
							Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
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